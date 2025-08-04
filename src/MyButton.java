import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton {
	public static final Font FONT_BUTTON = new Font("Helvetica", Font.ITALIC, 20);

	public MyButton(String text) {
		super(text);
		setFont(FONT_BUTTON);

	}

}
