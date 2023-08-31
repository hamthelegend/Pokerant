package com.thebrownfoxx.pokerant.model

import com.thebrownfoxx.pokerant.model.agent.Agent
import kotlin.random.Random

class Player(
    val name: String,
    val agents: List<Agent>,
) {
    var activeAgent = agents.first()
        private set

    var credits = 4000
        private set
}