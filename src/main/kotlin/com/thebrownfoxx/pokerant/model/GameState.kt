package com.thebrownfoxx.pokerant.model

import com.thebrownfoxx.pokerant.model.agent.Agent

class GameState(
    player1Name: String,
    player1Agents: List<Agent>,
    player2Name: String,
    player2Agents: List<Agent>
) {
    val player1 = Player(player1Name, player1Agents)
    val player2 = Player(player2Name, player2Agents)
}