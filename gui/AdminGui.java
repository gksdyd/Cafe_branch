package Cafe_branch.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static final int SAVE_X_LOCATION = 150;
	private static final int SAVE_Y_LOCATION = 150;
	private static final String SAVE_BUTTON_NAME = "Save";
	
	private static final int REMOVE_X_LOCATION = 150;
	private static final int REMOVE_Y_LOCATION = 300;
	private static final String REMOVE_BUTTON_NAME = "Remove";
	
	private static final int EXIT_X_LOCATION = 150;
	private static final int EXIT_Y_LOCATION = 450;
	private static final String EXIT_BUTTON_NAME = "Exit";
	
	JFrame adminFrame;
	
	JButton saveButton;
	JButton removeButton;
	JButton exitButton;
	
	public AdminGui() {
		initGui();
		
		saveButton = setButton(Gui.BUTTON_WIDTH, Gui.BUTTON_HEIGHT, SAVE_X_LOCATION, SAVE_Y_LOCATION, SAVE_BUTTON_NAME);
		removeButton = setButton(Gui.BUTTON_WIDTH, Gui.BUTTON_HEIGHT, REMOVE_X_LOCATION, REMOVE_Y_LOCATION, REMOVE_BUTTON_NAME);
		exitButton = setButton(Gui.BUTTON_WIDTH, Gui.BUTTON_HEIGHT, EXIT_X_LOCATION, EXIT_Y_LOCATION, EXIT_BUTTON_NAME);
		setVisible(true);
		
		actionListener(saveButton);
		actionListener(removeButton);
		actionListener(exitButton);
	}
	
	void initGui() {
		adminFrame = new JFrame();
		adminFrame.setTitle(Gui.TITLE);
		adminFrame.setSize(Gui.BACKGROUND_WIDTH, Gui.BACKGROUND_HEIGHT);
		adminFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	JButton setButton(int width, int height, int xLocation, int yLocation, String name) {
		adminFrame.setLayout(null);
		
		JButton button = new JButton(name);
		button.setLocation(xLocation,yLocation);
		button.setSize(width, height);
		adminFrame.add(button);
		
		return button;
	}
	
	void actionListener(JButton button) {
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) {
			try {
				new SaveGui();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == removeButton) {
			
		} else if (e.getSource() == exitButton) {
			System.exit(0);
		}
		adminFrame.dispose();
	}
}
