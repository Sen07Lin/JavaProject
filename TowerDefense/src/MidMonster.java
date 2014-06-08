import java.awt.Rectangle;

/**
 * MidMonster, it is fairly fast with fair health.
 * @author Sen
 * @version 1.0
 */
public class MidMonster extends Monster {
    /**
     * Constructor of the MidMonster, it is fairly fast with fair health.
     * @param bounds boundary of the map
     * @param x x-coordinate of the monster.
     * @param y y-coordinate of the monster.
     */
    public MidMonster(Rectangle bounds, int x, int y) {
        super(bounds, x, y);
        setHealth(60);
        setSpeed(4);
        setImage("MidMonster.png");
    }

}
