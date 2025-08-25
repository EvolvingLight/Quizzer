package quizlogic;

public class QuestionDTO {

	/**
	 * Theme ID to link the question DTO to the theme
	 */
	private int themeID;

	/**
	 * All id's for question and answers
	 */
	private int questionID;
	private int answerOneID;
	private int answerTwoID;
	private int answerThreeID;
	private int answerFourID;
	
	/**
	 * All strings for questions and answers
	 */
	private String questionTitle;
	private String questionText;
	private String answerOneText;
	private String answerTwoText;
	private String answerThreeText;
	private String answerFourText;
	
	/**
	 * All booleans for the answers
	 */
	private boolean answerOneTrue;
	private boolean answerTwoTrue;
	private boolean answerThreeTrue;
	private boolean answerFourTrue;
	
	/**
	 * function to test the class
	 */
	public String getInfo() {
		String info = ""; 
		info += "Theme ID: " + themeID + "\n";
		info += "Question-ID: " + questionID + "\n";
		info += "Question title: " + questionTitle + "\n";
		info += "Question text: " + questionText + "\n";
		
		info += "Answer one id: " + answerOneText + "\n";
		info += "Answer one text: " + answerOneText + "\n";
		info += "Answer one true: " + answerOneTrue + "\n";
		
		info += "Answer two text: " + answerTwoText + "\n";
		info += "Answer two true: " + answerTwoTrue + "\n";
		info += "Answer two true: " + answerTwoTrue + "\n";
		
		info += "Answer three text: " + answerThreeText + "\n";
		info += "Answer three true: " + answerThreeTrue + "\n";
		info += "Answer three true: " + answerThreeTrue + "\n";
		
		info += "Answer four text: " + answerFourText + "\n";
		info += "Answer four true: " + answerFourTrue + "\n";
		info += "Answer four true: " + answerFourTrue + "\n";
		return info;
	}
	
	
	
	public int getThemeID() {
		return themeID;
	}
	
	public void setThemeID(int themeID) {
		this.themeID = themeID;
	}

	public int getQuestionID() {
		return questionID;
	}
	
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	
	public int getAnswerOneID() {
		return answerOneID;
	}
	
	public void setAnswerOneID(int answerOneID) {
		this.answerOneID = answerOneID;
	}
	
	public int getAnswerTwoID() {
		return answerTwoID;
	}
	
	public void setAnswerTwoID(int answerTwoID) {
		this.answerTwoID = answerTwoID;
	}
	
	public int getAnswerThreeID() {
		return answerThreeID;
	}
	
	public void setAnswerThreeID(int answerThreeID) {
		this.answerThreeID = answerThreeID;
	}
	
	public int getAnswerFourID() {
		return answerFourID;
	}
	
	public void setAnswerFourID(int answerFourID) {
		this.answerFourID = answerFourID;
	}
	
	public String getQuestionTitle() {
		return questionTitle;
	}
	
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public String getAnswerOneText() {
		return answerOneText;
	}
	
	public void setAnswerOneText(String answerOneText) {
		this.answerOneText = answerOneText;
	}
	
	public String getAnswerTwoText() {
		return answerTwoText;
	}
	
	public void setAnswerTwoText(String answerTwoText) {
		this.answerTwoText = answerTwoText;
	}
	
	public String getAnswerThreeText() {
		return answerThreeText;
	}
	
	public void setAnswerThreeText(String answerThreeText) {
		this.answerThreeText = answerThreeText;
	}
	
	public String getAnswerFourText() {
		return answerFourText;
	}
	
	public void setAnswerFourText(String answerFourText) {
		this.answerFourText = answerFourText;
	}
	
	public boolean isAnswerOneTrue() {
		return answerOneTrue;
	}
	
	public void setAnswerOneTrue(boolean answerOneTrue) {
		this.answerOneTrue = answerOneTrue;
	}
	
	public boolean isAnswerTwoTrue() {
		return answerTwoTrue;
	}
	
	public void setAnswerTwoTrue(boolean answerTwoTrue) {
		this.answerTwoTrue = answerTwoTrue;
	}
	
	public boolean isAnswerThreeTrue() {
		return answerThreeTrue;
	}
	
	public void setAnswerThreeTrue(boolean answerThreeTrue) {
		this.answerThreeTrue = answerThreeTrue;
	}
	
	public boolean isAnswerFourTrue() {
		return answerFourTrue;
	}
	
	public void setAnswerFourTrue(boolean answerFourTrue) {
		this.answerFourTrue = answerFourTrue;
	}
	
	/**
	 * Overwrites the default toString method.
	 * Aim is to display the title instead of the memory address (ThemeDTO@123456fg) 
	 */
	@Override
	public String toString() {
		return questionTitle;
	}
	
}






















