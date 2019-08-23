import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.RuntimeException

internal class MoveForwardTest {

    // 延迟初始化属性与变量
    lateinit var area: Area

    @BeforeEach
    fun before() {
        val A = Point(10, 10, Direction.SOUTH)
        val B = Point(-10, 10, Direction.SOUTH)
        val C = Point(-10, -10, Direction.SOUTH)
        val D = Point(10, -10, Direction.SOUTH)

        area = Area(A, B, C, D)
    }

    @Test
    @DisplayName("向前移动")
    fun `test move forward excute`() {
        assertEquals(1, MoveForward(area).excute(Point(0, 0, Direction.SOUTH)).y)
        assertEquals(1, MoveForward(area).excute(Point(0, 0, Direction.EAST)).x)
        // 越界
        assertThrows<RuntimeException> { MoveForward(area).excute(Point(10, 10, Direction.EAST)).x }
    }

}