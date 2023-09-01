package com.thebrownfoxx.pokerant.util

open class OnTry(
    open val onSuccess: () -> Unit,
    open val onFailure: () -> Unit,
)

class OnSuccess(onSuccess: () -> Unit): OnTry(onSuccess = onSuccess, onFailure = {})

class OnFailure(onFailure: () -> Unit): OnTry(onSuccess = {}, onFailure = onFailure)