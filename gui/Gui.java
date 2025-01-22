package cafe_project.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	static final String TITLE = "STAR CAFE";
	
	static final int BACKGROUND_WIDTH = 500;
	static final int BACKGROUND_HEIGHT = 800;
	
	static final int BUTTON_WIDTH = 200;
	static final int BUTTON_HEIGHT = 50;
	
	private static final int CUSTOMER_X_LOCATION = 150;
	private static final int CUSTOMER_Y_LOCATION = 150;
	private static final String CUSTOMER_BUTTON_NAME = "Custom";
	
	private static final int ADMIN_X_LOCATION = 150;
	private static final int ADMIN_Y_LOCATION = 300;
	private static final String ADMIN_BUTTON_NAME = "Admin";
	
	private static final int EXIT_X_LOCATION = 150;
	private static final int EXIT_Y_LOCATION = 450;
	private static final String EXIT_BUTTON_NAME = "Exit";
	
	JFrame mainFrame;
	
	JButton customButton;
	JButton adminButton;
	JButton exitButton;
	
	public Gui() {
		initGui();
		
		customButton = setButton(BUTTON_WIDTH, BUTTON_HEIGHT, CUSTOMER_X_LOCATION, CUSTOMER_Y_LOCATION, CUSTOMER_BUTTON_NAME);
		adminButton = setButton(BUTTON_WIDTH, BUTTON_HEIGHT, ADMIN_X_LOCATION, ADMIN_Y_LOCATION, ADMIN_BUTTON_NAME);
		exitButton = setButton(BUTTON_WIDTH, BUTTON_HEIGHT, EXIT_X_LOCATION, EXIT_Y_LOCATION, EXIT_BUTTON_NAME);
		setVisible(true);
		
		actionListner(customButton);
		actionListner(adminButton);
		actionListner(exitButton);
	}
	
	void initGui() {
		mainFrame = new JFrame();
		mainFrame.setTitle(TITLE);
		mainFrame.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	JButton setButton(int width, int height, int xLocation, int yLocation, String name) {
		mainFrame.setLayout(null);
		
		JButton button = new JButton(name);
		button.setLocation(xLocation,yLocation);
		button.setSize(width, height);
		mainFrame.add(button);
		
		return button;
	}
	
	public void actionListner(JButton button) {
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == customButton) {
			new CustomGui();
		} else if (e.getSource() == adminButton) {
			new AdminGui();
		} else if (e.getSource() == exitButton) {
			System.exit(0);
		}
		mainFrame.dispose();
	}
}
