import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	public static final Font FONT_LABEL = new Font("Helvetica", Font.ITALIC, 20);
	
	public MyLabel(String text) {
		super(text);
		setFont(FONT_LABEL);
	}

}
