import java.time.LocalDateTime;

public class Question {
    private String category;
    private String questionText;
    private String[] answers;
    private LocalDateTime created;


    //Empty Constructor
    public Question(){
        this.category = "";
        this.questionText = "";
        this.answers = new String[0];
        this.created = LocalDateTime.now();
    }

    //Constructor for category, text and answers
    public Question(String category, String questionText, String[] answers){
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

    public String[] getAnswers(){
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

    public void setAnswers(String[] answers){
        this.answers = answers;
    }

}
