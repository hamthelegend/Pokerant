package com.thebrownfoxx.pokerant.model.player

import com.thebrownfoxx.pokerant.model.gamestate.GameState
import com.thebrownfoxx.pokerant.model.agent.base.AgentConstructor

class Player(
    val gameState: GameState,
    val name: String,
    agentConstructors: List<AgentConstructor>,
) {
    val agents = agentConstructors.map { it.construct(this) }

    var activeAgent = agents.first()
        private set

    var credits = 4000
        private set

    val enemy
        get() = when (this) {
            gameState.player1 -> gameState.player2
            else -> gameState.player1
        }

    override fun toString() = "Player(name = $name, agents = $agents, activeAgent = $activeAgent, credits = $credits)"
}

fun GameState.Player(
    name: String,
    agentConstructors: List<AgentConstructor>,
) = Player(gameState = this, name = name, agentConstructors = agentConstructors)