import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;


    public Quiz (int numberOfQuestions){
        questions = new ArrayList<Question>();
    }


    public int getQuizLength(){
        return this.questions.size();
    }

}
