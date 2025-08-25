package gui;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import layout.QPanel;
import quizlogic.ThemeDTO;

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
	 * Array list holding the theme titles
	 */
	public ArrayList<String> themeList;
	
	/**
	 * Default list model to display and refresh the theme list
	 */
	private DefaultListModel<ThemeDTO> model;

	/**
	 * Variable to define in which row of the GridBagLayout 
	 * a component will be added
	 */
	private int row;
	
	/**
	 * A scroll pane to show the theme list
	 */
	JScrollPane scrollPane;

	/**
	 * A list containing the themes to display in the scroll pane
	 */
	public JList<ThemeDTO> themes;

	/**
	 * Theme ID used to refresh GUI
	 */
	public int themeID;
	
	/**
	 * Delegate between theme panels
	 */
	ThemeTabDelegate delegate;

	/**
	 * The constructor initializes and adds the components
	 */
	public ThemeTabThemeListPanel() {
		super();
		
		initComponents();
		addComponents();
		setupListSelectionListener();
	}

	/**
	 * Initializes the components
	 */
	void initComponents() {
		themeLabelHeader = new JLabel("Themen");
		msgLabel = new JLabel();
		titleField = new JTextField();
		model = new DefaultListModel<>();
	}

	/*
	 * Adds the components to the panel The components can be labels, textfields,
	 * textareas or checkboxes for example
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
	 * Adds the theme list and the scroll pane
	 * Themes will be added using the refreshThemeList method
	 */
	public void addThemeList() {
	    gbc.gridheight = 3;
	    gbc.gridwidth = 2;
	    
	    if (themes == null) { 
	        themes = new JList<>(model);
	        scrollPane = new JScrollPane(themes);
	        int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
			scrollPane.setVerticalScrollBarPolicy(verticalPolicy);
			addComponent(scrollPane, row, 0);
	    }

	    gbc.gridwidth = 1;
	    row += gbc.gridheight;
	    gbc.gridheight = 1;
	}   
	
	public void setupListSelectionListener() {
	    themes.addListSelectionListener(new ListSelectionListener() {


			@Override
	        public void valueChanged(ListSelectionEvent e) {
				delegate.clearMsgLabel();
	            if (!e.getValueIsAdjusting()) {
	                ThemeDTO selectedTheme = themes.getSelectedValue();
	                if (selectedTheme != null) {
	                    System.out.println("Selected Theme ID: " + selectedTheme.getId());
	                    System.out.println("Selected Theme Title: " + selectedTheme.getTitle());
	                    delegate.refreshThemePanel(selectedTheme);
	                }
	            }
	        }
	    });
	}
	
	/**
	 * Clears the model (theme list) then adds the title of the 
	 * DTO elements of the updated theme list to the model. 
	 * @param updatedThemeList
	 */
	public void refreshThemeList(ArrayList<ThemeDTO> updatedThemeList) {
	    model.clear();	   
	    
	   for (ThemeDTO theme : updatedThemeList) {
		   model.addElement(theme);
	   }

	}

	
	/**
	 * Getter for the model
	 * @return default list model
	 */
	public DefaultListModel<ThemeDTO> getModel() {
		return model;
	}

}






























