package com.thebrownfoxx.pokerant.model.agent

enum class StatusEffectType {
    Flashed,
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