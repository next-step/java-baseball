import java.util.Scanner
import kotlin.system.exitProcess

enum class EvaluatedRule(val value: String) {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크")
}

fun main() {
    var rand3digit = generateRand3digit()
    while (true) {
        print("숫자를 입력해주세요 : ")
        val userInputStr = readUserInput()
        val transformedUserList = transformStringNumToIntArray(userInputStr)
        val transformedGeneratedList = transformStringNumToIntArray(rand3digit)
        val gameResult = evaluateRule(transformedUserList, transformedGeneratedList)
        println(gameResult)
        val regame = isRegame(gameResult)
        if (regame) {
            rand3digit = generateRand3digit()
        }
    }
}

fun isRegame(gameResult: String): Boolean {
    if (gameResult == "3 ${EvaluatedRule.STRIKE.value}") {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val reader = Scanner(System.`in`)
        val userInput = reader.next().toIntOrNull() ?: throw Exception("잘못된 숫자를 입력하였습니다. 게임을 종료합니다.")
        if (userInput == 2) {
            exitProcess(0)
        }
        return true
    }
    return false
}

fun readUserInput(): String {
    val reader = Scanner(System.`in`)
    val userInput = reader.next().toString()
    if (userInput.toIntOrNull() == null || userInput.length != 3) {
        throw Exception("3자리 숫자를 입력해 주세요")
    }
    return userInput
}

fun evaluateRule(transformedUserInputList: List<Int>, transformedGeneratedList: List<Int>): String {
    var evaluatedResult = evaluateStrike(
        transformedUserInputList,
        transformedGeneratedList
    )
    evaluatedResult += " ${evaluateBall(transformedUserInputList, transformedGeneratedList)}"
    if (evaluatedResult.trim() == "") {
        return EvaluatedRule.NOTHING.value
    }
    return evaluatedResult.trimStart().trimEnd()
}

fun evaluateBall(transformedUserInputList: List<Int>, transformedGeneratedList: List<Int>): String {
    val strikeCount = calcStrikeCount(transformedUserInputList, transformedGeneratedList)
    val strikePlusBallCount = transformedUserInputList.intersect(transformedGeneratedList).size
    val ballCount = strikePlusBallCount - strikeCount
    if (strikePlusBallCount - strikeCount != 0) {
        return "$ballCount ${EvaluatedRule.BALL.value}"
    }
    return ""
}

fun evaluateStrike(transformedUserInputList: List<Int>, transformedGeneratedList: List<Int>): String {
    val strikeCount = calcStrikeCount(transformedUserInputList, transformedGeneratedList)
    if (strikeCount != 0) {
        return "$strikeCount ${EvaluatedRule.STRIKE.value}"
    }
    return ""
}

fun calcStrikeCount(transformedUserInputList: List<Int>, transformedGeneratedList: List<Int>): Int {
    return transformedUserInputList.filterIndexed { idx, i ->
        transformedGeneratedList[idx] == i
    }.size
}

fun transformStringNumToIntArray(userInput: String): List<Int> {
    // ascii 48 -> 0, 49 -> 1
    return userInput.toCharArray().map { it.toInt() - 48 }
}

fun generateRand3digit(): String {
    val sampleList = (1..9)
    return sampleList.shuffled().take(3).joinToString("")
}