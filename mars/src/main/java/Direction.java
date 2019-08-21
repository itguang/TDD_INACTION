import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author guang
 * @since 2019-08-21 16:39
 */
@AllArgsConstructor
@Getter
@ToString
public enum Direction {

    /**
     * 东 西 北 南
     */
    EAST("E", "东"),
    WEST("W", "西"),
    SOUTH("S", "北"),
    NORTH("N", "南");

    private String abb;
    private String orientation;

}
