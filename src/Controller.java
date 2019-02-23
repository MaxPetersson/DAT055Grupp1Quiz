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

	/*
	 * Controller constructor.
	 * set mainWindow, newQuestionFrame & game.
	 * Add actionlisteners to buttons in mainWindow & newQuestionFrame
	 */
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
			Question theQuestion;
			String category = newQuestionFrame.getCategory().trim();
			String question = newQuestionFrame.getQuestion().trim();
			ArrayList<String> untrimmedAnswers = newQuestionFrame.getAnswers();
			ArrayList<String> answers = new ArrayList<String>();
			for(String s:untrimmedAnswers) {
				answers.add(s.trim());
			}
			try {
				//Make sure that the category, question & answer is not empty.
				if(checkQuestionFieldsNotEmpty(category, question, answers)) {
					//Set first char in category to upper case.
					category = category.substring(0, 1).toUpperCase() + category.substring(1);
					// make a question object with category, question, answers.
					theQuestion = new Question(category, question, answers);
					//tell game to add the question to the question bank.
					game.addQuestionToQuestionBank(theQuestion);
				}
				if (!game.fetchCategories().contains(category)) {
					game.addCategory(category);
				}
				newQuestionFrame.clearWindow();
				JOptionPane.showMessageDialog(newQuestionFrame, "New question has been added!");
			}
			catch (NullPointerException ex) {
				newQuestionFrame.displayErrorMessage("The error message");
			}
			catch (BadUserInputException buex) {
				newQuestionFrame.displayErrorMessage(buex.getMessage());
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


 /*
  * Checks if the user entered a category, question and answer.
  * If fields are ok, returns true.
  * If a field is missing, throw BadUserInputException.
  */
private boolean checkQuestionFieldsNotEmpty(String category, String question, ArrayList<String> answers) 
throws BadUserInputException {
	// Checks if the user entered a category, throw error if not.
	if (category.equals("")) {
		throw new BadUserInputException("You must enter a category");
	}
	// Check if the user entered a question, throw error if not.
	else if (question.equals("")) {
		throw new BadUserInputException("You must enter a question");
	}
	// Check if the user entered an answer, throw error if not.
	else {
		for(String s: answers) {
			if(s.equals("")) {
				throw new BadUserInputException("You must enter an answer");
			}
		}
	}
	//Return true if all fields are ok.
	return true;
}
}
