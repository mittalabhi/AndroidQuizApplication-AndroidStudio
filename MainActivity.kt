package com.vinti.quizapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var handler = Handler()

        handler.postDelayed(Runnable{


            var intent = Intent(this, MenuActivity :: class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
}
