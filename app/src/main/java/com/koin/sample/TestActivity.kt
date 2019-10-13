package com.koin.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.getKoin

class TestActivity : AppCompatActivity() {

    val scope = getKoin().getScope("sessionID")
    val session = scope.get<Session>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TEST", "Token ::  " + session.getToken())

        val scope = getKoin().getScope("sessionID")
        scope.close()
        getKoin().deleteScope("sessionID")


        Log.d("TEST", "Token ::  " + session.getToken())

        clickMe.setOnClickListener {
            startActivity(Intent(baseContext, MainActivity::class.java))
        }
    }
}
