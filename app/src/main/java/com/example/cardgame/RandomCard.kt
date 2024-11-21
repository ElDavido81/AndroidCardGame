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
        cardList.add("h14")

        cardList.add("d1")
        cardList.add("d2")
        cardList.add("d3")
        cardList.add("d4")
        cardList.add("d5")
        cardList.add("d6")
        cardList.add("d7")
        cardList.add("d8")
        cardList.add("d9")
        cardList.add("d10")
        cardList.add("d11")
        cardList.add("d12")
        cardList.add("d13")
        cardList.add("d14")

        cardList.add("c1")
        cardList.add("c2")
        cardList.add("c3")
        cardList.add("c4")
        cardList.add("c5")
        cardList.add("c6")
        cardList.add("c7")
        cardList.add("c8")
        cardList.add("c9")
        cardList.add("c10")
        cardList.add("c11")
        cardList.add("c12")
        cardList.add("c13")
        cardList.add("c14")

        cardList.add("s1")
        cardList.add("s2")
        cardList.add("s3")
        cardList.add("s4")
        cardList.add("s5")
        cardList.add("s6")
        cardList.add("s7")
        cardList.add("s8")
        cardList.add("s9")
        cardList.add("s10")
        cardList.add("s11")
        cardList.add("s12")
        cardList.add("s13")
        cardList.add("s14")

    }

    fun randomCard() : String {
        val rnd = (0 until cardList.size).random()
        currentCard = cardList[rnd]
        return currentCard
    }

}

