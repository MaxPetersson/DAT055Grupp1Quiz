import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class NewQFrame extends JFrame  {
	private JPanel panel;
	private JButton submit;
	private JLabel categorylabel;
	private JLabel questionlabel;
	private JLabel answerlabel;
	private JTextArea entercategory;
	private JTextArea enterquestion;
	private JTextArea enteranswer;
	private String category;
	private String question;
	private ArrayList<String> answers;
	//private int numCreated = 0;	perhaps for later use


	//Constructor
	public NewQFrame(String title) {
		super(title);
		setupPanel();
		this.setBounds(120, 200, 350, 300);
		this.setPreferredSize(new Dimension(350,300));
		this.setMinimumSize(new Dimension(350,300));
		this.setMaximumSize(new Dimension(350,500));
		this.add(panel);
	}
	
	private void setupPanel() {
		categorylabel = new JLabel("Category:");
		questionlabel = new JLabel("Question:");
		answerlabel = new JLabel("Answer:");
		
		entercategory = new JTextArea(2, 30);
		entercategory.setPreferredSize(new Dimension(100,30));
		entercategory.setMinimumSize(new Dimension(100,30));
		entercategory.setMaximumSize(new Dimension(100,30));
		entercategory.setLineWrap(true);
		entercategory.setWrapStyleWord(true);
		TextPrompt c = new TextPrompt("Enter category", entercategory); //display if text area is empty
		c.setForeground(Color.GRAY);
		c.changeStyle(Font.ITALIC);
		
		enterquestion = new JTextArea(5, 50);
		enterquestion.setPreferredSize(new Dimension (100,50));
		enterquestion.setLineWrap(true);
		enterquestion.setWrapStyleWord(true);
		TextPrompt q = new TextPrompt("Enter question", enterquestion); 
		q.setForeground(Color.GRAY);
		q.changeStyle(Font.ITALIC);
		
		enteranswer = new JTextArea(5, 50);
		enteranswer.setPreferredSize(new Dimension (100,50));
		enteranswer.setLineWrap(true);
		enteranswer.setWrapStyleWord(true);
		TextPrompt a = new TextPrompt("Enter answer", enteranswer); 
		a.setForeground(Color.GRAY);
		a.changeStyle(Font.ITALIC);
		
		submit = new JButton("Submit");
		submit.setBounds(1,1,10,10);
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
		answers = new ArrayList<String>();
		String[] tempAnswers = enteranswer.getText().split(",");
		for(String s: tempAnswers)
		{
			answers.add(s);
		}
		
		if (category.replaceAll("\\s+","").equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter category");
			return false;
		}
		else if (question.replaceAll("\\s+","").equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter question");
			return false;
		}
		else if (tempAnswers[0].replaceAll("\\s+","").equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter answer");
			return false;
		}
		else return true;
	}
	
	
	private void submitQuestion(String category, String question, ArrayList<String> answers) {
		
		Question newQ = new Question(category, question, answers);
		//tempArrayListofQuestions.add(newQ);		store newQ somewhere
		JOptionPane.showMessageDialog(this, "New question created in category: "+category);
		entercategory.setText(""); //clear fields. User may enter new question(?)
		enterquestion.setText("");
		enteranswer.setText("");
		//numCreated++;
	}

}

