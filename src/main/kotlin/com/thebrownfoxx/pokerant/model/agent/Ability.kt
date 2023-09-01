package com.thebrownfoxx.pokerant.model.agent

import com.thebrownfoxx.pokerant.model.OnTry

class AbilityUseCasePrompt(val prompt: String = "")

class AbilityUseCase(
    val prompt: AbilityUseCasePrompt,
    val use: Agent.() -> Unit,
) {
    constructor(prompt: String = "", use: Agent.() -> Unit) :
            this(prompt = AbilityUseCasePrompt(prompt), use = use)
}

abstract class Ability(
    val agent: Agent,
    val name: String,
    val maxCharges: Int,
    freeCharges: Int = 0,
) {
    private var existingCharges = freeCharges
    private var queuedCharges = 0
    val charges get() = existingCharges + queuedCharges

    protected abstract val useCases: List<AbilityUseCase>
    val useCasePrompts get() = useCases.map { it.prompt }

    override fun toString() = "Ability(name = $name, maxCharges = $maxCharges, charges = $charges)"

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

    fun tryUse(useCasePrompt: AbilityUseCasePrompt, onTry: OnTry) {
        if (existingCharges > 0) {
            existingCharges--
            val useCase = useCases.first { it.prompt == useCasePrompt }
            useCase.use(agent)
            onTry.onSuccess()
        } else onTry.onFailure()
    }
}

abstract class Ultimate(
    val agent: Agent,
    val name: String,
    val requiredCharges: Int,
) {
    var charges: Int = 0
        protected set

    protected abstract val useCases: List<AbilityUseCase>
    val useCasePrompts get() = useCases.map { it.prompt }

    override fun toString() = "Ability(name = $name, requiredCharges = $requiredCharges, charges = $charges)"

    fun charge() {
        if (charges < requiredCharges) charges++
    }

    fun tryUse(useCasePrompt: AbilityUseCasePrompt, onTry: OnTry) {
        if (charges >= requiredCharges) {
            val useCase = useCases.first { it.prompt == useCasePrompt }
            useCase.use(agent)
            onTry.onSuccess()
        } else {
            onTry.onFailure()
        }
    }
}