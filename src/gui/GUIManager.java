package gui;

import java.util.ArrayList;

import quizlogic.BLManager;
import quizlogic.ThemeDTO;

/**
 * This class is used to handle the display of data changes For example the
 * refresh of changing data
 */
public class GUIManager {

	private ThemeTabThemeListPanel themeListPanel;
	private ThemeTabThemePanel themePanel;

	private BLManager mngBL = new BLManager();

	// ------ Theme Tab Theme List Panel ------ //
	/**
	 * Uses the method inside the ThemeTabThemeListPanel to refresh the theme list
	 * 
	 * @param updatedThemeList
	 */
	public void refreshThemeList(ArrayList<ThemeDTO> updatedThemeList) {
		ArrayList<ThemeDTO> themes = mngBL.loadThemeList();

		themeListPanel.refreshThemeList(themes);
	}

	// ------ Theme Tab Theme Panel ------ //
	public String getSelectedThemeTitle() {
		ThemeDTO selectedTheme = themeListPanel.themes.getSelectedValue();
//		System.out.println("getSelectedThemeTitle() => " + selectedTheme.getTitle());
		return selectedTheme.getTitle();
	}
	
	public Integer getSelectedThemeID() {
		ThemeDTO selectedTheme = themeListPanel.themes.getSelectedValue();
//		System.out.println("getSelectedThemeTitle() => " + selectedTheme.getTitle());
		return selectedTheme.getId();
	}

	public void refreshThemePanel() {
		ThemeDTO selectedTheme = themeListPanel.themes.getSelectedValue();
		
		if (selectedTheme != null) {
			themePanel.refreshThemeTitle(selectedTheme.getTitle());
			themePanel.refreshThemeInfo(selectedTheme.getText());
		}

	}

	

	// Setter-Methode
	public void setThemeListPanel(ThemeTabThemeListPanel themeListPanel) {
		this.themeListPanel = themeListPanel;
	}

	public void setThemePanel(ThemeTabThemePanel themePanel) {
		this.themePanel = themePanel;
	}

	// Getter-Methode
	public ThemeTabThemeListPanel getThemeListPanel() {
		return themeListPanel;
	}

	public ThemeTabThemePanel getThemePanel() {
		return themePanel;
	}

}
