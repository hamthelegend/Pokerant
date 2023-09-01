package com.thebrownfoxx.pokerant.model.gamestate

import com.thebrownfoxx.pokerant.model.agent.base.AgentConstructor
import com.thebrownfoxx.pokerant.model.player.Player

const val AgentsPerPlayer = 1

class GameState(
    player1Name: String,
    player1Agents: List<AgentConstructor>,
    player2Name: String,
    player2Agents: List<AgentConstructor>
) {
    val player1 = Player(player1Name, player1Agents)
    val player2 = Player(player2Name, player2Agents)

    override fun toString() = "GameState(player1 = $player1, player2 = $player2)"
}