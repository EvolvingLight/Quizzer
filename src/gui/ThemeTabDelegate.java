package gui;

import java.util.ArrayList;

import quizlogic.ThemeDTO;

public interface ThemeTabDelegate {

	/**
	 * Transfer of the selected object (selected Item) 
	 * from list panel to theme panel, where the selected item 
	 * is used for other functions
	 * @param selectedTheme
	 */
	public void refreshThemePanel(ThemeDTO selectedTheme);
	
	/**
	 * Transfer between ThemeListPanel and ThemePanel
	 */
	public void clearMsgLabel();
	
	/**
	 * Method which returns an array list with the themeDTO class
	 * @return 
	 */
	public ArrayList<ThemeDTO> loadThemeDTOFromDB();
}
