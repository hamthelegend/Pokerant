package com.thebrownfoxx.pokerant.util

fun readStringWithPrompt(
    prompt: String,
    isValid: (input: String) -> Boolean = { true },
): String {
    print("$prompt: ")
    var input = readln()
    while (!isValid(input)) {
        println()
        print("$prompt: ")
        input = readln()
    }
    return input
}