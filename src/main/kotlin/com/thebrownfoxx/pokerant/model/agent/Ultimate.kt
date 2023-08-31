package com.thebrownfoxx.pokerant.model.agent

import com.thebrownfoxx.pokerant.model.GameState
import com.thebrownfoxx.pokerant.model.OnTry

abstract class Ultimate(
    val name: String,
    val requiredCharges: Int,
) {
    var charges: Int = 0
        protected set

    abstract fun GameState.use()

    fun charge() {
        if (charges < requiredCharges) charges++
    }

    fun GameState.tryUse(onTry: OnTry) {
        if (charges >= requiredCharges) {
            use()
            onTry.onSuccess()
        } else {
            onTry.onFailure()
        }
    }
}