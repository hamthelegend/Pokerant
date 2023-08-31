package com.thebrownfoxx.pokerant.model

class GameState(
    val player1: Player,
    val player2: Player,
) {
    val Player.enemy get() = when (this) {
        player1 -> player2
        else -> player1
    }
}