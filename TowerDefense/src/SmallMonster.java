import java.awt.Rectangle;

/**
 * SmallMonsters are fast but lack of health.
 * @author Sen
 * @version 1.0
 */
public class SmallMonster extends Monster {
    /**
     * Constructor of the SmallMonsters, it is fast with lowHealth.
     * @param bounds  boundary of the map
     * @param x x-coordinate of the monster.
     * @param y y-coordinate of the monster.
     */
    public SmallMonster(Rectangle bounds, int x, int y) {
        super(bounds, x, y);
        setHealth(30);
        setSpeed(6);
        setImage("SmallMonster.png");
    }

}
