
import java.util.ArrayList;
import java.util.Observable;

public class QuestionsClient extends Observable {

	private ArrayList<Question> questionBank = new ArrayList<Question>();
	private ArrayList<String> categories;
	// hardcoding of 3 questions
	private String[] qtextarray = {
			"En båt kör med en hastighet av fyra knop mot en brygga. En meter från bryggan saktar båten ner till tre knop. Har långt tid tar det att laga bryggan?",
			"What is the air-speed velocity of an unladen swallow?",
			"How much wood could a woodchuck chuck if a woodchuck could chuck wood? " };

	private ArrayList<String> answers1;
	private ArrayList<String> answers2;
	private ArrayList<String> answers3;

	public QuestionsClient() {

		// hardcoding of 3 questions
		answers1 = new ArrayList<String>();
		answers1.add("1");

		answers2 = new ArrayList<String>();
		answers2.add("1");

		answers3 = new ArrayList<String>();
		answers3.add("1");

		categories = new ArrayList<String>();
		categories.add("Gåtor");
		categories.add("Monty Python");
		categories.add("Trivia");

		// Remove later
		questionBank.add(new Question(categories.get(0), qtextarray[0], answers1));
		questionBank.add(new Question(categories.get(1), qtextarray[1], answers2));
		questionBank.add(new Question(categories.get(2), qtextarray[2], answers3));

	}
	//Returns the question bank.
	public ArrayList<Question> getQuestionBank(){
		return questionBank;
	}
	//Notify the observers with the categories and question bank.
	public void loadQuestions() {
		setChanged();
		notifyObservers(questionBank);
	}
	public void loadCategories() {

		setChanged();
		notifyObservers(categories);
	}

	// Adds a question to the question bank.
	public void addQuestionToQuestionBank(Question questionToAdd) {
		questionBank.add(questionToAdd);
		setChanged();
		notifyObservers(questionBank);
		checkIfNewCategory(questionToAdd.getCategory());
	}

	//Add category to categories then notify observers with categories.
	public void addCategory(String categoryToAdd) {

		categories.add(categoryToAdd);
		setChanged();
		notifyObservers(categories);
	}
	
	//If the category does'nt exist, call addCategory with the category.
	private void checkIfNewCategory(String category) {
		if (!categories.contains(category)) {
			addCategory(category);
		}
	}

	//Remove the question object from the question bank.
	public void removeQuestion(Question theQuestion) {

		questionBank.remove(theQuestion);
		setChanged();
		notifyObservers(questionBank);

		boolean categoryLeft = false; // this part erases the category from the category list should there be no more
										// questions with that category
		for (Question i : questionBank) {

			if (i.getCategory().equals(theQuestion.getCategory())) {
				categoryLeft = true;
			}
		}
		if (!categoryLeft) {
			categories.remove(theQuestion.getCategory());
			setChanged();
			notifyObservers(categories);
		}

	}

}
