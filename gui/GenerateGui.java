package cafe_branch.gui;

import javax.swing.JFrame;

public class GenerateGui extends JFrame {

	private static final long serialVersionUID = 1L;

	public GenerateGui() {
		initGui();
	}
	
	void initGui() {
		setTitle(Gui.TITLE);
		setSize(Gui.BACKGROUND_WIDTH, Gui.BACKGROUND_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
