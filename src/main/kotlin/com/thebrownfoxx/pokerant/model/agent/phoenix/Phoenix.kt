package com.thebrownfoxx.pokerant.model.agent.phoenix

import com.thebrownfoxx.pokerant.model.Player
import com.thebrownfoxx.pokerant.model.agent.Agent
import com.thebrownfoxx.pokerant.model.agent.AgentConstructor

class Phoenix(player: Player) : Agent(
    player = player,
    name = AgentConstructor.Phoenix.agentName,
) {
    override val ability1 = Blaze(this)
    override val ability2 = Curveball(this)
    override val signatureAbility = HotHands(this)
    override val ultimate = RunItBack(this)
}