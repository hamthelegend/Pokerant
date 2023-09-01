package com.thebrownfoxx.pokerant.game

import com.thebrownfoxx.pokerant.model.AgentsPerPlayer
import com.thebrownfoxx.pokerant.model.GameState
import com.thebrownfoxx.pokerant.model.agent.AgentConstructor
import com.thebrownfoxx.pokerant.util.readIntWithPrompt
import com.thebrownfoxx.pokerant.util.readStringithPrompt

fun main() {
    val player1Name = readStringithPrompt("Player 1 name")
    val agentConstructors1 = mutableListOf<AgentConstructor>()
    repeat(AgentsPerPlayer) {
        println("Agents: ")
        AgentConstructor.entries.forEachIndexed { agentIndex, agent ->
            println("$agentIndex - ${agent.agentName}")
        }
        var agent1Index: Int? = null
        while (agent1Index == null || agent1Index !in AgentConstructor.entries.indices) {
            agent1Index = readIntWithPrompt("Choose your agent by index")
        }
        agentConstructors1.add(AgentConstructor.entries[agent1Index])
    }
    val player2Name = readStringithPrompt("Player 1 name")
    val agentConstructors2 = mutableListOf<AgentConstructor>()
    repeat(AgentsPerPlayer) {
        println("Agents: ")
        AgentConstructor.entries.forEachIndexed { agentIndex, agent ->
            println("$agentIndex - ${agent.agentName}")
        }
        var agent2Index: Int? = null
        while (agent2Index == null || agent2Index !in AgentConstructor.entries.indices) {
            agent2Index = readIntWithPrompt("Choose your agent by index")
        }
        agentConstructors2.add(AgentConstructor.entries[agent2Index])
    }
    val gameState = GameState(
        player1Name = player1Name,
        player1Agents = agentConstructors1,
        player2Name = player2Name,
        player2Agents = agentConstructors2,
    )
    println(gameState)
}