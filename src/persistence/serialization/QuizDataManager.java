package persistence.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import persistence.QuizDataInterface;
import quizlogic.Answer;
import quizlogic.Question;
import quizlogic.Thema;

/**
 * This class manages different methods like save or delete operations used via the QuizDataInterface
 */
public class QuizDataManager implements QuizDataInterface {

	/**
	 * A constant defining the folder to store data in
	 */
	private static final String FOLDER = ".\\quizData";
	
	/**
	 * A constant to define the filename of new created files
	 */
	private static final String FILE = FOLDER + "\\Theme.";
	
	/**
	 * A string to save the filename
	 */
	private String file;
	
	/**
	 * The theme of a question
	 */
	private Thema th;

	/**
	 * Constructor for this class
	 */
	public QuizDataManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a random question out of the question list, MAYBE RETRICTED TO A SINGLE THEME
	 * @return a random question
	 */
	@Override
	public Question getRandomQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * A method to return an ArrayList with all existing themes
	 * @return all themes
	 */
	@Override
	public ArrayList<Thema> getAllThemes() {
		
		ArrayList<Thema> themen = new ArrayList<Thema>();
		File dir= new File(FILE);
		
		// Empty list, if directory is not available
		if (!dir.exists() || !dir.isDirectory()) {
			return themen;
		}
		
		File[] files = dir.listFiles();
		if (files == null) {
			return themen;
		}
		
		for (File file : files) {
			if (file.isFile()) {
				try (FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis)) {
							Thema th = (Thema) ois.readObject();
							themen.add(th);
					} catch (IOException | ClassNotFoundException e) {
						System.err.println("Fehler beim lesen von Thema aus Datei: " + file.getName());
						e.printStackTrace();
					}
						
			}
		}
		return themen;
	}

	/**
	 * Returns an ArrayList with questions associated to a single theme
	 * @return an ArrayList with questions
	 */
	@Override
	public ArrayList<Question> getQuestionFor(Thema th) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * A method to return an ArrayList of Answers associated to a question
	 * @return an ArrayList with Answers
	 */
	@Override
	public ArrayList<Answer> getAnswersFor(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to save a newly created theme into the folder and using the file name defined in the constant FILE
	 */
	@Override
	public String saveTheme(Thema th) {
		FileOutputStream fileOutputStream;
		try {
			if (th.getId() == -1)
				th.setId(createNewThemeId());

			fileOutputStream = new FileOutputStream(FILE + th.getId());

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(th);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			return e.getMessage();
		}
		return null;
	}

	/**
	 * Method to delete a theme. Also validates the existence of the theme to be deleted
	 */
	@Override
	public String deleteTheme(Thema th) {
		if (th == null) {
			return "Thema nicht vorhanden";
		}
		
		int id = th.getId();
		if(id == -1) {
			return "Ungültige ID: -1";
		}
		
		File file = new File(FILE + id);
		
		if(!file.exists()) {
			return "Thema mit ID " + id + " existiert nicht!";
		}
		
		if (!file.delete()) {
			return "Fehler beim löschen der Datei für Thema mit ID " + id;
		}
		
		return null;
	}

	/**
	 * Saves the question using the saveTheme method.
	 * The question parameter "q" will be used as argument in the 
	 * saveTheme method to associate the question to a theme
	 */
	@Override
	public String saveQuestion(Question q) {
		return saveTheme(q.getThema());
	}

	/**
	 * Method to delete a question
	 */
	@Override
	public String deleteQuestion(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Searching inside the FOLDER for themes and counting them
	 * @return the number of themes inside the folder
	 */
	public int getThemesCount() {
		File folder = new File(FOLDER);
		int count = 0;

		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory())
				count++;
		}
		return count;
	}

	/**
	 * Creates a new theme ID using the amount of existing themes + 1.
	 * For example, if we already have 5 themes existing the next created theme will get id "6"
	 * @return the ID of a newly created theme
	 */
	public int createNewThemeId() {
		return getThemesCount() + 1;
	}

}
