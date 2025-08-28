package persistence.mariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import quizlogic.QuestionDTO;
import quizlogic.ThemeDTO;

/**
 * This class manages the connection to the database. IT saves and loads data
 * from / into the database
 */
public class DBManager {

	private Connection connection;

	/**
	 * Address of the database
	 */
	static String URL = "jdbc:mysql://localhost:3306/quizzer";

	/**
	 * Login user name for the database
	 */
	static String USER = "root";

	/**
	 * Password for the database
	 */
	static String PASSWORD = "";

	public ThemeDTO themeDTO;
	public QuestionDTO questionDTO;

	/**
	 * Establishes a connection to the database If no connection can be established
	 * an error message will be displayed in the console
	 */
	private void establishConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Uses prepared statement and them id to delete a theme from the database
	 * @param th => ThemeDTO
	 */
	public void deleteTheme(ThemeDTO th) {
		int id = th.getId();
		PreparedStatement pstmt;
		String sqlStmt;

		establishConnection();

		// standard input => id only part of input if id > 0
		try {
			sqlStmt = ThemeDAO.SQL_DELETE_THEME;
			pstmt = connection.prepareStatement(sqlStmt);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Fehler beim Löschen des Themas aus der Datenbank: " + e.getMessage());
			e.printStackTrace();
		}

//		return null;
	}

	/**
	 * Uses prepared SQL statements and the insertValues method to save or update a
	 * theme in the DB
	 * 
	 * @param th Instance of ThemeDTO
	 * @return An error message if the save process was not successful
	 */
	public String saveThemeIntoDB(ThemeDTO th) {
		int id = th.getId();
		PreparedStatement pstmt;
		String sqlStmt;

		if (id > 0) {
			sqlStmt = ThemeDAO.SQL_UPDATE_THEME;
			System.out.println("SQL Update used");
		} else {
			sqlStmt = ThemeDAO.SQL_INSERT_THEME;
			System.out.println("SQL Insert used");
		}

		establishConnection();

		// standard input => id only part of input if id > 0
		try {
			pstmt = connection.prepareStatement(sqlStmt, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, th.getTitle());
			pstmt.setString(2, th.getText());

			if (id > 0) {
				pstmt.setInt(3, id);
			}

			pstmt.executeUpdate();
			ResultSet res = pstmt.getGeneratedKeys();
			if (res.next()) {
				th.setId(res.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println("Fehler beim Speichern in die Datenbank: " + e.getMessage());
			e.printStackTrace();
			return e.getMessage();
		}
		return null;
	}

	/**
	 * Establishes a connection to the database. Creates a new array list for the
	 * DTO's Then querys data from the database and saves it to the DTO's. As last
	 * action saves the DTO's to a list
	 * 
	 * @return ThemeDTO's
	 */
	public ArrayList<ThemeDTO> loadAllThemesFromDB() {
		int themeID;
		String themeTitle;
		String themeText;
		int questionID;
		String questionTitle;
		String questionText;
		String sqlStmt;
		int questionTableThemeID;

		establishConnection();

		ArrayList<ThemeDTO> themeList = new ArrayList<ThemeDTO>();

		try {
			Statement stmtTheme = connection.createStatement();
			ResultSet rsTheme = stmtTheme.executeQuery(ThemeDAO.SQL_SELECT_ALL);

			while (rsTheme.next()) {
				themeDTO = new ThemeDTO();
				themeID = rsTheme.getInt("id");
				themeTitle = rsTheme.getString("themeTitle");
				themeText = rsTheme.getString("themeText");

				themeDTO.setId(themeID);
				themeDTO.setTitle(themeTitle);
				themeDTO.setText(themeText);

//				sqlStmt = QuestionDAO.SQL_SELECT_QUESTION_BY_THEME;
//				PreparedStatement pstmtQuestion = connection.prepareStatement(sqlStmt);
//				pstmtQuestion.setInt(1, themeID);
//				ResultSet rsQuestion = pstmtQuestion.executeQuery();
				
				Statement stmtQuestion = connection.createStatement();
				ResultSet rsQuestion = stmtQuestion.executeQuery(QuestionDAO.SQL_SELECT_ALL);

				while (rsQuestion.next()) {
					questionDTO = new QuestionDTO();

					questionID = rsQuestion.getInt("id");
					questionTitle = rsQuestion.getString("questionTitle");
					questionText = rsQuestion.getString("questionText");
					questionTableThemeID = rsQuestion.getInt("themeID");

					questionDTO.setQuestionID(questionID);
					questionDTO.setQuestionTitle(questionTitle);
					questionDTO.setQuestionText(questionText);
					questionDTO.setThemeID(questionTableThemeID);
					
					themeDTO.setQuestionDTO(questionDTO);
					themeList.add(themeDTO);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return themeList;
	}

	/**
	 * Establishes a connection to the database. Creates a new array list for the
	 * DTO's Then querys data from the database and saves it to the DTO's. As last
	 * action saves the DTO's to a list
	 * 
	 * @return ThemeDTO's
	 */
	public ArrayList<QuestionDTO> loadAllQuestionsFromDB() {
		int questionID;
		String questionTitle;
		String questionText;
		int questionThemeID;

		establishConnection();

		ArrayList<QuestionDTO> questionList = new ArrayList<QuestionDTO>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(QuestionDAO.SQL_SELECT_ALL);

			while (rs.next()) {
				questionDTO = new QuestionDTO();
				questionID = rs.getInt("id");
				questionTitle = rs.getString("questionTitle");
				questionText = rs.getString("questionText");
				questionThemeID = rs.getInt("themeID");

				questionDTO.setQuestionID(questionID);
				questionDTO.setQuestionTitle(questionTitle);
				questionDTO.setQuestionText(questionText);
				questionDTO.setThemeID(questionThemeID);

				questionList.add(questionDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return questionList;
	}
}
