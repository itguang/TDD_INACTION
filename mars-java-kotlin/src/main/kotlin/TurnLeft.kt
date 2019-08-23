/**
 * 左转指令
 */
class TurnLeft : Turn() {
    open override fun excute(point: Point): Point {

        when (point.direction) {
            Direction.SOUTH -> point.direction = Direction.WEST
            Direction.WEST -> point.direction = Direction.NORTH
            Direction.NORTH -> point.direction = Direction.EAST
            Direction.EAST -> point.direction = Direction.SOUTH
            else -> throw RuntimeException("point.Direction 不合法$point")
        }

        return point
    }
}