import java.util.Scanner

enum class evaluatedRule(val value: String) {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크")
}

fun main() {
    print("숫자를 입력해주세요 : ")
    val userInputStr = readUserInput()
    val rand3digit = generateRand3digit()
    val transformedUserList = transformStringNumToIntArray(userInputStr)
    val transformedGeneratedList = transformStringNumToIntArray(rand3digit)
    println(evaluateRule(transformedUserList, transformedGeneratedList))
}

fun readUserInput(): String {
    val reader = Scanner(System.`in`)
    val userInput = reader.next().toString()
    if (userInput.toIntOrNull() == null || userInput.length != 3) {
        return throw Exception("3자리 숫자를 입력해 주세요")
    }
    return userInput
}

fun evaluateRule(transformedUserInputList: List<Int>, transformedGeneratedList: List<Int>): String {
    println("transformedUserInputList: $transformedUserInputList, transformedGeneratedList: $transformedGeneratedList")
    var evaluatedResult = "${
        evaluateStrike(
            transformedUserInputList,
            transformedGeneratedList
        )
    }"
    evaluatedResult += " ${evaluateBall(transformedUserInputList, transformedGeneratedList)}"
    if (evaluatedResult.trim() == "") {
        return evaluatedRule.NOTHING.value
    }
    return evaluatedResult.trimStart().trimEnd()
}

fun evaluateBall(transformedUserInputList: List<Int>, transformedGeneratedList: List<Int>): String {
    val strikeCount = calcStrikeCount(transformedUserInputList, transformedGeneratedList)
    val strikePlusBallCount = transformedUserInputList.intersect(transformedGeneratedList).size
    val ballCount = strikePlusBallCount - strikeCount
    if (strikePlusBallCount - strikeCount != 0) {
        return "$ballCount ${evaluatedRule.BALL.value}"
    }
    return ""
}

fun evaluateStrike(transformedUserInputList: List<Int>, transformedGeneratedList: List<Int>): String {
    val strikeCount = calcStrikeCount(transformedUserInputList, transformedGeneratedList)
    if (strikeCount != 0) {
        return "$strikeCount ${evaluatedRule.STRIKE.value}"
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