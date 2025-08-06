package quizlogic;

import java.io.Serializable;

/**
 * 
 */
public class Answer extends QObject implements Serializable {
	
	/**
	 * General serial version UID for serialization compatibility
	 */
	protected static final long serialVersionUID = 1L;
	
	/**
	 * Constant to define the maximum possible answers per question
	 */
	public static final int MAX_ANSWERS = 4;
	
	/**
	 * The answer text
	 */
	private String text;
	
	/**
	 * Boolean to define whether an answer is correct or not
	 */
	private boolean correct;
	
	/**
	 * A question associated to the answer
	 */
	private Question question;
	
	/**
	 * This constructor creates an answer object associated to the question 
	 * @param question
	 * The question to associate with this answer, must not be null
	 */
	public Answer(Question question) {
		super();
		this.question = question;
	}

	/**
	 * Returns the text of this answer
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the text for this answer
	 * @param text
	 * The text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returns the status (true / false) of this answer
	 * @return the status 
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * Sets the status (true / false) of the answer
	 * @param correct
	 * The boolean to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	/**
	 * Returns the question associated to this answer
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Sets the question associated to the answer
	 * @param question
	 * The question associated to this answer
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
}
