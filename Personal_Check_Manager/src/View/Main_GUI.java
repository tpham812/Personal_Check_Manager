package View;
import java.awt.Dimension;

import javax.swing.*;


public class Main_GUI {

	private static JTabbedPane tabbedPane;
	private static JFrame frame;
	private static JPanel[] panel;
	
	public static void main(String[] args) {
		
		initializeComponents();
		createMainFrame();
	}
	
	static void initializeComponents() {
		
		frame = new JFrame("Personal Check Manager");
		panel = new JPanel[2];
		panel[0] = new HomeTab();
		panel[1] = new AddTab();
		
	}
	static void createMainFrame() {
		
		frame.setMinimumSize(new Dimension(1100,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("<html><body marginwidth = 35 marginheight = 5>Home</body></html>", panel[0]);
		tabbedPane.addTab("<html><body marginwidth = 35 marginheight = 5>Add</body></html>", panel[1]);
		frame.add(tabbedPane);
	}
}
