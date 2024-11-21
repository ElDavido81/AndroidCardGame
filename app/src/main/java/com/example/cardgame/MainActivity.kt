package com.example.cardgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var leftCard : ImageView
    lateinit var rightCard : ImageView
    lateinit var resultText : TextView
    lateinit var pickText : TextView
    lateinit var newCardsButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        leftCard = findViewById<ImageView>(R.id.iv_card1) // visa baksidan av vänstra kortet
        rightCard = findViewById<ImageView>(R.id.iv_card2) // visa baksidan av högra kortet
        resultText = findViewById<TextView>(R.id.result_text)
        newCardsButton = findViewById<Button>(R.id.new_cards_button)
        pickText = findViewById<TextView>(R.id.pick_card_text)

        newCardsButton.setOnClickListener {
            leftCard.setImageResource(R.drawable.back)
            rightCard.setImageResource(R.drawable.back)
            resultText.visibility = View.INVISIBLE
            newCardsButton.visibility = View.INVISIBLE
            pickText.visibility = View.VISIBLE
        }


        leftCard.setOnClickListener {    // välj vänstra kortet
            val randomCard1 = RandomCard().randomCard()
            val randomCard2 = (RandomCard().randomCard())+"h"
            val displayLeftCard = resources.getIdentifier(randomCard1, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för vänstra kortet
            val displayRightCard = resources.getIdentifier(randomCard2, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för högra kortet
            leftCard.setImageResource(displayLeftCard)
            rightCard.setImageResource(displayRightCard)
            Toast.makeText(this, randomCard1+" "+randomCard2, Toast.LENGTH_SHORT).show()

            resultText.visibility = View.VISIBLE
            resultText.text = "Nice!"
            newCardsButton.visibility = View.VISIBLE
            pickText.visibility = View.INVISIBLE

        }

        rightCard.setOnClickListener {   // välj högra kortet
            val randomCard1 = (RandomCard().randomCard())+"h"
            val randomCard2 = RandomCard().randomCard()
            val displayLeftCard = resources.getIdentifier(randomCard1, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för vänstra kortet
            val displayRightCard = resources.getIdentifier(randomCard2, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för högra kortet
            leftCard.setImageResource(displayLeftCard)
            rightCard.setImageResource(displayRightCard)
            Toast.makeText(this, randomCard2+" "+randomCard1, Toast.LENGTH_SHORT).show()

            resultText.visibility = View.VISIBLE
            resultText.text = "Nope!"
            newCardsButton.visibility = View.VISIBLE
            pickText.visibility = View.INVISIBLE


        }



    }

    }