package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUpdatedUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUseCase
import hr.tstrelar.advent_of_code_2022.application.service.Strategy.*

enum class Shape(val score: Int) {
    ROCK( 1),
    PAPER( 2),
    SCISSORS( 3);
    fun wins(): Shape {
        return when(this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }
    }
    fun loses(): Shape {
        return when(this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
    }
    companion object {
        fun fromCode(value: String): Shape {
            return when(value) {
                "A" -> ROCK
                "X" -> ROCK
                "B" -> PAPER
                "Y" -> PAPER
                "C" -> SCISSORS
                "Z" -> SCISSORS
                else -> throw IllegalArgumentException("$value is not a valid shape code")
            }
        }
    }
}

enum class Strategy(val score: Int) {
    LOSE(0),
    DRAW(3),
    WIN(6);
    companion object {
        fun fromCode(value: String): Strategy {
            return when(value) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw IllegalArgumentException("$value is not a valid strategy code")
            }
        }
    }
}

class Game(firstCode: String, secondCode: String) {
    private val opponent = Shape.fromCode(firstCode)
    private val my = Shape.fromCode(secondCode)
    private val strategy = Strategy.fromCode(secondCode)

    fun play() = my.score + if (isDraw()) { 3 } else if (isWin()) { 6 } else { 0 }
    fun playUpdated() = shouldPlay().score + strategy.score

    private fun isDraw() = opponent == my

    private fun isWin() = my.wins() == opponent

    private fun shouldPlay(): Shape {
        return when (strategy) {
            LOSE -> opponent.wins()
            DRAW -> opponent
            WIN -> opponent.loses()
        }
    }

}

class DayTwoService : CalculateRpsScoreUseCase, CalculateRpsScoreUpdatedUseCase {
    override fun calculateScore(input: String) = getGames(input).sumOf {it.play() }.toString()

    override fun calculateScoreUpdated(input: String) = getGames(input).sumOf { it.playUpdated() }.toString()

    private fun getGames(input: String) = input.split(NL).map {
        val gameInCode = it.split(" ")
        Game(gameInCode[0], gameInCode[1])
    }
}