package cafe_branch.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cafe_branch.app.FileInOutput;

public class GenerateGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static final String GENERATE_TITLE = "Generate File";
	
	private static final int GENERATE_WINDOW_WIDTH = 300;
	private static final int GENERATE_WINDOW_HEIGHT = 200;
	
	private static final int GENERATE_BUTTON_WIDTH = 100;
	private static final int GENERATE_BUTTON_HEIGHT = 50;
	
	private static final int GENERATE_X_LOCATION = 100;
	private static final int GENERATE_Y_LOCATION = 90;
	private static final String GENERATE_BUTTON_NAME = "Generate";
	
	private static final int TEXT_FIELD_WIDTH = 200;
	private static final int TEXT_FIELD_HEIGHT = 30;
	
	private static final int TEXT_FIELD_X_LOCATION = 20;
	private static final int TEXT_FIELD_Y_LOCATION = 35;
	
	private static final int LABEL_WIDTH = 30;
	private static final int LABEL_HEIGHT = TEXT_FIELD_HEIGHT;
	
	private static final int LABEL_X_LOCATION = TEXT_FIELD_X_LOCATION + TEXT_FIELD_WIDTH;
	private static final int LABEL_Y_LOCATION = TEXT_FIELD_Y_LOCATION;
	private static final String LABEL_NAME = ".txt";
	
	JFrame generateFrame;
	
	JButton generateButton;
	
	JTextField text;
	
	JLabel label;
	
	public GenerateGui() {
		initGui();
		generateButton = setButton(GENERATE_BUTTON_WIDTH, GENERATE_BUTTON_HEIGHT, GENERATE_X_LOCATION, GENERATE_Y_LOCATION, GENERATE_BUTTON_NAME);
		initText();
		initLabel();
		setVisible(true);
		actionListner(generateButton);
	}
	
	void initGui() {
		generateFrame = new JFrame();
		generateFrame.setTitle(GENERATE_TITLE);
		generateFrame.setSize(GENERATE_WINDOW_WIDTH, GENERATE_WINDOW_HEIGHT);
		generateFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void initText() {
		text = new JTextField();
		text.setLocation(TEXT_FIELD_X_LOCATION, TEXT_FIELD_Y_LOCATION);
		text.setSize(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		generateFrame.add(text);
	}
	
	void initLabel() {
		Font font = new Font(null, Font.PLAIN, 20);
		label = new JLabel(LABEL_NAME);
		label.setLocation(LABEL_X_LOCATION, LABEL_Y_LOCATION);
		label.setSize(LABEL_WIDTH, LABEL_HEIGHT);
		label.setFont(font);
		generateFrame.add(label);
	}
	
	JButton setButton(int width, int height, int xLocation, int yLocation, String name) {
		setLayout(null);
		
		JButton button = new JButton(name);
		button.setLocation(xLocation,yLocation);
		button.setSize(width, height);
		generateFrame.add(button);
		
		return button;
	}

	public void actionListner(JButton button) {
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generateButton) {
			try {
				new FileInOutput(text.getText() + ".txt");
				new SaveGui();
				generateFrame.dispose();
//				saveFrame.dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
