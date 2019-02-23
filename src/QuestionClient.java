
import java.util.ArrayList;
import java.util.Observable;

public class QuestionClient extends Observable {

	public ArrayList<Question> questionBank = new ArrayList<Question>();
	public ArrayList<String> catArr;
	// hardcoding of 3 questions
	private String[] qtextarray = {
			"En b�t k�r med en hastighet av fyra knop mot en brygga. En meter fr�n bryggan saktar b�ten ner till tre knop. Har l�ngt tid tar det att laga bryggan?",
			"What is the air-speed velocity of an unladen swallow?",
			"How much wood could a woodchuck chuck if a woodchuck could chuck wood? " };

	private ArrayList<String> answers1;
	private ArrayList<String> answers2;
	private ArrayList<String> answers3;

	public QuestionClient() {

		// hardcoding of 3 questions
		answers1 = new ArrayList<String>();
		answers1.add("1");

		answers2 = new ArrayList<String>();
		answers2.add("1");

		answers3 = new ArrayList<String>();
		answers3.add("1");

		catArr = new ArrayList<String>();
		catArr.add("G�tor");
		catArr.add("Monty Python");
		catArr.add("Trivia");

		// Remove later
		questionBank.add(new Question(catArr.get(0), qtextarray[0], answers1));
		questionBank.add(new Question(catArr.get(1), qtextarray[1], answers2));
		questionBank.add(new Question(catArr.get(2), qtextarray[2], answers3));

	}

	// SETTER
	public void addQuestionToQuestionBank(Question qToAdd) {
		questionBank.add(qToAdd);
		setChanged();
		notifyObservers(questionBank);
	}

	public void addCategory(String catToAdd) {

		catArr.add(catToAdd);
		setChanged();
		notifyObservers(catArr);
	}

	public void removeQuestion(Question theQuestion) {

		questionBank.remove(theQuestion);
		setChanged();
		notifyObservers(questionBank);

		boolean categoryLeft = false; // this part erases the category from the categorylist should there be no more
										// questions with that category
		for (Question i : questionBank) {

			if (i.getCategory().equals(theQuestion.getCategory())) {
				categoryLeft = true;
			}
		}
		if (!categoryLeft) {
			catArr.remove(theQuestion.getCategory());
			setChanged();
			notifyObservers(catArr);
		}

	}

}