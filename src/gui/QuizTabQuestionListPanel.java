package gui;

import java.util.ArrayList;

import quizlogic.serialization.Question;
import quizlogic.serialization.Thema;

public class QuizTabQuestionListPanel extends QuestionTabListPanel{

	public QuizTabQuestionListPanel(ArrayList<Thema> themeDataList, ArrayList<Question> questionDataList) {
		super(themeDataList, questionDataList);
		
	}

}
