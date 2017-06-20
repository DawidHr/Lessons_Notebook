import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class lessonsPanel {
	JPanel panel = new JPanel();
	TableModel table;
	JTable tab;
	ArrayList<Subject> records = new ArrayList<>();
	String[] opisKolumn = { "Tytu³", "Opis" };

	public lessonsPanel() {

		/*DataBase baza = new DataBase();
		records = baza.pobierzNaprawe(1);
		table = new tableSubject(2, records);
		tab = new JTable(table);
		tab.setRowHeight(90);
		tab.setPreferredScrollableViewportSize(new Dimension(600, 300));
		JScrollPane pane = new JScrollPane(tab);
		panel.add(pane);*/
	}

	public JPanel getPanel() {
		return panel;
	}

	
}
