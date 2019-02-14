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
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class main_view implements Observer {

	private JFrame frame;
	private JTextField qAmount;
	private JPanel card_pane = new JPanel();
	private JTextArea qtextarea = new JTextArea();
	private JLabel qnolabel = new JLabel("X");
	private JLabel qtotlabel = new JLabel("X");
	private JButton newQuestionButton = new JButton("+ New Question");
	private JButton submitbutton = new JButton("Submit");
	private JButton startQuizButton = new JButton("Start Quiz");
	private JLabel amountErrorLabel = new JLabel(" ");
	private JLabel catLabel = new JLabel("Category");
	private JLabel answerFeedbackLabel = new JLabel(" ");
	private JTextArea resultArea = new JTextArea();
	private JTextField answerField;

	public void setVisible() {
		frame.setVisible(true);
	}

	public main_view() {

		initialize();

	}

	private void initialize() {

		frame = new JFrame();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 206, 209));
		panel_1.setMinimumSize(new Dimension(100, 100));
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		newQuestionButton.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(newQuestionButton);

		card_pane.setOpaque(false);
		panel.add(card_pane, BorderLayout.CENTER);
		card_pane.setLayout(new CardLayout(0, 0));

		JPanel main_pane = new JPanel();
		main_pane.setOpaque(false);
		card_pane.add(main_pane, "name_278414619626250");
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

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		main_pane.add(panel_6, BorderLayout.EAST);

		JPanel panel_7 = new JPanel();
		panel_7.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_7.setOpaque(false);
		main_pane.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox = Box.createVerticalBox();
		panel_7.add(verticalBox);

		JPanel panel_22 = new JPanel();
		panel_22.setOpaque(false);
		verticalBox.add(panel_22);
		panel_22.add(startQuizButton);
		startQuizButton.setAlignmentY(Component.TOP_ALIGNMENT);
		startQuizButton.setFont(new Font("Tahoma", Font.PLAIN, 28));

		Component verticalStrut = Box.createVerticalStrut(30);
		verticalBox.add(verticalStrut);

		JPanel panel_23 = new JPanel();
		panel_23.setOpaque(false);
		verticalBox.add(panel_23);

		Box horizontalBox = Box.createHorizontalBox();
		panel_23.add(horizontalBox);
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel lblAntalFrgor = new JLabel("Amount of Questions: ");
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
		card_pane.add(question_pane, "name_278418384142294");
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

		catLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_15.add(catLabel);
		catLabel.setHorizontalAlignment(SwingConstants.RIGHT);

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
		horizontalBox_1.add(qnolabel);
		qnolabel.setVerticalAlignment(SwingConstants.BOTTOM);
		qnolabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		qnolabel.setHorizontalAlignment(SwingConstants.RIGHT);

		qnolabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblAv = new JLabel(" of ");
		horizontalBox_1.add(lblAv);
		lblAv.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAv.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAv.setFont(new Font("Tahoma", Font.PLAIN, 24));
		horizontalBox_1.add(qtotlabel);
		qtotlabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		qtotlabel.setVerticalAlignment(SwingConstants.BOTTOM);

		qtotlabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

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

		JButton returnbutton = new JButton("< Return");
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cardLayout = (CardLayout) card_pane.getLayout();
				cardLayout.first(card_pane);

			}
		});
		panel_12.add(returnbutton);

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

		panel_13.add(submitbutton);

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
		FormLayout fl_panel_11 = new FormLayout(
				new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("40px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("374px:grow"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("1px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("16px"), },
				new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("202px"), FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("100px"), FormFactory.LINE_GAP_ROWSPEC,
						RowSpec.decode("1px"), FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), });
		panel_11.setLayout(fl_panel_11);

		qtextarea.setFont(new Font("Calibri", Font.PLAIN, 18));
		qtextarea.setLineWrap(true);
		qtextarea.setWrapStyleWord(true);

		qtextarea.setMargin(new Insets(2, 2, 20, 2));
		qtextarea.setRows(10);
		qtextarea.setColumns(50);
		panel_11.add(qtextarea, "4, 2, right, top");

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_11.add(verticalStrut_1, "4, 4, fill, center");

		Box verticalBox_2 = Box.createVerticalBox();
		panel_11.add(verticalBox_2, "4, 6");

		JLabel lblSvar = new JLabel("Answer:");
		lblSvar.setAlignmentY(Component.TOP_ALIGNMENT);
		verticalBox_2.add(lblSvar);
		lblSvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSvar.setHorizontalAlignment(SwingConstants.LEFT);

		answerField = new JTextField();
		verticalBox_2.add(answerField);
		answerField.setColumns(10);

		JPanel result_pane = new JPanel();
		result_pane.setOpaque(false);
		card_pane.add(result_pane, "name_1377216972528328");
		result_pane.setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel();
		panel_17.setOpaque(false);
		result_pane.add(panel_17, BorderLayout.NORTH);

		JLabel lblResult = new JLabel("Result");
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

		JButton resultReturn = new JButton("< Return");
		panel_21.add(resultReturn);
		resultReturn.setAlignmentX(Component.CENTER_ALIGNMENT);
		resultReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cardLayout = (CardLayout) card_pane.getLayout();
				cardLayout.first(card_pane);
			}
		});

		JPanel panel_19 = new JPanel();
		panel_19.setOpaque(false);
		result_pane.add(panel_19, BorderLayout.EAST);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(100, 0));
		panel_19.add(horizontalStrut_3);

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
		resultArea.setOpaque(false);

		resultArea.setFont(new Font("Calibri", Font.PLAIN, 28));
		resultArea.setColumns(20);
		verticalBox_1.add(resultArea);
		frame.setAlwaysOnTop(false);
		frame.setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 896, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addSubmitAnswerListener(ActionListener listenForSubmitAnswer) {

		submitbutton.addActionListener(listenForSubmitAnswer);

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

	public void displayQuestion(String category, String qtext, int qtot, int qnumber) {

		qtextarea.setText(qtext);
		qnolabel.setText(Integer.toString(qnumber));
		catLabel.setText(category);
		qtotlabel.setText(Integer.toString(qtot));

		clearAnsFields();

	}

	private void clearAnsFields() {

		answerField.setText("");
		answerFeedbackLabel.setText(" ");

	}

	public void changeToQuizScreen() {

		CardLayout cardLayout = (CardLayout) card_pane.getLayout();

		cardLayout.next(card_pane);

	}

	public void changeToStartScreen() {
		CardLayout cardLayout = (CardLayout) card_pane.getLayout();

		cardLayout.first(card_pane);
	}

	public void displayResult(ArrayList<Boolean> list) {

	};

	public String getAnswer() {

		return answerField.getText();

	}

	public String getQuizSize() {
		return qAmount.getText();
	}

	public void printResult(ArrayList<Boolean> results) {

		resultArea.setRows(results.size());

		String resultText = "";
		int loop = 1;

		for (Boolean i : results) {

			if (i) {

				resultText += "- " + loop + ". Rätt\n";

			} else {

				resultText += "- " + loop + ". Fel\n";

			}
			loop++;
		}

		resultArea.setText(resultText);

		CardLayout cardLayout = (CardLayout) card_pane.getLayout();
		cardLayout.last(card_pane);
	}

	public void update(Observable o, Object arg) {

		if (o instanceof Game && arg instanceof QuizQuestion) {

			QuizQuestion question = (QuizQuestion) arg;

			displayQuestion(question.getCategory(), question.getQuestionText(), question.getTotalQuestions(),
					question.getQuestionNumber());

		}

	}

}
