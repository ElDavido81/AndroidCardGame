package com.example.cardgame

class RandomCard {

    val cardList = mutableListOf<String>()

    private val deckOfCards = mapOf(
        "h2" to R.drawable.h2,
        "h3" to R.drawable.h3,
        "h4" to R.drawable.h4,
        "h5" to R.drawable.h5,
        "h6" to R.drawable.h6,
        "h7" to R.drawable.h7,
        "h8" to R.drawable.h8,
        "h9" to R.drawable.h9,
        "h10" to R.drawable.h10,
        "h11" to R.drawable.h11,
        "h12" to R.drawable.h12,
        "h13" to R.drawable.h13,
        "h14" to R.drawable.h14,

        "d2" to R.drawable.d2,
        "d3" to R.drawable.d3,
        "d4" to R.drawable.d4,
        "d5" to R.drawable.d5,
        "d6" to R.drawable.d6,
        "d7" to R.drawable.d7,
        "d8" to R.drawable.d8,
        "d9" to R.drawable.d9,
        "d10" to R.drawable.d10,
        "d11" to R.drawable.d11,
        "d12" to R.drawable.d12,
        "d13" to R.drawable.d13,
        "d14" to R.drawable.d14,

        "c2" to R.drawable.c2,
        "c3" to R.drawable.c3,
        "c4" to R.drawable.c4,
        "c5" to R.drawable.c5,
        "c6" to R.drawable.c6,
        "c7" to R.drawable.c7,
        "c8" to R.drawable.c8,
        "c9" to R.drawable.c9,
        "c10" to R.drawable.c10,
        "c11" to R.drawable.c11,
        "c12" to R.drawable.c12,
        "c13" to R.drawable.c13,
        "c14" to R.drawable.c14,

        "s2" to R.drawable.s2,
        "s3" to R.drawable.s3,
        "s4" to R.drawable.s4,
        "s5" to R.drawable.s5,
        "s6" to R.drawable.s6,
        "s7" to R.drawable.s7,
        "s8" to R.drawable.s8,
        "s9" to R.drawable.s9,
        "s10" to R.drawable.s10,
        "s11" to R.drawable.s11,
        "s12" to R.drawable.s12,
        "s13" to R.drawable.s13,
        "s14" to R.drawable.s14,
    )

        fun cardsSuits() {
        cardList.add("h")
        cardList.add("d")
        cardList.add("c")
        cardList.add("s")
    }

        fun randomCardNumber() : Int {
             val cardNumber = (2 until 14).random()
             return cardNumber
        }

        fun randomCardSuit() : String {
            cardsSuits()
            val rnd = (0 until cardList.size).random()
            val cardSuit = cardList[rnd]
            return cardSuit
        }

        fun getCardFromMap(card: String): Int {
            return deckOfCards[card]?: throw IllegalArgumentException("No image")
        }

    }
