import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class TurnRightTest {

    @Test
    @DisplayName("测试右转指令")
    fun `test excute`() {
        assertEquals(Direction.EAST, TurnRight().excute(Point(0, 0, Direction.SOUTH)).direction)
        assertEquals(Direction.NORTH, TurnRight().excute(Point(0, 0, Direction.EAST)).direction)
        assertEquals(Direction.WEST, TurnRight().excute(Point(0, 0, Direction.NORTH)).direction)
        assertEquals(Direction.SOUTH, TurnRight().excute(Point(0, 0, Direction.WEST)).direction)
    }


}