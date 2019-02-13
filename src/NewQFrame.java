import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class NewQFrame extends JFrame {
	private JPanel panel;
	private JButton submit;
	private JLabel categorylabel;
	private JLabel questionlabel;
	private JLabel answerlabel;
	JTextArea categoryTextArea;
	JTextArea questionTextArea;
	JTextArea answerTextArea;
	private JScrollPane categoryScrollPane = new JScrollPane();
	private JScrollPane questionScrollPane = new JScrollPane();
	private JScrollPane answerScrollPane = new JScrollPane();
	private TextPrompt tp;
	private String category;
	private String question;
	private ArrayList<String> answers;
	// private int numCreated = 0; perhaps for later use

	// Constructor
	public NewQFrame(String title) {
		super(title);
		setupPanel();
		this.setBounds(120, 200, 350, 400);
		this.setResizable(false);
		this.add(panel);
		this.pack();
	}

	private void setupPanel() {
		categorylabel = new JLabel("Category:");
		questionlabel = new JLabel("Question:");
		answerlabel = new JLabel("Answer:");

		categoryTextArea = new JTextArea(1, 25);
		initializeTextArea(categoryTextArea, "Enter category", 1);
		setScrollable(categoryScrollPane, categoryTextArea);

		questionTextArea = new JTextArea(6, 25);
		initializeTextArea(questionTextArea, "Enter question", 6);
		setScrollable(questionScrollPane, questionTextArea);

		answerTextArea = new JTextArea(6, 25);
		initializeTextArea(answerTextArea, "Enter answer", 6);
		setScrollable(answerScrollPane, answerTextArea);

		submit = new JButton("Submit");
		submit.setBounds(1, 1, 10, 10);

		panel = new JPanel(new SpringLayout());
		panel.add(categorylabel);
		panel.add(categoryScrollPane);
		panel.add(questionlabel);
		panel.add(questionScrollPane);
		panel.add(answerlabel);
		panel.add(answerScrollPane);
		panel.add(new JLabel("")); // empty label
		panel.add(submit);
		SpringUtilities.makeCompactGrid(panel, 4, 2, 10, 10, 10, 10); // 4 rows, 2 columns
	}

	public String getCategory() {
		return categoryTextArea.getText();
	}

	public String getQuestion() {
		return questionTextArea.getText();
	}

	public ArrayList<String> getAnswers() {
		ArrayList<String> answers = new ArrayList<String>();
		answers.add(questionTextArea.getText());
		return answers;
	}

	// initialize text area and add text prompt
	private void initializeTextArea(JTextArea textArea, String text, int rows) {
		tp = new TextPrompt(text, textArea);
		tp.setForeground(Color.GRAY);
		tp.changeStyle(Font.ITALIC);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		// move focus forward to next textArea (or to the 'submit' button) when TAB key
		// is pressed. If modifier key is held down, move focus backward.
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					if (e.getModifiersEx() > 0) {
						textArea.transferFocusBackward();
					} else {
						textArea.transferFocus();
					}
					e.consume();
				}
			}
		});
	}

	// make text area scrollable
	private void setScrollable(JScrollPane sp, JTextArea ta) {
		sp.setViewportView(ta);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	public void addSubmitNewQuestionListener(ActionListener listenForSubmitQuestion) {
		submit.addActionListener(listenForSubmitQuestion);
	}

	public void displayErrorMessage(String error) {
		JOptionPane.showMessageDialog(this, error);
	}
}
