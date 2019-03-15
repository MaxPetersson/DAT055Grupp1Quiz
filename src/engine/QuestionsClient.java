package engine;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import shared.Question;

/**
 * QuestionClient stores teh questions and is used to load and store new
 * questions from/in a server
 * 
 * @author Niclas Tauson CO-Author: Max Petersson
 * @version 2019-03-08
 */
public class QuestionsClient extends Observable {

	private ArrayList<shared.Question> questionBank = new ArrayList<shared.Question>();
	private ArrayList<String> categories;

	public QuestionsClient() {

		categories = new ArrayList<String>();

	}

	/**
	 * Returns the question bank.
	 * 
	 * @return ArrayList<Question>
	 */
	public ArrayList<shared.Question> getQuestionBank() {
		return questionBank;
	}

	/**
	 * Fetches the questions from server and notifies the observers
	 * 
	 */
	public void loadQuestions() {

		int serverPort = 6060;
		questionBank.clear();
		int loop = 0;

		while (questionBank.isEmpty() && loop < 3) {

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
				questionBank = (ArrayList<shared.Question>) oIn.readObject();

				// Close all streams.
				in.close();
				out.close();
				oOut.close();
				oIn.close();
				socket.close();

			} catch (Exception e) {
				System.out.println("Exceptionet som kastades var: " + e);
			}

			loop++;
		}

		setChanged();

		notifyObservers(questionBank);

	}

	//
	/**
	 * Sends a new question to be stored on the server and then calls load questions
	 * to update the question bank.
	 * 
	 * @param questionToAdd
	 */
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

		if (questionBank.isEmpty()) {

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		loadQuestions();
		loadCategories();

	}

	//
	/**
	 * Sets the available categories then notify observers with categories.
	 * 
	 */
	public void loadCategories() {

		if (!categories.isEmpty()) {
			categories.clear();
		}

		for (Question i : questionBank) {

			if (!categories.contains(i.getCategory())) { // // If the category does'nt exist, call addCategory with the
															// category.
				categories.add(i.getCategory());
			}

		}

		setChanged();
		notifyObservers(categories);
	}

	/**
	 * Removes the question object from the question bank and notifies observers.
	 * 
	 * @param theQuestion
	 */
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
