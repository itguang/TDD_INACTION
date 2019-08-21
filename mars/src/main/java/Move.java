/**
 * @author guang
 * @since 2019-08-21 16:49
 */
public abstract class Move implements Instruction {

    /**
     * 执行移动指令,执行完后需要校验是否超出指定区域
     *
     * @param point
     * @return
     */
    @Override
    public abstract Point execute(Point point);
}
