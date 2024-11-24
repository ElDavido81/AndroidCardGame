package com.example.cardgame

class RandomCard() {

    val cardList = mutableListOf<String>()

    init {
        cardsSuits()
    }

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
            val rnd = (0 until cardList.size).random()
            val cardSuit = cardList[rnd]
            return cardSuit
        }


    }

