package quizlogic;

import persistence.mariaDB.DBManager;

	
public class FakeDataManager {
	private DBManager mngDB = new DBManager();
	
	public void createData() {
		System.out.println("fdm triggered");
		ThemeDTO dto = new ThemeDTO();
		dto.setTitle("Thema xyz" );
		dto.setText("BlaBlaBla");
		
		mngDB.saveThemeIntoDB(dto);
	}
}




























