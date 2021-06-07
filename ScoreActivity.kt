package com.vinti.quizapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        var highScore = 0
        var loaded = false

        var receivingIntent = intent

        var score = receivingIntent.getIntExtra("score", 0)

        currentScore.text = "Score : $score"

        // SharedPrefences
        // File --> data save

        var sharedPreferences: SharedPreferences = getPreferences(Context.MODE_PRIVATE)
        highScore = sharedPreferences.getInt("score", 0)
        loaded = sharedPreferences.getBoolean("loaded", false)
        //var sharedPreferences : SharedPreferences.Editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()

        // 50 > 40
        if(score > highScore)
        {
            // for saving value with shared preference
            var sharedPreferences: SharedPreferences.Editor = getPreferences(Context.MODE_PRIVATE).edit()
            sharedPreferences.putInt("score", score)
            sharedPreferences.putBoolean("loaded", true)
            sharedPreferences.apply()
            // score : 20
        }
        // 50 > 40
        if(score > highScore)
        {
            currentScore.text = score.toString()
            highestScore.text = score.toString()
        }
        else{
            currentScore.text = score.toString()
            highestScore.text = highScore.toString()
        }
//        if(score > highScore)
//        {
//            currentScore.text = score.toString()
//            highestScore.text = score.toString()
//        }
//        else{
//            currentScore.text = score.toString()
//            highestScore.text = highScore.toString()
//        }
    }
}
