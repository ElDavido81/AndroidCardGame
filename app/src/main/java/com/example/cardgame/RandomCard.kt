package com.example.cardgame

class RandomCard() {

    val cardList = mutableListOf<String>()
    lateinit var currentCard : String

    init {
        initializeCards()
    }

    fun initializeCards() {

        cardList.add("h1")
        cardList.add("h2")
        cardList.add("h3")
        cardList.add("h4")
        cardList.add("h5")
        cardList.add("h6")
        cardList.add("h7")
        cardList.add("h8")
        cardList.add("h9")
        cardList.add("h10")
        cardList.add("h11")
        cardList.add("h12")
        cardList.add("h13")

    }

    fun randomCard() : String {
        val rnd = (0 until cardList.size).random()
        currentCard = cardList[rnd]
        return currentCard
    }

}

