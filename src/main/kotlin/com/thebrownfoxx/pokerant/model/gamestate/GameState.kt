package com.thebrownfoxx.pokerant.model.gamestate

import com.thebrownfoxx.pokerant.model.agent.base.AgentConstructor
import com.thebrownfoxx.pokerant.model.player.Player
import com.thebrownfoxx.pokerant.model.player.PlayerInitializer

const val AgentsPerPlayer = 5

class GameState(
    player1Initializer: PlayerInitializer,
    player2Initializer: PlayerInitializer,
) {
    val player1 = player1Initializer.toPlayer()
    val player2 = player2Initializer.toPlayer()

    private fun PlayerInitializer.toPlayer() = Player(
        name = name,
        agentConstructors = agentConstructors,
    )

    override fun toString() = "GameState(player1 = $player1, player2 = $player2)"
}