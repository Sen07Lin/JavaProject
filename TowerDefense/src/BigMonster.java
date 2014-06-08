import java.awt.Rectangle;
/**
 * bigMonster, it is slow with highHealth.
 * @author Sen
 * @version 1.0
 */
public class BigMonster extends Monster {
    /**
     * Constructor of the bigMonster, it is slow with highHealth.
     * @param bounds  boundary of the map
     * @param x x-coordinate of the monster.
     * @param y y-coordinate of the monster.
     */
    public BigMonster(Rectangle bounds, int x, int y) {
        super(bounds, x, y);
        setHealth(200);
        setSpeed(1);
        setImage("BigMonster.png");
    }

}
