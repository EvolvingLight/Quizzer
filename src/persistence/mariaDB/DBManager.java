package persistence.mariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quizlogic.ThemeDTO;

public class DBManager {

	private Connection connection;
	private int id;
	private String themeTitle;
	private String themeText;
	
	static String URL = "jdbc:mysql://localhost:3306/quizzer";
	static String USER = "root";
	static String PASSWORD = "";

	/**
	 * Establishes a connection to the database
	 */
	private void establishConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Uses prepared SQL statements and the insertValues method to save / or update data in the DB
	 * If the save process was not successful an error message will be displayed
	 * @param th
	 * @return
	 */
	public String saveThemeIntoDB(ThemeDTO th) {
		String sqlInsert = ThemeDAO.SQL_INSERT_THEME;
		String sqlUpdate = ThemeDAO.SQL_UPDATE_THEME;

		establishConnection();

		if (id == 0) {
			try (PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
				insertValues(pstmt);
				pstmt.executeUpdate();

				// Return generated ID
				try (ResultSet res = pstmt.getGeneratedKeys()) {
					if (res.next()) {
						id = res.getInt(1);
					}
				}
				connection.close();
				
			} catch (SQLException e) {
				System.out.println("Fehler beim Speichern in die Datenbank: " + e.getMessage());
				e.printStackTrace();
				return e.getMessage();
			}

		} else {
			System.out.println("Id already used!");
			
			try (PreparedStatement pstmt = connection.prepareStatement(sqlUpdate)) {
				insertValues(pstmt);
				pstmt.executeUpdate();
				connection.close();
				
			} catch (SQLException e) {
				System.out.println("Fehler beim Speichern in die Datenbank: " + e.getMessage());
				e.printStackTrace();
				return e.getMessage();
			}
		}
		
		return null;
	}

	/**
	 * Inserts themeTitle and themeText to the correct position in the SQL statement
	 * inside the ThemeDAO class. Swaps the question marks with the values in this method.
	 * The first question mark will be "themeTitle" and the second "themeText"
	 * @param pstmt
	 * @throws SQLException
	 */
	private void insertValues(PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, themeTitle);
		pstmt.setString(2, themeText);
	}
}
