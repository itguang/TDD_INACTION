/**
 * @author guang
 * @since 2019-08-21 16:45
 */
public interface Instruction {

    /**
     * 执行指令
     *
     * @param point
     * @return
     */
    Point execute(Point point);
}
