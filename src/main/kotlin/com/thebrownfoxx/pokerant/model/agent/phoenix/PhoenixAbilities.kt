package com.thebrownfoxx.pokerant.model.agent.phoenix

import com.thebrownfoxx.pokerant.model.agent.*

class Blaze(phoenix: Phoenix) : Ability(
    agent = phoenix,
    name = "Blaze",
    maxCharges = 1,
) {
    override val useCases = listOf(
        AbilityUseCase(prompt = "Enemy") {
            player.enemy.activeAgent.apply(
                statusEffectOf(
                    type = StatusEffectType.Smoked,
                    turnsActive = 1,
                )
            )
        },
        AbilityUseCase(prompt = "Self") {
            heal(50)
        }
    )
}

class Curveball(phoenix: Phoenix): Ability(
    agent = phoenix,
    name = "Curveball",
    maxCharges = 2,
) {
    override val useCases = listOf(
        AbilityUseCase {
            player.enemy.activeAgent.apply(
                statusEffectOf(
                    type = StatusEffectType.Flashed,
                    turnsActive = 1,
                )
            )
        },
    )
}

class HotHands(phoenix: Phoenix): Ability(
    agent = phoenix,
    name = "Hot Hands",
    maxCharges = 1,
    freeCharges = 1,
) {
    override val useCases = listOf(
        AbilityUseCase(prompt = "Enemy") {
            player.enemy.activeAgent.damage(50)
        },
        AbilityUseCase(prompt = "") {
            heal(50)
        }
    )
}

class RunItBack(phoenix: Phoenix): Ultimate(
    agent = phoenix,
    name = "Run it Back",
    requiredCharges = 1,
) {
    override val useCases = listOf(
        AbilityUseCase {
            apply(
                statusEffectOf(
                    type = StatusEffectType.RunItBack,
                    turnsActive = 1,
                )
            )
        }
    )
}