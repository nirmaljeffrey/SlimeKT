package slime.com.routes

import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import slime.com.plugins.userId
import slime.com.service.AuthService
import slime.com.service.SubscriptionService
import slime.com.utils.getUserId
import slime.com.utils.respondWith
import slime.com.utils.respondWithResult

fun Route.registerSubscribeCategoriesRoute(
    service: SubscriptionService,
    authService: AuthService
) {

    authenticate {
        post("/api/subscribedCategories/subscribe") {
            getUserId(authService) { userId ->
                respondWithResult {
                    service.verifyAndSubscribe(userId, call.parameters["id"] ?: return@post)
                }
            }
        }
    }

    authenticate {
        get("api/subscribedCategories/get") {
            val userId = call.userId ?: return@get
            respondWith(service.getUserSubscribedCategories(userId))
        }
    }

    authenticate {
        post("/api/subscribedCategories/unsubscribe") {
            getUserId(authService) { userId ->
                respondWithResult {
                    service.verifyAndUnsubscribe(userId, call.parameters["id"] ?: return@post)
                }
            }
        }
    }

    authenticate {
        get("/api/subscribedCategories/check") {
            getUserId(authService) { userId ->
                val data = service.checkIfUserSubscribes(userId, call.parameters["id"] ?: return@get)
                respondWith(data)
            }
        }
    }

    authenticate {
        get("api/subscribedCategories/explore") {
            val userId = call.userId ?: return@get
            respondWith(service.getCategoriesNotSubscribed(userId) ?: listOf())
        }
    }

    authenticate {
        get("api/subscribedCategories/totalSubscribers") {
            respondWith(service.getNumber(call.parameters["id"] ?: return@get))
        }
    }
}
