import lombok.Data;

/**
 * @author guang
 * @since 2019-08-21 16:29
 */
@Data
public class Area {

    public Area(Point a, Point b, Point c, Point d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    private Point A;

    private Point B;

    private Point C;

    private Point D;

    public boolean contains(Point point) {
        boolean x = B.getX() <= point.getX() && point.getX() <= A.getX();
        boolean y = D.getY() <= point.getY() && point.getY() <= A.getY();

        if (x && y) {
            return true;
        } else {
            return false;
        }

    }

}
