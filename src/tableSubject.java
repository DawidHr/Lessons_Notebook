import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class tableSubject extends AbstractTableModel {
	int rowCount;
	ArrayList<Subject> opis;

	public tableSubject() {
		// TODO Auto-generated constructor stub
	}

	public tableSubject(int rowCount, ArrayList<Subject> opis) {
		this.rowCount = rowCount;
		this.opis = opis;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return opis.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		String nameOfClass = opis.get(arg0).getNameOfClass();
		JButton button = new JButton(nameOfClass);
		button.addActionListener(listener);
		return button;
	}

	public String getColumnName(int c) {
		return "";
	}

	ActionListener listener = new ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			
		};
	};
	
}
