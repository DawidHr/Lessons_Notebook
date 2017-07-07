import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addLessonPanel {
JFrame frame;
DataBase db;
JPanel panel = new JPanel();	
JLabel text = new JLabel("Proszê podaæ nazwê przedmiotu: ");
JTextField field = new JTextField(20);
JButton save = new JButton("Zapisz");

	addLessonPanel(JFrame frame, DataBase db) {
		this.frame = frame;
		this.db = db ;
		main();
	}
	
	public void main() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		panel.add(text, c);
		c.gridx=1;
		panel.add(field, c);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
		panel.add(save, c);
		save.addActionListener(listener);
		
		frame.add(panel);
	}
	
	ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		save();	
		panel.setVisible(false);
		lessonsPanel panel1 = new lessonsPanel(frame, db);
		}
	};
	
	public void save() {
		db.addLessons(field.getText().toString());
	}
}
