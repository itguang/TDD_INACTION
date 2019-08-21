import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurnLeftTest5 {

    private TurnLeft turnLeft;

    @BeforeAll
    @DisplayName("只执行一次，执行时机是在所有测试和 @BeforeEach 注解方法之前")
    static void initAll() {
    }

    @AfterAll
    @DisplayName("只执行一次，执行时机是在所有测试和 @AfterEach 注解方法之后")
    static void tearDownAll() {
    }


    @BeforeEach
    @DisplayName("每条用例开始时执行")
    void start() {
        turnLeft = new TurnLeft();
    }

    @AfterEach
    @DisplayName("每条用例结束时执行")
    void end() {

    }

    @Test
    @DisplayName("测试方向 西 -> 左转")
    void test_excute_W() {
        Point point = new Point(0, 0, Direction.WEST);
        assertEquals(Direction.NORTH, turnLeft.execute(point).getDirection());
    }

    @Test
    @DisplayName("测试方向 北 -> 左转")
    void test_excute_S() {
        Point point = new Point(0, 0, Direction.SOUTH);
        assertEquals(Direction.WEST, turnLeft.execute(point).getDirection());
    }

    @Test
    @DisplayName("测试方向 东 -> 左转")
    void test_excute_E() {
        Point point = new Point(0, 0, Direction.EAST);
        assertEquals(Direction.SOUTH, turnLeft.execute(point).getDirection());
    }

    @Test
    @DisplayName("测试方向 南 -> 左转")
    void test_excute_N() {
        Point point = new Point(0, 0, Direction.NORTH);
        assertEquals(Direction.EAST, turnLeft.execute(point).getDirection());
    }

    @Test
    @Disabled("这个测试跳过啦")
    void skippedTest() {
        // not executed
    }

}