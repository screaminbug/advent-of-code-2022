package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.MoveCrates9001UseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.MoveCratesUseCase
import java.util.*
import java.util.regex.Pattern

class DayFiveService : MoveCratesUseCase, MoveCrates9001UseCase {
    override fun rearrange(input: String): String {
        val data = input.split("$NL$NL")
        val crateStack = parseCrates(data[0].split(NL))
        data[1].split(NL).forEach { instructionStep ->
            val instructions = parseInstructions(instructionStep)
            repeat((0 until instructions.howMany).count()) {
                crateStack[instructions.to].push(crateStack[instructions.from].pop())
            }
        }
       return  crateStack.mapNotNull {
            if (it.isNotEmpty()) it.peek() else null
        }.joinToString("")
    }
    override fun rearrange9001(input: String): String {
        val data = input.split("$NL$NL")
        val crateStack = parseCrates(data[0].split(NL))
        data[1].split(NL).forEach { instructionStep ->
            val instructions = parseInstructions(instructionStep)
            val bufferStack = Stack<String>()
            parseInstructions(instructionStep)
            repeat((0 until instructions.howMany).count()) {
                bufferStack.push(crateStack[instructions.from].pop())
            }
            repeat((0 until instructions.howMany).count()) {
                crateStack[instructions.to].push(bufferStack.pop())
            }
        }
        return  crateStack.mapNotNull {
            if (it.isNotEmpty()) it.peek() else null
        }.joinToString("")
    }

    private fun parseInstructions(instruction: String): Instructions {
        val instructions = Pattern.compile("\\d+")
            .toRegex()
            .findAll(instruction)
            .map { it.value.toInt() }
            .toList()
        return Instructions(
            howMany = instructions[0],
            from = instructions[1] - 1,
            to = instructions[2] - 1
        )
    }

    private fun parseCrates(cratesInput: List<String>): List<Stack<String>> {
        val stackCount = (cratesInput.last().length + 1) / 3
        val stackList = mutableListOf<Stack<String>>()
        repeat((0 until stackCount).count()) { stackList.add(Stack()) }
        val reversedWithoutNumbers = cratesInput.asReversed().drop(1)
        reversedWithoutNumbers.forEach { line ->
            line.chunked(4).forEachIndexed { i, crate ->
                if (crate.first() == '[') {
                    stackList[i].add(crate.trim().removePrefix("[").removeSuffix("]"))
                }
            }
        }
        return stackList

    }

    data class Instructions(
        val howMany: Int,
        val from: Int,
        val to: Int
    )



}