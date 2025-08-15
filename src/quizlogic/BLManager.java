package quizlogic;

import persistence.mariaDB.DBManager;

public class BLManager {
	
	private DBManager beaver = new DBManager();
	
	/**
	 * Uses the title of the DTO Object of the MainPanel and saves it in a DAO
	 */
	public void saveTheme(ThemeDTO th) {
		
		
		th.setId(55);
		System.out.println("Method saveTheme called!");
		
	}
	
	public ThemeDTO loadTheme() {
		ThemeDTO dto = beaver.loadDTOFromDB(); 
		System.out.println("BL DTO title: " + dto.getTitle());
		return dto;
		
	}
	
}
