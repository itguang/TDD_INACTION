import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurnRightTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("北 -> 右转")
    void test_TurnRight_excute_S() {
        TurnRight turnRight = new TurnRight();
        Point point = new Point(0, 0, Direction.SOUTH);
        assertEquals(Direction.EAST, turnRight.execute(point).getDirection());
    }

    @Test
    @DisplayName("东 -> 右转")
    void test_TurnRight_excute_E() {
        TurnRight turnRight = new TurnRight();
        Point point = new Point(0, 0, Direction.EAST);
        assertEquals(Direction.NORTH, turnRight.execute(point).getDirection());
    }

    @Test
    @DisplayName("南 -> 右转")
    void test_TurnRight_excute_N() {
        TurnRight turnRight = new TurnRight();
        Point point = new Point(0, 0, Direction.NORTH);
        assertEquals(Direction.WEST, turnRight.execute(point).getDirection());
    }

    @Test
    @DisplayName("西 -> 右转")
    void test_TurnRight_excute_W() {
        TurnRight turnRight = new TurnRight();
        Point point = new Point(0, 0, Direction.WEST);
        assertEquals(Direction.SOUTH, turnRight.execute(point).getDirection());
    }
}