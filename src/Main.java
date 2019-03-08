public class Main {

	/**
	 * Initializes and runs the application
	 * 
	 * @Oscar Thureborn
	 * 
	 * @param args
	 * @version 2019-03-08
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		final QuestionsClient theClient = new QuestionsClient();
		final Game theGame = new Game(theClient);
		final Main_Window theMainView = new Main_Window();
		final NewQuestionWindow theNewQFrame = new NewQuestionWindow("QuestionFrame");

		final Controller theController = new Controller(theMainView, theNewQFrame, theGame);

		theClient.addObserver(theMainView);
		theGame.addObserver(theMainView);
		theClient.loadQuestions();
		theClient.loadCategories();

		theMainView.setVisible();

	}

}
