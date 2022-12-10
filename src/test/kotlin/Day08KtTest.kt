import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day08KtTest {

    @Test
    fun `Test visible trees`() {
        val total = visibleTrees("Day08.txt")
        assertEquals(21, total)
    }

    @Test
    fun `Test visible trees all`() {
        val total = visibleTrees("Day08_all.txt")
        assertEquals(1789, total)
    }

    @Test
    fun `Test visible scenic score`() {
        val total = scenicScore("Day08.txt")
        assertEquals(8, total)
    }

    @Test
    fun `Test visible scenic score all`() {
        val total = scenicScore("Day08_all.txt")
        assertEquals(314820, total)
    }
}
