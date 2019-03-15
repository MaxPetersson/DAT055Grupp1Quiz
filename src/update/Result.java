package update;
import java.util.ArrayList;

import engine.Question;

/**
 * The Result class is used to store the questions and answers from a quiz
 * session and if the answer was right
 * 
 * @author Oscar Thureborn
 * @version 2019-03-08
 */
public class Result {
	ArrayList<Boolean> results;
	ArrayList<String> answers;
	ArrayList<Question> questions;

	public Result(ArrayList<Boolean> results, ArrayList<String> answers, ArrayList<Question> questions) {
		this.results = results;
		this.answers = answers;
		this.questions = questions;
	}

	/**
	 * Returns the results of the object
	 * 
	 * @return ArrayList<Boolean>
	 */
	public ArrayList<Boolean> getResults() {
		return results;
	}

	/**
	 * Returns the answers of result
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAnswers() {
		return answers;
	}

	/**
	 * Returns the questions of result
	 * 
	 * @return ArrayList<Question>
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}

}
