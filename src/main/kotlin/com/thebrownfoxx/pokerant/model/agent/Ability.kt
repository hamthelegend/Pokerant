package com.thebrownfoxx.pokerant.model.agent

import com.thebrownfoxx.pokerant.model.GameState
import com.thebrownfoxx.pokerant.model.OnTry

abstract class Ability(
    val name: String,
    val maxCharges: Int,
    freeCharges: Int = 0,
) {
    private var existingCharges = freeCharges
    private var queuedCharges = 0
    val charges get() = existingCharges + queuedCharges

    protected abstract val useCases: List<AbilityUseCase>
    val useCasePrompts get() = useCases.map { it.prompt }

    fun tryBuy(onTry: OnTry) {
        if (charges < maxCharges) {
            queuedCharges++
            onTry.onSuccess()
        } else {
            onTry.onFailure()
        }
    }

    fun trySell(onTry: OnTry) {
        if (queuedCharges > 0) {
            queuedCharges--
            onTry.onSuccess()
        } else onTry.onFailure()
    }

    fun commitBuy() {
        existingCharges += queuedCharges
        queuedCharges = 0
    }

    fun GameState.tryUse(useCase: AbilityUseCase, onTry: OnTry) {
        if (existingCharges > 0) {
            existingCharges--
            useCase.use(this)
            onTry.onSuccess()
        } else onTry.onFailure()
    }
}