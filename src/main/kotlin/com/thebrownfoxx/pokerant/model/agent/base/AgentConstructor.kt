package com.thebrownfoxx.pokerant.model.agent.base

import com.thebrownfoxx.pokerant.model.player.Player
import com.thebrownfoxx.pokerant.model.agent.phoenix.Phoenix

enum class AgentConstructor(val agentName: String, val construct: (Player) -> Agent) {
    Phoenix("Phoenix", { player -> Phoenix(player) }),
}