package com.example.kotlin.course.enums

enum class CardType {
    SPADES, HEARTS, CLUBS, DIAMONDS
}

enum class CardTypeParam(val label: String) {
    // case that requires ';' at end of expression (when a function exists in enum)
    SPADES("spades"), HEARTS("hearts"), CLUBS("clubs"), DIAMONDS("diamonds");

    fun printLabel() {
        println("label: $label")
    }
}

