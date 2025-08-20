package quizlogic;

import java.util.ArrayList;

import persistence.mariaDB.DBManager;

/**
 * This class manages the data transfer between the layers
 * DTO's are creates at the GUI layer 
 * DAO's are created at the persistence layer
 * Here we handle the data transfer between all three layers
 */
public class BLManager {
	
	private DBManager beaver = new DBManager();
	
	/**
	 * Receives a DTO Object from the MainPanel and saves it in the database (DAO)
	 */
	public void saveTheme(ThemeDTO th) {		
		beaver.saveThemeIntoDB(th);
	}
	
	/**
	 * Loads the theme DTO's from the database using the DB manager
	 * @return the updated DTO list
	 */
	public ArrayList<ThemeDTO> loadThemeList() {
		ArrayList<ThemeDTO> updatedList = beaver.loadAllThemesFromDB();
		return updatedList;
	}
	
	public void deleteTheme(ThemeDTO th) {
		beaver.deleteTheme(th);
	}
	
}











