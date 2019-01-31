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

public class main_view {

	private JFrame frame;
	private JTextField textField;

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
		panel_1.setOpaque(false);
		panel_1.setMinimumSize(new Dimension(100, 100));
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("+ Ny Fr\u00E5ga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(50);
		panel_3.setOpaque(false);
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblMainView = new JLabel("Main View");
		lblMainView.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel_3.add(lblMainView);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_2.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_2.add(panel_6, BorderLayout.EAST);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_2.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox = Box.createVerticalBox();
		panel_7.add(verticalBox);
		
		JButton btnStartaQuiz = new JButton("Starta Quiz");
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
		frame.setAlwaysOnTop(true);
		frame.setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 896, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
