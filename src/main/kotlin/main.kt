import java.util.Scanner

enum class EvalulatedRule(val value: String) {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크")
}

fun main() {
    print("숫자를 입력해주세요 : ")
    val userInputStr = readUserInput()
    val rand3digit = generateRand3digit()
}

fun readUserInput(): String {
    val reader = Scanner(System.`in`)
    val userInput = reader.next().toString()
    if (userInput.toIntOrNull() == null || userInput.length != 3) {
        return throw Exception("3자리 숫자를 입력해 주세요")
    }
    return userInput
}

fun evaluateRule(userInput: String, generatedValue: String): String {
   return ""
}

fun generateRand3digit(): String {
    val sampleList = (1..9)
    return sampleList.shuffled().take(3).joinToString("")
}