package persistence.mariaDB;

public class ThemeDAO {
	public static final String SQL_INSERT_THEME = "insert into themes (themeTitle, themeText values (?, ?)";
	public static final String SQL_UPDATE_THEME = "update themes set themeTitle = ?, themeText = ? where id = ?)";
	
	
}
