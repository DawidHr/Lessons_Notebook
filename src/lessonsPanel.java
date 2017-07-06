import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
		records.add(new Subject(1, "Dodaj"));
		records.add(new Subject(2, "Alina"));
		
		table = new tableSubject(1, records);
		tab = new JTable(table);
		tab.setRowHeight(90);
		tab.setPreferredScrollableViewportSize(new Dimension(650, 500));
		JScrollPane pane = new JScrollPane(tab);
		SelectionListener listener = new SelectionListener(frame, baza, panel, tab, records);
		tab.getSelectionModel().addListSelectionListener(listener);
		
		panel.add(pane);
		
	}
	public void changeResultSetToList(ResultSet rs){
		try{while(rs.next()) {
			records.add(new Subject(rs.getInt("id"), rs.getString("subject")));
		System.out.println(rs.getString("className"));
		}}
		catch(Exception e) {
			System.out.println("Pusta");
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

	public void getClickedButton(){
		
	}
	
}


class SelectionListener implements ListSelectionListener {
JTable table;
ArrayList<Subject> records;
JFrame frame;
JPanel panel;
DataBase baza;
SelectionListener(JFrame frame,DataBase baza, JPanel panel, JTable table, ArrayList<Subject> records) {
	this.frame=frame;
	this.baza=baza;
	this.panel=panel;
	this.table=table;
	this.records=records;
}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == table.getSelectionModel() && table.getRowSelectionAllowed()) {
			int f = e.getFirstIndex();
			int c = e.getLastIndex();
			String k = records.get(c).getNameOfClass().toString();
			System.out.println("Wartosc to:"+f+""+c+ "" +k);
			if(records.get(c).getNameOfClass().toString() == "Dodaj") {
				System.out.println("hej dodaj");
				panel.setVisible(false);
				addLessonPanel panel = new addLessonPanel(frame, baza);
			}
			else {
			
			}
		}
	}
	
}