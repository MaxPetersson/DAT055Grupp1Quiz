import java.awt.event.*;
import java.util.ArrayList;

public class Controller {

	/*
	 * Instances of classes in the category View will be labelled by v_ followed by class name.
	 * Instances of classes in the category Model will be labelled by m_ followed by class name.
	 */
	private main_view v_main_view;
	private NewQFrame v_NewQFrame;
	private Game m_game;
	
	
	//Controller constructor.
	
	public Controller (main_view v_main_view, NewQFrame v_NewQFrame, Game m_game) {
		this.v_main_view = v_main_view;
		this.v_NewQFrame = v_NewQFrame;
		this.m_game = m_game;
		
		this.v_main_view.addNewGameListener(new NewGameListener ());
		this.v_main_view.addSubmitAnswerListener(new SubmitAnswerListener());
		this.v_main_view.addNewQuestionListener(new CreateNewQuestionListener());
		this.v_NewQFrame.addSubmitNewQuestionListener(new SubmitNewQuestionListener());
	}
	

	///// INNER CLASS NewGameListener /////////////////////////////////////////////////////////////////////////////////
	/*
	 * When NEW GAME is requested.
	 * 1. Get size of quiz from UI.
	 * 2. Call Game to create new Quiz with this size.
	 * 3. Get first question from Game.
	 * 4. Tell UI to display question.
	 */
	
	//public void addNewGameListener(ActionListener e) {
	//	newGame.addActionListener(e)
	//}
	
	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			int quizSize = 0;
			try {
				/* 1.
				 * Get size of Quiz from UI and save in userInput.
				 * parse to integer and save in quizSize.
				 */
				userInput = v_main_view.getQuizSize();
				quizSize = Integer.parseInt(userInput);
				
				//2. Call Game to create new Quiz with size quizSize.
				m_game.generateQuiz(quizSize);
				
				//3. Get first question from Game.
				Question firstQuestion = m_game.getNextQuestion();
				
				//4. Tell UI to display first question.
				v_main_view.changeToQuizScreen();
				v_main_view.displayQuestion(firstQuestion.getCategory(), firstQuestion.getQuestionText(), m_game.getTotalNumberOfQuestionInQuiz(), m_game.getCurrentQuestion());
			}
			catch (NumberFormatException nfex) {
				v_main_view.displayErrorMessage("Bad input: '" + userInput + "'");
			}
		}
		
		
	}
	
	
	
	///// INNER CLASS SubmitAnswerListener ////////////////////////////////////////////////////////////////////////////
	/*
	 * When AWNSER is submitted.
	 * 1. Get answer from UI.
	 * 2. Call Game to compare [submitted answer] with [question answer].
	 * 3. Get result from Game.
	 * 4. Tell UI to display the result.
	 * 5. Get next question from Game.
	 * 6. Tell UI to display question from Game.
	 * 7. End game if there is no more questions.
	 */
	class SubmitAnswerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userAnswer = "";
			
			try {
				//1. get answer from user and store in userAnswer
				userAnswer = v_main_view.getAnswer();
				
				//2. Compare userAwnser to the current question's answer.
				m_game.compareAnswer(userAnswer);
				
				//3 & 4. Tell UI to display the result from Game.
				v_main_view.displayResult(m_game.getResult());
				
				
				if(m_game.existNextQuestion()) {
					//5. Get next question from Game.
					Question nextQuestion = m_game.getNextQuestion();
					//6. Tell UI to display next question. 
					v_main_view.displayQuestion(nextQuestion.getCategory(), nextQuestion.getQuestionText(), m_game.getTotalNumberOfQuestionInQuiz(), m_game.getCurrentQuestion());
					}
				else {
					//7. Show the start screen.
					v_main_view.changeToStartScreen();
				}
					
			}
			catch (NullPointerException npex) {
				v_main_view.displayErrorMessage("The error message");
			}
		}
	}
	
	///// INNER CLASS CreateNewQuestionListener ///////////////////////////////////////////////////////////////////////
	/*
	 * 1. Tell UI to show NewQuestionFrame
	 */
	class CreateNewQuestionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			v_NewQFrame.setVisible(true);
		}
	}
	
	///// INNER CLASS SubmitNewQuestionListener ///////////////////////////////////////////////////////////////////////
	/*
	 * 1. Get Category, Question & Answer from UI.
	 * 2. Create New Question.
	 * 3. Tell UI to clear question form.
	 */
	class SubmitNewQuestionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String question = "";
			String category = "";
			ArrayList<String> answer = new ArrayList<String>();
			Question theQuestion;
			try {
//				v_NewQFrame.getQuestion();
//				v_NewQFrame.getCategory();
//				v_NewQFrame.getAnswer();
				answer.add("");
				theQuestion = new Question(category, question ,answer);
				m_game.addQuestionToLocalQuestionBank(theQuestion);
			}
			catch(NullPointerException ex) {
				v_NewQFrame.displayErrorMessage("The error message");
			}
			
		}
	}
}
