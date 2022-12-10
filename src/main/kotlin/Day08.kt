
fun main() {
    val visibleTrees = visibleTrees("Day08.txt")
    println("Visible trees $visibleTrees")

    val score = scenicScore("Day08.txt")
    println("Visible trees $score")
}

fun visibleTrees(fileName: String): Int {
    val forrest = readInput(fileName).map { line -> line.toCharArray().map { it.digitToInt() }}
    var visible = forrest.size*2 + forrest.first().size*2 - 4

    forrest.drop(1).dropLast(1).forEachIndexed() {row, line ->
        line.drop(1).dropLast(1).forEachIndexed() { col, tree ->
            if (forrest[row+1].subList(0,col+1).max() < tree ||  // left
                forrest[row+1].subList(minOf(col + 2, forrest[0].size), forrest[0].size).maxOf { it } < tree || // right
                (0..row).maxOf { forrest[it][col + 1] } < tree ||  // top
                (minOf( forrest.size-1, row+2) until forrest.size).maxOf { forrest[it][col+1] } < tree  // bottom
                ) {
                visible++
            }
        }
    }
    return visible
}

fun scenicScore(fileName: String): Int {
    val forrest = readInput(fileName).map { line -> line.toCharArray().map { it.digitToInt() }}
    var topScore = 0

    forrest.forEachIndexed() { row, line ->
        line.forEachIndexed() { col, tree ->
            if (col > 0 && row > 0 && col < line.size-1 && row < forrest.size-1) {
                val left = run { (col - 1 downTo 0).fold(0) { acc, it ->
                    val result = acc.inc()
                    if (line[it] >= tree) return@run result
                    result
                } } // left
                val top = run { (row - 1 downTo 0).fold(0) { acc, it ->
                    val result = acc.inc()
                    if (forrest[it][col] >= tree) return@run result
                    result
                } }// top
                val right = run { (col + 1 until line.size).fold(0) { acc, it ->
                    val result = acc.inc()
                    if (line[it] >= tree) return@run result
                    result
                } } // right
                val bottom = run { (row + 1 until forrest.size).fold(0) { acc, it ->
                    val result = acc.inc()
                    if (forrest[it][col] >= tree) return@run result
                    result
                } } // bottom

                val score = left * top * right * bottom
                topScore = maxOf(score, topScore)
            }
        }
    }
    return topScore
}