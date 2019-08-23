import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class TurnLeftTest {

    @Test
    @DisplayName("S->左转")
    fun `test excute S`() {
        val point = TurnLeft().excute(Point(0, 0, Direction.SOUTH))
        assertEquals(Direction.WEST, point.direction)
    }

    @Test
    @DisplayName("W->左转")
    fun `test excute W`() {
        val point = TurnLeft().excute(Point(0, 0, Direction.WEST))
        assertEquals(Direction.NORTH, point.direction)
    }

    @Test
    @DisplayName("N->左转")
    fun test_excute_N() {
        val point = TurnLeft().excute(Point(0, 0, Direction.NORTH))
        assertEquals(Direction.EAST, point.direction)
    }

    @Test
    @DisplayName("E->左转")
    fun test_excute_E() {
        val point = TurnLeft().excute(Point(0, 0, Direction.EAST))
        assertEquals(Direction.SOUTH, point.direction)
    }

}