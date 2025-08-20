package quizlogic;

import persistence.mariaDB.DBManager;

	
/**
 * This class is used for testing purpose
 * A method is created to generate fake data for testing
 */
public class FakeDataManager {
	private DBManager beaver = new DBManager();
	
	/**
	 * Creates fake data and saves it into the database
	 */
	public void createData() {
		System.out.println("fdm triggered");
		ThemeDTO dto = new ThemeDTO();
		dto.setTitle("Thema def" );
		dto.setText("BlaBlaBla");
//		dto.setId(3);
		
		beaver.saveThemeIntoDB(dto);
	}
}




























