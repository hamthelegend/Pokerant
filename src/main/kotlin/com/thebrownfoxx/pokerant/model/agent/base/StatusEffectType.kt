package com.thebrownfoxx.pokerant.model.agent.base

enum class StatusEffectType {
    Smoked,
    Flashed,
    RunItBack,
}

abstract class StatusEffect {
    abstract val type: StatusEffectType
    abstract val turnsActive: Int
}

class MutableStatusEffect(
    override val type: StatusEffectType,
    turnsActive: Int,
): StatusEffect() {
    override var turnsActive = turnsActive
        private set

    fun tickDown() {
        if (turnsActive > 0) turnsActive--
    }
}

fun statusEffectOf(
    type: StatusEffectType,
    turnsActive: Int,
) = MutableStatusEffect(type, turnsActive)