import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoveForwardTest {

    private static Area area;

    @BeforeAll
    static void init() {
        Point A = new Point(10, 10, Direction.SOUTH);
        Point B = new Point(-10, 10, Direction.SOUTH);
        Point C = new Point(-10, -10, Direction.SOUTH);
        Point D = new Point(10, -10, Direction.SOUTH);
        area = new Area(A, B, C, D);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("北 -> 前进")
    void test_MoveForward_S() {
        MoveForward moveForward = new MoveForward(area);
        Point point = new Point(1, 1, Direction.SOUTH);
        assertEquals(point.getY() + 1, moveForward.execute(point).getY());
    }

    @Test
    @DisplayName("南 -> 前进")
    void test_MoveForward_N() {
        MoveForward moveForward = new MoveForward(area);
        Point point = new Point(1, 1, Direction.NORTH);
        assertEquals(point.getY() - 1, moveForward.execute(point).getY());
    }

    @Test
    @DisplayName("东 -> 前进")
    void test_MoveForward_E() {
        MoveForward moveForward = new MoveForward(area);
        Point point = new Point(1, 1, Direction.EAST);
        assertEquals(point.getX() + 1, moveForward.execute(point).getX());
    }

    @Test
    @DisplayName("西 -> 前进")
    void test_MoveForward_W() {
        MoveForward moveForward = new MoveForward(area);
        Point point = new Point(1, 1, Direction.WEST);
        assertEquals(point.getX() - 1, moveForward.execute(point).getX());
    }

    @Test
    @DisplayName("超出探索区域")
    void test_MoveForward_W_more_area() {

        MoveForward moveForward = new MoveForward(area);
        Point point = new Point(-10, 10, Direction.WEST);
        assertThrows(RuntimeException.class,
                () -> assertEquals(point.getX() - 1, moveForward.execute(point).getX()));
    }
}