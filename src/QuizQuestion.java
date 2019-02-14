
public class QuizQuestion {

	public String question;
	public String category;
	public int questionNumber;
	public int totalQuestions;

	public QuizQuestion(String question, String category, int questionNumber, int totalQuestions) {

		question = this.question;
		category = this.category;
		questionNumber = this.questionNumber;
		totalQuestions = this.totalQuestions;

	}

	public void setQuestionText(String question) {

		question = this.question;
	}

	public void setCategory(String category) {

		category = this.category;
	}

	public void setQuestionNumber(int questionNumber) {

		questionNumber = this.questionNumber;
	}

	public void setTotalQuestions(int totalQuestions) {

		totalQuestions = this.totalQuestions;
	}

	public void setNewQuestion(String question, String category, int questionNumber, int totalQuestions) {

		this.question = question;
		this.category = category;
		this.questionNumber = questionNumber;
		this.totalQuestions = totalQuestions;

	}

	public String getQuestionText() {

		return question;
	}

	public String getCategory() {

		return category;
	}

	public int getQuestionNumber() {

		return questionNumber;
	}

	public int getTotalQuestions() {

		return totalQuestions;
	}

}
