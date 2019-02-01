import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NewQFrame extends JFrame  {
	
	private JButton submit;
	private JFrame questionSubmitted;
	private JLabel questionlabel;
	private JLabel answerlabel;
	private JTextField enterquestion;
	private JTextField enteranswer;



	//Constructor
	public NewQFrame(String title) {
		super(title);
		questionlabel = new JLabel();
		questionlabel.setText("Question:");
		questionlabel.setBounds(10, 10, 100, 100);
		
		answerlabel = new JLabel();
		answerlabel.setText("Answer:");
		answerlabel.setBounds(10, 10, 100, 100);
		
		enterquestion = new JTextField("Enter question here");
		enterquestion.setBounds(110, 50, 130, 30);
		
		enteranswer = new JTextField("Enter answer here");
		enteranswer.setBounds(110, 50, 130, 30);
		
		submit = new JButton("Submit");
		submit.setBounds(100,100,150,50);
		submit.addActionListener(new ActionListener() {
			//Add new question with user inserted text
			
			public void actionPerformed(ActionEvent e) {
				//questionSubmitted = new JFrame("Question submitted");
				//questionSubmitted.setVisible(true);
			}});
		
		
		this.setSize(400,400);
		this.setLayout(new GridLayout(4,2,5,5));
		this.add(questionlabel);
		this.add(enterquestion);
		this.add(answerlabel);
		this.add(enteranswer);
		
		
		this.add(submit);
		
		//frame.getContentPane().setLayout(new GridLayout(3, 1, 4, 4));	
	}

}

