import java.util.*

class Rover {

    private lateinit var point: Point

    fun getPoint(): Point {
        return point
    }

    fun deploy(point: Point) {
        this.point = point
    }

    fun run(instructions: LinkedList<Instruction>): Point {
        instructions.forEach { point = it.excute(point) }
        return point
    }

    fun run(instruction: Instruction): Point {
        return instruction.excute(point)
    }

}