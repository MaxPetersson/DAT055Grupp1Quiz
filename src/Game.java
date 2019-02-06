
import java.util.ArrayList;

public class Game {
    ArrayList<Question> localQuestionBank = new ArrayList<Question>();
    ArrayList<Question> currentQuiz;
    int currentQuestion;



    //hardcoding of 3 questions
    private String[] qtextarray = {"En b�t k�r med en hastighet av fyra knop mot en brygga. En meter fr�n bryggan saktar b�ten ner till tre knop. Har l�ngt tid tar det att laga bryggan?",
            "What is the air-speed velocity of an unladen swallow?",
            "How much wood could a woodchuck chuck if a woodchuck could chuck wood? "};
    private String[] catArr = {"G�tor","Monty Python","Trivia"};
    private ArrayList<String> answers1;
    private ArrayList<String> answers2;
    private ArrayList<String> answers3;

    public Game (){
        currentQuestion = 0;

        //hardcoding of 3 questions
        answers1 = new ArrayList<String>();
        answers1.add("1");

        answers2 = new ArrayList<String>();
        answers2.add("1");

        answers3 = new ArrayList<String>();
        answers3.add("1");

        //Remove later
        localQuestionBank.add(new Question(catArr[0], qtextarray[0], answers1));
        localQuestionBank.add(new Question(catArr[1], qtextarray[1], answers1));
        localQuestionBank.add(new Question(catArr[2], qtextarray[2], answers1));


    }
    //GETTER
    public int getTotalNumberOfQuestionInQuiz(){
        return currentQuiz.size();
    }

    public int getCurrentQuestion(){
        return currentQuestion;
    }


    //SETTER
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
            currentQuestion = 0;
            return true;
        }

    }

    public boolean compareAnswer(String userAnswer) {
    	return currentQuiz.get(currentQuestion).getAnswers().get(0).equals(userAnswer);
    }

    public Question getNextQuestion(){
        return currentQuiz.get(currentQuestion++);

    }

}
