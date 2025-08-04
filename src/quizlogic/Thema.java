package quizlogic;

import java.util.ArrayList;

public class Thema extends QObject {
	
	private String title;
	private String text;
	
	private ArrayList<Question> questions;
	
	
	public void addQuestion(Question q) {
		if(questions == null) {
			questions = new ArrayList<Question>();
		}
		
		questions.add(q);
	}
	
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
	
	

	// ---------------- Getter / Setter ---------------- // 
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
