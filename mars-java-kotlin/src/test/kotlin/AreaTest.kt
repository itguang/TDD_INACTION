import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AreaTest {

    @Test
    @DisplayName("Area 是否包含 point")
    fun `test contains`() {
        val A = Point(10, 10, Direction.SOUTH)
        val B = Point(-10, 10, Direction.SOUTH)
        val C = Point(-10, -10, Direction.SOUTH)
        val D = Point(10, -10, Direction.SOUTH)

        val area = Area(A, B, C, D)

        assertTrue(area.contains(Point(2, 2, Direction.SOUTH)))

        assertFalse(area.contains(Point(-11,-11,Direction.SOUTH)))
    }
}