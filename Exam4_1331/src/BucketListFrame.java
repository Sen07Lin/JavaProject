/*import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class BucketListFrame extends JFrame{
	public BucketListFrame(){
		super("Buck List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		add(new JScrollPane(new JList<String>(listModel)), BorderLayout.CENTER);
		add(createButton("new item.. ", new NewItemListener(this, listModel), BorderLayout.SOUTH));
		pack();
	}
	public JButton createButton(String label, ActionListener listener){
		JButton button = new JButton(label);
		button.addActionListener((listener));
		return button;
	}
	public class NewItemListener implements ActionListener {
		private Component parent;
		private DefaultListModel<String> listModel;
		public NewItemListener (Component parent, DefaultListModel<String> listModel) {
			this.parent= parent;
			this.listModel = listModel;
		}
		public void actionPerformed(ActionEvent e){
			String item = JOptionPane.showInputDialog(parent, "new item");
			listModel.addElement(item);
		}
	}
	public static void main(String[] arg){
		BucketListFrame bf = new BucketListFrame();
		bf.setVisible(true);
	}

}

*/