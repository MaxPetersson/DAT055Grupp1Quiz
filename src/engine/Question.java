package engine;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The question class is used to store the questions used in a generated quiz
 * 
 * @author ntaus
 * @version 2019-03-08
 */
@SuppressWarnings("serial")
public class Question implements Serializable {
	private String category;
	private String questionText;
	private ArrayList<String> answers;
	private LocalDateTime created;

	/**
	 * Empty Constructor
	 */
	public Question() {
		this.category = "";
		this.questionText = "";
		this.answers.add("");
		this.created = LocalDateTime.now();
	}

	/**
	 * Constructor for category, text and answers
	 * 
	 * @param category
	 * @param questionText
	 * @param answers
	 */
	public Question(String category, String questionText, ArrayList<String> answers) {
		this.category = category;
		this.questionText = questionText;
		this.answers = answers;
		this.created = LocalDateTime.now();
	}

	// Getters
	/**
	 * Returns the category of the question
	 * 
	 * @return String
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * Returns the question text
	 * 
	 * @return String
	 */
	public String getQuestionText() {
		return this.questionText;
	}

	/**
	 * Returns the answers to the question
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAnswers() {
		return this.answers;
	}

	/**
	 * Returns the creation datetime of the questio
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getCreated() {
		return this.created;
	}

	// Setters

	/**
	 * Sets the category of the question
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the questiontext of the question
	 * 
	 * @param questionText
	 */
	public void setQuestionTextonText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * Sets the answers of the question
	 * 
	 * @param answers
	 */
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

}
