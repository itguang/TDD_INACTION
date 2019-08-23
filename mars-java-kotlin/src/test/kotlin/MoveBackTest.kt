import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MoveBackTest {

    // 延迟初始化属性与变量
    lateinit var area: Area

    @BeforeEach
    fun setUp() {

        val A = Point(10, 10, Direction.SOUTH)
        val B = Point(-10, 10, Direction.SOUTH)
        val C = Point(-10, -10, Direction.SOUTH)
        val D = Point(10, -10, Direction.SOUTH)

        area = Area(A, B, C, D)
    }

    @Test
    @DisplayName("后退指令")
    fun excute() {

        assertEquals(-1, MoveBack(area).excute(Point(0, 0, Direction.SOUTH)).y)
        assertEquals(-1, MoveBack(area).excute(Point(0, 0, Direction.EAST)).x)
        // 越界
        assertThrows<RuntimeException> { MoveBack(area).excute(Point(-10, -10, Direction.EAST)).x }

    }

}