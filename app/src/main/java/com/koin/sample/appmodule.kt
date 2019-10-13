package com.koin.sample

import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    scope(named("session")) {
        scoped { Session() }
    }

    single<SessionRepository> {
        // SessionRepositoryImpl(getScope("sessionID").get<Session>()) as SessionRepository
        val sessionProvider = { getScope("sessionID").get<Session>() }
        SessionRepositoryImpl(sessionProvider)
    }
    single { SessionPresenter(get()) }
}