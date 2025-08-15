package persistence.mariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import quizlogic.ThemeDTO;

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

	public ThemeDTO dto;

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

		if (id <= 0) {
			sqlStmt = ThemeDAO.SQL_INSERT_THEME;
			System.out.println("SQL Insert used");
		} else {
			sqlStmt = ThemeDAO.SQL_UPDATE_THEME;
			System.out.println("SQL Update used");
		}

		establishConnection();

		// get id from database
		try {
			PreparedStatement query = connection.prepareStatement(ThemeDAO.SQL_GET_ID);
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				th.setId(id);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

		// standard input => id only part of input if id > 0
		try {
			pstmt = connection.prepareStatement(sqlStmt, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, th.getTitle());
			pstmt.setString(2, th.getText());

			if (id > 0) {
				pstmt.setInt(3, id);
			}

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Fehler beim Speichern in die Datenbank: " + e.getMessage());
			e.printStackTrace();
			return e.getMessage();
		}

		return null;

	}

	/**
	 * Method to load existing DTO's from the DB
	 * 
	 * @return ThemeDTO's
	 */
	public ArrayList<ThemeDTO> loadAllThemesFromDB() {
		int id;
		String themeTitle;
		String themeText;

		establishConnection();

		ArrayList<ThemeDTO> list = new ArrayList<ThemeDTO>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(ThemeDAO.SQL_SELECT_ALL);

			while (rs.next()) {
				dto = new ThemeDTO();
				id = rs.getInt("id");
				themeTitle = rs.getString("themeTitle");
				themeText = rs.getString("themeText");

				dto.setId(id);
				dto.setTitle(themeTitle);
				dto.setText(themeText);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("dto: " + dto.getInfo());
		return list;
	}

}