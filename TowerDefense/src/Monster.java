import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Monster class is the parent class for other Monster class.
 * @author Sen
 * @version 1.0
 */
public abstract class Monster {
    private int health;
    private int speed;
    private Point p = new Point();
    private Rectangle bounds;
    private BufferedImage image;
    private boolean isUnderAttack;

    /**
     * constructor of the Monster.
     * @param bounds Boundary of the swimming map
     * @param x X-coordinate of the monster
     * @parma y Y-coordinate of teh monster.
     */
    public Monster(Rectangle bounds, int x, int y) {
        setCoordinate(x, y);
        setBound(bounds);
        setIsUnderAttack(false);
    }

    /**
     * set boundary of the map.
     * @param bounds boundary of the map
     */
    private void setBound(Rectangle bounds) {
        this.bounds = bounds;

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
     * set the health of the monster.
     * @param health set health of the monster
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * set the speed of the monster
     * @param speed set the speed of the monster
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * setCoordinate of the monster.
     * @param x set x-coordinate of the monster
     * @param y set y-coordinate of the monster
     */
    public void setCoordinate(int x, int y) {
        p.x = x;
        p.y = y;
    }

    /**
     * getCoordinate of the monster.
     * @return return coordinate of the monster
     */
    public Point getCoordinate() {
        return p;
    }

    /**
     * get the health of monster.
     * @return return the health of the monster.
     */
    public int getHealth() {
        return health;
    }

    /**
     * get the speed of monster
     * @return get the speed of monster
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * get the boundary of the map.
     * @return return the rectangle class.
     */
    public Rectangle getBound() {
        return bounds;
    }

    /**
     * get the image of the monster.
     * @return a Buffered Image
     */
    public BufferedImage getImg() {
        return image;
    }

    /**
     * method to make a monster to move.
     */
    public void move() {
        if (p.x + image.getWidth() < 225) {
            p.x = p.x + speed;
        } else if (p.x < 250 && p.y + image.getHeight() < 425) {
            p.y = p.y + speed;
        } else if (p.y > 300 && p.x + image.getWidth() < 375) {
            p.x = p.x + speed;
        } else if (p.x > 250 && p.y + image.getHeight() > 200) {
            p.y = p.y - speed;
        } else {
            p.x = p.x + speed;
        }
    }

    /**
     * set the under attack status
     * @param b make isUnderAttack equal to b.
     */
    public void setIsUnderAttack(boolean b) {
        isUnderAttack = b;
    }

    /**
     * get the status of the monster.
     * @return get the status of the monster.
     */
    public boolean getIsUnderAttack() {
        return isUnderAttack;
    }

    /**
     * this method draw the image into JPanel.
     * @param g the graphic object
     */
    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, p.x, p.y, null);
        }
        if (isUnderAttack) {
            g.setColor(new Color(0, 0, 200));
            g.drawRect(p.x, p.y - 5, (int) health / 5, 2);
        }
    }
}
