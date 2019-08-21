import lombok.Data;

/**
 * @author guang
 * @since 2019-08-21 16:37
 */

@Data
public class Point {
    private Integer x;
    private Integer y;
    private Direction direction;

    public Point(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

}
