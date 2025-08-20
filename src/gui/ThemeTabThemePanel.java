package gui;

import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import layout.QPanel;

/**
 * This class builds the view of the themePanel Several components are
 * initialized and
 */
public class ThemeTabThemePanel extends QPanel {

	/**
	 * Label to display a header
	 */
	private JLabel themeHeaderLabel;
	
	/**
	 * Label to display the theme title
	 */
	private JLabel themeTitleLabel;
	
	/**
	 * Textfield to enter the theme title
	 */
	public JTextField themeTitleTextField;
	
	/**
	 * Label to display the information text header
	 */
	private JLabel themeInfoLabel;
	
	/**
	 * Textarea to wrap inside the scroll pane
	 */
	public TextArea themeTextArea;
	
	/**
	 * Variable to define the row of the grid bag layout
	 */
	private int row;
	
	/**
	 * Label to display a message if necessary
	 */
	public JLabel msgLabel;

	/**
	 * The constructor initializes and adds the components
	 */
	public ThemeTabThemePanel() {
		super();
		initComponents();
		addComponents();
	}

	/**
	 * Initializes the components
	 */
	private void initComponents() {
		themeHeaderLabel = new JLabel("Information zum Thema");
		themeTitleLabel = new JLabel("Titel");
		themeTitleTextField = new JTextField();
		themeInfoLabel = new JLabel("Information zum Thema");
		themeTextArea = new TextArea();
		msgLabel = new JLabel();
	}

	/*
	 * Adds the components to the panel
	 * The components can be labels, textfields, textareas or checkboxes for example
	 */
	private void addComponents() {
		row = 0;
		// Row 1: Header (label)
		addHeaderLabel();

		// Row 2: Title (label, textfield)
		addTitle();

		// Row 3: Theme information label (label)
		addThemeInfo();

		// Row 4-6: Theme textarea (textarea)
		addThemeText();

		// Row 7: Message label (label)
		addMsgLabel();

	}

	/**
	 * Adds a labels as header 
	 */
	private void addHeaderLabel() {
		addComponent(themeHeaderLabel, row, 0);
		row++;
	}

	/**
	 * Adds the title row ("Title", textfield) 
	 */
	private void addTitle() {
		addComponent(themeTitleLabel, row, 0);
		gbc.gridwidth = 2; // Theme textfield 2 columns wide
		addComponent(themeTitleTextField, row, 1);
//		refreshThemeTitle(); // Writes the title which is selected in the title list into the textfield
		gbc.gridwidth = 1; // Back to standard => 1 column wide
		addBoxOrEmpty(row, 1);
		row++;
	}

	/**
	 * Adds a label (Info) 
	 */
	private void addThemeInfo() {
		addComponent(themeInfoLabel, row, 0);
		row++;
	}

	/**
	 * Adds a scrollPane to enter the information 
	 */
	private void addThemeText() {
		gbc.gridheight = 3; // Theme ScrollPane 3 columns high
		gbc.gridwidth = 2; // Theme ScrollPane 2 columns wide
		JScrollPane pane = new JScrollPane(themeTextArea);
		pane.setMinimumSize(new Dimension(200, 100));
		addComponent(pane, row, 0);
		gbc.gridwidth = 1; // Back to standard => 1 column wide
		gbc.gridheight = 1; // Back to standard => 1 column high
		row += 3;

	}

	/**
	 * Adds the message panel
	 */
	private void addMsgLabel() {
		gbc.gridwidth = 2; // Message panel 2 columns wide
		msgLabel.setText("");
		addComponent(msgLabel, row, 0);
		row++;
	}

	public void refreshThemeTitle(String titleText) {
		themeTitleTextField.setText(titleText);
	}
	
	public void refreshThemeInfo(String themeInfo) {
		themeTextArea.setText(themeInfo);
	}
	
	public void clearInputFields() {
		themeTitleTextField.setText("");
		themeTextArea.setText("");
	}
	
}



















