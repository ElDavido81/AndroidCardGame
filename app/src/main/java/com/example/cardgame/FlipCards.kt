package com.example.cardgame

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class FlipCards(private val context: Context) {


fun leftCard(resultText: TextView, rightCard: ImageView, points: Int, pointsDigit: TextView, pointsText: TextView, newCardsButton: Button) {
    resultText.visibility = View.VISIBLE
    resultText.text = "Nice!"
    resultText.setRotation(-5f)
    rightCard.alpha = 0.5f
    pointsDigit.text = "$points"
    pointsText.visibility = View.VISIBLE
    newCardsButton.setBackgroundColor(ContextCompat.getColor(context, R.color.green))
    newCardsButton.text = "New cards"
}

}
