abstract class Move(area: Area) : Instruction {

    var area: Area = area

    abstract override fun excute(point: Point): Point

    /**
     * 是否越界
     */
    fun isCrossing(point: Point): Boolean {
        return !area.contains(point)
    }

}