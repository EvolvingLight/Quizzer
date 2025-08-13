package quizlogic.serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class FakeDataDeliverer implements Serializable {
	
	protected static final long serialVersionUID = 1L;

	public ArrayList<Thema> themes;
	public ArrayList<Question> questions;

	/**
	 * @param themes
	 */
	public FakeDataDeliverer() {
		super();
		createThemes(2);
	}

	public Question getRandomQuestion() {

		// Zufälliges Thema aus der Liste auswählen
		Random random = new Random();
		int indexT = random.nextInt(themes.size());
		Thema thema = themes.get(indexT);

		// Aus der Liste der Fragen zum ausgewählten Thema eine Frage auswählen
		int indexQ = random.nextInt(thema.getQuestions().size());
		Question que = thema.getQuestions().get(indexQ);

		return que;
	}
	
	public void getQuestionFromList(int index) {
		
	}
	

	public void createThemes(int count) {

		themes = new ArrayList<Thema>();
		Thema th;

		for (int i = 0; i < count; i++) {
			th = new Thema();
			th.setId(i);
			th.setTitle("Title of category " + i);
			th.setText("Text of category " + i);

			createQuestionsFor(th);
			themes.add(th);
		}
	}
	
	public void createQuestionsFor(Thema th) {
		
		questions = new ArrayList<Question>();
		Question q;

		for (int i = 0; i < 6; i++) {
			q = new Question(th);
			q.setId(i);
			q.setTitle("Title of question " + i);
			q.setText("Text of question " + i);

			th.addQuestion(q);
			questions.add(q);
						
			createAnswersFor(q);
			
		}
	}

	public void createAnswersFor(Question q) {
		Answer a;

		for (int i = 1; i <= Answer.MAX_ANSWERS; i++) {
			a = new Answer(q);
			a.setId(i);
			a.setText("Text of answer " + i);
			a.setCorrect(i % 2 == 0);

			q.addAnswer(a);

		}

	}

}
