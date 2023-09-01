package com.thebrownfoxx.pokerant.game

import com.thebrownfoxx.pokerant.model.agent.base.AgentConstructor
import com.thebrownfoxx.pokerant.model.gamestate.AgentsPerPlayer
import com.thebrownfoxx.pokerant.model.player.PlayerInitializer
import com.thebrownfoxx.pokerant.util.printHorizontalDivider
import com.thebrownfoxx.pokerant.util.readStringWithPrompt

fun getPlayerInitializer(playerNumber: Int): PlayerInitializer {
    printHorizontalDivider()

    val playerName = readPlayerName(playerNumber)
    println()

    val chosenAgents = mutableListOf<AgentConstructor>()

    repeat(AgentsPerPlayer) { currentAgentIndex ->
        printAgentSelect(playerNumber, playerName, chosenAgents)
        val chosenAgentIndex = readAgentIndex(currentAgentIndex)
        chosenAgents.add(AgentConstructor.entries[chosenAgentIndex])
    }

    printAgentSelect(playerNumber, playerName, chosenAgents)
    return PlayerInitializer(playerName, chosenAgents)
}

private fun readPlayerName(playerNumber: Int) = readStringWithPrompt("Player $playerNumber name") { input ->
    if (input.isBlank()) {
        println("Player $playerNumber's name cannot be blank.")
    }
    input.isNotBlank()
}

private fun printAgentSelect(
    playerNumber: Int,
    playerName: String,
    chosenAgents: List<AgentConstructor>,
) {
    printHorizontalDivider()
    println("Player $playerNumber: $playerName")
    println()
    println("Available agents: ")
    AgentConstructor.entries.forEachIndexed { index, constructor ->
        println("${index + 1} - ${constructor.agentName}")
    }
    println()
    if (chosenAgents.isNotEmpty()) {
        println("Your agents: ")
        chosenAgents.forEachIndexed { index, constructor ->
            println("Agent ${index + 1}: ${constructor.agentName}")
        }
    }
}

private fun readAgentIndex(currentAgentIndex: Int) = readStringWithPrompt("Agent ${currentAgentIndex + 1}") { input ->
    val intInput = input.toIntOrNull()?.minus(1)
    val inputValid = intInput != null && intInput in AgentConstructor.entries.indices
    if (!inputValid) {
        println("Please choose agent by index.")
    }
    inputValid
}.toInt() - 1