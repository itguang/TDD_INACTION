import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

internal class RoverTest {

    // 延迟初始化属性与变量
    lateinit var area: Area
    lateinit var rover: Rover
    @BeforeEach
    fun setUp() {


        val A = Point(10, 10, Direction.SOUTH)
        val B = Point(-10, 10, Direction.SOUTH)
        val C = Point(-10, -10, Direction.SOUTH)
        val D = Point(10, -10, Direction.SOUTH)

        area = Area(A, B, C, D)

        rover = Rover()
        rover.deploy(Point(0, 0, Direction.SOUTH))
    }

    @Test
    fun deploy() {

        val rover = Rover()
        rover.deploy(Point(0, 0, Direction.SOUTH))
        assertEquals(0, rover.getPoint().x)
    }

    @Test
    fun `run one`() {
        assertEquals(Direction.WEST, rover.run(TurnLeft()).direction)
        assertEquals(-1, rover.run(MoveForward(area)).x)
    }

    @Test
    fun `run more`() {
        val list = LinkedList<Instruction>()
        list.add(TurnLeft())
        list.add(MoveForward(area))

        val point = rover.run(list)

        assertEquals(Direction.WEST,point.direction)
        assertEquals(-1,point.x)

    }

}