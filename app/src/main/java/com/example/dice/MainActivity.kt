package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var game = true
    var dice = intArrayOf(
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice44,
        R.drawable.dice5,
        R.drawable.dice6
    )

    fun diceroll(v:View) {
        textView = findViewById<TextView>(R.id.status)
        img1 = findViewById<ImageView>(R.id.img1)
        img2 = findViewById<ImageView>(R.id.img2)
        val d1 = (0..6).random()
        //val d1 = random1.nextInt(packageName)
        val d2 =(0..6).random()
      //  val d2 = random2.nextInt(6)
        if (!game) reset(v)
        if (d1 > d2) textView?.setText(" WINNER IS PLAYER1 To RESTART click here!!")
        else if (d1 < d2) textView?.setText("  WINNER IS PLAYER2 To RESTART click here!!")
        else textView?.setText("   MATCH DRAW To RESTART click here!!")
        img1?.setImageResource(dice[d1])
        img2?.setImageResource(dice[d2])
    }

    fun reset(v: View?) {
        game = true
        for (d in dice.indices) {
            (findViewById<View>(R.id.img1) as ImageView).setImageResource(R.drawable.dice1)
            (findViewById<View>(R.id.img2) as ImageView).setImageResource(R.drawable.dice1)
            textView = findViewById<TextView>(R.id.status)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        var textView: TextView? = null
        var img1: ImageView? = null
        var img2: ImageView? = null
    }
}