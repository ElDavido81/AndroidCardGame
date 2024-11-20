package com.example.cardgame

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var leftCard : ImageView
    lateinit var rightCard : ImageView
    val randomCard = RandomCard().randomCard()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        leftCard = findViewById<ImageView>(R.id.iv_card1)

        val displayLeftCard = resources.getIdentifier(randomCard.toString(), "drawable", this.packageName) // spara det slumpade kortet i en variabel

        leftCard.setOnClickListener {    // byt vänstra kortet
            leftCard.setImageResource(displayLeftCard)
            rightCard.setImageResource(R.drawable.h2half)
            Toast.makeText(this, randomCard, Toast.LENGTH_SHORT).show()

        }

        rightCard = findViewById<ImageView>(R.id.iv_card2)
        rightCard.setOnClickListener {   // byt högra kortet
            leftCard.setImageResource(R.drawable.h2)
            rightCard.setImageResource(R.drawable.h2)
        }
    }

    fun randomCard() {

    }

}