package com.thebrownfoxx.pokerant.model.player

import com.thebrownfoxx.pokerant.model.agent.base.AgentConstructor

data class PlayerInitializer(
    val name: String,
    val agentConstructors: List<AgentConstructor>,
)