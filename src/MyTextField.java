import java.awt.Font;

import javax.swing.JTextField;

public class MyTextField extends JTextField {
	public static final Font FONT_TEXTFIELD = new Font("Helvetica", Font.ITALIC, 20);
	
	public MyTextField(String text) {
		super(text);
		setFont(FONT_TEXTFIELD);
	}

}
