package com.thebrownfoxx.pokerant.game

import com.thebrownfoxx.pokerant.model.gamestate.GameState
import com.thebrownfoxx.pokerant.model.player.PlayerInitializer

fun main() {
    val player1Initializer = getPlayerInitializer(1)
    val player2Initializer = getPlayerInitializer(2)
    val gameState = GameState(player1Initializer, player2Initializer)
}