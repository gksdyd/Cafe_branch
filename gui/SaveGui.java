package Cafe_branch.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import Cafe_branch.api.ArrayListApi;
import Cafe_branch.app.FileInOutput;

public class SaveGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static final int LIST_X_LOCATION = 0;	// 이미 가운데 정렬이라
	private static final int LIST_Y_LOCATION = 200;
	
	private static final int LIST_ROW_COUNT = 10;

	JList<String> list;
	
	public SaveGui() throws IOException {
		initGui();
		initList();
		setVisible(true);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
