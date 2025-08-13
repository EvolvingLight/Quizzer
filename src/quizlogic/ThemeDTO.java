package quizlogic;

public class ThemeDTO {

	private int id = -1;

	/**
	 * String to hold the theme title
	 */
	private String title;

	/**
	 * String to hold the theme text
	 */
	private String text;

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
	 * 
	 * @return theme id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the theme id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return theme title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the theme title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return theme text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the theme text
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * function to test the class
	 */
	public String getInfo() {
		String info = "ID: " + id + "\n";
		info += "Titel: " + title + "\n";
		info += "Text: " + text;
		return info;
	}

}
