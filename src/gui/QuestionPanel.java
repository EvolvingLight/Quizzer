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
import quizlogic.Answer;
import quizlogic.FakeDataDeliverer;
import quizlogic.Question;

public class QuestionPanel extends QPanel {

	// ------------- Fields ------------- //
	
	public JLabel themeLabelText;
	public JLabel msgLabel;
	public JTextField titleField;
	public JTextArea questionArea;
	public FakeDataDeliverer fdd;
	
	public ArrayList<JTextField> answersFields;
	public ArrayList<JCheckBox> correctBoxes;

	int answersCount = 4;
	private Question question;
	
	

	// ------------- Start ------------- //
	public QuestionPanel(Question question) {
		super();
		this.question = question;
		
		init();
	}
	

	// ------------- Methods ------------- //
	private void init() {
		initComponents();
		addComponents();
		fillWithData();
	}

	private void fillWithData() {
		if (question != null) {
			themeLabelText.setText(question.getThema().getTitle());
			titleField.setText(question.getTitle());
			questionArea.setText(question.getText());

			ArrayList<Answer> answers = question.getAnswers();
			Answer a;
			for (int i = 0; i < answers.size(); i++) {
				a = answers.get(i);
				answersFields.get(i).setText(a.getText());
				correctBoxes.get(i).setSelected(a.isCorrect());
			}
		}
	}

	void initComponents() {
		themeLabelText = new JLabel();
		msgLabel = new JLabel();
		titleField = new JTextField();
		questionArea = new JTextArea(40,200);
		
		answersFields = new ArrayList<JTextField>(answersCount);
		correctBoxes = new ArrayList<JCheckBox>(answersCount);
		
		for (int i = 0; i < answersCount; i++) {
			answersFields.add(new JTextField(18));
			correctBoxes.add(new JCheckBox());
		}
	}

	
	private void addComponents() {
		int row = 1;
		// Row 1. Theme (Label: "Theme", Label: "Leer", empty)
		gbc.anchor = GridBagConstraints.SOUTH;
		addComponent(new JLabel("Thema"), row, 0);
		themeLabelText.setMinimumSize(new Dimension(200, 22));
		addComponent(themeLabelText, row, 1);
		addBoxOrEmpty(row, 1);
		row++;
		
		// Row 2. Title (Label: "Title", TextField, empty)
		addComponent(new JLabel("Titel"), row, 0);
		gbc.gridwidth = 2;										// Title TextField 2 columns wide
		addComponent(titleField, row, 1);
		gbc.gridwidth = 1;										// Back to standard => 1 column wide
		row++;
		
		// Row 3-5. Question (Label: "Question", TextArea, empty)
		gbc.gridheight = 3;										// Question Label and ScrollPane 3 columns high
		
		addComponent(new JLabel("Frage"), row, 0);
		gbc.gridwidth = 2;										// Question ScrollPane 2 columns wide
		JScrollPane pane = new JScrollPane(questionArea);
		pane.setMinimumSize(new Dimension(200, 100));
		addComponent(pane, row, 1);
		gbc.gridwidth = 1;										// Back to standard => 1 column wide
		gbc.gridheight = 1;										// Back to standard => 1 column high
		row+=3;
		
		// Row 6. Possible Answers (Label: ..., Leer, Label: "Correct")
		addComponent(new JLabel("Antwortwahl"), row, 0);
		addBoxOrEmpty(1, row);
		addComponent(new JLabel("Richtig"), row, 2);
		row++;
		
		// Row 7-10. Answer 1-4
		for(int i = 0; i < answersFields.size(); i++) {
			addComponent(new JLabel("Antwort " + (i + 1)), row, 0);
			addComponent(answersFields.get(i), row, 1);
			addComponent(correctBoxes.get(i), row, 2);
			row++;
		}
		
		// Row 11. Messages
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = 2;										// Message panel 2 columns wide
		msgLabel.setText("Hier Könnte ihre Werbung stehen!");
		addComponent(msgLabel, row, 0);
		row++;
			
		
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
