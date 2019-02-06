import java.util.ArrayList;

public class Game {
    ArrayList<Question> localQuestionBank = new ArrayList<Question>();
    ArrayList<Question> currentQuiz;
    public Game (){

    }

    public void addQuestionToLocalQuestionBank (Question qToAdd){
        localQuestionBank.add(qToAdd);
    }

    //returns true if quiz generated successfully
    //returns false if it didnt (most likely because there wasnt enough questions
    //Set nrOfQuestions to max?
    public boolean generateQuiz(int nrOfQuestions){
        if (nrOfQuestions > localQuestionBank.size()){
            return false;
        }
        else
        {
            currentQuiz = new ArrayList<Question>();
            for (int i = 0; i <= nrOfQuestions; i++){
                currentQuiz.add(localQuestionBank.get(i));
            }

            return true;
        }

    }

    public Question getNextQuestion(int index){
        return currentQuiz.get(index);

    }

}
