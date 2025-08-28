package gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import layout.QPanel;
import persistence.serialization.QuizDataManager;
import quizlogic.BLManager;
import quizlogic.QuestionDTO;
import quizlogic.ThemeDTO;

/**
 * Main panel for the question tab in the quiz application. This panel uses a
 * {@link GridBagLayout} to organize subcomponents into a structured layout: -
 * Left: Displays the current question ({@link QuestionTabQuestionPanel}) -
 * Right: Displays a list of questions or an alternate view - Bottom: Contains
 * action buttons via {@link QuestionTabButtonPanel}
 * 
 * The panel implements {@link ButtonPanelDelegate} to respond to button clicks,
 * dynamically switching content in the right panel
 */
public class QuestionTabMainPanel extends QPanel implements ButtonPanelDelegate, QuestionTabDelegate {

	/**
	 * General serial version UID for serialization compatibility
	 */
	protected static final long serialVersionUID = 1L;

	/**
	 * Part of the view from the question tab
	 */
	private QuestionTabQuestionPanel questionTabQuestionPanel;

	/**
	 * Part of the view from the question tab
	 */
	private QuestionTabListPanel questionTabQuestionListPanel;

	/**
	 * Part of the view from the question tab
	 */
	private QuestionTabButtonPanel questionTabButtonPanel;

	/**
	 * New Instance of QuizDataManager to manage the functionalities of this class
	 */
	public QuizDataManager fdd = new QuizDataManager();

	/**
	 * New instance of the managers to organize the data handling
	 */
	private BLManager mngBL = new BLManager();

	/**
	 * Container for the panel to be added to the left side of the view In this case
	 * the questionPanel
	 */
	private QPanel leftPanel;

	/**
	 * Container for the panel to be added to the right side of the view In this
	 * case the questionListPanel
	 */
	private QPanel rightPanel;

	/**
	 * Container for the panel to be added to the bottom of the view In this case
	 * the buttonPanel
	 */
	private QPanel bottomPanel;

	/**
	 * State tracking of the right panel to manage the button action
	 */
	private boolean defaultView = true;
	
	ArrayList<ThemeDTO> themeList;
	
	ArrayList<QuestionDTO> questionList;

	/**
	 * Constructs a new QuestionMainPanel. Initializes the layout, creates all
	 * required sub-panels, configures their placement, and adds them to the
	 * container. The panel is ready for display upon construction.
	 */
	public QuestionTabMainPanel() {
		super();
		setLayout();
		initPanels();
		setPanels();
		addPanels();
	}

	/**
	 * Sets the layout manager for this panel to {@link GridBagLayout}. This layout
	 * allows flexible and precise positioning of components in a grid. Constraints
	 * are managed via the {@code gbc} instance field.
	 */
	private void setLayout() {
		setLayout(new GridBagLayout());
	}

	/**
	 * Initializes all sub-panels and content components. Creates: - Three
	 * placeholder panels (left, right, bottom) - Two question display panels - A
	 * button panel with this panel as delegate
	 */
	private void initPanels() {
		leftPanel = new QPanel();
		rightPanel = new QPanel();
		bottomPanel = new QPanel();

		questionTabQuestionPanel = new QuestionTabQuestionPanel(fdd.getRandomQuestion());
		themeList = loadAllThemes();
		questionTabQuestionListPanel = new QuestionTabListPanel(themeList);
		questionTabButtonPanel = new QuestionTabButtonPanel(this);
	}

	/**
	 * Configures the position and constraints of each sub-panel within the
	 * {@link GridBagLayout}. Places: - {@code leftPanel} and {@code rightPanel} in
	 * row 0 (side by side) - {@code bottomPanel} in row 1, spanning the full width
	 * Constraints are reset after placing the bottom panel to avoid unintended
	 * effects.
	 */
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
		gbc.gridwidth = 2;
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
		addComponent(bottomPanel, row, 0);

		// Reset to standard
		gbc.gridwidth = 1;

	}

	/**
	 * Adds the content components to their respective container panels. - Adds
	 * {@code questionTabQuestionPanel} to the left panel - Adds
	 * {@code questionTabQuestionListPanel} to the right panel - Adds
	 * {@code questionTabButtonPanel} to the bottom panel These components are
	 * displayed immediately when the panel is rendered. The right panel may be
	 * dynamically updated later (e.g., during button interactions).
	 */
	private void addPanels() {
		// Panel one => questionTabquestionPanel
		leftPanel.add(questionTabQuestionPanel);

		// Panel two => questionTabquestionListPanel
		rightPanel.add(questionTabQuestionListPanel);
		loadAllThemes();

		// Panel three => quesitonTabButtonPanel
		bottomPanel.add(questionTabButtonPanel);
	}

	/**
	 * Handles the event when the first button is clicked. The first button is used
	 * to delete a question
	 */
	@Override
	public void firstBtnWasClicked() {
		System.out.println("first button clicked");
		questionTabQuestionListPanel.refreshQuestionList(themeList);
	}

	/**
	 * Handles the event when the second button is clicked. The second button is
	 * used to save a question
	 * 
	 */
	@Override
	public void secondBtnWasClicked() {
		System.out.println("second button clicked");

	}

	/**
	 * Handles the event when the third button is clicked. The third button is used
	 * to clear the input fields
	 */
	@Override
	public void thirdBtnWasClicked() {
		System.out.println("third button clicked");

	}

	public ArrayList<ThemeDTO> loadAllThemes() {
		ArrayList<ThemeDTO> themeList = mngBL.loadThemeDTOList();
		return themeList;
	}
	
//	public ArrayList<QuestionDTO> loadQuestionToScrollpane() {
//		questionList = mngBL.loadQuestionList();
//		
//		return questionList;
//	}
	
	
}































