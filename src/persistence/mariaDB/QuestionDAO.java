package persistence.mariaDB;

public class QuestionDAO {

	public static final String SQL_SELECT_ALL = "select * from questions";
	public static final String SQL_SELECT_QUESTION_BY_THEME = "select * from questions where themeid = ?";
	
}
