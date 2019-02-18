
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {

	ArrayList<Question> currentQuiz;
	ArrayList<Boolean> results = new ArrayList<Boolean>();
	ArrayList<Question> categoryQuestions = new ArrayList<Question>();
	int currentQuestion;
	int nrOfQuestions;
	QuizQuestion activeQuestion = new QuizQuestion(null, null, currentQuestion, currentQuestion);
	private QuestionClient q_client = new QuestionClient();

	public Game(QuestionClient q_client) {
		currentQuestion = 0;

		this.q_client = q_client;

	}

	// GETTER
	public int getTotalNumberOfQuestionInQuiz() {
		return currentQuiz.size();
	}

	public int getCurrentQuestion() {
		return currentQuestion;
	}

	public ArrayList<Boolean> getResult() {
		return results;
	}

	// SETTER

	public void addQuestionToQuestionBank(Question qToAdd) {
		q_client.addQuestionToQuestionBank(qToAdd);
	}

	public void addCategory(String catToAdd) {

		q_client.addCategory(catToAdd);
	}

	// returns true if quiz generated successfully
	// returns false if it didnt (most likely because there wasnt enough questions
	// Set nrOfQuestions to max?
	public boolean generateQuiz(int nrOfQuestions, List<String> category) throws BadUserInputException {

		this.nrOfQuestions = nrOfQuestions;
		results.clear();
		categoryQuestions.clear();

		for (Question i : q_client.questionBank) { // picks out questions from the choosen category
			for (String j : category) {

				if (i.getCategory().equals(j)) {

					categoryQuestions.add(i);

				}
			}
		}

		if (nrOfQuestions > categoryQuestions.size() || nrOfQuestions < 1) {
			throw new BadUserInputException(
					"There are only " + categoryQuestions.size() + " questions to choose from.");
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

	public void compareAnswer(String userAnswer) {

		results.add(currentQuestion - 1, currentQuiz.get(currentQuestion - 1).getAnswers().get(0).equals(userAnswer));

	}

	public void setNextQuestion() {

		// return currentQuiz.get(currentQuestion++);
		currentQuestion++;

		activeQuestion.setNewQuestion(currentQuiz.get(currentQuestion - 1).getQuestionText(),
				currentQuiz.get(currentQuestion - 1).getCategory(), currentQuestion, nrOfQuestions);

		setChanged();
		notifyObservers(activeQuestion);
	}

	public boolean existNextQuestion() {
		if (currentQuestion < currentQuiz.size()) {
			return true;
		}
		return false;
	}

	public ArrayList<String> fetchCategories() {

		return q_client.catArr;

	}

	public ArrayList<Question> fetchQuestions() {

		return q_client.questionBank;

	}
}
