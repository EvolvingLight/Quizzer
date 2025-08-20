package persistence.mariaDB;

public class ThemeDAO {
	public static final String SQL_INSERT_THEME = "insert into themes (themeTitle, themeText) values (?, ?)";
	public static final String SQL_UPDATE_THEME = "update themes set themeTitle = ?, themeText = ? where id = ?";
	public static final String SQL_GET_ID = "select id from themes where id = ?";
	public static final String SQL_SELECT_ALL = "select * from themes";
	public static final String SQL_SELECT_THEMES = "select themeTitle from themes";
	public static final String SQL_DELETE_THEME = "delete from themes where id = ?";
	
	
	
}
