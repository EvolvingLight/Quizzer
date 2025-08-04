import java.awt.HeadlessException;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import gui.QuestionMainPanel;

public class Quiz extends JFrame {

	private static final int FRAME_X = 400; 						// Position of window
	private static final int FRAME_Y = 100;  						// Position of window
	public static final int FRAME_WIDTH = 1200;
	public static final int FRAME_HEIGHT = 800;
	public static LayoutManager grid;
	
	public Quiz() throws HeadlessException{
		super("Quizzer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		
		TabPane tabPanel = new TabPane();
		QuestionMainPanel quizMainPanel= new QuestionMainPanel(); 
		tabPanel.addTab("Quizfragen", quizMainPanel);
		
		
		
		add(tabPanel);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Quiz();

	}

}
