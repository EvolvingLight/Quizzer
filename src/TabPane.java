import java.awt.Font;

import javax.swing.JTabbedPane;

public class TabPane extends JTabbedPane {
	private static final Font FONT_TAB = new Font("Arial", Font.PLAIN, 24);
	
	public TabPane() {
		super(JTabbedPane.TOP);
		setFont(FONT_TAB);
	}

}
