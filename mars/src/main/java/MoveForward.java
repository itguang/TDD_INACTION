/**
 * @author guang
 * @since 2019-08-22 14:20
 */
public class MoveForward extends Move {
    @Override
    public Point execute(Point point) {
        switch (point.getDirection()) {
            case SOUTH:
                point.setY(point.getY() + 1);
                break;
            case NORTH:
                point.setY(point.getY() - 1);
                break;
            case EAST:
                point.setX(point.getX() + 1);
                break;
            case WEST:
                point.setX(point.getX() - 1);
            default:
        }
        return point;
    }
}
