import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Main_Window implements Observer {

	private JFrame frame;
	private JTextField qAmount;
	private JPanel cardPane = new JPanel();
	private JTextArea questionTextArea = new JTextArea("");
	private JLabel questionNumberLabel = new JLabel("X");
	private JLabel questionTotLabel = new JLabel("X");
	private JButton newQuestionButton = new JButton("+ New Question");
	private JButton submitButton = new JButton("Submit");
	private JButton startQuizButton = new JButton("Start Quiz");
	private JButton editQuestionsButton = new JButton("Edit Questions");
	private JLabel amountErrorLabel = new JLabel(" ");
	private JLabel categoryLabel = new JLabel("Category");
	private JLabel answerFeedbackLabel = new JLabel(" ");
	private JTextArea resultArea = new JTextArea();
	private JTextField answerField;
	private ArrayList<String> categoryArray;
	private JLabel resultTotLabel = new JLabel("");
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> categoryList = new JList<String>(listModel);
	private DefaultListModel<String> questionsListModel = new DefaultListModel<String>();
	private JList<String> questionList = new JList<String>(questionsListModel);
	private JButton editQuestionButton = new JButton("Edit question");
	private JButton deleteQuestionButton = new JButton("Delete question");
	private JLabel lblResult = new JLabel("Result");
	private JButton refreshButton = new JButton("");

	public Main_Window() {

		initialize();

	}

	private void initialize() {

		frame = new JFrame();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(140, 10));
		panel_1.setBackground(new Color(0, 206, 209));
		panel_1.setMinimumSize(new Dimension(110, 100));
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));

		Box verticalBox_3 = Box.createVerticalBox();
		panel_1.add(verticalBox_3);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		verticalBox_3.add(verticalStrut_7);
		newQuestionButton.setHorizontalAlignment(SwingConstants.TRAILING);
		newQuestionButton.setPreferredSize(new Dimension(125, 25));
		verticalBox_3.add(newQuestionButton);

		newQuestionButton.setVerticalAlignment(SwingConstants.TOP);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalStrut_4.setPreferredSize(new Dimension(0, 10));
		verticalStrut_4.setMinimumSize(new Dimension(0, 10));
		verticalBox_3.add(verticalStrut_4);
		editQuestionsButton.setVisible(false);

		editQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CardLayout cardLayout = (CardLayout) cardPane.getLayout();
				cardLayout.last(cardPane);

			}
		});
		editQuestionsButton.setMaximumSize(new Dimension(125, 25));
		editQuestionsButton.setMinimumSize(new Dimension(125, 25));
		editQuestionsButton.setPreferredSize(new Dimension(125, 25));
		editQuestionsButton.setVerticalAlignment(SwingConstants.TOP);
		verticalBox_3.add(editQuestionsButton);

		JPanel panel_30 = new JPanel();
		panel_30.setPreferredSize(new Dimension(10, 40));
		panel_30.setOpaque(false);
		panel_1.add(panel_30, BorderLayout.SOUTH);

		JButton returnButton = new JButton("< Return");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CardLayout cardLayout = (CardLayout) cardPane.getLayout();
				cardLayout.first(cardPane);
			}
		});
		panel_30.add(returnButton);

		JPanel panel_31 = new JPanel();
		panel_31.setPreferredSize(new Dimension(7, 10));
		panel_31.setMinimumSize(new Dimension(5, 10));
		panel_31.setOpaque(false);
		panel_1.add(panel_31, BorderLayout.WEST);

		cardPane.setOpaque(false);
		panel.add(cardPane, BorderLayout.CENTER);
		cardPane.setLayout(new CardLayout(0, 0));

		JPanel main_pane = new JPanel();
		main_pane.setOpaque(false);
		cardPane.add(main_pane, "name_278414619626250");
		main_pane.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(50);
		panel_3.setOpaque(false);
		main_pane.add(panel_3, BorderLayout.NORTH);

		JLabel lblMainView = new JLabel("Main View");
		lblMainView.setHorizontalTextPosition(SwingConstants.LEFT);
		lblMainView.setHorizontalAlignment(SwingConstants.LEFT);
		lblMainView.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel_3.add(lblMainView);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		main_pane.add(panel_4, BorderLayout.WEST);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		main_pane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_32 = new JPanel();
		panel_32.setOpaque(false);
		panel_5.add(panel_32, BorderLayout.EAST);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		main_pane.add(panel_6, BorderLayout.EAST);

		JPanel panel_7 = new JPanel();
		panel_7.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_7.setOpaque(false);
		main_pane.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAutoscrolls(true);
		verticalBox.setMaximumSize(new Dimension(0, 10));
		panel_7.add(verticalBox);

		JPanel panel_22 = new JPanel();
		panel_22.setOpaque(false);
		verticalBox.add(panel_22);
		panel_22.add(startQuizButton);
		startQuizButton.setAlignmentY(Component.TOP_ALIGNMENT);
		startQuizButton.setFont(new Font("Tahoma", Font.PLAIN, 28));

		Component verticalStrut = Box.createVerticalStrut(30);
		verticalBox.add(verticalStrut);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		JLabel lblKategorier = new JLabel("Categories:");
		horizontalBox_2.add(lblKategorier);
		lblKategorier.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblKategorier.setFont(new Font("Tahoma", Font.PLAIN, 20));

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setMaximumSize(new Dimension(200, 32767));
		horizontalStrut_4.setSize(new Dimension(50, 0));
		horizontalStrut_4.setPreferredSize(new Dimension(50, 0));
		horizontalBox_2.add(horizontalStrut_4);
		refreshButton.setToolTipText("Refresh Categories");
		refreshButton.setMaximumSize(new Dimension(30, 30));
		horizontalBox_2.add(refreshButton);
		refreshButton.setPreferredSize(new Dimension(30, 30));
		refreshButton.setOpaque(false);
		refreshButton.setIcon(
				new ImageIcon(Main_Window.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		verticalStrut_6.setPreferredSize(new Dimension(0, 10));
		verticalStrut_6.setMinimumSize(new Dimension(0, 10));
		verticalBox.add(verticalStrut_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 140));

		verticalBox.add(scrollPane);
		scrollPane.setViewportView(categoryList);
		categoryList.setMinimumSize(new Dimension(10, 0));

		categoryList.setAlignmentY(Component.TOP_ALIGNMENT);
		categoryList.setAlignmentX(Component.RIGHT_ALIGNMENT);
		categoryList.setOpaque(false);

		Component verticalStrut_3 = Box.createVerticalStrut(30);
		verticalBox.add(verticalStrut_3);

		JPanel panel_23 = new JPanel();
		panel_23.setOpaque(false);
		verticalBox.add(panel_23);

		Box horizontalBox = Box.createHorizontalBox();
		panel_23.add(horizontalBox);
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel lblAntalFrgor = new JLabel("Number of questions: ");
		lblAntalFrgor.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblAntalFrgor.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAntalFrgor.setHorizontalAlignment(SwingConstants.LEFT);
		horizontalBox.add(lblAntalFrgor);
		lblAntalFrgor.setFont(new Font("Tahoma", Font.PLAIN, 18));

		qAmount = new JTextField();
		qAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		qAmount.setMaximumSize(new Dimension(30, 50));
		horizontalBox.add(qAmount);
		qAmount.setColumns(3);

		amountErrorLabel.setForeground(Color.RED);
		verticalBox.add(amountErrorLabel);

		JPanel question_pane = new JPanel();
		question_pane.setOpaque(false);
		cardPane.add(question_pane, "name_278418384142294");
		question_pane.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("160px"), ColumnSpec.decode("453px"),
						ColumnSpec.decode("160px"), },
				new RowSpec[] { RowSpec.decode("100px"), RowSpec.decode("387px"), RowSpec.decode("10px"), }));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setPreferredSize(new Dimension(100, 100));
		question_pane.add(panel_2, "1, 1, 3, 1, fill, top");

		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_2.add(panel_15, BorderLayout.NORTH);

		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_15.add(categoryLabel);
		categoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		JPanel panel_16 = new JPanel();
		panel_16.setOpaque(false);
		panel_2.add(panel_16, BorderLayout.SOUTH);

		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_16.add(horizontalBox_1);

		JLabel lblFrga = new JLabel("Question ");
		horizontalBox_1.add(lblFrga);
		lblFrga.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFrga.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFrga.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFrga.setHorizontalAlignment(SwingConstants.RIGHT);
		horizontalBox_1.add(questionNumberLabel);
		questionNumberLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		questionNumberLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		questionNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		questionNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblAv = new JLabel(" of ");
		horizontalBox_1.add(lblAv);
		lblAv.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAv.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAv.setFont(new Font("Tahoma", Font.PLAIN, 24));
		horizontalBox_1.add(questionTotLabel);
		questionTotLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		questionTotLabel.setVerticalAlignment(SwingConstants.BOTTOM);

		questionTotLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JPanel panel_8 = new JPanel();
		panel_8.setMinimumSize(new Dimension(1000, 10));
		panel_8.setOpaque(false);
		question_pane.add(panel_8, "1, 2, left, fill");
		panel_8.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut = Box.createHorizontalStrut(150);
		horizontalStrut.setMaximumSize(new Dimension(4000, 32767));
		horizontalStrut.setMinimumSize(new Dimension(1000, 0));
		panel_8.add(horizontalStrut, BorderLayout.NORTH);

		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_8.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		question_pane.add(panel_9, "1, 3, 3, 1, fill, top");

		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		question_pane.add(panel_10, "3, 2, left, fill");
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_10.add(panel_13, BorderLayout.SOUTH);

		panel_13.add(submitButton);

		JPanel panel_14 = new JPanel();
		panel_14.setOpaque(false);
		panel_10.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Component horizontalStrut_1 = Box.createHorizontalStrut(150);
		panel_14.add(horizontalStrut_1);
		horizontalStrut_1.setMinimumSize(new Dimension(1000, 0));
		horizontalStrut_1.setMaximumSize(new Dimension(4000, 32767));

		answerFeedbackLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_14.add(answerFeedbackLabel);

		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		question_pane.add(panel_11, "2, 2, fill, fill");
		panel_11.setLayout(new BorderLayout(0, 0));

		Box verticalBox_5 = Box.createVerticalBox();
		panel_11.add(verticalBox_5, BorderLayout.NORTH);

		JScrollPane scrollPane_3 = new JScrollPane();
		verticalBox_5.add(scrollPane_3);

		DefaultCaret caret = (DefaultCaret) questionTextArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

		scrollPane_3.setPreferredSize(new Dimension(500, 320));
		scrollPane_3.setViewportView(questionTextArea);

		questionTextArea.setFont(new Font("Calibri", Font.PLAIN, 18));
		questionTextArea.setLineWrap(true);
		questionTextArea.setWrapStyleWord(true);
		questionTextArea.setEditable(false);

		questionTextArea.setMargin(new Insets(2, 2, 20, 2));
		questionTextArea.setRows(10);
		questionTextArea.setColumns(22);

		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_5.add(verticalBox_2);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_2.add(verticalStrut_1);

		JLabel lblSvar = new JLabel("Answer:");
		verticalBox_2.add(lblSvar);
		lblSvar.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSvar.setHorizontalAlignment(SwingConstants.LEFT);

		answerField = new JTextField();
		verticalBox_2.add(answerField);
		answerField.setColumns(10);

		JPanel result_pane = new JPanel();
		result_pane.setOpaque(false);
		cardPane.add(result_pane, "name_1377216972528328");
		result_pane.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel();
		panel_17.setOpaque(false);
		result_pane.add(panel_17, BorderLayout.NORTH);

		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 48));
		panel_17.add(lblResult);

		JPanel panel_18 = new JPanel();
		panel_18.setOpaque(false);
		result_pane.add(panel_18, BorderLayout.WEST);
		panel_18.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_2 = Box.createHorizontalStrut(30);
		horizontalStrut_2.setPreferredSize(new Dimension(100, 0));
		panel_18.add(horizontalStrut_2);

		JPanel panel_21 = new JPanel();
		panel_21.setOpaque(false);
		panel_18.add(panel_21, BorderLayout.SOUTH);

		JPanel panel_19 = new JPanel();
		panel_19.setOpaque(false);
		result_pane.add(panel_19, BorderLayout.EAST);
		panel_19.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(100, 0));
		panel_19.add(horizontalStrut_3);

		JPanel panel_24 = new JPanel();
		panel_24.setOpaque(false);
		panel_19.add(panel_24, BorderLayout.SOUTH);
		resultTotLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));

		panel_24.add(resultTotLabel);

		JPanel panel_20 = new JPanel();
		panel_20.setOpaque(false);
		result_pane.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JList list = new JList();
		panel_20.add(list);

		Box verticalBox_1 = Box.createVerticalBox();
		panel_20.add(verticalBox_1);

		Component verticalStrut_2 = Box.createVerticalStrut(50);
		verticalBox_1.add(verticalStrut_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(null);
		scrollPane_2.setOpaque(false);
		scrollPane_2.setBackground(new Color(135, 206, 235));
		scrollPane_2.setPreferredSize(new Dimension(500, 350));

		verticalBox_1.add(scrollPane_2);

		DefaultCaret caret1 = (DefaultCaret) resultArea.getCaret();
		caret1.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		resultArea.setBackground(new Color(0, 206, 209));
		resultArea.setEditable(false);
		scrollPane_2.setViewportView(resultArea);
		scrollPane_2.getViewport().setOpaque(false);
		resultArea.setWrapStyleWord(true);
		resultArea.setOpaque(false);
		resultArea.setLineWrap(true);
		resultArea.setFont(new Font("Calibri", Font.PLAIN, 16));
		resultArea.setColumns(20);

		JPanel editQuestions_pane = new JPanel();
		editQuestions_pane.setOpaque(false);
		cardPane.add(editQuestions_pane, "name_374809113378669");
		editQuestions_pane.setLayout(new BorderLayout(0, 0));

		JPanel panel_25 = new JPanel();
		panel_25.setOpaque(false);
		editQuestions_pane.add(panel_25, BorderLayout.NORTH);

		JLabel lblEditQuestions = new JLabel("Edit Questions");
		lblEditQuestions.setFont(new Font("Tahoma", Font.PLAIN, 48));
		panel_25.add(lblEditQuestions);

		JPanel panel_26 = new JPanel();
		panel_26.setOpaque(false);
		editQuestions_pane.add(panel_26, BorderLayout.CENTER);
		panel_26.setLayout(new BorderLayout(0, 0));

		Box verticalBox_4 = Box.createVerticalBox();
		panel_26.add(verticalBox_4, BorderLayout.NORTH);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalStrut_5.setPreferredSize(new Dimension(0, 40));
		verticalStrut_5.setMinimumSize(new Dimension(0, 40));
		verticalBox_4.add(verticalStrut_5);

		JPanel panel_28 = new JPanel();
		verticalBox_4.add(panel_28);
		panel_28.setOpaque(false);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(400, 200));
		scrollPane_1.setMaximumSize(new Dimension(400, 400));
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_28.add(scrollPane_1);
		questionList.setMaximumSize(new Dimension(400, 400));

		scrollPane_1.setViewportView(questionList);

		questionList.setVisibleRowCount(4);

		JPanel panel_27 = new JPanel();
		panel_27.setPreferredSize(new Dimension(10, 40));
		panel_27.setOpaque(false);
		panel_26.add(panel_27, BorderLayout.SOUTH);
		panel_27.setLayout(new BorderLayout(0, 0));

		JPanel panel_29 = new JPanel();
		panel_29.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_29.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_27.add(panel_29, BorderLayout.NORTH);

		panel_29.add(editQuestionButton);

		panel_29.add(deleteQuestionButton);
		frame.setAlwaysOnTop(false);
		frame.setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 896, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible() {
		frame.setVisible(true);
	}

	public void addSubmitAnswerListener(ActionListener listenForSubmitAnswer) {

		submitButton.addActionListener(listenForSubmitAnswer);

	}

	public void addRefreshListener(ActionListener listenForRefresh) {

		refreshButton.addActionListener(listenForRefresh);

	}

	public void addEditQuestionsListener(ActionListener listenForEditQuestion) {

		editQuestionButton.addActionListener(listenForEditQuestion);

	}

	public void addDeleteQuestionsListener(ActionListener listenForDeleteQuestion) {

		deleteQuestionButton.addActionListener(listenForDeleteQuestion);

	}

	public void addNewGameListener(ActionListener listenForNewGame) {

		startQuizButton.addActionListener(listenForNewGame);

	}

	public void addNewQuestionListener(ActionListener listenForNewQuestion) {
		newQuestionButton.addActionListener(listenForNewQuestion);
	}

	public void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(frame, errorMessage);

	}

	private void displayQuestion(String category, String question, int totalNumberOfQuestions, int questionNumber) {

		questionTextArea.setText(question);
		questionNumberLabel.setText(Integer.toString(questionNumber));
		categoryLabel.setText(category);
		questionTotLabel.setText(Integer.toString(totalNumberOfQuestions));

		clearAnsFields();

	}

	private void clearAnsFields() {

		answerField.setText("");
		answerFeedbackLabel.setText(" ");

	}

	public void changeToQuizScreen() {

		CardLayout cardLayout = (CardLayout) cardPane.getLayout();

		cardLayout.next(cardPane);

	}

	public void changeToStartScreen() {
		CardLayout cardLayout = (CardLayout) cardPane.getLayout();

		cardLayout.first(cardPane);
	}

	public String getAnswer() {

		return answerField.getText();

	}

	public String getQuizSize() {
		return qAmount.getText();
	}

	private void printResult(ArrayList<Boolean> results, ArrayList<String> answers, ArrayList<Question> questions) {

		resultArea.setRows(results.size());

		String resultText = "";
		int loop = 1;
		int correct = 0;

		for (Boolean i : results) {

			if (i) {

				resultText += "- Question " + loop + ". Correct\n";
				resultText += "---------------------------------\n";
				correct++;

			} else {

				resultText += "- " + loop + ". Wrong\n";
				resultText += "Question: \n" + questions.get(loop - 1).getQuestionText() + "\n\n";
				resultText += "Answer: " + questions.get(loop - 1).getAnswers().get(0) + "\n\n";
				resultText += "Your answer: " + answers.get(loop - 1) + "\n\n";
				resultText += "---------------------------------\n";

			}
			loop++;
		}

		resultArea.setText(resultText);
		lblResult.setText("Result: " + correct + "/" + (loop - 1));

		CardLayout cardLayout = (CardLayout) cardPane.getLayout();

		cardLayout.next(cardPane);

	}

	public List<String> getSelectedCategory() {

		return categoryList.getSelectedValuesList();
	}

	public String getSelectedQuestion() {

		return questionList.getSelectedValue();
	}

	private void setCategories(ArrayList<String> catArr) {

		this.categoryArray = catArr;

		categoryArray.sort(null);

		for (int i = 0; i < categoryArray.size(); i++) {
			listModel.addElement(categoryArray.get(i));

		}

	}

	private void printQuestionsList(ArrayList<Question> questions) {

		Collections.sort(questions, new Comparator<Question>() {
			@Override
			public int compare(Question s1, Question s2) {
				return s1.getCategory().compareToIgnoreCase(s2.getCategory());
			}
		});

		for (int i = 0; i < questions.size(); i++) {

			questionsListModel.addElement(
					i + 1 + ". " + questions.get(i).getCategory() + " - " + questions.get(i).getQuestionText());

		}

	}

	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg) {

		// Display the updated question
		if (o instanceof Game && arg instanceof QuizQuestion) {

			QuizQuestion question = (QuizQuestion) arg;

			displayQuestion(question.getCategory(), question.getQuestionText(), question.getTotalQuestions(),
					question.getQuestionNumber());

		}
		// Update the displayed question/category list.
		if (o instanceof QuestionsClient && arg instanceof ArrayList<?>) {
			// if the length of the sent list is 0 then clear question & category list
			// (if there are no questions left then there are no categories, and vice versa)
			if (((ArrayList<?>) arg).size() < 1) {
				// clear question & category lists.
				questionsListModel.clear();
				listModel.clear();

			}
			// if the elements in the list contains question objects, then update the
			// question list.
			else if (((ArrayList<Question>) arg).get(0) instanceof Question) {

				questionsListModel.clear();
				ArrayList<Question> qArray = (ArrayList<Question>) arg;
				printQuestionsList(qArray);

			}
			// update the category list
			else {

				ArrayList<String> catArr = (ArrayList<String>) arg;

				listModel.clear();
				setCategories(catArr);

			}

		}
		// Display the results.
		if (o instanceof Game && arg instanceof Result) {
			Result result = (Result) arg;
			printResult(result.getResults(), result.getAnswers(), result.getQuestions());
		}

	}

}
