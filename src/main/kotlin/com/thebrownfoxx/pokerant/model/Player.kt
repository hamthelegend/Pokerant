package com.thebrownfoxx.pokerant.model

import com.thebrownfoxx.pokerant.model.agent.Agent

class Player(
    val gameState: GameState,
    val name: String,
    val agents: List<Agent>,
) {
    var activeAgent = agents.first()
        private set

    var credits = 4000
        private set

    val enemy
        get() = when (this) {
            gameState.player1 -> gameState.player2
            else -> gameState.player1
        }
}

fun GameState.Player(
    name: String,
    agents: List<Agent>,
) = Player(gameState = this, name = name, agents = agents)