package com.thebrownfoxx.pokerant.util

val Int.ordinal get() = when (this) {
    1 -> "first"
    2 -> "second"
    3 -> "third"
    4 -> "fourth"
    5 -> "fifth"
    else -> "${this}th"
}