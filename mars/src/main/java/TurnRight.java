/**
 * @author guang
 * @since 2019-08-22 14:04
 */
public class TurnRight extends Turn {

    @Override
    public Point execute(Point point) {
        switch (point.getDirection()){
            case SOUTH:
                point.setDirection(Direction.EAST);
                break;
            case EAST:
                point.setDirection(Direction.NORTH);
                break;
            case NORTH:
                point.setDirection(Direction.WEST);
                break;
            case WEST:
                point.setDirection(Direction.SOUTH);
                break;
            default:
        }
        return point;
    }
}
