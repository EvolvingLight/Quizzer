package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import layout.QPanel;

/**
 * This class builds the view of the questionPanel
 * Several components are initialized, added and structured in GridBagyLayout 
 */
public class ThemeTabThemeListPanel extends QPanel {

	/**
	 * Label to display error / hint message
	 */
	public JLabel msgLabel;

	/**
	 * Label to display the word "theme"
	 */
	private JLabel themeLabelHeader;

	/**
	 * Textfield to enter / show the text of the title
	 */
	public JTextField titleField;
	
	/**
	 * Textarea to enter new questions
	 */
	public JTextArea questionArea;
	

	/**
	 * Variable to define in which row of the GridBagLayout a component will be added
	 */
	private int row;
	
	/**
	 * The constructor initializes and adds the components
	 */
	public ThemeTabThemeListPanel() {
		super();
		
		initComponents();
		addComponents();
	}
		
	/**
	 * Initializes the components
	 */
	void initComponents() {
		themeLabelHeader = new JLabel("Themen");

		msgLabel = new JLabel();

		titleField = new JTextField();
		questionArea = new JTextArea(40, 200);
		
	}

	/*
	 * Adds the components to the panel
	 * The components can be labels, textfields, textareas or checkboxes for example
	 */
	private void addComponents() {
		row = 0;
		// Row 1: Theme (Label: "Themen")
		addThemeLabelHeader();
		
		// Row 2+ ScrollPane including title list
		addThemeList();
	}


	/**
	 * Adds a labels title as header 
	 */
	private void addThemeLabelHeader() {
		addComponent(themeLabelHeader, row, 0);
		row++;
	}


	/**
	 * Adds the question label and the scroll pane
	 */
	private void addThemeList() {
		gbc.gridheight = 3;										// Question Label and ScrollPane 3 columns high
		gbc.gridwidth = 2;										// Question ScrollPane 2 columns wide
		JScrollPane pane = new JScrollPane(questionArea);
		pane.setMinimumSize(new Dimension(300, 400));
		addComponent(pane, row, 0);
		gbc.gridwidth = 1;										// Back to standard => 1 column wide							
		row+=gbc.gridheight;
		gbc.gridheight = 1;										// Back to standard => 1 column high
	}




	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
