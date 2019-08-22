import org.junit.jupiter.api.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {

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
    @DisplayName("获取火星车位置")
    void test_get_rover_point() {
        Rover rover = new Rover();
        Point point = new Point(0, 0, Direction.SOUTH);
        rover.deploy(point);
        assertEquals(rover.getPoint(), point);

    }

    @Test
    @DisplayName("北 -> 左转")
    void test_Rover_TurnLeft_S() {

        // 左转指令
        Instruction instruction = new TurnLeft();

        Rover rover = new Rover();
        rover.deploy(new Point(0, 0, Direction.SOUTH));
        assertEquals(rover.run(instruction).getDirection(), Direction.WEST);
    }

    @Test
    @DisplayName("北 -> 左转(抛出异常)")
    void test_Rover_TurnLeft_S_not_init_point() {

        // 左转指令
        Instruction instruction = new TurnLeft();

        Rover rover = new Rover();
        assertThrows(RuntimeException.class, () -> {
            rover.run(instruction).getDirection();
        });
    }

    @Test
    @DisplayName("北 -> 批量左转")
    void test_batch_TurnLeft_S() {

        // 有序指令集
        LinkedList<Instruction> instructions = new LinkedList<>();
        instructions.add(new TurnLeft());
        instructions.add(new TurnLeft());

        Rover rover = new Rover();
        rover.deploy(new Point(0, 0, Direction.SOUTH));

        assertEquals(rover.run(instructions).getDirection(), Direction.NORTH);
    }

    @Test
    @DisplayName("北 -> 批量前进")
    void test_batch_MoveForward_S() {
        Rover rover = new Rover();
        rover.deploy(new Point(0, 0, Direction.SOUTH));

        // 有序指令集
        LinkedList<Instruction> instructions = new LinkedList<>();
        instructions.add(new MoveForward(area));
        instructions.add(new MoveForward(area));

        Point point = rover.run(instructions);
        assertEquals(point.getDirection(), Direction.SOUTH);
        assertEquals(point.getX(), 0);
        assertEquals(point.getY(), 2);
    }

    @Test
    @DisplayName("北 -> 批量(转向,前进)")
    void test_batch_Move_and_Turn_S() {

        Rover rover = new Rover();
        // 初始坐标 (0,0,S)
        rover.deploy(new Point(0, 0, Direction.SOUTH));

        MoveForward moveForward = new MoveForward(area);
        TurnRight turnRight = new TurnRight();

        // 有序指令集
        LinkedList<Instruction> instructions = new LinkedList<>();
        // 北进2
        instructions.add(moveForward);
        instructions.add(moveForward);
        // 北右转
        instructions.add(turnRight);
        // 东进2
        instructions.add(moveForward);
        instructions.add(moveForward);

        // 最终坐标 (2,2,E)
        Point point = rover.run(instructions);

        assertEquals(point.getDirection(), Direction.EAST);
        assertEquals(point.getX(), 2);
        assertEquals(point.getY(), 2);
    }

    @Test
    @DisplayName("东 -> 批量(转向,前进)")
    void test_batch_Move_and_Turn_E() {

        Rover rover = new Rover();
        // 初始坐标 (0,0,S)
        rover.deploy(new Point(0, 0, Direction.EAST));

        TurnRight turnRight = new TurnRight();
        MoveForward moveForward = new MoveForward(area);

        // 有序指令集
        LinkedList<Instruction> instructions = new LinkedList<>();
        // 连续两次右转 -> (0,0,W)
        instructions.add(turnRight);
        instructions.add(turnRight);

        // 进2 -> (-2,0,W)
        instructions.add(moveForward);
        instructions.add(moveForward);
        // 右转 -> (-2,0,S)
        instructions.add(turnRight);
        // 进2 -> (-2,2,S)
        instructions.add(moveForward);
        instructions.add(moveForward);

        // 最终坐标 (-2,2,S)
        Point point = rover.run(instructions);

        assertEquals(point.getDirection(), Direction.SOUTH);
        assertEquals(point.getX(), -2);
        assertEquals(point.getY(), 2);
    }

    @Test
    @DisplayName("东 -> 批量(转向,前进) ,超出区域")
    void test_batch_Move_and_Turn_more() {

        Rover rover = new Rover();
        // 初始坐标
        rover.deploy(new Point(10, 10, Direction.EAST));

        TurnRight turnRight = new TurnRight();
        MoveForward moveForward = new MoveForward(area);

        // 有序指令集
        LinkedList<Instruction> instructions = new LinkedList<>();

        // 进2
        instructions.add(moveForward);
        instructions.add(moveForward);
        // 连续两次右转
        instructions.add(turnRight);
        instructions.add(turnRight);

        // 进2
        instructions.add(moveForward);
        instructions.add(moveForward);
        // 右转
        instructions.add(turnRight);
        // 进2
        instructions.add(moveForward);
        instructions.add(moveForward);

        // 最终坐标
        assertThrows(RuntimeException.class, () -> rover.run(instructions));

    }

}