package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
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
import quizlogic.QuestionDTO;
import quizlogic.ThemeDTO;
import quizlogic.serialization.Question;
import quizlogic.serialization.Theme;

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
	private JComboBox<ThemeDTO> box;
	private JScrollPane scrollPane;
	private JButton showThemeBtn;
	private int row;

	private DefaultListModel<QuestionDTO> questionModel;
	private DefaultListModel<ThemeDTO> themeModel;

//	private ArrayList<QuestionDTO> questionList;
	private ArrayList<ThemeDTO> themeList;
	private JList<QuestionDTO> questions;

	QuestionTabDelegate delegate;
//	private ArrayList<QuestionDTO> questionList;
	private JList<ThemeDTO> jListThemeList;

	/**
	 * Constructs a new QuestionListPanel with the given theme and question data.
	 * Initializes all UI components and populates them with data: - Fills the theme
	 * combo box with theme titles - Fills the question list with question titles
	 * 
	 * @param arrayList
	 *
	 * @param themeList    the list of available themes; must not be {@code null}
	 * @param questionList the list of questions to display; may be {@code null}
	 */
	public QuestionTabListPanel(ArrayList<ThemeDTO> themeList) {
		super();
		this.themeList = themeList;
//		this.questionList = questionList;
		init();
	}

	/**
	 * Initializes and adds all components to the panel
	 */
	private void init() {
		initComponents();
		addComponents();
		setupQuestionListListener();
		setupThemeListListener();
	}

	/**
	 * Initializes the UI components used in this panel. Creates: - A label for the
	 * header - A combo box for theme selection - A list model for dynamic question
	 * list updates
	 */
	private void initComponents() {
		themeHeader = new JLabel();
		box = new JComboBox<ThemeDTO>();
		showThemeBtn = new JButton();
		questionModel = new DefaultListModel<>();
		themeModel = new DefaultListModel<>();
	}

	/**
	 * Adds all initialized components to the panel using {@link GridBagLayout}.
	 * Arranged in three rows: 1. Header label 2. Theme selection combo box 3.
	 * Scrollable question list
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
		addQuestionList();
	}

	/**
	 * Adds header text in the specified row
	 */
	private void addHeader() {
		themeHeader.setText("Fragen zum Thema");
		addComponent(themeHeader, row, 0);

		showThemeBtn.setText("Thema anzeigen");
		addComponent(showThemeBtn, row, 1);
		showThemeBtn.setVisible(false); // Button not visible, as long as no entry is selected
		row++;
	}

	/**
	 * Fill the theme combobox with theme titles and adds it to the panel
	 */
	private void addComboBox() {
		for (int i = 0; i < themeList.size(); i++) {
			box.addItem(themeList.get(i));
		}

		addComponent(box, row, 0);
		row++;
	}

	/**
	 * Creates and adds a scroll pane
	 * 
	 */
	private void addQuestionList() {
		gbc.weighty = 1.0;
		gbc.gridheight = 3; // List height => X row high

		if (questions == null) {
			questions = new JList<>(questionModel);
			scrollPane = new JScrollPane(questions);
			int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
			scrollPane.setVerticalScrollBarPolicy(verticalPolicy);

			addComponent(scrollPane, row, 0);
			refreshQuestionList(themeList);

		}

		row += gbc.gridheight;
		gbc.gridheight = 1; // Back to standard => 1 row high
	}

	/**
	 * 
	 */
	public void setupThemeListListener() {
		box.addActionListener(e -> themeSelected(e));
	}

	private void themeSelected(ActionEvent e) {
		ThemeDTO theme = (ThemeDTO) box.getSelectedItem();
		ArrayList<ThemeDTO> updatedThemeList = new ArrayList<ThemeDTO>(1);
		updatedThemeList.add(theme);
		refreshQuestionList(updatedThemeList);
	}

	public void setupQuestionListListener() {
		questions.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					QuestionDTO selectedQuestion = questions.getSelectedValue();
//					System.out.println(selectedQuestion);
					if (selectedQuestion != null) {
//						System.out.println(selectedQuestion.getInfo());
					}
//					delegate.refreshQuestionPanel(selectedQuestion);
//					showThemeBtn.setVisible(true); // Button visible as an entry is selected
				}

			}
		});
	}

	/**
	 * Clears the model (question list) then adds the question of the DTO elements
	 * of the updated question list to the model.
	 * 
	 * @param updatedQuestionList
	 */
	public void refreshQuestionList(ArrayList<ThemeDTO> updatedThemeList) {
		questionModel.clear();

		for (ThemeDTO theme : updatedThemeList) {
			ArrayList<QuestionDTO> updatedQuestionList = new ArrayList<QuestionDTO>();
			updatedQuestionList.add(theme.getQuestionDTO());

			for (QuestionDTO question : updatedQuestionList) {
				if (theme.getId() == question.getThemeID()) {
					questionModel.addElement(question);
//					System.out.println("Theme id: " + theme.getId());
//					System.out.println("Question theme id: " + question.getThemeID());
//					System.out.println("Question: " + question);
//					System.out.println("Question List refreshed!");
				}
			}
		}
	}

	/**
	 * Getter for the question model
	 * 
	 * @return default list model
	 */
	public DefaultListModel<QuestionDTO> getQuestionModel() {
		return questionModel;
	}

	/**
	 * Getter for the theme model
	 * 
	 * @return default list model
	 */
	public DefaultListModel<ThemeDTO> getThemeModel() {
		return themeModel;
	}

}
