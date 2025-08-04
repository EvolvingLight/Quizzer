import java.awt.Font;

import javax.swing.JTextArea;

public class MyTextArea extends JTextArea {
	public static final Font FONT_TEXTAREA = new Font("Helvetica", Font.ITALIC, 20);

	public MyTextArea(String text) {
		super(text);
		setFont(FONT_TEXTAREA);
	}

}
