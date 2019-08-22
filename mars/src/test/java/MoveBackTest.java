import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoveBackTest {

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
    @DisplayName("北 -> 后退")
    void test_MoveBack_S() {
        MoveBack moveBack = new MoveBack(area);
        Point point = new Point(1, 1, Direction.SOUTH);
        assertEquals(point.getY() - 1, moveBack.execute(point).getY());
    }

    @Test
    @DisplayName("南 -> 后退")
    void test_MoveBack_N() {
        MoveBack moveBack = new MoveBack(area);
        Point point = new Point(1, 1, Direction.NORTH);
        assertEquals(point.getY() + 1, moveBack.execute(point).getY());
    }

    @Test
    @DisplayName("东 -> 后退")
    void test_MoveBack_E() {
        MoveBack moveBack = new MoveBack(area);
        Point point = new Point(1, 1, Direction.EAST);
        assertEquals(point.getX() - 1, moveBack.execute(point).getX());
    }

    @Test
    @DisplayName("西 -> 后退")
    void test_MoveBack_W() {
        MoveBack moveBack = new MoveBack(area);
        Point point = new Point(1, 1, Direction.WEST);
        assertEquals(point.getX() + 1, moveBack.execute(point).getX());
    }

    @Test
    @DisplayName("超出探索区域")
    void test_MoveBack_E_more() {
        MoveBack moveBack = new MoveBack(area);
        Point point = new Point(-10, 10, Direction.EAST);
        assertThrows(RuntimeException.class,
                () -> assertEquals(point.getX() - 1, moveBack.execute(point).getX()));
    }
}