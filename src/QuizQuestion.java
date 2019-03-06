
/**
 * QuizQuestion is used to be able to update the UI with a questions and it's
 * order in the generated quiz
 * 
 * @author ntaus
 *
 */
public class QuizQuestion {

	private String question;
	private String category;
	private int questionNumber;
	private int totalQuestions;

	public QuizQuestion(String question, String category, int questionNumber, int totalQuestions) {

		question = this.question;
		category = this.category;
		questionNumber = this.questionNumber;
		totalQuestions = this.totalQuestions;

	}

	/**
	 * Set the question text of the question
	 * 
	 * @param question
	 */
	public void setQuestionText(String question) {

		question = this.question;
	}

	/**
	 * Set the category text of the question
	 * 
	 * @param category
	 */
	public void setCategory(String category) {

		category = this.category;
	}

	/**
	 * Set the question number of the question
	 * 
	 * @param questionNumber
	 */
	public void setQuestionNumber(int questionNumber) {

		questionNumber = this.questionNumber;
	}

	/**
	 * Set the total number of questions in the quiz that this question belongs to
	 * 
	 * @param totalQuestions
	 */
	public void setTotalQuestions(int totalQuestions) {

		totalQuestions = this.totalQuestions;
	}

	/**
	 * Sets all paramaters of this question in one call
	 * 
	 * @param question
	 * @param category
	 * @param questionNumber
	 * @param totalQuestions
	 */
	public void setNewQuestion(String question, String category, int questionNumber, int totalQuestions) {

		this.question = question;
		this.category = category;
		this.questionNumber = questionNumber;
		this.totalQuestions = totalQuestions;

	}

	/**
	 * Returns the text of the question
	 * 
	 * @return
	 */
	public String getQuestionText() {

		return question;
	}

	/**
	 * Gets the category of the question
	 * 
	 * @return
	 */
	public String getCategory() {

		return category;
	}

	/**
	 * Gets the question number of the question
	 * 
	 * @return
	 */
	public int getQuestionNumber() {

		return questionNumber;
	}

	/**
	 * Gets the total number of questions in the quiz that this question belongs to
	 * 
	 * @return
	 */
	public int getTotalQuestions() {

		return totalQuestions;
	}

}
