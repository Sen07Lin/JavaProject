import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This is a JPanel type class. GamePenel of the Game. all activities of the
 * game will be occur in
 * @author Sen
 * @version 1.0
 */
public class GamePanel extends JPanel {
    /**
     * Width and Height of the boundary.
     */
    public static final int WIDTH = 600, HEIGHT = 600;
    /**
     * cost of advanced and regular tower.
     */
    public static final int COSTOFADTOWER = 100, COSTOFREGTOWER = 60;
    private ArrayList<Tower> towers = new ArrayList<Tower>();
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private ControlPanel cPanel;
    private Timer timer;
    private Rectangle bounds;
    private BufferedImage castle;

    /**
     * constructor of the GamePanel. It initiates the color and dimension of the
     * GamePanel. Using time to run the simulation.
     * @param control A ControlPanel instance which is used to determine the
     *            next tower to create
     */
    public GamePanel(ControlPanel control) {
        cPanel = control;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        bounds = new Rectangle(0, 0, WIDTH, HEIGHT);
        addMouseListener(new ClickListener());
        timer = new Timer(100, new TimerListener());
        timer.start();
    }

    /**
     * The method to make Monsters after sendWave button being pressed.
     * @param isHasSent. The status to indicate if monsters have been sent.
     */
    public void makeMonster(boolean isHasSent) {
        if (isHasSent) {
            Random generator = new Random();
            int numOfBig = generator.nextInt(5) + 1;
            int numOfMid = generator.nextInt(6 - numOfBig);
            int numOfSmall = generator.nextInt(10 - numOfBig - numOfMid) + 1;
            for (int j = 0; j < numOfBig; j++) {
                monsters.add(new BigMonster(bounds, -j * 30, 200));
            }
            for (int j = 0; j < numOfMid; j++) {
                monsters.add(new MidMonster(bounds, -j * 25, 200));
            }
            for (int j = 0; j < numOfSmall; j++) {
                monsters.add(new SmallMonster(bounds, -j * 20, 200));
            }
            int i = cPanel.getWaveCount();
            for (Monster m : monsters) {
                m.setHealth(m.getHealth() + 20 * i);
                m.setSpeed(m.getSpeed() + (int) (i / 2));
            }
            cPanel.setHasSent(false); // finish sending monsters
        }
    }

    /**
     * Move all the monsters.
     */
    public void moveAll() {
        for (Monster m : monsters) {
            m.move();
            repaint();
        }
    }

    /**
     * let's attack monster
     */
    public void attack() {
        for (Tower t : towers) {
            for (Monster m : monsters) {
                if (!t.getAttackStatus()) {
                    t.attackMonster(m);
                }
            }
        }
    }

    /**
     * check if any monster has been killed
     */
    public void checkDead() {
        Iterator<Monster> monsterIter = monsters.iterator();
        while (monsterIter.hasNext()) {
            Monster monster = monsterIter.next();
            if (monster.getHealth() <= 0) {
                if (monster instanceof BigMonster) {
                    cPanel.getPlayer().setMoney(
                            cPanel.getPlayer().getMoney() + 10);
                    cPanel.getPlayer().setScore(
                            cPanel.getPlayer().getScore() + 10);
                } else if (monster instanceof MidMonster) {
                    cPanel.getPlayer().setMoney(
                            cPanel.getPlayer().getMoney() + 5);
                    cPanel.getPlayer().setScore(
                            cPanel.getPlayer().getScore() + 5);
                } else {
                    cPanel.getPlayer().setMoney(
                            cPanel.getPlayer().getMoney() + 3);
                    cPanel.getPlayer().setScore(
                            cPanel.getPlayer().getScore() + 3);
                }
                monsterIter.remove();
            }
        }
    }

    /**
     * check if any tower is eligible to be upgraded.
     */
    public void checkUpgrade() {
        for (Tower t : towers) {
            t.checkTowerUpgrade();
        }
    }

    /**
     * check if any monster is attacking the castle.
     */
    public void chekcCastleBeingAttack() {
        Iterator<Monster> monsterIter = monsters.iterator();
        while (monsterIter.hasNext()) {
            Monster m = monsterIter.next();
            if (WIDTH - castle.getWidth() - m.getCoordinate().x <= 0) {
                monsterIter.remove();
                cPanel.getPlayer().setScore(cPanel.getPlayer().getScore() - 20);
                // if the player's score decreases to 0. game is over.
                if (cPanel.getPlayer().getScore() <= 0) {
                    cPanel.changeLabel(cPanel.getPlayer().moneyToString(),
                            cPanel.getPlayer().scoreToString());
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Sorry, you're dead!");
                }
            }
        }
    }

    /**
     * draw the path that monsters walk
     * @param g object to draw on the GamePanel.
     */
    private void drawPath(Graphics g) {
        g.setColor(new Color(0, 250, 154));
        g.drawRect(0, 200, 200, 25);
        g.drawRect(200, 200, 25, 200);
        g.drawRect(200, 400, 175, 25);
        g.drawRect(350, 200, 25, 200);
        g.drawRect(350, 175, WIDTH - castle.getWidth() - 345, 25);
    }

    @Override
    /**
     * Draw all the elements.
     * @param g object to draw on the GamePanel.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            castle = ImageIO.read(new File("Castle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        drawPath(g);
        g.drawImage(castle, WIDTH - castle.getWidth(), 120, null);
        for (Monster m : monsters) {
            m.draw(g);
        }
        for (Tower t : towers) {
            t.positionAutoCorrect();
            t.draw(g);
            t.setAttackStatus(false);
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        /**
         * the main method of TimerListener.
         * it calls all necessary methods to run the simulation.
         * Override the actionPerform method,
         * @param e trigger after 100 unit time.
         */
        public void actionPerformed(ActionEvent e) {
            cPanel.changeLabel(cPanel.getPlayer().moneyToString(), cPanel
                    .getPlayer().scoreToString());
            makeMonster(cPanel.isHasSent());
            moveAll();
            attack();
            checkDead();
            checkUpgrade();
            chekcCastleBeingAttack();
        }
    }

    private class ClickListener extends MouseAdapter {
        /*
         * @param Point p is where the tower will be placed to start.
         * @param String className is the class name for the type of tower that
         * we want to instantiate.
         * @return Tower that is exactly the type of Tower that we want to add
         * to the panel.
         */
        public Tower instantiateTower(Point p, String className) {
            try {
                Class cl = Class.forName(className);
                return (Tower) (cl.getDeclaredConstructor(int.class, int.class,
                        Rectangle.class).newInstance(p.x, p.y, bounds));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (InstantiationException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                System.exit(1);
            }
            return null;
        }

        @Override
        /**
         * help to add Tower instance.
         * and repaint Tower instance back to the GamePanel.
         * @param e trigger when mouse clicks on the map,
         */
        public void mousePressed(MouseEvent e) {
            String towerType = cPanel.getTowerType();
            Point p = e.getPoint();
            int money = cPanel.getPlayer().getMoney();
            if ((money >= COSTOFADTOWER && towerType.equals("AdvancedTower"))
                    || (money >= COSTOFREGTOWER && towerType
                            .equals("RegularTower"))) {
                towers.add(instantiateTower(p, towerType));
                cPanel.getPlayer().minusCost(towerType);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No enough money for the selected tower!");
            }
            repaint();
        }
    }
}
