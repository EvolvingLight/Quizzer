package gui;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;

import layout.QPanel;
import persistence.mariaDB.DBManager;
import persistence.serialization.QuizDataManager;
import quizlogic.BLManager;
import quizlogic.FakeDataManager;
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
public class ThemeTabMainPanel extends QPanel implements ButtonPanelDelegate {

	/**
	 * General serial version UID for serialization compatibility
	 */
	protected static final long serialVersionUID = 1L;

	/**
	 * Part of the view from the theme tab
	 */
	private ThemeTabThemePanel themeTabThemePanel;

	/**
	 * Part of the view from the theme tab
	 */
	private ThemeTabThemeListPanel themeTabThemeListPanel;

	/**
	 * Part of the view from the theme tab
	 */
	private ThemeTabButtonPanel themeTabButtonPanel;

	/**
	 * Container for the panel to be added to the left side of the view
	 */
	private QPanel leftPanel;

	/**
	 * Container for the panel to be added to the right side of the view
	 */
	private QPanel rightPanel;

	/**
	 * Container for the panel to be added to the bottom of the view
	 */
	private QPanel bottomPanel;

	/**
	 * New Instance of QuizDataManager to manage the functionalities of this class
	 */
	QuizDataManager fdd = new QuizDataManager();

	/**
	 * New instance of the business logic manager to manage data transfer to the
	 * business logic
	 */
	private BLManager mngBL = new BLManager();

	private DBManager mngDB = new DBManager();

	/**
	 * Constructs a new ThemeMainPanel. Initializes the layout, creates all required
	 * sub-panels, configures their placement, and adds them to the container. The
	 * panel is ready for display upon construction.
	 */
	public ThemeTabMainPanel() {
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
	 * placeholder panels (left, right, bottom) - Two theme display panels - A
	 * button panel with this panel as delegate
	 */
	private void initPanels() {
		leftPanel = new QPanel();
		rightPanel = new QPanel();
		bottomPanel = new QPanel();

		themeTabThemePanel = new ThemeTabThemePanel();
		themeTabThemeListPanel = new ThemeTabThemeListPanel(mngBL.loadTheme());
		themeTabButtonPanel = new ThemeTabButtonPanel(this);
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
		// Panel one => ThemeTabThemePanel
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		addComponent(leftPanel, row, 0);

		// Panel two => themeTabThemeListPanel
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.green));
		addComponent(rightPanel, row, 1);
		row++;

		// ------ Row 1 ------ //
		// Panel three => themeTabButtonPanel
		gbc.gridwidth = 2;
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
		addComponent(bottomPanel, row, 0);
		gbc.gridwidth = 1; // Back to standard
	}

	/**
	 * Adds the content components to their respective container panels. - Adds
	 * {@code themeTabThemePanel} to the left panel - Adds
	 * {@code themeTabThemeListPanel} to the right panel - Adds
	 * {@code themeTabButtonPanel} to the bottom panel These components are
	 * displayed immediately when the panel is rendered. The right panel may be
	 * dynamically updated later (e.g., during button interactions).
	 */
	private void addPanels() {
		// Panel one => questionTabquestionPanel
		leftPanel.add(themeTabThemePanel);

		// Panel two => questionTabquestionListPanel
		rightPanel.add(themeTabThemeListPanel);

		// Panel three => quesitonTabButtonPanel
		bottomPanel.add(themeTabButtonPanel);
	}

	/**
	 * Handles the event when the first button is clicked. Currently used for
	 * debugging purposes only — prints a message to the console. TODO: Update to
	 * perform a specific action (e.g., edit question, navigate, etc.).
	 */
	@Override
	public void firstBtnWasClicked() {
		System.out.println("first button clicked");

	}

	/**
	 * Handles the event when the second button is clicked. Currently used for
	 * debugging purposes only — prints a message to the console. TODO: Update to
	 * perform a specific action (e.g., edit question, navigate, etc.).
	 * 
	 */
	@Override
	public void secondBtnWasClicked() {
		// System.out.println("second button clicked");
		// transferToBL();
		transferToDB();
	}

	/**
	 * Handles the event when the third button is clicked. Currently used for
	 * debugging purposes only — prints a message to the console. TODO: Update to
	 * perform a specific action (e.g., edit question, navigate, etc.).
	 */
	@Override
	public void thirdBtnWasClicked() {
		System.out.println("third button clicked");
		transferFromDB();
	}

	private void transferToDB() {
		FakeDataManager fdm = new FakeDataManager();
		fdm.createData();
	}

	/**
	 * Reads input fields and instantiates a DTO object containing the input data
	 */
	public void transferToBL() {
		ThemeDTO dto = new ThemeDTO();

		dto.setTitle(themeTabThemePanel.themeTitleTextField.getText());
		dto.setText(themeTabThemePanel.themeTextArea.getText());
		System.out.println("Vorher: " + dto.getInfo());
		mngBL.saveTheme(dto);
		System.out.println(dto.getInfo());

	}
	
	/**
	 * 
	 */
	public void transferFromDB() {
		mngBL.loadTheme();
	}

}
