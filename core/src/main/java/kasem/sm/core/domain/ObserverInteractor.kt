/*
 * Copyright (C) 2022, Kasem S.M
 * All rights reserved.
 */
package kasem.sm.core.domain

import kasem.sm.core.utils.toMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

/**
 * Inspired by ChrisBane's [tivi](https://github.com/chrisbanes/tivi/)
*/
abstract class ObserverInteractor<P : Any, T> {
    private val flowOfError = MutableSharedFlow<String>()

    // Ideally this would be buffer = 0, since we use flatMapLatest below, BUT invoke is not
    // suspending. This means that we can't suspend while flatMapLatest cancels any
    // existing flows. The buffer of 1 means that we can use tryEmit() and buffer the value
    // instead, resulting in mostly the same result.
    private val paramState = MutableSharedFlow<P>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val flow: Flow<T> = paramState
        .distinctUntilChanged()
        .flatMapLatest { execute(it) }
        .distinctUntilChanged()
        .catch {
            flowOfError.emit(it.toMessage)
        }

    /**
     * A function which takes in a [coroutineScope]
     * and [onError] lambda gets triggered if any exception is thrown.
     */
    @Suppress("Unchecked_Cast")
    fun join(
        coroutineScope: CoroutineScope,
        onError: suspend (String) -> Unit = { },
        params: P? = null,
    ) {
        paramState.tryEmit(params ?: Unit as P)
        coroutineScope.launch {
            flowOfError.collectLatest { message ->
                onError(message)
            }
        }
    }

    /**
     * A function similar to [join] which also returns Flow of type T
     * which has it's own use-case.
     */
    @Suppress("Unchecked_Cast")
    fun joinAndCollect(
        coroutineScope: CoroutineScope,
        onError: suspend (String) -> Unit = { },
        params: P? = null,
    ): Flow<T> {
        paramState.tryEmit(params ?: Unit as P)
        coroutineScope.launch {
            flowOfError.collectLatest { message ->
                onError(message)
            }
        }
        return flow
    }

    protected abstract suspend fun execute(params: P): Flow<T>
}
