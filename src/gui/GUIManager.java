package gui;

import java.util.ArrayList;

import quizlogic.BLManager;
import quizlogic.ThemeDTO;

public class GUIManager {

	private ThemeTabThemeListPanel themeListPanel;
	
	private BLManager mngBL = new BLManager();

	// Setter-Methode
	public void setThemeListPanel(ThemeTabThemeListPanel themeListPanel) {
		this.themeListPanel = themeListPanel;
	}

	// Getter-Methode
	public ThemeTabThemeListPanel getThemeListPanel() {
		return themeListPanel;
	}
	
	public void refreshThemeList(ArrayList<ThemeDTO> updatedThemeList) {
	    ArrayList<ThemeDTO> themes = mngBL.loadThemeList();

	    themeListPanel.refreshThemeList(themes);
	} 
	
}



























