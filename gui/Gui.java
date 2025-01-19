package cafe_project.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "STAR CAFE";
	
	private static final int BACKGROUND_WIDTH = 500;
	private static final int BACKGROUND_HEIGHT = 800;
	
	private static final int BUTTON_WIDTH = 200;
	private static final int BUTTON_HEIGHT = 50;
	
	private static final int CUSTOMER_X_LOCATION = 150;
	private static final int CUSTOMER_Y_LOCATION = 150;
	private static final String CUSTOMER_BUTTON_NAME = "Custom";
	
	private static final int ADMIN_X_LOCATION = 150;
	private static final int ADMIN_Y_LOCATION = 300;
	private static final String ADMIN_BUTTON_NAME = "Admin";
	
	private static final int EXIT_X_LOCATION = 150;
	private static final int EXIT_Y_LOCATION = 450;
	private static final String EXIT_BUTTON_NAME = "Exit";
	
	PanelGui pannel;
	ButtonGui button;
	
	public Gui() {
		initGui();
		
		setButton(BUTTON_WIDTH, BUTTON_HEIGHT, CUSTOMER_X_LOCATION, CUSTOMER_Y_LOCATION, CUSTOMER_BUTTON_NAME);
		setButton(BUTTON_WIDTH, BUTTON_HEIGHT, ADMIN_X_LOCATION, ADMIN_Y_LOCATION, ADMIN_BUTTON_NAME);
		setButton(BUTTON_WIDTH, BUTTON_HEIGHT, EXIT_X_LOCATION, EXIT_Y_LOCATION, EXIT_BUTTON_NAME);
		setVisible(true);
	}
	
	void initGui() {
		setTitle(TITLE);
		setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void setButton(int width, int height, int xLocation, int yLocation, String name) {
		setLayout(null);
		
		JButton button = new JButton("Customer");
		button.setLocation(xLocation,yLocation);
		button.setSize(width, height);
		add(button);
	}
}
