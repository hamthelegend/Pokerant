package com.thebrownfoxx.pokerant.model.agent.phoenix

import com.thebrownfoxx.pokerant.model.Player
import com.thebrownfoxx.pokerant.model.agent.Agent

class Phoenix(player: Player) : Agent(player) {
    override val _ability1 = Blaze(this)
    override val _ability2 = Curveball(this)
    override val _signatureAbility = HotHands(this)
    override val _ultimate = RunItBack(this)
}