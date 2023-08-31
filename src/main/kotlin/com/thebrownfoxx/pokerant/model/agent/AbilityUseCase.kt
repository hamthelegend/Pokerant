package com.thebrownfoxx.pokerant.model.agent

import com.thebrownfoxx.pokerant.model.GameState

class AbilityUseCase(
    val prompt: String,
    val use: GameState.() -> Unit,
)