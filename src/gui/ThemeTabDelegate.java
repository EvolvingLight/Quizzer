package gui;

import quizlogic.ThemeDTO;

public interface ThemeTabDelegate {

	/**
	 * Übergabe des selektierten Objektes (selected Item) 
	 * vom Panel mit der JList zu dem Panel, 
	 * auf dem alles weitere mit dem selektierten Objekt gemacht wird
	 * @param selectedTheme
	 */
	public void refreshThemePanel(ThemeDTO selectedTheme);
	
	/**
	 * Transfer between ThemeListPanel and ThemePanel
	 */
	public void clearMsgLabel();
}
