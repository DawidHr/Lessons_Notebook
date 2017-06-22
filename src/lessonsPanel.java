import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
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
JFrame frame;
	public lessonsPanel(JFrame frame) {
this.frame=frame;
		DataBase baza = new DataBase();
		ResultSet rs = baza.viewLessons();
		changeResultSetToList(rs);
		applicatioSize();
		table = new tableSubject(1, records);
		tab = new JTable(table);
		tab.setRowHeight(90);
		tab.setPreferredScrollableViewportSize(new Dimension(650, 500));
		JScrollPane pane = new JScrollPane(tab);
		panel.add(pane);
		int a = tab.getSelectedRow();
		int c =tab.getSelectedColumnCount();
		System.out.println(a+" "+c);
		/*records = baza.pobierzNaprawe(1);
		table = new tableSubject(2, records);
		tab = new JTable(table);
		tab.setRowHeight(90);
		tab.setPreferredScrollableViewportSize(new Dimension(600, 300));
		JScrollPane pane = new JScrollPane(tab);
		panel.add(pane);*/
	}
	public void changeResultSetToList(ResultSet rs){
		try{while(rs.next()) {
			records.add(new Subject(rs.getInt("id"), rs.getString("subject")));
		System.out.println(rs.getString("className"));
		}}
		catch(Exception e) {
			
		}
	}
	
	public Dimension applicatioSize() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(d.getWidth());
		System.out.println(d.getHeight());
		return d; 
		
	}

	public JPanel getPanel() {
		return panel;
	}

	
}
