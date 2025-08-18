package quizlogic;

import java.util.ArrayList;

import persistence.mariaDB.DBManager;

public class BLManager {
	
	private DBManager beaver = new DBManager();
	
	
	
	/**
	 * Uses the title of the DTO Object of the MainPanel and saves it in a DAO
	 */
	public void saveTheme(ThemeDTO th) {
		th.setId(55);
		
	}
	
	/**
	 * 
	 * @return the updated theme list
	 */
	public ArrayList<ThemeDTO> loadThemeList() {
		ArrayList<ThemeDTO> updatedList = beaver.loadAllThemesFromDB();
		return updatedList;
	}
	
	


	
	
}











