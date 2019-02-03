import javax.swing.*;
import java.awt.event.*;

public class NewQFrame extends JFrame  {
	private JPanel panel;
	private JButton submit;
	private JLabel categorylabel;
	private JLabel questionlabel;
	private JLabel answerlabel;
	private JTextField entercategory;
	private JTextField enterquestion;
	private JTextField enteranswer;
	private String category;
	private String question;
	private String[] answers;
	//private int numCreated = 0;	perhaps for later use


	//Constructor
	public NewQFrame(String title) {
		super(title);
		setupPanel();
		this.setSize(400,400);
		this.add(panel);
	}
	
	private void setupPanel() {
		categorylabel = new JLabel();
		categorylabel.setText("Category:");
		categorylabel.setBounds(10, 10, 50, 50);
		
		questionlabel = new JLabel();
		questionlabel.setText("Question:");
		questionlabel.setBounds(10, 10, 50, 100);
		
		answerlabel = new JLabel();
		answerlabel.setText("Answer:");
		answerlabel.setBounds(10, 10, 50, 100);
		
		entercategory = new JTextField("Enter category here");
		entercategory.setBounds(110, 50, 130, 30);
		
		enterquestion = new JTextField("Enter question here");
		enterquestion.setBounds(110, 50, 130, 30);
		
		enteranswer = new JTextField("Enter answer here");
		enteranswer.setBounds(110, 50, 130, 30);
		
		submit = new JButton("Submit");
		submit.setBounds(100,100,150,50);
		submit.addActionListener(new ActionListener() {	//When submit button is pressed, add new question with user inserted text
				public void actionPerformed(ActionEvent e) {
					if(fieldsOK()) {
						submitQuestion(category, question, answers);
					}	
				}
		});
		
		panel = new JPanel(new SpringLayout());
		panel.add(categorylabel);
		panel.add(entercategory);
		panel.add(questionlabel);
		panel.add(enterquestion);
		panel.add(answerlabel);
		panel.add(enteranswer);
		panel.add(new JLabel("")); //empty label
		panel.add(submit);
		SpringUtilities.makeCompactGrid(panel, 4, 2, 10, 10, 10, 10); //4 rows, 2 columns
	}
	
	
	private boolean fieldsOK() {
		category = entercategory.getText();
		question = enterquestion.getText();
		answers = new String[10];
		answers = enteranswer.getText().split(",");
		
		if (category.equals("Enter category here") || category.replaceAll("\\s+","").equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter category");
			return false;
		}
		else if (question.equals("Enter question here") || question.replaceAll("\\s+","").equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter question");
			return false;
		}
		else if (answers[0].equals("Enter answer here") || answers[0].replaceAll("\\s+","").equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter answer");
			return false;
		}
		else return true;
	}
	
	
	private void submitQuestion(String category, String question, String[] answers) {
		Question newQ = new Question(category, question, answers);
		//tempArrayListofQuestions.add(newQ);		store newQ somewhere
		JOptionPane.showMessageDialog(this, "New question created in category: "+category);
		entercategory.setText(""); //clear fields. User may enter new question(?)
		enterquestion.setText("");
		enteranswer.setText("");
		//numCreated++;
	}

}

