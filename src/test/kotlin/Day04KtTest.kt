import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04KtTest {

    @Test
    fun `Test sum of contains ranges`() {
        val pairs = contains("Day04.txt")
        assertEquals(5, pairs)
    }

    @Test
    fun `Test sum of overlap ranges`() {
        val pairs = overlap("Day04.txt")
        assertEquals(7, pairs)
    }
}
