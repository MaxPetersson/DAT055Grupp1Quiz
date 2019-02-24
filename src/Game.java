
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {
	Result currentResult;
	ArrayList<Question> currentQuiz;
	ArrayList<Boolean> results = new ArrayList<Boolean>();
	ArrayList<Question> categoryQuestions = new ArrayList<Question>();
	ArrayList<String> userAnswers = new ArrayList<String>();

	int currentQuestion;
	int nrOfQuestions;
	QuizQuestion activeQuestion = new QuizQuestion(null, null, currentQuestion, currentQuestion);
	private QuestionsClient questionClient = new QuestionsClient();
	public ArrayList<String> catArr;

	public Game(QuestionsClient questionClient) {
		currentQuestion = 0;

		this.questionClient = questionClient;

	}
	
	// Tell questionClient to add a question to the question bank.
	public void addQuestionToQuestionBank(Question questionToAdd) {
		questionClient.addQuestionToQuestionBank(questionToAdd);
	}


	// returns true if quiz generated successfully
	// returns false if it did'nt (most likely because there was'nt enough questions
	// Set nrOfQuestions to max?
	public boolean generateQuiz(int nrOfQuestions, List<String> category) throws BadUserInputException {

		this.nrOfQuestions = nrOfQuestions;
		userAnswers.clear();
		results.clear();
		categoryQuestions.clear();

		for (Question i : questionClient.getQuestionBank()) { // picks out questions from the chosen category
			for (String j : category) {

				if (i.getCategory().equals(j)) {

					categoryQuestions.add(i);

				}
			}
		}

		if (nrOfQuestions > categoryQuestions.size() || nrOfQuestions < 1) {
			throw new BadUserInputException("Choose a number between 1 and " + categoryQuestions.size());
		} else {
			currentQuiz = new ArrayList<Question>();

			for (int i = 0; i < nrOfQuestions;) {

				int index = (int) Math.round((Math.random() * (categoryQuestions.size() - 1))); // returns a random
																								// number
																								// between 0
																								// and the size of the
																								// array of the
																								// choosen category/-ies

				if (!currentQuiz.contains(categoryQuestions.get(index))) { // makes sure that the randomly choosen
																			// question
																			// hasnt already been choosen
					currentQuiz.add(categoryQuestions.get(index));
					i++; // adds i if and only if a question has been added

				}
			}
			currentQuestion = 0;
			return true;
		}

	}

	/*
	 * Compares the users answer with the questions answer.
	 * 1. Store the users answer.
	 * 2. Modify question & users answer strings: remove spaces & set letters to lower case.
	 * 3. Compare modified strings and store result in results.
	 */
	public void compareAnswer(String userAnswer) {
		//1.Store the users answer.
		userAnswers.add(userAnswer);
		//2. Create placeholder for the correct answer, remove spaces & set to lower case.
		String questionAnswer = currentQuiz.get(currentQuestion-1).getAnswers().get(0).toLowerCase().replace(" ", "");
		// Remove spaces from the users answer and set all letters to lower case.
		userAnswer = userAnswer.toLowerCase().replaceAll(" ", "");
		//3.Compare the users answer and the questions answer and store the result in results
		results.add(userAnswer.equals(questionAnswer));
	}

	/*
	 * Change the current question in the quiz to the next one.
	 * 1. Increment the currentQuestion.
	 * 2. Tell activeQuestion to set parameters with next questions parameters.
	 * 3. set changed & notify observers with activeQuestion.
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
	
	/*
	 * Checks if there are any more questions in the current quiz.
	 * Returns true if there is.
	 */
	public boolean existNextQuestion() {
		if (currentQuestion < currentQuiz.size()) {
			return true;
		}
		return false;
	}

	
	/*
	 * Should be rebuild to use question id.
	 * Decision will be taken later.
	 * Should maybe be handled by QuestionClient.
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
	
	//Notify observers with the results.
	public void notifyResult() {
		setChanged();
		notifyObservers(currentResult= new Result(results, userAnswers, currentQuiz));
	}
	
	public void loadQuestions() {
		questionClient.loadQuestions();
	}

}
