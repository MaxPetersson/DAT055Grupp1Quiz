import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private String category;
    private String questionText;
    private ArrayList<String> answers;
    private LocalDateTime created;


    //Empty Constructor
    public Question(){
        this.category = "";
        this.questionText = "";
        this.answers.add("");
        this.created = LocalDateTime.now();
    }

    //Constructor for category, text and answers
    public Question(String category, String questionText, ArrayList<String> answers){
        this.category = category;
        this.questionText = questionText;
        this.answers = answers;
        this.created = LocalDateTime.now();
    }

    //Getters
    public String getCategory(){
        return this.category;
    }

    public String getQuestionText(){
        return this.questionText;
    }

    public ArrayList<String> getAnswers(){
        return this.answers;
    }

    public LocalDateTime getCreated(){
        return this.created;
    }

    //Setters
    public void setCategory(String category){
        this.category = category;
    }

    public void setQuestionTextonText(String questionText){
        this.questionText = questionText;
    }

    public void setAnswers(ArrayList<String> answers){
        this.answers = answers;
    }

}
