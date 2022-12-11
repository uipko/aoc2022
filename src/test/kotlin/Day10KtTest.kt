import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day10KtTest {

    @Test
    fun `Test signal strength`() {
        val total = signalStrength("Day10.txt")
        assertEquals(13140, total)
    }

    @Test
    fun `Test visible render`() {
        val screen = renderText("Day10.txt")
        assertEquals(6, screen.size)
        assertEquals(40, screen.first().size)
        assertEquals(40, screen.last().size)
    }
}
