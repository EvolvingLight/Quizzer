package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;

import layout.QPanel;
import quizlogic.FakeDataDeliverer;


public class QuestionMainPanel extends QPanel implements ButtonPanelDelegate {
	
	private QuestionPanel questionTabQuestionPanel;
	private QuestionListPanel questionTabQuestionListPanel;
	private QuestionTabButtonPanel questionTabButtonPanel;
		
	FakeDataDeliverer fdd = new FakeDataDeliverer();

	GridBagConstraints gbc = new GridBagConstraints();
	private QuestionPanel questionTabQuestionPanel2;
	private QPanel leftPanel;
	private QPanel rightPanel;
	private QPanel bottomPanel;
	
	

	public QuestionMainPanel() {
		super();
		setLayout();
		initPanels();
		setPanels();
		addPanels();
	}
	


	private void setLayout() {
		setLayout(new GridBagLayout());		
	}
	
	private void initPanels() {
		new QPanel();
		leftPanel = new QPanel();
		rightPanel = new QPanel();
		bottomPanel = new QPanel();
		
		questionTabQuestionPanel = new QuestionPanel(fdd.getRandomQuestion());
		questionTabQuestionListPanel = new QuestionListPanel(fdd.themes, fdd.questions);
		questionTabButtonPanel = new QuestionTabButtonPanel(this);
		questionTabQuestionPanel2 = new QuestionPanel(fdd.getRandomQuestion());
	}
	
	private void setPanels() {
		int row = 0;
		
		// ------ Row 0 ------ //
		// Panel one => questionTabquestionPanel
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		addComponent(leftPanel, row, 0);
		
		// Panel two => questionTabquestionListPanel
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.green));
		addComponent(rightPanel, row, 1);
		row++;
		
		// ------ Row 1 ------ //
		// Panel three => quesitonTabButtonPanel
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
		addComponent(bottomPanel, row, 0);
		// Reset to standard
		gbc.gridwidth = 1;
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
	}
	
	
	private void addPanels() {

		// Panel one => questionTabquestionPanel
		leftPanel.add(questionTabQuestionPanel);
		
		// Panel two => questionTabquestionListPanel
		rightPanel.add(questionTabQuestionListPanel);
		
		// Panel three => quesitonTabButtonPanel
		bottomPanel.add(questionTabButtonPanel);		
	}



	@Override
	public void firstBtnWasClicked() {
		System.out.println("first button clicked");
		
		// Test button function //
		System.out.println("right panel before:" + rightPanel.equals(questionTabQuestionListPanel));
		rightPanel.removeAll();
		

		rightPanel.add(questionTabQuestionPanel2);
		System.out.println("right panel after:" + rightPanel.equals(questionTabQuestionListPanel));
			
		revalidate();
		repaint();
		
		
	}



	@Override
	public void secondBtnWasClicked() {
		System.out.println("second button clicked");
		
	}



	@Override
	public void thirdBtnWasClicked() {
		System.out.println("third button clicked");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
