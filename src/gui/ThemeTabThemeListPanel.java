package gui;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import layout.QPanel;
import persistence.mariaDB.ThemeDAO;
import quizlogic.ThemeDTO;

/**
 * This class builds the view of the questionPanel Several components are
 * initialized, added and structured in GridBagyLayout
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
	 * 
	 */
	private DefaultListModel<String> model;

	/**
	 * Variable to define in which row of the GridBagLayout a component will be
	 * added
	 */
	private int row;
	
	JScrollPane scrollPane;

	public JList<String> themes;

	private ArrayList<ThemeDTO> dtoThemeList;

	private ArrayList<ThemeDTO> arrayThemeList;

	private ThemeDAO themeDAO;

	/**
	 * The constructor initializes and adds the components
	 */
	public ThemeTabThemeListPanel() {
		super();
		
		initComponents();
		addComponents();

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
	        addComponent(scrollPane, row, 0);
	        
	    }

	    gbc.gridwidth = 1;
	    row += gbc.gridheight;
	    gbc.gridheight = 1;
	}   
	
//	public void addThemeList() {
//		gbc.gridheight = 3; // Question Label and ScrollPane 3 columns high
//		gbc.gridwidth = 2; // Question ScrollPane 2 columns wide
//		ThemeDTO dto = new ThemeDTO();
//		
//		
//		if (dtoThemeList.size() > 0) {
//			for (int i = 0; i < dtoThemeList.size(); i++) {
//				dto = dtoThemeList.get(i);
//				String theme = dto.getTitle();
//				model.addElement(theme);
//			}
//		}
//		
//		themes = new JList<String>(model);
//		scrollPane = new JScrollPane(themes);
//		addComponent(scrollPane, row, 0);
//		
//		
//		gbc.gridwidth = 1; // Back to standard => 1 column wide
//		row += gbc.gridheight; // Adds rows used for the scroll pane to the variable -row-
//		gbc.gridheight = 1; // Back to standard => 1 column high
//	}
	
	public void refreshThemeList(ArrayList<ThemeDTO> updatedThemeList) {
	    model.clear();

	    if (updatedThemeList != null && !updatedThemeList.isEmpty()) {
	        for (ThemeDTO dto : updatedThemeList) {
	            model.addElement(dto.getTitle());
	        }
	        System.out.println("JList aktualisiert mit " + updatedThemeList.size() + " Einträgen");
	    }
	}   

	
	public DefaultListModel<String> getModel() {
		return model;
	}

}






























