package Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Quizler.BadUserInputException;
import Update.QuizQuestion;
import Update.Result;

/**
 * Game generates a and runs a quiz and stores the results. It also acts as a
 * proxy between controller and questionClient for question storage
 * 
 * @author Niclas Tauson & Oscar Thureborn
 * @version 2019-03-08
 */
public class Game extends Observable {

	private ArrayList<Question> currentQuiz;
	private ArrayList<Question> categoryQuestions = new ArrayList<Question>();
	private ArrayList<Boolean> results = new ArrayList<Boolean>();
	private ArrayList<String> userAnswers = new ArrayList<String>();
	// int value representing the number of the current question in the current
	// quiz.
	private int currentQuestion;
	// int value representing the total number of questions in the current quiz.
	private int nrOfQuestions;

	// Object used to update observers (QuizQuestion & Result)
	private QuizQuestion activeQuestion = new QuizQuestion(null, null, currentQuestion, currentQuestion);
	private Result currentResult;

	private QuestionsClient questionClient;

	public Game(QuestionsClient questionClient) {
		currentQuestion = 0;

		this.questionClient = questionClient;

	}

	/**
	 * Tell questionClient to add a question to the question bank.
	 * 
	 * @param questionToAdd
	 */
	public void addQuestionToQuestionBank(Question questionToAdd) {
		questionClient.addQuestionToQuestionBank(questionToAdd);
	}

	/**
	 * Generates a quiz with a given size and list of categories. throws
	 * BadUserInputException if the chosen size of the quiz exceeds the number of
	 * available questions in that category.
	 * 
	 * @param nrOfQuestions
	 * @param category
	 *
	 * @throws BadUserInputException
	 */
	public boolean generateQuiz(int nrOfQuestions, List<String> category) throws BadUserInputException {
		// set nrOfQuestions to chosen number of questions.
		this.nrOfQuestions = nrOfQuestions;
		// Reset quiz parameters.
		userAnswers.clear();
		results.clear();
		categoryQuestions.clear();
		currentQuestion = 0;

		// picks out all questions with the chosen categories from question bank.
		// questions are stored in categoryQuestions.
		for (Question i : questionClient.getQuestionBank()) {
			for (String j : category) {

				if (i.getCategory().equals(j)) {
					categoryQuestions.add(i);

				}
			}
		}
		// If the chosen number of questions are out of categoryQuestions bounds then
		// throw BadUserInputException.
		if (nrOfQuestions > categoryQuestions.size() || nrOfQuestions < 1) {
			throw new BadUserInputException("Choose a number between 1 and " + categoryQuestions.size());
		}
		// If chosen number of questions for the quiz is within the reach of
		// categoryQyestions, create the quiz.
		else {
			// Set currentQuiz to new ArrayList of Question
			currentQuiz = new ArrayList<Question>();
			// This for loop fills currentQuiz with random questions from categoryQuesions
			for (int i = 0; i < nrOfQuestions;) {
				// Set index to a random number between 0 and the size of categoryQuestions
				int index = (int) Math.round((Math.random() * (categoryQuestions.size() - 1)));
				// If the randomly chosen question DOES'NT exist in currentQuiz, add it.
				if (!currentQuiz.contains(categoryQuestions.get(index))) {
					// Add question to currentQuiz from categoryQuestions
					currentQuiz.add(categoryQuestions.get(index));
					// i is only incremented when a question is added.
					i++;
				}
			}
			return true;
		}

	}

	/**
	 * Compares the users answer with the questions answer. 1. Store the users
	 * answer. 2. Modify question & users answer strings: remove spaces & set
	 * letters to lower case. 3. Compare modified strings and store result in
	 * results.
	 * 
	 * @param userAnswer
	 */

	public void compareAnswer(String userAnswer) {
		// 1.Store the users answer.
		userAnswers.add(userAnswer);
		// 2. Create placeholder for the correct answer, remove spaces & set to lower
		// case.
		String questionAnswer = currentQuiz.get(currentQuestion - 1).getAnswers().get(0).toLowerCase().replace(" ", "");
		// Remove spaces from the users answer and set all letters to lower case.
		userAnswer = userAnswer.toLowerCase().replaceAll(" ", "");
		// 3.Compare the users answer and the questions answer and store the result in
		// results
		results.add(userAnswer.equals(questionAnswer));
	}

	/**
	 * Change the current question in the quiz to the next one. 1. Increment the
	 * currentQuestion. 2. Tell activeQuestion to set parameters with next questions
	 * parameters. 3. set changed & notify observers with activeQuestion.
	 */
	public void setNextQuestion() {
		// 1. Increment the currentQuestion.
		currentQuestion++;
		// 2. Set activeQuestions parameters with next questions parameters.
		activeQuestion.setNewQuestion(currentQuiz.get(currentQuestion - 1).getQuestionText(),
				currentQuiz.get(currentQuestion - 1).getCategory(), currentQuestion, nrOfQuestions);
		// 3. Set changed and notify observers with the change.
		setChanged();
		notifyObservers(activeQuestion);
	}

	/**
	 * Checks if there are any more questions in the current quiz. Returns true if
	 * there is.
	 */
	public boolean existNextQuestion() {
		if (currentQuestion < currentQuiz.size()) {
			return true;
		}
		return false;
	}

	/**
	 * Calls for questionClient to delete a question with the given parameters - NOT
	 * USED
	 * 
	 * @param category
	 * @param question
	 */
	public void deleteQuestion(String category, String question) {

		ArrayList<Question> questions = questionClient.getQuestionBank();

		for (Question i : questions) {

			if (i.getQuestionText().equals(question) && i.getCategory().equals(category)) {
				questionClient.removeQuestion(i);
				break;
			}

		}

	}

	/**
	 * Notify observers with the quiz results.
	 */
	public void notifyResult() {
		currentResult = new Result(results, userAnswers, currentQuiz);
		setChanged();
		notifyObservers(currentResult);
	}

	/**
	 * call questionClient to load all Questions.
	 */
	public void loadQuestions() {
		questionClient.loadQuestions();
	}

	/**
	 * call questionClient to load all Categories.
	 */
	public void loadCategories() {
		questionClient.loadCategories();
	}

}
