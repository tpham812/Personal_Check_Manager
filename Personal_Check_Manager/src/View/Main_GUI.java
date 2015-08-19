package View;
import java.awt.Dimension;

import javax.swing.*;


public class Main_GUI {

	private static JTabbedPane tabbedPane;
	private static JFrame frame;
	private static JPanel homePanel;
	private static JPanel addPanel;
	
	public static void main(String[] args) {

		initializeComponents();
		createMainFrame();
	}
	
	static void initializeComponents() {
		
		frame = new JFrame("Personal Check Manager");
		homePanel = new HomeTab();
		addPanel = new AddTab();
	}
	
	static void createMainFrame() {
		
		frame.setMinimumSize(new Dimension(1100,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("<html><body marginwidth = 35 marginheight = 5>Home</body></html>", homePanel);
		tabbedPane.addTab("<html><body marginwidth = 35 marginheight = 5>Add</body></html>", addPanel);
		frame.add(tabbedPane);
	}
}