package com.thebrownfoxx.pokerant.model.agent

import com.thebrownfoxx.pokerant.model.Player
import com.thebrownfoxx.pokerant.model.agent.phoenix.Phoenix

enum class AgentConstructor(val agentName: String, val construct: (Player) -> Agent) {
    Phoenix("Phoenix", { player -> Phoenix(player) }),
}