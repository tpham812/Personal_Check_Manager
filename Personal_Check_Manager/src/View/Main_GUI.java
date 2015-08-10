package View;
import java.awt.Dimension;

import javax.swing.*;


public class Main_GUI {

	private static JTabbedPane tabbedPane;
	private static JFrame frame;
	private static JPanel[] panel;
	
	public static void main(String[] args) {
		
		createMainFrame();
	}
	
	static void createMainFrame() {
		
		frame = new JFrame("Personal Check Manager");
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(700,700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel = new JPanel[3];
		for(int i = 0; i < 3; i++) {
			panel[i] = new JPanel();
		}
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Add", panel[0]);
		tabbedPane.addTab("Delete", panel[1]);
		tabbedPane.addTab("Search", panel[2]);
		frame.add(tabbedPane);
	}
}
