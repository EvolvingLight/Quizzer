package quizlogic.serialization;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class associates a question with a theme and manages an answer list
 * It supports setting the question's title and text, and allows dynamic addition of answers.
 * This class is serializable to support persistence
 */
public class Question extends QObject implements Serializable {

	protected static final long serialVersionUID = 1L;
	
	/**
	 * The question title
	 */
	private String title;
	
	/**
	 * The question text
	 */
	private String text;

	/**
	 * The theme associated to the question
	 */
	private Theme theme;
	
	/**
	 * An ArrayList with possible answers to the question
	 */
	private ArrayList<Answer> answers;

	/**
	 * This constructor creates a question object associated to the theme 
	 * @param theme 
	 * The theme to associate with this question, must not be null
	 */
	public Question(Theme theme) {
		super();
		this.theme = theme;
	}
	
	/**
	 * This method adds answers to the answer list
	 * @param a 
	 * The answer to add
	 */
	public void addAnswer(Answer a) {
		if (answers == null) {
			answers = new ArrayList<Answer>();
		}
		answers.add(a);
	}
	
	/**
	 * Returns the list of answers for this question
	 * @return the list of answers
	 */
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	
	/**
	 * Returns the theme associated with this question
	 * @return the theme, never null after construction
	 */
	public Theme getTheme() {
		return theme;
	}
	
	/**
	 * Sets the theme for this question.
     * @param theme 
     * The theme to set; must not be null
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	/**
	 * Returns the title of this question.
     * @return the title, or null if not set
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title of this question.
     * @param title 
     * The title to set, must not be null
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the main text of this question.
     * @return the question text, or null if not set
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the main text of this question
	 * @param text
	 * The question text to set, must not be null
	 */
	public void setText(String text) {
		this.text = text;
	}

}
