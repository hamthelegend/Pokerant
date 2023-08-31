package com.thebrownfoxx.pokerant.model.agent

import kotlin.math.min

const val MaxHp = 100
const val MaxArmor = 50
const val ArmorAbsorption = 0.66f

abstract class Agent {
    var hp = MaxHp
        private set(value) {
            field = when {
                value < 0 -> 0
                value > MaxHp -> MaxHp
                else -> value
            }
        }
    var armor = 0
        private set(value) {
            field = when {
                value < 0 -> 0
                value > MaxArmor -> MaxArmor
                else -> value
            }
        }

    abstract val _ability1: Ability
    abstract val _ability2: Ability
    abstract val _signatureAbility: Ability
    abstract val _ultimate: Ultimate

    private val _statusEffects = mutableListOf<MutableStatusEffect>()
    val statusEffects: List<StatusEffect> = _statusEffects

    fun damage(amount: Int) {
        val damageForArmor = min((ArmorAbsorption * amount).toInt(), armor)
        armor -= damageForArmor
        val remainingDamage = amount - damageForArmor
        hp -= remainingDamage
    }

    fun heal(amount: Int) {
        hp += amount
    }

    fun overheal(amount: Int) {
        val healingForHp = min(amount, MaxHp - hp)
        hp += healingForHp
        val remainingHealing = amount - healingForHp
        armor += remainingHealing
    }

    fun applyStatusEffect(statusEffect: MutableStatusEffect) {
        val duplicates = _statusEffects.filter { it.type == statusEffect.type }
        _statusEffects.removeAll(duplicates)
        _statusEffects.add(statusEffect)
    }

    fun tickStatusEffectsDown() {
        for (statusEffect in _statusEffects) {
            statusEffect.tickDown()
            if (statusEffect.turnsActive <= 0) _statusEffects.remove(statusEffect)
        }
    }
}
