package gui;

import java.util.ArrayList;

import quizlogic.serialization.Question;
import quizlogic.serialization.Theme;

public class QuizTabQuestionListPanel extends QuestionTabListPanel{

	public QuizTabQuestionListPanel(ArrayList<Theme> themeDataList, ArrayList<Question> questionDataList) {
		super(themeDataList, questionDataList);
		
	}

}
