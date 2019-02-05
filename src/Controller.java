import java.awt.event.*;

public class Controller {

	/*
	 * Instances of classes in the category View will be labelled by v_ followed by class name.
	 * Instances of classes in the category Model will be labelled by m_ followed by class name.
	 */
	private main_view v_main_view;
	private Game m_game;
	
	
	//Controller constructor.
	
	public Controller (main_view v_main_view, Game m_game) {
		/* 
		 * # to do:
		 * 			1. Implement Game in constructor when class is created in workspace.
		 */
		
		this.v_main_view = v_main_view;
		this.m_game = m_game;
	}
	

	///// INNER CLASS NewGameListener /////////////////////////////////////////////////////////////////////////////////
	/*
	 * When NEW GAME is requested.
	 * 1. Get size of quiz from UI.
	 * 2. Call Game to create new Quiz with this size.
	 * 3. Get first question from Game.
	 * 4. Tell UI to display question.
	 */
	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			int quizSize = 0;
			try {
				/* 1.
				 * Get size of Quiz from UI and save in userInput.
				 * parse to integer and save in quizSize.
				 */
				userInput = v_main_view.getQuizSize;
				quizSize = Integer.parseInt(userInput);
				
				//2. Call Game to create new Quiz with size quizSize.
				m_game.createNewQuiz(quizSize);
				
				//3. Get first question from Game.
				Question firstQuestion = m_game.getNextQuestion();
				
				//4. Tell UI to display first question.
				v_main_view.openQuestion(firstQuestion.getQuestionText(), firstQuestion.getCategory());
			}
			catch (NumberFormatException nfex) {
				v_main_view.showError("Bad input: '" + userInput + "'");
			}
		}
		
		
	}
	
	///// INNER CLASS SubmitAwserListener ////////////////////////////////////////////////////////////////////////////
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
}
