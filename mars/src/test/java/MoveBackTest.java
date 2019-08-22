import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveBackTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("北 -> 后退")
    void test_MoveBack_S() {
        MoveBack moveBack = new MoveBack();
        Point point = new Point(1, 1, Direction.SOUTH);
        assertEquals(point.getY() - 1, moveBack.execute(point).getY());
    }

    @Test
    @DisplayName("南 -> 后退")
    void test_MoveBack_N() {
        MoveBack moveBack = new MoveBack();
        Point point = new Point(1, 1, Direction.NORTH);
        assertEquals(point.getY() + 1, moveBack.execute(point).getY());
    }

    @Test
    @DisplayName("东 -> 后退")
    void test_MoveBack_E() {
        MoveBack moveBack = new MoveBack();
        Point point = new Point(1, 1, Direction.EAST);
        assertEquals(point.getX() - 1, moveBack.execute(point).getX());
    }

    @Test
    @DisplayName("西 -> 后退")
    void test_MoveBack_W() {
        MoveBack moveBack = new MoveBack();
        Point point = new Point(1, 1, Direction.WEST);
        assertEquals(point.getX() + 1, moveBack.execute(point).getX());
    }
}