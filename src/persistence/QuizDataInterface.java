package persistence;

import java.util.ArrayList;

import quizlogic.Answer;
import quizlogic.Question;
import quizlogic.Thema;

/**
 * This interface represents several methods uses inside the project to handle data
 * There are methods to save / load or delete questions or themes for example
 * All Methods are declared in the QuizDataManager
 * 
 */
public interface QuizDataInterface {
	/**
	 * Retrieves a randomly selected question from the data source
	 */
	public Question getRandomQuestion();

	/**
	 * Retrieves a list of all available themes
	 */
	public ArrayList<Thema> getAllThemes();

	/**
	 * Retrieves all questions associated with the specified theme.
	 */
	public ArrayList<Question> getQuestionFor(Thema th);

	/**
	 * Retrieves all answers associated with the specified question.
	 */
	public ArrayList<Answer> getAnswersFor(Question q);

	/**
	 * Persists the given theme to the data store. If the theme is new, it will be
	 * created.
	 */
	public String saveTheme(Thema th);

	/**
	 * Removes the specified theme from the data store.
	 */
	public String deleteTheme(Thema th);

	/**
	 * This method saves a new question or updates an existing one
	 */
	public String saveQuestion(Question q);

	/**
	 * Removes the specified question from the data store.
	 */
	public String deleteQuestion(Question q);

}
