package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.MoveCratesUseCase
import java.util.Stack

class DayFiveService : MoveCratesUseCase {
    override fun rearrange(input: String): String {
        val data = input.split("$NL$NL")
        val crateStack = parseCrates(data[0].split(NL))
        val insructions = parseInstructions(data[1])
    }

    private fun parseCrates(cratesInput: List<String>): List<Stack<String>> {
        val count = cratesInput.last().count { it.isDigit() }

    }
}