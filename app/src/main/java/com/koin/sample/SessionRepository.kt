package com.koin.sample

interface SessionRepository {
    fun getSession(): String
}

class SessionRepositoryImpl(private val session: Session) : SessionRepository {
    override fun getSession() = session.getToken()
}