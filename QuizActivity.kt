package com.vinti.quizapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.vinti.quizapplication.controller.Factory
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    lateinit var questionArray : Array<String>
    lateinit var optionsArray : Array<String>
    lateinit var answerArray : Array<String>
    lateinit var heartImageView : Array<ImageView>
    lateinit var buttonArray : Array<Button>
    lateinit var handler : Handler

    lateinit var timer : Timer
    val DELAY_MILLISECONDS : Long = 2000
    val TOTAL_QUESTIONS = 5
    var score = 0
    var counter = 0
    var heartCounter = 0
    var flag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        heartImageView = arrayOf(heart3, heart2, heart1)
        buttonArray = arrayOf(option1, option2, option3, option4)

        handler = Handler()

        var receivingIntent = intent
        var selected = receivingIntent.getStringExtra("selected")
        // selected = "Android or Python"

        var factory = Factory()
        var createdObject = factory.passData(selected)

        questionArray = createdObject!!.questions
        optionsArray = createdObject!!.options
        answerArray = createdObject!!.answers

        timer = Timer()

        timer.start()

        loadQuestion()
    }

    inner class Timer : CountDownTimer(21000, 1000)
    {
        override fun onFinish() {
            counter++
            loadQuestion()
            heartImageView[heartCounter].visibility = View.INVISIBLE
            heartCounter++
        }

        override fun onTick(millisUntilFinished: Long)
        {
          timerTextView.text = (millisUntilFinished/1000).toString()
        }
    }

    fun loadQuestion()
    {

        if(counter >= TOTAL_QUESTIONS && heartCounter != 2)
        {
            callScoreActivity()
        }
        else if(counter < TOTAL_QUESTIONS){

            for (i in 0..3)
            {
                buttonArray[i].background = null
            }

            questionTextView.text = questionArray[counter] // 1
            option1.text = optionsArray[4 * counter + 0] // 4 * 1 = 4
            option2.text = optionsArray[4 * counter + 1] // 4 * 1 = 4 + 1 = 5
            option3.text = optionsArray[4 * counter + 2] // 6
            option4.text = optionsArray[4 * counter + 3] // 7
            timer.cancel()
            timer.start()
        }
    }

    fun checkScore(view : View)
    {
        var button = findViewById<Button>(view.id)
        var buttonText = button.text.toString()

        if(buttonText == answerArray[counter]) // 0
        {
            score += 10
            // TAG --> class name or method name or variable name
            Log.i("QuizActivity", "Score is : $score")
            button.setBackgroundResource(android.R.color.holo_green_dark)
        }
        else{

            button.setBackgroundResource(android.R.color.holo_red_light)

            for(i in 0..3)
            {
                    if(buttonArray[i].text == answerArray[counter]) {
                        buttonArray[i].setBackgroundResource(android.R.color.holo_green_dark)
                        break
                    }
            }

            if(heartCounter >= 2)
            {
                callScoreActivity()
            }
            else {
                heartImageView[heartCounter].visibility = View.INVISIBLE
                heartCounter++
            }

        }
        // Log --> Ready made class for developers
        handler.postDelayed({
            counter++   // 1
            loadQuestion()
        }, DELAY_MILLISECONDS)
    }

    fun callScoreActivity(){
        flag = 1
        var intent = Intent(this, ScoreActivity :: class.java)
        intent.putExtra("score", score)
        startActivity(intent)
        timer.cancel()
        finish()
    }
}
