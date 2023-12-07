package com.example.my.cargame

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), GameTask {

    private lateinit var rootLayout: LinearLayout
    private lateinit var startBtn: Button
    private lateinit var gameView: GameView
    private lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        gameView = GameView(this, this)

        startBtn.setOnClickListener {
            gameView.setBackgroundResource(R.drawable.img)
            rootLayout.addView(gameView)
            startBtn.visibility = View.GONE
            score.visibility = View.GONE
        }
    }

    @SuppressLint("SetTextI18n")
    override fun closeGame(mScore: Int) {
        this.score.text = "Score : $mScore"
        rootLayout.removeView(gameView)
        startBtn.visibility = View.VISIBLE
        this.score.visibility = View.VISIBLE
    }

}