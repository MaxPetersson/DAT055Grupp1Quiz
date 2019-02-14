
import java.util.ArrayList;
import java.util.Observable;

public class Game extends Observable {
	ArrayList<Question> localQuestionBank = new ArrayList<Question>();
	ArrayList<Question> currentQuiz;
	ArrayList<Boolean> results = new ArrayList<Boolean>();
	int currentQuestion;
	int nrOfQuestions;
	QuizQuestion activeQuestion = new QuizQuestion(null, null, currentQuestion, currentQuestion);

	// hardcoding of 3 questions
	private String[] qtextarray = {
			"En båt kör med en hastighet av fyra knop mot en brygga. En meter från bryggan saktar båten ner till tre knop. Har långt tid tar det att laga bryggan?",
			"What is the air-speed velocity of an unladen swallow?",
			"How much wood could a woodchuck chuck if a woodchuck could chuck wood? " };
	private String[] catArr = { "Gåtor", "Monty Python", "Trivia" };
	private ArrayList<String> answers1;
	private ArrayList<String> answers2;
	private ArrayList<String> answers3;

	public Game() {
		currentQuestion = 0;

		// hardcoding of 3 questions
		answers1 = new ArrayList<String>();
		answers1.add("1");

		answers2 = new ArrayList<String>();
		answers2.add("1");

		answers3 = new ArrayList<String>();
		answers3.add("1");

		// Remove later
		localQuestionBank.add(new Question(catArr[0], qtextarray[0], answers1));
		localQuestionBank.add(new Question(catArr[1], qtextarray[1], answers1));
		localQuestionBank.add(new Question(catArr[2], qtextarray[2], answers1));

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
	public void addQuestionToLocalQuestionBank(Question qToAdd) {
		localQuestionBank.add(qToAdd);
	}

	// returns true if quiz generated successfully
	// returns false if it didnt (most likely because there wasnt enough questions
	// Set nrOfQuestions to max?
	public boolean generateQuiz(int nrOfQuestions) throws BadUserInputException {

		this.nrOfQuestions = nrOfQuestions;
		results.clear();

		if (nrOfQuestions > localQuestionBank.size() || nrOfQuestions < 1) {
			throw new BadUserInputException(
					"There are only " + localQuestionBank.size() + " questions to choose from.");
		} else {
			currentQuiz = new ArrayList<Question>();
			for (int i = 0; i < nrOfQuestions; i++) {
				currentQuiz.add(localQuestionBank.get(i));
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
}
