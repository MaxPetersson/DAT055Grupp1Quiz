public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		final QuestionsClient theClient = new QuestionsClient();
		final Game theGame = new Game(theClient);
		final MainWindow theMainView = new MainWindow();
		final NewQuestionFrame theNewQFrame = new NewQuestionFrame("QuestionFrame");
		
		final Controller theController = new Controller(theMainView, theNewQFrame, theGame);

		theClient.addObserver(theMainView);
		theGame.addObserver(theMainView);
		theClient.loadCategories();

		theMainView.setVisible();

	}

}
