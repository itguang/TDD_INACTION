/**
 * @author guang
 * @since 2019-08-22 14:37
 */
public class MoveBack extends Move {
    public MoveBack(Area area) {
        super(area);
    }

    @Override
    public Point execute(Point point) {
        switch (point.getDirection()) {
            case SOUTH:
                point.setY(point.getY() - 1);
                break;
            case NORTH:
                point.setY(point.getY() + 1);
                break;
            case EAST:
                point.setX(point.getX() - 1);
                break;
            case WEST:
                point.setX(point.getX() + 1);
                break;
            default:
        }

        // 是否超出区域
        if (isCrossing(point)) {
            throw new RuntimeException("Rover 超出探索区域 point: " + point.toString());
        }
        return point;
    }
}
