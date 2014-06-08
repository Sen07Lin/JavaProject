import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * The TowerDefenseGame class contains main to run everything.
 *
 * @author Sen
 * @version 1.0
 */
public class TowerDefenseGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);
        frame.add(new GamePanel(control)); // defaults to CENTER
        frame.pack();
        frame.setVisible(true);
    }
}
