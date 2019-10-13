package com.koin.sample

import org.koin.core.KoinComponent

class SessionPresenter(val repo: SessionRepository) : KoinComponent {

    fun getSession() = repo.getSession()

    fun clearSession(){
        val scope = getKoin().getScope("sessionID")
        scope.close()
        getKoin().deleteScope("sessionID")
    }

}