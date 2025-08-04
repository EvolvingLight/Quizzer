package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import layout.QPanel;
import quizlogic.Question;
import quizlogic.Thema;

public class QuestionListPanel extends QPanel {

	// ------------- Fields ------------- //
	private JLabel subjectHeader;
	private JList<String> questionList;
	private JComboBox<String> box;
	private DefaultListModel<String> model;

	private ArrayList<Thema> themeDataList;
	private ArrayList<Question> questionDataList;



	// ------------- Start ------------- //
	public QuestionListPanel(ArrayList<Thema> themeDataList, ArrayList<Question> questionDataList) {
		super();
		this.themeDataList = themeDataList;
		this.questionDataList = questionDataList;
		
		
		init();
	}
	
	// ------------- Methods ------------- //
	private void init() {
		initComponents();
		addComponents();
		
	}

	private void initComponents() {
		subjectHeader = new JLabel();
		box = new JComboBox<String>();
		model = new DefaultListModel<>();
	
	}
		
	private void addComponents() {
		int row = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 1.0;
//		gbc.weighty = 0.0;
		gbc.insets = new Insets(15, 5, 15, 5);
		
		// Row 1. Header
		
		addComponent(subjectHeader, row, 0);
		subjectHeader.setText("Fragen zum Thema");
		row++;
		
		
		// Row 2. Subject-list in combo box

		for(int i = 0; i < themeDataList.size(); i++) {
			box.addItem(themeDataList.get(i).getTitle());
		}
		
		addComponent(box, row, 0);
		row++;
		
		
		// Row 3+ Questions in scroll pane
		
		gbc.weighty = 1.0;		
		for(int i = 0; i < questionDataList.size(); i++) {
			model.addElement(questionDataList.get(i).getTitle());
		}
		
		gbc.gridheight = 3;									// List height => X row high
		questionList = new JList<String>(model);
		
		JScrollPane scrollPane = new JScrollPane(questionList);
		int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
		scrollPane.setVerticalScrollBarPolicy(verticalPolicy);
//		scrollPane.setPreferredSize(new Dimension(0, super.getPreferredSize().height));

		
		addComponent(scrollPane, row, 0);	
		
		gbc.gridheight = 1;									// Back to standard => 1 row high
		
	}

	




	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
