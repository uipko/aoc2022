
fun main() {
    val nrOfChars1 = parseStream("Day06.txt", 4)
    println("The number characters which needs to be processed before the first start-of-packet marker is detected $nrOfChars1")

    val nrOfChars2 = parseStream("Day06.txt", 14)
    println("The number characters which needs to be processed before the first start-of-packet marker is detected $nrOfChars2")

}

fun parseStream(fileName: String, size: Int): Int {
    return readFile(fileName).windowed(size).takeWhile { it.toSet().size != it.length }.count() + size

}
