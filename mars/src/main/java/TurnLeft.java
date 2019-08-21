/**
 * @author guang
 * @since 2019-08-21 16:51
 */
public class TurnLeft extends Turn {
    @Override
    public Point execute(Point point) {
        switch (point.getDirection()) {
            case SOUTH:
                point.setDirection(Direction.WEST);
                break;
            case WEST:
                point.setDirection(Direction.NORTH);
                break;
            case NORTH:
                point.setDirection(Direction.EAST);
                break;
            case EAST:
                point.setDirection(Direction.SOUTH);
                break;
            default:
        }
        return point;
    }
}
