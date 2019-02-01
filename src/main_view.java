import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.FormFactory;

public class main_view {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_view window = new main_view();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 206, 209));
		panel_1.setMinimumSize(new Dimension(100, 100));
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("+ Ny Fr\u00E5ga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewQFrame newQuestion = new NewQFrame("Create new question");
				newQuestion.setVisible(true);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(btnNewButton);
		
		JPanel card_pane = new JPanel();
		card_pane.setOpaque(false);
		panel.add(card_pane, BorderLayout.CENTER);
		card_pane.setLayout(new CardLayout(0, 0));
		
		JPanel main_pane = new JPanel();
		card_pane.add(main_pane, "name_278414619626250");
		main_pane.setOpaque(false);
		main_pane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(50);
		panel_3.setOpaque(false);
		main_pane.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblMainView = new JLabel("Main View");
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
		panel_7.setOpaque(false);
		main_pane.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox = Box.createVerticalBox();
		panel_7.add(verticalBox);
		
		JButton btnStartaQuiz = new JButton("Starta Quiz");
		btnStartaQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cardLayout = (CardLayout) card_pane.getLayout();
	            cardLayout.next(card_pane);
		
			}
		});
		verticalBox.add(btnStartaQuiz);
		btnStartaQuiz.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		Component verticalStrut = Box.createVerticalStrut(30);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		JLabel lblAntalFrgor = new JLabel("Antal Fr\u00E5gor: ");
		lblAntalFrgor.setHorizontalAlignment(SwingConstants.RIGHT);
		horizontalBox.add(lblAntalFrgor);
		lblAntalFrgor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setMaximumSize(new Dimension(30, 50));
		horizontalBox.add(textField);
		textField.setColumns(3);
		
		JPanel question_pane = new JPanel();
		question_pane.setOpaque(false);
		card_pane.add(question_pane, "name_278418384142294");
		question_pane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("160px"),
				ColumnSpec.decode("453px"),
				ColumnSpec.decode("160px"),},
			new RowSpec[] {
				RowSpec.decode("100px"),
				RowSpec.decode("387px"),
				RowSpec.decode("10px"),}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setPreferredSize(new Dimension(100, 100));
		question_pane.add(panel_2, "1, 1, 3, 1, fill, top");
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblFrga = new JLabel("Fr\u00E5ga");
		lblFrga.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblFrga.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblFrga);
		
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
		
		JButton returnbutton = new JButton("<- \u00C5terg\u00E5");
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cardLayout = (CardLayout) card_pane.getLayout();
	            cardLayout.next(card_pane);
				
			}
		});
		panel_12.add(returnbutton);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		question_pane.add(panel_9, "1, 3, 3, 1, fill, top");
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		question_pane.add(panel_10, "3, 2, left, fill");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(150);
		horizontalStrut_1.setMinimumSize(new Dimension(1000, 0));
		horizontalStrut_1.setMaximumSize(new Dimension(4000, 32767));
		panel_10.add(horizontalStrut_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		question_pane.add(panel_11, "2, 2, fill, fill");
		panel_11.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("40px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("374px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("1px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("202px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("100px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("1px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JTextArea textArea = new JTextArea();
		textArea.setMargin(new Insets(2, 2, 20, 2));
		textArea.setRows(10);
		textArea.setColumns(50);
		panel_11.add(textArea, "2, 2, 3, 1, right, top");
		
		JLabel label = new JLabel("");
		panel_11.add(label, "6, 2, left, center");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_11.add(verticalStrut_1, "4, 4, fill, center");
		
		JLabel lblSvar = new JLabel("Svar:");
		panel_11.add(lblSvar, "2, 6, left, center");
		lblSvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSvar.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField_1 = new JTextField();
		panel_11.add(textField_1, "4, 6");
		textField_1.setMaximumSize(new Dimension(2147483647, 30));
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		panel_11.add(label_1, "4, 8, center, top");
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setPreferredSize(new Dimension(400, 100));
		verticalBox_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_11.add(verticalBox_1, "4, 10, left, top");
		frame.setAlwaysOnTop(false);
		frame.setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 896, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
