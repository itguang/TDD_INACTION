class MoveForward(area: Area) : Move(area) {

    override fun excute(point: Point): Point {

        when (point.direction) {
            Direction.SOUTH -> point.y = point.y + 1
            Direction.NORTH -> point.y = point.y - 1
            Direction.WEST -> point.x = point.x - 1
            Direction.EAST -> point.x = point.x + 1
        }

        if (isCrossing(point)) {
            throw RuntimeException("越移动界point : $point")
        }

        return point
    }
}