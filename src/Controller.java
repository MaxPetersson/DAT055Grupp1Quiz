import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controller {

	/*
	 * 
	 */
	private main_view mainWindow;
	private NewQFrame newQuestionFrame;
	private Game game;

	// Controller constructor.

	public Controller(main_view mainWindow, NewQFrame newQuestionFrame, Game game) {
		this.mainWindow = mainWindow;
		this.newQuestionFrame = newQuestionFrame;
		this.game = game;

		this.mainWindow.addNewGameListener(new NewGameListener());
		this.mainWindow.addSubmitAnswerListener(new SubmitAnswerListener());
		this.mainWindow.addNewQuestionListener(new CreateNewQuestionListener());
		this.newQuestionFrame.addSubmitNewQuestionListener(new SubmitNewQuestionListener());
		this.mainWindow.addEditQuestionsListener(new EditQuestionsListener());
		this.mainWindow.addDeleteQuestionsListener(new DeleteQuestionsListener());
		mainWindow.setCategories(game.fetchCategories());
		game.fetchQuestions();

	}

	///// INNER CLASS NewGameListener
	///// /////////////////////////////////////////////////////////////////////////////////
	/*
	 * When NEW GAME is requested. 
	 * 1. Get size of quiz from UI. 
	 * 2. Call Game to create new Quiz with this size in selected categories. 
	 * 3. Set first question in Game.
	 * 4. Change to quiz screen in MainWindow. 
	 */

	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			int quizSize = 0;
			try {
				/*
				 * 1. Get size of Quiz from UI and save in userInput. parse to integer and save in quizSize.
				 */
				userInput = mainWindow.getQuizSize();
				quizSize = Integer.parseInt(userInput);
				
				//2. Call Game to create new Quiz with this quizSize in selected categories.
				if (!mainWindow.getSelectedCategory().isEmpty()) {
					// Generating quiz with size = quizSise and chosen categories.
					game.generateQuiz(quizSize, mainWindow.getSelectedCategory());

					// 3. Set first Question in Game.
					game.setNextQuestion();

					// 4. Tell UI to display quiz screen.
					mainWindow.changeToQuizScreen();;

				} else {
					// If no category is chosen, throw BadUserInputException.
					throw new BadUserInputException("Choose at least one category");

				}
			} catch (NumberFormatException nfex) {
				mainWindow.displayErrorMessage("You must enter a number of questions");
			} catch (BadUserInputException buiex) {
				mainWindow.displayErrorMessage(buiex.getMessage());
			}
		}

	}

	///// INNER CLASS SubmitAnswerListener
	///// ////////////////////////////////////////////////////////////////////////////
	/*
	 * When ANSWER is submitted.
	 * 1. Get answer from UI. 
	 * 2. Call Game to compare the submitted answer with question answer.
	 * 3. Set next question in Game.  
	 * 4. Show quiz score if there is no more questions.
	 */
	class SubmitAnswerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userAnswer = "";

			try {
				// 1. get answer from user and store in userAnswer
				userAnswer = mainWindow.getAnswer();

				// 2. Compare userAwnser to the current question's answer.
				game.compareAnswer(userAnswer);
				
				if (game.existNextQuestion()) {
					// 3. Set next question in Game.
					game.setNextQuestion();
				} else {
					// 4. Display the quiz score in MainWindow.
					mainWindow.printResult(game.results, game.userAnswers, game.currentQuiz);
				}

			} catch (NullPointerException npex) {
				mainWindow.displayErrorMessage("The error message");
			}
		}
	}

	///// INNER CLASS CreateNewQuestionListener
	///// ///////////////////////////////////////////////////////////////////////
	/*
	 * 1. Tell UI to show NewQuestionFrame
	 */
	class CreateNewQuestionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newQuestionFrame.setVisible(true);
		}
	}

	///// INNER CLASS SubmitNewQuestionListener
	///// ///////////////////////////////////////////////////////////////////////
	/*
	 * 1. Get Category, Question & Answer from UI. 
	 * 2. Tell game to create new Question.
	 * 3. Tell UI to clear question form.
	 */
	class SubmitNewQuestionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String question = "";
			String category = "";
			ArrayList<String> answers = new ArrayList<String>();
			Question theQuestion;

			if (fieldsOK()) {
				try {
					question = newQuestionFrame.getQuestion();
					category = newQuestionFrame.getCategory().substring(0, 1).toUpperCase() // sets first letter to uppercase
																						// and leaves rest alone
							+ newQuestionFrame.getCategory().substring(1);
					answers.addAll(newQuestionFrame.getAnswers());
					theQuestion = new Question(category, question, answers);
					game.addQuestionToQuestionBank(theQuestion);

					if (!game.fetchCategories().contains(theQuestion.getCategory())) {
						game.addCategory(theQuestion.getCategory());

					}

					JOptionPane.showMessageDialog(newQuestionFrame, "New question has been added!");
				} catch (NullPointerException ex) {
					newQuestionFrame.displayErrorMessage("The error message");
				}

				newQuestionFrame.clearWindow();

			}

		}
	}

	class EditQuestionsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			ArrayList<Question> questions = game.fetchQuestions();
			mainWindow.printQuestionsList(questions);
		}

	}

	class DeleteQuestionsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String[] parts = mainWindow.getSelectedQuestion().substring(3).split(" - ");

			game.deleteQuestion(parts[0], parts[1]);

		}

	}

	private boolean fieldsOK() { // check if ok to submit
		String category = newQuestionFrame.getCategory();
		String question = newQuestionFrame.getQuestion();
		ArrayList<String> answers = new ArrayList<String>();
		String[] tempAnswers = newQuestionFrame.answerTextArea.getText().split(",");
		for (String s : tempAnswers) {
			answers.add(s);
		}

		if (category.replaceAll("\\s+", "").equals("")) {
			newQuestionFrame.displayErrorMessage("Please enter category");
			return false;
		} else if (question.replaceAll("\\s+", "").equals("")) {
			newQuestionFrame.displayErrorMessage("Please enter question");
			return false;
		} else if (tempAnswers[0].replaceAll("\\s+", "").equals("")) {
			newQuestionFrame.displayErrorMessage("Please enter answer");
			return false;
		} else
			return true;
	}

private boolean checkQuestionFields(String category, String question, ArrayList<String> answers) 
throws BadUserInputException {
	
	if (category.replaceAll("\\s+", "").equals("")) {
		throw new BadUserInputException("Enter a category");
	}
	else if (question.replaceAll("\\s+", "").equals("")) {
		throw new BadUserInputException("Enter a question");
	} 
	else if (answers.get(0).equals("")) {
		throw new BadUserInputException("Enter a category");
	}
	return true;
}
}
