public class Main {

	public static void main(String[] args) {

		final QuestionClient theClient = new QuestionClient();
		final Game theGame = new Game(theClient);
		final main_view theMainView = new main_view();
		final NewQFrame theNewQFrame = new NewQFrame("QuestionFrame");
		final Controller theController = new Controller(theMainView, theNewQFrame, theGame);

		theClient.addObserver(theMainView);
		theGame.addObserver(theMainView);
		theMainView.setCategories(theGame.fetchCategories());
		theMainView.setVisible();

	}

}
