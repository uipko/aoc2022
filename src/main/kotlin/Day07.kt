const val totalSpace = 70_000_000
const val neededFreeSpace = 30_000_000

fun main() {
    val total = dirsSize("Day07.txt", 100_000)
    println("Total size $total")

    val freeUp = freeUpSpace("Day07.txt")
    println("Total size $freeUp")
}

data class Folder(val name: String, val folders: MutableList<Folder> = ArrayList(), var size: Int = 0)

fun dirsSize(fileName: String, max: Int): Int {
    return getFolderSizes(fileName).filterValues { it < max }.values.sum()
}

fun freeUpSpace(fileName: String): Int {
    val folders = getFolderSizes(fileName)
    val needed = neededFreeSpace - (totalSpace - folders[listOf("/")]!!)
    return folders.filterValues { it > needed }.values.minOf { it }
}

private fun getFolderSizes(fileName: String): LinkedHashMap<List<String>, Int> {
    var key = mutableListOf<String>("/")
    var key1 = key
    return readInput(fileName).drop(1)
        .fold(linkedMapOf<List<String>, Int>(mutableListOf("/") to 0)) { initial, element ->
            var acc = initial
            with(element) {
                when {
                    equals("$ cd ..") -> key1 = key1.dropLast(1).toMutableList()
                    startsWith("$ cd") -> key1.add(substring(5))
                    startsWith("dir ") -> {
                        acc.put(key1.plus(split(" ").last()), 0)
                    }
                    "^\\d+ ".toRegex().containsMatchIn(this) -> {
                        var update = mutableListOf<String>()
                        key1.forEach {
                            update.add(it)
                            acc[update] = acc[update]!! + this.split(" ").first().toInt()
                        }
                    }
                    else -> null //ignore
                }
            }
            acc
        }
}
