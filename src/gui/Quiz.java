package gui;
import java.awt.HeadlessException;
import java.awt.LayoutManager;

import javax.swing.JFrame;

/**
 * The main application window for the Quizzer application.
 * This class extends {@link JFrame} and sets up the primary user interface,
 * including:
 * A fixed-size window positioned on the screen
 * A {@link TabPane} to organize different sections (currently one tab)
 * The main quiz content panel ({@link QuestionTabMainPanel})
 * The window is non-resizable and exits the application when closed.
 * This class serves as the entry point and container for the entire GUI.
 */
public class Quiz extends JFrame {

	private static final int FRAME_X = 400; 						// Position of window
	private static final int FRAME_Y = 100;  						// Position of window
	public static final int FRAME_WIDTH = 1200;
	public static final int FRAME_HEIGHT = 800;
	public static LayoutManager grid;
	
	/**
     * Constructs the main Quiz window.
     * Configures:
     * - Window title
     * - Default close operation
     * - Size and position
     * - Tabbed content
     * - Visibility
     */
	public Quiz() throws HeadlessException{
		super("Quizzer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		
		TabPane tabPanel = new TabPane();
		
		QuizTabMainPanel quizTabMainPanel = new QuizTabMainPanel();
		tabPanel.addTab("Quizthemen", quizTabMainPanel);
		add(tabPanel);
		
		QuestionTabMainPanel questionTabMainPanel= new QuestionTabMainPanel(); 
		tabPanel.addTab("Quizfragen", questionTabMainPanel);
		add(tabPanel);
		
		setResizable(false);
		setVisible(true);
	}

	/**
     * Entry point of the application.
     * Creates and displays the main {@code Quiz} window on the Event Dispatch Thread (EDT)
     * to ensure thread safety for Swing components.
     * 
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		new Quiz();

	}

}
