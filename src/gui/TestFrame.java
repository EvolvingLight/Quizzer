package gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class TestFrame extends JFrame {

	public TestFrame() throws HeadlessException {
		super();
		setBounds(600, 100, 720, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new QuestionMainPanel());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		

	}

}
