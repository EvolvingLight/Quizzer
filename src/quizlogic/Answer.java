package quizlogic;

public class Answer extends QObject {
	
	public static final int MAX_ANSWERS = 4;
	private String text;
	private boolean correct;
	
	private Question question;
	

	public Answer(Question question) {
		super();
		this.question = question;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
