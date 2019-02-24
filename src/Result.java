import java.util.ArrayList;

public class Result {
	ArrayList<Boolean> results;
	ArrayList<String> answers;
	ArrayList<Question> questions;
	
	Result(ArrayList<Boolean> results, ArrayList<String> answers, ArrayList<Question> questions){
		this.results = results;
		this.answers = answers;
		this.questions = questions;
	}
	public ArrayList<Boolean> getResults(){
		return results;
	}
	public ArrayList<String> getAnswers(){
		return answers;
	}
	public ArrayList<Question> getQuestions(){
		return questions;
	}

}
