package com.thebrownfoxx.pokerant.model.agent.phoenix

import com.thebrownfoxx.pokerant.model.agent.Ability
import com.thebrownfoxx.pokerant.model.agent.AbilityUseCase

class Blaze: Ability(
    name = "Blaze",
    maxCharges = 1,
) {
    override val useCases = listOf(
        AbilityUseCase(prompt = "Enemy") {

        }
    )
}