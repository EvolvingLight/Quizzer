
import java.awt.GridLayout;

import javax.swing.JPanel;

public class SubPanel extends JPanel{
	
	static int y = 5;
	
	/**
	 * Creates a subpanel with only rows and columns
	 * @param rows
	 * @param cols
	 */	
	public SubPanel(int rows, int cols) {
		super();
		setLayout(new GridLayout(rows, cols));
	}
	
	/**
	 * Creates a subpanel with rows, cols and a factor to define the row height
	 * @param rows
	 * @param cols
	 * @param factor
	 */
	public SubPanel(int rows, int cols, int factor) {
		this(rows, cols);
		int height = Quiz.FRAME_HEIGHT / factor;
		
		
		setBounds(20, y, Quiz.FRAME_WIDTH - 40, height);
		y += height;
	}
	}
