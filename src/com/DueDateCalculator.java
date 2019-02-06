package com;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class DueDateCalculator {

	private JFrame frmDueDateCalculator;
	private JTextField txt_EffortTextBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DueDateCalculator window = new DueDateCalculator();
					window.frmDueDateCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DueDateCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	

		//DueDateCalculator Window
		frmDueDateCalculator = new JFrame();
		frmDueDateCalculator.setFont(new Font("Dialog", Font.BOLD, 12));
		frmDueDateCalculator.setTitle("DueDate Calculator");
		frmDueDateCalculator.setBounds(100, 100, 341, 294);
		frmDueDateCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDueDateCalculator.getContentPane().setLayout(null);

		//Start Date label
		JLabel lbl_StartLabel = new JLabel("Start date");
		lbl_StartLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lbl_StartLabel.setBounds(26, 37, 76, 14);
		frmDueDateCalculator.getContentPane().add(lbl_StartLabel);

		//DateChooser field:
		JDateChooser startDateChooser = new JDateChooser();
		startDateChooser.setDateFormatString("MM/dd/yyyy");
		startDateChooser.setBounds(175, 31, 106, 20);
		frmDueDateCalculator.getContentPane().add(startDateChooser);

		//Effort label:
		JLabel lbl_EffortLabel = new JLabel("Effort (days)");
		lbl_EffortLabel.setToolTipText("");
		lbl_EffortLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lbl_EffortLabel.setBounds(26, 90, 128, 14);
		frmDueDateCalculator.getContentPane().add(lbl_EffortLabel);

		//Effort textbox:
		txt_EffortTextBox = new JTextField();
		txt_EffortTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		txt_EffortTextBox.setBounds(175, 84, 106, 20);
		frmDueDateCalculator.getContentPane().add(txt_EffortTextBox);
		txt_EffortTextBox.setColumns(10);

		//Ok Button
		JButton btn_OkButton = new JButton("Ok");
		btn_OkButton.setBounds(26, 147, 255, 23);
		frmDueDateCalculator.getContentPane().add(btn_OkButton);

		//DueDate label
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Calibri", Font.BOLD, 14));
		lblDueDate.setBounds(26, 216, 76, 14);
		frmDueDateCalculator.getContentPane().add(lblDueDate);

		//FinalDate textArea:
		JTextArea finalDueDate = new JTextArea();
		finalDueDate.setEditable(false);
		finalDueDate.setBounds(175, 207, 106, 22);
		frmDueDateCalculator.getContentPane().add(finalDueDate);

		//Date format label:
		JLabel lblMmddyyyy = new JLabel("MM/DD/YYYY");
		lblMmddyyyy.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMmddyyyy.setBounds(212, 192, 65, 14);
		frmDueDateCalculator.getContentPane().add(lblMmddyyyy);

		//Day label:
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDay.setBounds(179, 192, 27, 14);
		frmDueDateCalculator.getContentPane().add(lblDay);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 90, 21);
		frmDueDateCalculator.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(70, 0, 67, 19);
		frmDueDateCalculator.getContentPane().add(mnNewMenu);

		//Action listener for OK button:
		btn_OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");
				final String startDateSelected = SDF.format(startDateChooser.getDate());
				final int effortEntered = Integer.parseInt(txt_EffortTextBox.getText());
				CalculatingDate CD = new CalculatingDate();				
				String dueDate = CD.dateGenerator(startDateSelected, effortEntered);
				finalDueDate.setText(dueDate);

			}
		});

	}
}
