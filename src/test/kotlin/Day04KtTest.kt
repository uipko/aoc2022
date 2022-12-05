import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04KtTest {

    @Test
    fun `Test sum of contains ranges, small`() {
        val pairs = contains("Day04.txt")
        assertEquals(5, pairs)
    }

    @Test
    fun `Test sum of contains ranges, all`() {
        val pairs = contains("Day04_all.txt")
        assertEquals(582, pairs)
    }

    @Test
    fun `Test sum of overlap ranges, small`() {
        val pairs = overlap("Day04.txt")
        assertEquals(7, pairs)
    }

    @Test
    fun `Test sum of overlap ranges, all`() {
        val pairs = overlap("Day04_all.txt")
        assertEquals(893, pairs)
    }
}
