class TurnRight : Turn() {
    override fun excute(point: Point): Point {
        when(point.direction){
            Direction.SOUTH -> point.direction = Direction.EAST
            Direction.EAST -> point.direction = Direction.NORTH
            Direction.NORTH -> point.direction = Direction.WEST
            Direction.WEST -> point.direction = Direction.SOUTH
        }
        return point
    }
}