import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * AdvancedTower has higher attack range and is more powerful
 * @author Sen
 * @version 1.0
 */
public class AdvancedTower extends Tower {
    /**
     * Constructor of the Advanced Tower.
     * @param x The X-Coordinate of the tower.
     * @param y The y-Coordinate of the tower.
     * @param bounds The boundary of the map.
     */
    public AdvancedTower(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setAttackPower(10);
        setImage("AdvancedTower.png");
        setAttackRadius(150);
        setCenter(x, y);
    }

    @Override
    /**
     * Override draw method.
     * @param g To draw on the map.
     */
    public void draw(Graphics g) {
        int r = getAttackRadius();
        Point p = getCenter();
        Point mP = getAttackedMonsterPoint();
        if (getImg() != null) {
            g.drawImage(getImg(), getX(), getY(), null);
        }
        g.drawOval((int) (p.x - r), (int) (p.y - r), 2 * r, 2 * r);
        if (getAttackStatus()) {
            g.setColor(new Color(100, 200, 100));
            g.drawLine(getX(), getY(), mP.x, mP.y);
        }
    }
}
