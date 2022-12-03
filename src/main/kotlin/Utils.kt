import java.math.BigInteger
import java.security.MessageDigest

const val offset_A = 'A'.code - 1
const val offset_X = 'X'.code - 1


/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = {}.javaClass.classLoader.getResourceAsStream(name).bufferedReader().readLines()

fun readText(name: String) = {}.javaClass.classLoader.getResourceAsStream(name).bufferedReader().readText()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
