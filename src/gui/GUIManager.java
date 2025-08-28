package gui;

import quizlogic.ThemeDTO;

/**
 * This class is used to handle the display of data changes For example the
 * refresh of changing data
 */
public class GUIManager {

	private ThemeTabThemeListPanel themeListPanel;
	private ThemeTabThemePanel themePanel;

	// ------ Theme Tab Theme Panel ------ //
	/**
	 * Returns the selected theme inside the theme list
	 * @return selected theme
	 */
	public ThemeDTO getSelectedTheme() {
		ThemeDTO selectedTheme = themeListPanel.themes.getSelectedValue();
//		System.out.println("getSelectedThemeTitle() => " + selectedTheme.getTitle());
		return selectedTheme;
	}

	/**
	 * Refreshes the theme title and theme text inside the theme panel
	 * @param selectedTheme
	 */
	public void refreshThemePanel(ThemeDTO selectedTheme) {
		
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
