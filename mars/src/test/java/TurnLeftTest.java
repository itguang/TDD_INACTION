import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnLeftTest {

    @Test
    public void execute() {
        TurnLeft turnLeft = new TurnLeft();
        Point point = new Point(0, 0, Direction.SOUTH);
        Point executePoint = turnLeft.execute(point);
        assertEquals(executePoint.getDirection().getAbb(), Direction.WEST.getAbb());
    }
}