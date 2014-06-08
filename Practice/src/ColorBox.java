import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ColorBox extends JFrame {

    JPanel colorPanel;
    Action redAction;
    Action whiteAction;
    Action blueAction;

    public ColorBox() {
        super("Color, Box, and Nesting Demo");

        initActions();

        // Set up color panel
        colorPanel = new JPanel();
        colorPanel.setSize(800, 200);

        // Set up main application frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Grid layout with 1 row, 2 columns
        setLayout(new GridLayout(1, 2));
        add(createButtonPanel());
        add(colorPanel);
        setJMenuBar(createJMenuBar());
    }

    private void initActions() {
        redAction = new AbstractAction("Red") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorPanel.setBackground(Color.RED);
            }
        };
        whiteAction = new AbstractAction("White") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorPanel.setBackground(Color.WHITE);
            }
        };
        blueAction = new AbstractAction("Blue") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorPanel.setBackground(Color.BLUE);
            }
        };
    }

    private JPanel createButtonPanel() {
        JButton redButton = new JButton(redAction);
        JButton whiteButton = new JButton(whiteAction);
        JButton blueButton = new JButton(blueAction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(redButton);
        buttonPanel.add(whiteButton);
        buttonPanel.add(blueButton);

        return buttonPanel;
    }

    private JMenuBar createJMenuBar() {
        JMenuItem redMenuItem = new JMenuItem(redAction);
        JMenuItem whiteMenuItem = new JMenuItem(whiteAction);
        JMenuItem blueMenuItem = new JMenuItem(blueAction);

        JMenu colorMenu = new JMenu("Color");
        colorMenu.add(redMenuItem);
        colorMenu.add(whiteMenuItem);
        colorMenu.add(blueMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colorMenu);
        return menuBar;
    }

    public static void main(String[] args) {
        ColorBox cb = new ColorBox();
        cb.pack();
        cb.setVisible(true);
    }
}