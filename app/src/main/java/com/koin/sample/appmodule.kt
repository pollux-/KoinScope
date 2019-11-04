package com.koin.sample

import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    scope(named("session")) {
        scoped { Session() }
    }

    single<SessionRepository> {
        val scope = getKoin().getOrCreateScope(
            "sessionID", named("session"))
        val session = scope.getScope("sessionID").get<Session>()
        SessionRepositoryImpl(session)
    }
    single { SessionPresenter(get()) }
}
