package com.koin.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

    private val sessionPresenter: SessionPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getKoin().createScope("sessionID", named("session"))
        sessionPresenter.getSession()
        Log.d("TEST", "Token " + sessionPresenter.getSession())
        sessionPresenter.clearSession()
        sessionPresenter.getSession()
        Log.d("TEST", "Token " + sessionPresenter.getSession())


        clickMe.setOnClickListener {
            startActivity(Intent(baseContext, TestActivity::class.java))
        }
    }

}
