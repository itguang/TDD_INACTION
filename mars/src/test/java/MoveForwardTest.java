import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveForwardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("北 -> 前进")
    void test_MoveForward_S() {
        MoveForward moveForward = new MoveForward();
        Point point = new Point(1, 1, Direction.SOUTH);
        assertEquals(point.getY() + 1, moveForward.execute(point).getY());
    }

    @Test
    @DisplayName("南 -> 前进")
    void test_MoveForward_N() {
        MoveForward moveForward = new MoveForward();
        Point point = new Point(1, 1, Direction.NORTH);
        assertEquals(point.getY() - 1, moveForward.execute(point).getY());
    }

    @Test
    @DisplayName("东 -> 前进")
    void test_MoveForward_E() {
        MoveForward moveForward = new MoveForward();
        Point point = new Point(1, 1, Direction.EAST);
        assertEquals(point.getX() + 1, moveForward.execute(point).getX());
    }

    @Test
    @DisplayName("西 -> 前进")
    void test_MoveForward_W() {
        MoveForward moveForward = new MoveForward();
        Point point = new Point(1, 1, Direction.WEST);
        assertEquals(point.getX() - 1, moveForward.execute(point).getX());
    }
}