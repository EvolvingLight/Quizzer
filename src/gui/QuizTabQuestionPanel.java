package gui;

import quizlogic.serialization.Question;

public class QuizTabQuestionPanel extends QuestionTabQuestionPanel{

	/**
	 * Needed for the constructor
	 */
	private Question question;

	public QuizTabQuestionPanel(Question question) {
		super(question);
		this.question = question;
	}

}
