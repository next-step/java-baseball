fun main() {
    println("Hello World")
}

fun generateRand3digit(): String {
    val sampleList = (1..9)
    return sampleList.shuffled().take(3).joinToString("")
}