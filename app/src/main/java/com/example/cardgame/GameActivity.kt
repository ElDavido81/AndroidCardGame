package com.example.cardgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {

    lateinit var leftCard : ImageView
    lateinit var rightCard : ImageView
    lateinit var resultText : TextView
    lateinit var pickText : TextView
    lateinit var newCardsButton : Button
    lateinit var pointsText : TextView
    lateinit var pointsDigit : TextView
    lateinit var highscoreText : TextView
    var points : Int = 0
    var highscore : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
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
        pointsText = findViewById<TextView>(R.id.points_text_tv)
        pointsDigit = findViewById<TextView>(R.id.points_digit_tv)
        highscoreText = findViewById<TextView>(R.id.highscore_tv)


        newCardsButton.setOnClickListener {
            leftCard.setImageResource(R.drawable.back)
            leftCard.alpha = 1f
            rightCard.setImageResource(R.drawable.back)
            rightCard.alpha = 1f
            resultText.visibility = View.INVISIBLE
            newCardsButton.visibility = View.INVISIBLE
            pickText.visibility = View.VISIBLE
        }


        leftCard.setOnClickListener {    // välj vänstra kortet
            val firstCardNumber = RandomCard().randomCardNumber()
            val firstCardSuit = RandomCard().randomCardSuit()
            val firstCard = "$firstCardSuit$firstCardNumber"

            val secondCardNumber = RandomCard().randomCardNumber()
            val secondCardSuit = RandomCard().randomCardSuit()
            val secondCard = "$secondCardSuit$secondCardNumber"

            val displayLeftCard = resources.getIdentifier(firstCard, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för vänstra kortet
            val displayRightCard = resources.getIdentifier(secondCard, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för högra kortet

            leftCard.setImageResource(displayLeftCard)
            rightCard.setImageResource(displayRightCard)
//            rightCard.alpha = 0.5f

//            Toast.makeText(this, firstCard+" "+secondCard, Toast.LENGTH_SHORT).show()

            if (firstCardNumber>secondCardNumber){
                resultText.visibility = View.VISIBLE
                resultText.text = "Nice!"
                resultText.setRotation(-5f)
                rightCard.alpha = 0.5f
                points++
                pointsDigit.text = "$points"
                pointsText.visibility = View.VISIBLE
                newCardsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                newCardsButton.text = "New cards"

            } else if (firstCardNumber == secondCardNumber) {
                resultText.visibility = View.VISIBLE
                resultText.text = "None"
                resultText.setRotation(0f)
                pointsDigit.text = "$points"
                pointsText.visibility = View.VISIBLE
                newCardsButton.text = "New cards"
                newCardsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))

            } else {
                resultText.visibility = View.VISIBLE
                resultText.text = "Nope!"
                resultText.setRotation(5f)
                leftCard.alpha = 0.5f
                if (points>highscore) {
                    highscore=points
                    highscoreText.visibility = View.VISIBLE
                    highscoreText.text = "Highscore: $points"
                }
                points = 0
                pointsDigit.text = "$points"
                pointsText.visibility = View.VISIBLE
                newCardsButton.text = "New game"
                newCardsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))

            }

            newCardsButton.visibility = View.VISIBLE
            pickText.visibility = View.INVISIBLE

        }

        rightCard.setOnClickListener {   // välj högra kortet
            val firstCardNumber = RandomCard().randomCardNumber()
            val firstCardSuit = RandomCard().randomCardSuit()
            val firstCard = "$firstCardSuit$firstCardNumber"

            val secondCardNumber = RandomCard().randomCardNumber()
            val secondCardSuit = RandomCard().randomCardSuit()
            val secondCard = "$secondCardSuit$secondCardNumber"

            val displayLeftCard = resources.getIdentifier(firstCard, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för vänstra kortet
            val displayRightCard = resources.getIdentifier(secondCard, "drawable", this.packageName) // spara det slumpade kortet i en variabeln för högra kortet
            leftCard.setImageResource(displayLeftCard)
//            leftCard.alpha = 0.5f
            rightCard.setImageResource(displayRightCard)

//            Toast.makeText(this, secondCard+" "+firstCard, Toast.LENGTH_SHORT).show()


            if (firstCardNumber<secondCardNumber){
                resultText.visibility = View.VISIBLE
                resultText.text = "Nice!"
                resultText.setRotation(-5f)
                leftCard.alpha = 0.5f
                points++
                pointsDigit.text = "$points"
                pointsText.visibility = View.VISIBLE
                newCardsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                newCardsButton.text = "New cards"

            } else if (firstCardNumber == secondCardNumber) {
                resultText.visibility = View.VISIBLE
                resultText.text = "None"
                resultText.setRotation(0f)
                pointsDigit.text = "$points"
                pointsText.visibility = View.VISIBLE
                newCardsButton.text = "New cards"
                newCardsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))

            } else {
                resultText.visibility = View.VISIBLE
                resultText.text = "Nope!"
                resultText.setRotation(5f)
                rightCard.alpha = 0.5f
                points = 0
                pointsDigit.text = "$points"
                pointsText.visibility = View.VISIBLE
                if (points>highscore) {
                    highscore=points
                    highscoreText.visibility = View.VISIBLE
                    highscoreText.text = "Highscore: $points"
                }
                newCardsButton.text = "New game"
                newCardsButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))

            }

            newCardsButton.visibility = View.VISIBLE
            pickText.visibility = View.INVISIBLE

        }


    }
}