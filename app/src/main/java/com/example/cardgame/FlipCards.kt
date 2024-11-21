package com.example.cardgame

import android.content.Context
import android.widget.Toast

class FlipCards(private val context: Context) {

    val randomCard1 = RandomCard().randomCard()
    val randomCard2 = (RandomCard().randomCard())+"h"

    fun chooseLeftCard() {
        val displayLeftCard = context.resources.getIdentifier(randomCard1.toString(), "drawable", context.packageName)
        val displayRightCard = context.resources.getIdentifier(randomCard2.toString(), "drawable", context.packageName)
    Toast.makeText(context, randomCard1+" "+randomCard2, Toast.LENGTH_SHORT).show()
    }

}