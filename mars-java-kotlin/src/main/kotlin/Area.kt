class Area(val A: Point, val B: Point, val C: Point, val D: Point) {

    /**
     * 判断坐标点是否在 探索区域内
     */
    fun contains(point: Point): Boolean {
        val xIn = B.x <= point.x && point.x <= A.x
        val yIn = D.y <= point.y && point.y <= A.y
        return xIn && yIn
    }

}