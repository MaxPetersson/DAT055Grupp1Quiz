import java.util.ArrayList;

/**
 * The Result class is used to store the questions and answers from a quiz
 * session and if the answer was right
 * 
 * @author ntaus
 *
 */
public class Result {
	ArrayList<Boolean> results;
	ArrayList<String> answers;
	ArrayList<Question> questions;

	Result(ArrayList<Boolean> results, ArrayList<String> answers, ArrayList<Question> questions) {
		this.results = results;
		this.answers = answers;
		this.questions = questions;
	}

	/**
	 * Returns the results of the object
	 * 
	 * @return
	 */
	public ArrayList<Boolean> getResults() {
		return results;
	}

	/**
	 * Returns the answers of result
	 * 
	 * @return
	 */
	public ArrayList<String> getAnswers() {
		return answers;
	}

	/**
	 * Returns the questions of result
	 * 
	 * @return
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}

}
