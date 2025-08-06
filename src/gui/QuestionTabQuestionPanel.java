package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import layout.QPanel;
import quizlogic.Question;

/**
 * This class builds the view of the questionPanel
 * Several components are initialized, added and structured in GridBagyLayout 
 */
public class QuestionTabQuestionPanel extends QPanel {

	/**
	 * 	Label to display the theme
	 */
	public JLabel themeLabelText;
	
	/**
	 * Label to display error / hint message
	 */
	public JLabel msgLabel;
	
	/**
	 * Label to display the word "title"
	 */
	private JLabel titleLabel;

	/**
	 * Label to display the word "theme"
	 */
	private JLabel themeLabel;

	/**
	 * Label to display the word "question"
	 */
	private JLabel questionLabel;

	/**
	 * Label to show the header-text of the answer section
	 */
	private JLabel answerHeaderLabel;

	/**
	 * Label to display the text "correct"
	 */
	private JLabel answerCorrectLabel;
	
	/**
	 * Textfield to enter / show the text of the title
	 */
	public JTextField titleField;
	
	/**
	 * Textarea to enter new questions
	 */
	public JTextArea questionArea;
	
	/**
	 * ArrayList, which is used to display the answer fields 
	 */
	public ArrayList<JTextField> answersFields;
	
	/**
	 * ArrayList, which is used to display the checkboxes in the answer section
	 */
	public ArrayList<JCheckBox> correctBoxes;
	
	/**
	 * Variable to define in which row of the GridBagLayout a component will be added
	 */
	private int row;
	
	/**
	 * Determines how many answer fields and checkboxes will be created
	 */
	private int answersCount = 4;
	
	/**
	 * Needed for the constructor
	 */
	private Question question;

	/**
	 * The constructor initializes the panel by passing the question to the
	 * superclass (QPanel), then initializes and adds the components
	 *
	 * @param question 
	 */
	public QuestionTabQuestionPanel(Question question) {
		super();
		this.question = question;
		
		initComponents();
		addComponents();
	}
		
	/**
	 * Initializes the components
	 */
	void initComponents() {
		themeLabel = new JLabel("Thema");
		themeLabelText = new JLabel();
		msgLabel = new JLabel();
		titleLabel = new JLabel("Titel");
		titleField = new JTextField();
		questionLabel = new JLabel("Frage");
		questionArea = new JTextArea(40,200);
		answerHeaderLabel = new JLabel("Antwortwahl");
		answerCorrectLabel = new JLabel("Richtig");
		
		answersFields = new ArrayList<JTextField>(answersCount);
		correctBoxes = new ArrayList<JCheckBox>(answersCount);
		
		for (int i = 0; i < answersCount; i++) {
			answersFields.add(new JTextField(18));
			correctBoxes.add(new JCheckBox());
		}
	}

	/*
	 * Adds the components to the panel
	 * The components can be labels, textfields, textareas or checkboxes for example
	 */
	private void addComponents() {
		row = 0;
		// Row 1. Theme (Label: "Theme", Label: "Leer", empty)
		addQuestionTheme();
		
		// Row 2. Title (Label: "Title", TextField, empty)
		addQuestionTitle();
		
		// Row 3-5. Question (Label: "Question", TextArea, empty)
		addQuestionArea();
		
		// Row 6. Possible Answers (Label: ..., Leer, Label: "Correct")
		addAnswerHeader();
		
		// Row 7-10. Answer 1-4
		addAnswerFields();
		
		// Row 11. Messages
		addMsgPanel();
	}


	/**
	 * Adds two theme labels, one as title and 
	 * one with the value of the current selected question
	 */
	private void addQuestionTheme() {
		gbc.anchor = GridBagConstraints.SOUTH;
		addComponent(themeLabel, row, 0);
		themeLabelText.setMinimumSize(new Dimension(200, 22));
		addComponent(themeLabelText, row, 1);
		addBoxOrEmpty(row, 1);
		row++;
	}


	/**
	 * Adds the question title label and text field
	 */
	private void addQuestionTitle() {
		addComponent(titleLabel, row, 0);
		gbc.gridwidth = 2;										// Title TextField 2 columns wide
		addComponent(titleField, row, 1);
		gbc.gridwidth = 1;										// Back to standard => 1 column wide
		row++;
	}


	/**
	 * Adds the question label and the scroll pane
	 */
	private void addQuestionArea() {
		gbc.gridheight = 3;										// Question Label and ScrollPane 3 columns high
		
		addComponent(questionLabel, row, 0);
		gbc.gridwidth = 2;										// Question ScrollPane 2 columns wide
		JScrollPane pane = new JScrollPane(questionArea);
		pane.setMinimumSize(new Dimension(200, 100));
		addComponent(pane, row, 1);
		gbc.gridwidth = 1;										// Back to standard => 1 column wide
		gbc.gridheight = 1;										// Back to standard => 1 column high
		row+=3;
	}


	/**
	 * Adds the answer header row
	 */
	private void addAnswerHeader() {
		addComponent(answerHeaderLabel, row, 0);
		addBoxOrEmpty(1, row);
		addComponent(answerCorrectLabel, row, 2);
		row++;
	}


	/**
	 * Adds the answer fields including check boxes
	 */
	private void addAnswerFields() {
		for(int i = 0; i < answersFields.size(); i++) {
			addComponent(new JLabel("Antwort " + (i + 1)), row, 0);
			addComponent(answersFields.get(i), row, 1);
			addComponent(correctBoxes.get(i), row, 2);
			row++;
		}
	}


	/**
	 * Adds the message panel
	 */
	private void addMsgPanel() {
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = 2;											// Message panel 2 columns wide
		msgLabel.setText("Hier Könnte ihre Werbung stehen!");
		addComponent(msgLabel, row, 0);
		row++;
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
