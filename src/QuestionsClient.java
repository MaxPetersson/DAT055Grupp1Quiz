
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
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

	// Returns the question bank.
	public ArrayList<Question> getQuestionBank() {
		return questionBank;
	}

	// Notify the observers with the question bank.
	public void loadQuestions() {

		int serverPort = 6060;

		try {
			InetAddress inetAdd = InetAddress.getByName("127.0.0.1");
			Socket socket = new Socket(inetAdd, serverPort);

			// Generic streams
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			// Objects Stream use also for bool
			ObjectOutputStream oOut = new ObjectOutputStream(out);
			ObjectInputStream oIn = new ObjectInputStream(in);

			// Tell the server that we only want to load questions.
			oOut.writeBoolean(false);
			oOut.flush();

			// Read the arraylist of questions that the server has written.
			questionBank = (ArrayList<Question>) oIn.readObject();

			// Close all streams.
			in.close();
			out.close();
			oOut.close();
			oIn.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("Exceptionet som kastades var: " + e.getMessage());
		}

		setChanged();

		notifyObservers(questionBank);
		setChanged();
		notifyObservers(questionBank);
	}

	// Adds a question to the question bank.
	public void addQuestionToQuestionBank(Question questionToAdd) {

		int serverPort = 6060;

		try {
			InetAddress inetAdd = InetAddress.getByName("127.0.0.1");
			Socket socket = new Socket(inetAdd, serverPort);

			// Generic Streams
			InputStream in = socket.getInputStream();
			OutputStream out = (OutputStream) socket.getOutputStream();

			// Objects Streams
			ObjectOutputStream oOut = new ObjectOutputStream(out);
			ObjectInputStream oIn = new ObjectInputStream(in);

			// Tell the server we have a question to save.
			oOut.writeBoolean(true);
			oOut.flush();

			// Write the question-object to the stream.
			oOut.writeObject(questionToAdd);
			oOut.flush();

			// Close all streams.
			in.close();
			out.close();
			oOut.close();
			oIn.close();
			socket.close();
		} catch (Exception e) {
			// Please take care of me.
		}

		loadQuestions();
		loadCategories();

	}

	// Add category to categories then notify observers with categories.
	public void loadCategories() {

		categories.clear();

		for (Question i : questionBank) {

			if (!categories.contains(i.getCategory())) { // // If the category does'nt exist, call addCategory with the
															// category.
				categories.add(i.getCategory());
			}

		}

		setChanged();
		notifyObservers(categories);
	}

	// Remove the question object from the question bank.
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
