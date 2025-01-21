package Cafe_branch.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import cafe_branch.api.ArrayListApi;
import cafe_branch.app.FileInOutput;

public class SaveGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static final int LIST_X_LOCATION = 0;	// 이미 가운데 정렬이라
	private static final int LIST_Y_LOCATION = 200;
	
	private static final int LIST_ROW_COUNT = 10;
	
	private static final int BUTTON_WIDTH = 100;
	private static final int BUTTON_HEIGHT = 50;
	
	private static final int OPEN_X_LOCATION = 100;
	private static final int OPEN_Y_LOCATION = 500;
	private static final String OPEN_BUTTON_NAME = "Open";
	
	private static final int GENERATE_X_LOCATION = 300;
	private static final int GENERATE_Y_LOCATION = 500;
	private static final String GENERATE_BUTTON_NAME = "Generate";

	JList<String> list;
	
	JButton openButton;
	JButton generateButton;
	
	public SaveGui() throws IOException {
		initGui();
		initList();
		setVisible(true);
		openButton = setButton(BUTTON_WIDTH, BUTTON_HEIGHT, OPEN_X_LOCATION, OPEN_Y_LOCATION, OPEN_BUTTON_NAME);
		generateButton = setButton(BUTTON_WIDTH, BUTTON_HEIGHT, GENERATE_X_LOCATION, GENERATE_Y_LOCATION, GENERATE_BUTTON_NAME);
	}
	
	void initGui() {
		setTitle(Gui.TITLE);
		setSize(Gui.BACKGROUND_WIDTH, Gui.BACKGROUND_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void initList() throws IOException {
		FileInOutput getFile = new FileInOutput();
		ArrayListApi<String> files = getFile.readFileNames();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for (int i = 0; i < files.getSize(); i++) {
			listModel.addElement(files.getValue(i));
		}
		
		setLayout(new FlowLayout(FlowLayout.CENTER, LIST_X_LOCATION, LIST_Y_LOCATION));
		list = new JList<String>();
		list.setModel(listModel);
		list.setVisibleRowCount(LIST_ROW_COUNT);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
	}
	
	JButton setButton(int width, int height, int xLocation, int yLocation, String name) {
		setLayout(null);
		
		JButton button = new JButton(name);
		button.setLocation(xLocation,yLocation);
		button.setSize(width, height);
		add(button);
		
		return button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton) {
			new CustomGui();
		} else if (e.getSource() == generateButton) {
			new GenerateGui();
		}
		dispose();
	}

}
