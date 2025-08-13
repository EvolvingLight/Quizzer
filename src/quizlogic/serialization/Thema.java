package quizlogic.serialization;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class adds questions to a question list. It also holds a theme title and a question text
 * And returns a string with informations like title, question text and answers for display or debugging
 * This class is serializable to support persistence
 */
public class Thema extends QObject implements Serializable {
	
	protected static final long serialVersionUID = 1L;
	
	/**
	 * The title of this theme
	 */
	private String title;
	
	/**
	 * A description of this theme
	 */
	private String text;
	
	/**
	 * An ArrayList of questions associated with this theme
	 */
	public ArrayList<Question> questions;
	
	/**
	 * If no list exists creates a list of questions.
	 * If a list exists the question will be added to the list associated with this theme 
	 */
	public void addQuestion(Question q) {
		if(questions == null) {
			questions = new ArrayList<Question>();
		}
		
		questions.add(q);
	}
	
	/**
	 * Returns a string with informations like title, question text and answers associated to this theme
	 * This method is primarily intended for debugging
	 * @return a formatted string with theme and question details
	 * 
	 */
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Thema:\n");
		info.append("Title: " + title + "\n");
		info.append("Text: " + text + "\n\n");
		info.append("Fragen: \n");
		
		for (Question question : questions) {
			info.append("Title " + question.getTitle() + "\n");
			info.append("Text " + question.getText() + "\n\n");
			
			info.append("Antworten:\n");
			for (Answer a : question.getAnswers()) {
				info.append("Text " + a.getText());
				info.append("" + (a.isCorrect() ? "richtig" : "falsch"));
				
			}
		}
		return info.toString();
	}
	
	

	/**
	 * Returns the list of questions in this theme
	 * @return the list of questions
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	/**
	 * Sets the questions for this theme
	 * @param questions
	 * The question to set, must not be null
	 */
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	/**
	 * Returns the title for this theme
	 * @return the title of this theme
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title of tis theme
	 * @param title
	 * The title to set, must not be null
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the text of this theme
	 * @return the text of this theme
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the text of this theme
	 * @param text
	 * The text to set, must not be null
	 */ 
	public void setText(String text) {
		this.text = text;
	}
}
