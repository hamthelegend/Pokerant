package com.thebrownfoxx.pokerant.util

fun readStringithPrompt(prompt: String): String {
    print("$prompt: ")
    return readln()
}

fun readIntWithPrompt(prompt: String): Int {
    var int: Int? = null
    while (int == null) {
        int = readStringithPrompt(prompt).toIntOrNull()
    }
    return int
}