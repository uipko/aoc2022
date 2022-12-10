import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day07KtTest {

    @Test
    fun `Test folders smaller than 100_000`() {
        val total = dirsSize("Day07.txt", 100_000)
        assertEquals(95437, total)
    }

    @Test
    fun `Test folders smaller than 100_000 all`() {
        val total = dirsSize("Day07_all.txt", 100_000)
        assertEquals(1182909, total)
    }

    @Test
    fun `Test folders free space`() {
        val total = freeUpSpace("Day07.txt")
        assertEquals(24933642, total)
    }

    @Test
    fun `Test folders free space all`() {
        val total = freeUpSpace("Day07_all.txt")
        assertEquals(2832508, total)
    }
}
