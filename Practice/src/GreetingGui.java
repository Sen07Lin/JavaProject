import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class GreetingGui extends JFrame{
    private JLabel label;
    public GreetingGui () {
        label = new JLabel("go here");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton button = new JButton("Greeting");
        setLayout(new BorderLayout());
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                label.setText("hi");
                JOptionPane.showMessageDialog(null,"hi");
            }
        });
        add(label, BorderLayout.SOUTH);
        add(button, BorderLayout.CENTER);
        pack();
    }
    public static void main(String[] arg){
        GreetingGui gui = new GreetingGui();
        gui.setVisible(true);
    }
}

