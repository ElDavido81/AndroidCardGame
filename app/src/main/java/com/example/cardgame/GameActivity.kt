package com.example.cardgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        leftCard = findViewById(R.id.iv_card1) // visa baksidan av vänstra kortet
        rightCard = findViewById(R.id.iv_card2) // visa baksidan av högra kortet
        resultText = findViewById(R.id.result_text)
        newCardsButton = findViewById(R.id.new_cards_button)
        pickText = findViewById(R.id.pick_card_text)
        pointsText = findViewById(R.id.points_text_tv)
        pointsDigit = findViewById(R.id.points_digit_tv)
        highscoreText = findViewById(R.id.highscore_tv)

        val flipCards = FlipCards(this)
        val randomCard = RandomCard()

//        fun runGame() {
            points = 0
            pointsDigit.text = "$points"
            pointsText.visibility = View.VISIBLE


            leftCard.setOnClickListener {    // välj vänstra kortet
                val firstCardNumber = RandomCard().randomCardNumber()
                val firstCardSuit = RandomCard().randomCardSuit()
                val firstCard = "$firstCardSuit$firstCardNumber"

                val secondCardNumber = RandomCard().randomCardNumber()
                val secondCardSuit = RandomCard().randomCardSuit()
                val secondCard = "$secondCardSuit$secondCardNumber"

                val displayLeftCard = randomCard.getCardFromMap(firstCard)
                val displayRightCard = randomCard.getCardFromMap(secondCard)

                leftCard.setImageResource(displayLeftCard)
                rightCard.setImageResource(displayRightCard)

                if (firstCardNumber > secondCardNumber) {
                    points++
                    flipCards.leftCardCorrect(resultText, rightCard, points, pointsDigit, pointsText, newCardsButton)

                } else if (firstCardNumber == secondCardNumber) {
                    flipCards.cardDraw(resultText, points, pointsDigit, pointsText, newCardsButton)

                } else {
                    flipCards.leftCardWrong(resultText, leftCard, pointsDigit, pointsText, newCardsButton, points)

                    if (points > highscore) {
                        newHighScore()
//                        highscore = points
//                        highscoreText.visibility = View.VISIBLE
//                        highscoreText.text = "Highscore: $points"
                    }
                    points = 0
                }

                newCardsButton.visibility = View.VISIBLE
                pickText.visibility = View.INVISIBLE

            }

            rightCard.setOnClickListener {   // välj högra kortet
                var firstCard: String
                var secondCard: String
                var secondCardNumber: Int
                var firstCardNumber: Int

                do {
                    firstCardNumber = randomCard.randomCardNumber()
                    val firstCardSuit = randomCard.randomCardSuit()
                    firstCard = "$firstCardSuit$firstCardNumber"

                    secondCardNumber = randomCard.randomCardNumber()
                    val secondCardSuit = randomCard.randomCardSuit()
                    secondCard = "$secondCardSuit$secondCardNumber"
                } while (firstCard == secondCard)

                    val displayLeftCard = randomCard.getCardFromMap(firstCard)
                    val displayRightCard = randomCard.getCardFromMap(secondCard)

                leftCard.setImageResource(displayLeftCard)
                rightCard.setImageResource(displayRightCard)

                if (firstCardNumber < secondCardNumber) {
                    points++
                    flipCards.rightCardCorrect(resultText, leftCard, points, pointsDigit, pointsText, newCardsButton)

                } else if (firstCardNumber == secondCardNumber) {
                    flipCards.cardDraw(resultText, points, pointsDigit, pointsText, newCardsButton)

                } else {
                    flipCards.rightCardWrong(resultText, rightCard, pointsDigit, pointsText, newCardsButton, points)
                    if (points > highscore) {
                        newHighScore()
//                        highscore = points
//                        highscoreText.visibility = View.VISIBLE
//                        highscoreText.text = "Highscore: $points"
                    }
                    points = 0
                }
                newCardsButton.visibility = View.VISIBLE
                pickText.visibility = View.INVISIBLE
            }

        newCardsButton.setOnClickListener {
            resetCards()
        }

    }


    fun resetCards() {
        leftCard.setImageResource(R.drawable.back)
        leftCard.alpha = 1f
        rightCard.setImageResource(R.drawable.back)
        rightCard.alpha = 1f
        resultText.visibility = View.INVISIBLE
        newCardsButton.visibility = View.INVISIBLE
        pickText.visibility = View.VISIBLE
    }

    fun newHighScore() {
        highscore = points
        highscoreText.visibility = View.VISIBLE
        highscoreText.text = "Highscore: $points"
    }

}