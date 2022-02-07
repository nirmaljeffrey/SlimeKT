/*
 * Copyright (C) 2021, Kasem S.M
 * All rights reserved.
 */
package kasem.sm.feature_article.domain.interactors

import javax.inject.Inject
import kasem.sm.core.domain.SlimeDispatchers
import kasem.sm.core.domain.Stage
import kasem.sm.core.domain.start
import kasem.sm.core.utils.getOrDefault
import kasem.sm.feature_article.datasource.cache.ArticleDatabaseService
import kasem.sm.feature_article.datasource.network.ArticleApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GetLatestArticles @Inject constructor(
    private val api: ArticleApiService,
    private val cache: ArticleDatabaseService,
    private val applicationScope: CoroutineScope,
    private val slimeDispatchers: SlimeDispatchers,
) {
    suspend fun execute(): Flow<Stage> {
        return slimeDispatchers.defaultDispatcher.start {
            val articles = api.getAllArticles(0, 10)
                .getOrThrow()?.data?.articles.getOrDefault()

            applicationScope.launch {
                articles.map {
                    val pair = cache.getRespectivePair(it.id)
                    cache.insert(it.toEntity(pair))
                }
            }.join()
        }
    }
}
