/**
 * 抽象转向指令
 */
abstract class Turn : Instruction {
    abstract override fun excute(point: Point): Point
}