enum class EvalulatedRule(val value: String) {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크")
}

fun main() {
    println("Hello World")
}

fun evaluateRule(userInput: String, generatedValue: String): String {
   return ""
}

fun generateRand3digit(): String {
    val sampleList = (1..9)
    return sampleList.shuffled().take(3).joinToString("")
}