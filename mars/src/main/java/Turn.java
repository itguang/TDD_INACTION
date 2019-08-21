/**
 * @author guang
 * @since 2019-08-21 16:47
 */
public abstract class Turn implements Instruction {

    @Override
    public abstract Point execute(Point point);
}
