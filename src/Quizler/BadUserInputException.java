package Quizler;

/**
 * Throws an exception with the input errorMessage
 * 
 * @author Oscar Thureborn
 * @version 2019-03-08
 *
 */
public class BadUserInputException extends Exception {
	public BadUserInputException(String errorMessage) {
		super(errorMessage);
	}
}
