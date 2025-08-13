package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import layout.QPanel;
import quizlogic.serialization.Question;
import quizlogic.serialization.Thema;

/**
 * A panel that displays a list of questions grouped by theme. This component
 * allows users to: - Select a theme from a dropdown ({@link JComboBox}) - View
 * a scrollable list of question titles ({@link JList}) - Receive selection
 * events when a question is chosen Data is populated from external lists of
 * {@link Theme} and {@link Question} objects. The panel uses
 * {@link GridBagLayout} for flexible UI arrangement.
 */
public class QuestionTabListPanel extends QPanel {

	private JLabel themeHeader;
	private JList<String> questionList;
	private JComboBox<String> box;
	private DefaultListModel<String> model;

	private ArrayList<Thema> themeDataList;
	private ArrayList<Question> questionDataList;
	private int row;
	
	private JButton showThemeBtn;

	/**
	 * Constructs a new QuestionListPanel with the given theme and question data.
	 * Initializes all UI components and populates them with data: - Fills the theme
	 * combo box with theme titles - Fills the question list with question titles
	 *
	 * @param themeDataList    the list of available themes; must not be {@code null}
	 * @param questionDataList the list of questions to display; may be {@code null}
	 */
	public QuestionTabListPanel(ArrayList<Thema> themeDataList, ArrayList<Question> questionDataList) {
		super();
		this.themeDataList = themeDataList;
		this.questionDataList = questionDataList;

		init();
	}

	/**
	 * Initializes and adds all components to the panel
	 */
	private void init() {
		initComponents();
		addComponents();
	}

	/**
	 * Initializes the UI components used in this panel.
     * Creates:
     * - A label for the header
     * - A combo box for theme selection
     * - A list model for dynamic question list updates
	 */
	private void initComponents() {
		themeHeader = new JLabel();
		box = new JComboBox<String>();
		model = new DefaultListModel<>();
		showThemeBtn = new JButton();
	}

	/**
	 * Adds all initialized components to the panel using {@link GridBagLayout}.
     * Arranged in three rows:
     * 1. Header label
     * 2. Theme selection combo box
     * 3. Scrollable question list
	 */
	private void addComponents() {
		row = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
//		gbc.weighty = 0.0;
		gbc.insets = new Insets(15, 5, 15, 5);

		// Row 1. Header (label, button)
		addHeader();

		// Row 2. Theme-list (combo box)
		addComboBox();

		// Row 3+ Questions (scroll pane)
		addScrollPane();
	}

	/**
	 * Adds header text in the specified row
	 */
	private void addHeader() {
		themeHeader.setText("Fragen zum Thema");
		addComponent(themeHeader, row, 0);
		
		showThemeBtn.setText("Thema anzeigen");
		addComponent(showThemeBtn, row, 1);
		showThemeBtn.setVisible(false);							// Button not visible, as long as no entry is selected
		row++;
	}

	/**
	 * Fill the theme combobox with theme titles and adds it to the panel
	 */
	private void addComboBox() {
		for (int i = 0; i < themeDataList.size(); i++) {
			box.addItem(themeDataList.get(i).getTitle());
		}
		addComponent(box, row, 0);
		row++;
	}

	/**
	 * Creates and adds a scrollable list of questions.
     * Populates the list with question titles from {@code questionDataList}.
     * Registers a {@link ListSelectionListener} to detect user selections.
	 */
	private void addScrollPane() {
		/**
		 * Fill the data list
		 */
		gbc.weighty = 1.0;
		if (questionDataList != null) {
			for (int i = 0; i < questionDataList.size(); i++) {
				Question qd = questionDataList.get(i);
				if (qd != null && qd.getTitle() != null) {
					model.addElement(qd.getTitle());
				}
			}
		}

		/**
		 * Action listener to check which entry is selected
		 * TODO: Check for function when data is available
		 */
		gbc.gridheight = 3; // List height => X row high
		questionList = new JList<String>(model);

		questionList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedIndex = questionList.getSelectedIndex();
					System.out.println(selectedIndex);
					// fdd.q = question[selectedIndex];
					String test = questionList.getName();
					System.out.println(test);
					
					showThemeBtn.setVisible(true);				// Button visible as an entry is selected
				}

			}
		});

		/**
		 * Add scroll pane with the list
		 */
		JScrollPane scrollPane = new JScrollPane(questionList);
		// ListSelectionModel = questionList.getSelectionMode();

		int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
		scrollPane.setVerticalScrollBarPolicy(verticalPolicy);

		addComponent(scrollPane, row, 0);

		gbc.gridheight = 1; 									// Back to standard => 1 row high
	}

}
