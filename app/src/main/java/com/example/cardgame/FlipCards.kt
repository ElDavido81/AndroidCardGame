package com.example.cardgame

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class FlipCards(private val context: Context) {


fun leftCardCorrect(resultText: TextView, rightCard: ImageView, points: Int, pointsDigit: TextView, pointsText: TextView, newCardsButton: Button) {
    resultText.visibility = View.VISIBLE
    resultText.text = "Nice!"
    resultText.setRotation(-5f)
    rightCard.alpha = 0.5f
    pointsDigit.text = "$points"
    pointsText.visibility = View.VISIBLE
    newCardsButton.setBackgroundColor(ContextCompat.getColor(context, R.color.green))
    newCardsButton.text = "New cards"
}

    fun cardDraw(resultText: TextView, points: Int, pointsDigit: TextView, pointsText: TextView, newCardsButton: Button){
        resultText.visibility = View.VISIBLE
        resultText.text = "None"
        resultText.setRotation(0f)
        pointsDigit.text = "$points"
        pointsText.visibility = View.VISIBLE
        newCardsButton.text = "New cards"
        newCardsButton.setBackgroundColor(ContextCompat.getColor(context, R.color.blue))
    }

    fun leftCardWrong(resultText: TextView, leftCard: ImageView, pointsDigit: TextView, pointsText: TextView, newCardsButton: Button, points: Int){
        resultText.visibility = View.VISIBLE
        resultText.text = "Nope!"
        resultText.setRotation(5f)
        leftCard.alpha = 0.5f
        pointsDigit.text = "$points"
        pointsText.visibility = View.VISIBLE
        newCardsButton.text = "New game"
        newCardsButton.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
    }

    fun rightCardCorrect(resultText: TextView, leftCard: ImageView, points: Int, pointsDigit: TextView, pointsText: TextView, newCardsButton: Button) {
        resultText.visibility = View.VISIBLE
        resultText.text = "Nice!"
        resultText.setRotation(-5f)
        leftCard.alpha = 0.5f
        pointsDigit.text = "$points"
        pointsText.visibility = View.VISIBLE
        newCardsButton.setBackgroundColor(ContextCompat.getColor(context, R.color.green))
        newCardsButton.text = "New cards"
    }

    fun rightCardWrong(resultText: TextView, rightCard: ImageView, pointsDigit: TextView, pointsText: TextView, newCardsButton: Button, points: Int) {
        resultText.visibility = View.VISIBLE
        resultText.text = "Nope!"
        resultText.setRotation(5f)
        rightCard.alpha = 0.5f
        pointsDigit.text = "$points"
        pointsText.visibility = View.VISIBLE
        newCardsButton.text = "New game"
        newCardsButton.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
    }

}
