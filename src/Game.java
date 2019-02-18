
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {
	ArrayList<Question> localQuestionBank = new ArrayList<Question>();
	ArrayList<Question> currentQuiz;
	ArrayList<Boolean> results = new ArrayList<Boolean>();
	ArrayList<Question> categoryQuestions = new ArrayList<Question>();
	int currentQuestion;
	int nrOfQuestions;
	QuizQuestion activeQuestion = new QuizQuestion(null, null, currentQuestion, currentQuestion);

	// hardcoding of 3 questions
	private String[] qtextarray = {
			"En båt kör med en hastighet av fyra knop mot en brygga. En meter från bryggan saktar båten ner till tre knop. Har långt tid tar det att laga bryggan?",
			"What is the air-speed velocity of an unladen swallow?",
			"How much wood could a woodchuck chuck if a woodchuck could chuck wood? " };

	// { "Gåtor", "Monty Python", "Trivia" };
	private ArrayList<String> answers1;
	private ArrayList<String> answers2;
	private ArrayList<String> answers3;
	ArrayList<String> catArr;

	public Game() {
		currentQuestion = 0;

		// hardcoding of 3 questions
		answers1 = new ArrayList<String>();
		answers1.add("1");

		answers2 = new ArrayList<String>();
		answers2.add("1");

		answers3 = new ArrayList<String>();
		answers3.add("1");

		catArr = new ArrayList<String>();
		catArr.add("Gåtor");
		catArr.add("Monty Python");
		catArr.add("Trivia");

		// Remove later
		localQuestionBank.add(new Question(catArr.get(0), qtextarray[0], answers1));
		localQuestionBank.add(new Question(catArr.get(1), qtextarray[1], answers2));
		localQuestionBank.add(new Question(catArr.get(2), qtextarray[2], answers3));

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

	public void addCategory(String catToAdd) {

		catArr.add(catToAdd);
		setChanged();
		notifyObservers(catToAdd);
	}

	// returns true if quiz generated successfully
	// returns false if it didnt (most likely because there wasnt enough questions
	// Set nrOfQuestions to max?
	public boolean generateQuiz(int nrOfQuestions, List<String> category) throws BadUserInputException {

		this.nrOfQuestions = nrOfQuestions;
		results.clear();
		categoryQuestions.clear();

		for (Question i : localQuestionBank) { // picks out questions from the choosen category
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
}
