
public class Main {

	public static void main(String[] args) {
		final Game theGame = new Game();
		final main_view theMainView = new main_view();
		final NewQFrame theNewQFrame = new NewQFrame("QuestionFrame");
		final Controller theController = new Controller(theMainView, theNewQFrame, theGame);
		
		theMainView.setVisible();
		
	}

}
