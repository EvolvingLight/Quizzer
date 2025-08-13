package persistence.mariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quizlogic.ThemeDTO;

public class DBManager {

	private Connection connection;

	/**
	 * 
	 */
	static String URL = "jdbc:mysql://localhost:3306/quizzer";

	/**
	 * 
	 */
	static String USER = "root";

	/**
	 * 
	 */
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
	 * Uses prepared SQL statements and the insertValues method to save or update a
	 * theme in the DB
	 * 
	 * @param th Instance of ThemeDTO
	 * @return An error message if the save process was not successful
	 */
	public String saveThemeIntoDB(ThemeDTO th) {
		int id = th.getId();

		String sqlStmt;

		if (id < 0) {
			sqlStmt = ThemeDAO.SQL_INSERT_THEME;
		} else {
			sqlStmt = ThemeDAO.SQL_UPDATE_THEME;
		}

		establishConnection();

		if (id == 0) {
			try (PreparedStatement pstmt = connection.prepareStatement(sqlStmt)) {
				pstmt.setString(1, th.getTitle());
				pstmt.setString(2, th.getText());
				pstmt.executeUpdate();

				// Return generated ID
				try (ResultSet res = pstmt.getGeneratedKeys()) {
					if (res.next()) {
						th.setId(res.getInt(1));
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

			try (PreparedStatement pstmt = connection.prepareStatement(sqlStmt)) {
				pstmt.setString(1, th.getTitle());
				pstmt.setString(2, th.getText());
				
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


}
