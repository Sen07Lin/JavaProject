import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Tower class is the parent class for other Tower class.
 * @author Sen
 * @version 1.0
 */
public abstract class Tower {
    private boolean attackStatus;
    private int attackRadius;
    private int attackPower;
    private int x;
    private int y;
    private int numOfKill;
    private Point centerOfTower;
    private Point attackedMonsterPoint = new Point();
    private Rectangle bounds;
    private BufferedImage image;

    /**
     * constructor of the Tower.
     * @param x X coordinate of the Tower.
     * @param y Y coordinate of the Tower.
     * @param bounds Boundary of the map
     */
    public Tower(int x, int y, Rectangle bounds) {
        setX(x);
        setY(y);
        setAttackStatus(false);
        setBounds(bounds);
        setNumOfKill(0);
    }

    /**
     * positionAutoCorrect if the selected point is not valid.
     */
    public void positionAutoCorrect() {
        int w = image.getWidth();
        int h = image.getHeight();
        // Check if selected point is outside of the boundary.
        if (x + w >= bounds.getWidth()) {
            x = (int) (bounds.getWidth() - w);
        }
        if (y + h >= bounds.getHeight()) {
            y = (int) (bounds.getHeight() - w);
        }
    }

    /**
     * set the boundary of the map
     * @param bounds the boundary of the map
     */
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    /**
     * get the boundary of the map.
     * @return return the rectangle class.
     */
    public Rectangle getBound() {
        return bounds;
    }

    /**
     * set attack status.
     * @param b attackStatus is set to equal to b.
     */
    public void setAttackStatus(boolean b) {
        attackStatus = b;
    }

    /**
     * method to get attack status.
     * @return return true if the tower is attacking a monster.
     */
    public boolean getAttackStatus() {
        return attackStatus;
    }

    /**
     * the method to find the center of the tower.
     * @param x X-coordinate of the Tower.
     * @param y Y-coordinate of the Tower.
     */
    public void setCenter(int x, int y) {
        centerOfTower = new Point();
        centerOfTower.x = (int) (x + 0.5 * image.getWidth());
        centerOfTower.y = (int) (y + 0.5 * image.getHeight());
    }

    /**
     * get the center of the tower.
     * @return get the center in Point type.
     */
    public Point getCenter() {
        return centerOfTower;
    }

    /**
     * set and read the image by name.
     * @param imgName name of the picture.
     */
    public void setImage(String imgName) {
        try {
            image = ImageIO.read(new File(imgName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get the image of the tower.
     * @return a Buffered Image
     */
    public BufferedImage getImg() {
        return image;
    }

    /**
     * set the attackPower of the tower.
     * @param attackPower set attackPower of the tower
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * get the attackPower of the tower.
     * @return get the attackPower of the tower.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * get the number of killed monster by a particular tower.
     * @return get the number of killed monster by a particular tower.
     */
    public int getNumOfKill() {
        return numOfKill;
    }

    /**
     * set the number of killed monster by a particular tower.
     * @param numOfKill set the number of killed monster
     */
    public void setNumOfKill(int numOfKill) {
        this.numOfKill = numOfKill;
    }

    /**
     * Obtain monster's coordinate.
     * @return return monster's coordinate.
     */
    public Point getAttackedMonsterPoint() {
        return attackedMonsterPoint;
    }

    /**
     * to remember the coordinate of the monster.
     * @param attackedMonsterPoint the point to be remembered.
     */
    public void setAttackedMonsterPoint(Point attackedMonsterPoint) {
        this.attackedMonsterPoint.x = attackedMonsterPoint.x;
        this.attackedMonsterPoint.y = attackedMonsterPoint.y;
    }

    /**
     * check if a tower is ready to upgrade.
     */
    public void checkTowerUpgrade() {
        if (numOfKill >= 5) {
            attackPower++;
            numOfKill = numOfKill - 5;
        }
    }

    /**
     * set x-coordinate of the tower.
     * @param y set x-coordinate of the tower
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get the X-Coordinate of the tower.
     * @return return the x-coordinate of the tower
     */
    public int getX() {
        return x;
    }

    /**
     * set y-coordinate of the tower.
     * @param y set y-coordinate of the tower
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get the Y-Coordinate of the tower.
     * @return returns the y-coordinate of the tower
     */
    public int getY() {
        return y;
    }

    /**
     * set the attacking range for a tower
     * @param attackRadius valid attacking range
     */
    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }

    /**
     * get the attackRadius of attackRadius.
     * @return return the attackRadius of the tower.
     */
    public int getAttackRadius() {
        return attackRadius;
    }

    /**
     * check if the monster is killed by the tower.
     * @param monster the monster that to be checked
     * @return true if the monster has been killed
     */
    public boolean isKill(Monster monster) {
        if (monster.getHealth() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * check if monster is in the attack range
     * @param monster the target monster to be check
     * @return return true if monster is in the range
     */
    public boolean isInRange(Monster monster) {
        if (monster != null) {
            int w = monster.getImg().getWidth();
            int h = monster.getImg().getHeight();
            Point recPoint1 = new Point();
            recPoint1.x = monster.getCoordinate().x;
            recPoint1.y = monster.getCoordinate().y;
            Point recPoint2 = new Point();
            recPoint2.y = recPoint1.y;
            recPoint2.x = recPoint1.x + w;
            Point recPoint3 = new Point();
            recPoint3.x = recPoint1.x;
            recPoint3.y = recPoint1.y + h;
            Point recPoint4 = new Point();
            recPoint4.x = recPoint1.x + w;
            recPoint4.y = recPoint1.y + h;
            if (disToCenter(recPoint1) <= attackRadius) {
                setAttackedMonsterPoint(recPoint1);
                return true;
            } else if (disToCenter(recPoint2) <= attackRadius) {
                setAttackedMonsterPoint(recPoint2);
                return true;
            } else if (disToCenter(recPoint3) <= attackRadius) {
                setAttackedMonsterPoint(recPoint3);
                return true;
            } else if (disToCenter(recPoint4) <= attackRadius) {
                setAttackedMonsterPoint(recPoint4);
                return true;
            }
        }
        monster.setIsUnderAttack(false);
        return false;
    }

    /**
     * inner helper method to check the distance between points to tower.
     * @param p coordinate of the point
     * @return return the distance between one point of rectangle to the tower
     */
    private double disToCenter(Point p) {
        return Math.sqrt(Math.pow((p.x - centerOfTower.x), 2)
                + Math.pow((p.y - centerOfTower.y), 2));
    }

    /**
     * let's defend our home by attacking the monster
     * @param monster the target monster to be attacked
     */
    public void attackMonster(Monster monster) {
        if (isInRange(monster)) {
            setAttackStatus(true);
            monster.setIsUnderAttack(true);
            monster.setHealth(monster.getHealth() - attackPower);
            if (isKill(monster)) {
                setAttackStatus(false);
                setNumOfKill(getNumOfKill() + 1);
            }
        }
    }

    /**
     * this method draw the image into JPanel.
     * @param g the graphic object
     */
    public void draw(Graphics g) {
    }
}
