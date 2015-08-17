package View;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class HomeTab extends JPanel {
 

	private static JTable table;
	private static JScrollPane scrollPane;
	private String[] columnNames = {"ID", "Date", "Amount", "State Tax", "Federal Tax", "Pension", "Medical"};
	
	public HomeTab() {

		initializeComponents(); 
		createPanel();
	}
	
	public void initializeComponents() {
		
		String [][] sample = new String[100][7];
		table = new JTable(sample, columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600,535));
	}
	
	public void createPanel() {
		
		add(scrollPane);
		
	}
}
