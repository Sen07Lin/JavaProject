
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the ControlPanel for the game. It allows the user to pick which
 * towers. it would like to add next.
 * @author Sen
 * @version 1.0
 */
public class ControlPanel extends JPanel {
    private JButton sendWave, regularTower, advancedTower;
    private JLabel moneyLabel, scoreLabel, waveCountLabel;
    private Player player = new Player();
    private String towerType;
    private int waveCount = 0;
    private boolean hasSent = false;

    /**
     * The constructor of ControlPanel.
     */
    public ControlPanel() {
        setPreferredSize(new Dimension(150, GamePanel.HEIGHT));
        add(new JLabel("       Money      "));
        moneyLabel = new JLabel();
        add(moneyLabel);
        add(new JLabel("       Score      "));
        scoreLabel = new JLabel();
        add(scoreLabel);
        add(new JLabel("       Waves:      "));
        waveCountLabel = new JLabel(Integer.toString(0));
        add(waveCountLabel);
        sendWave = new JButton("     Send Wave     ");
        sendWave.addActionListener(new ActionListener() {
            @Override
            /**
             * The actionPerform method.
             * @param e event that happens after clicking button
             */
            public void actionPerformed(ActionEvent e) {
                waveCount++;
                setHasSent(true);
                waveCountLabel.setText(Integer.toString(waveCount));
            }
        });
        add(sendWave);
        regularTower = new JButton("  Regular Tower  ");
        regularTower.addActionListener(new ButtonListener("RegularTower"));
        add(regularTower);
        advancedTower = new JButton("Advanced Tower");
        advancedTower.addActionListener(new ButtonListener("AdvancedTower"));
        add(advancedTower);
    }

    /**
     * method to get player.
     * @return return player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * to change the Label in the control Panel.
     * @param money that player has
     * @param socre that player has
     */
    public void changeLabel(String money, String socre) {
        moneyLabel.setText(money);
        scoreLabel.setText(socre);
    }

    /**
     * method to get waveCount.
     * @return return the waveCount.
     */
    public int getWaveCount() {
        return waveCount;
    }

    /**
     * to determine which Tower was chosen.
     * @return The currently selected T type
     */
    public String getTowerType() {
        return towerType;
    }

    /**
     * Method to check if monsters has been sent.
     * @return true if monsters has been sent after sendWave Button has been
     *         clicked
     */
    public boolean isHasSent() {
        return hasSent;
    }

    /**
     * Method to change the status of hasSent variable.
     * @param hasSent to set the hasSent variable.
     */
    public void setHasSent(boolean hasSent) {
        this.hasSent = hasSent;
    }

    /**
     * public inner class to perform actions for events. it implements
     * ActionListener interface
     */
    public class ButtonListener implements ActionListener {
        private String name;

        /**
         * constructor of the ButtonListener.
         * @param className name of the event
         */
        public ButtonListener(String className) {
            name = className;
        }

        @Override
        /**
         * override the actionPerformed method
         * @param e className name of the event
         */
        public void actionPerformed(ActionEvent e) {
            towerType = name;
        }
    }
}
