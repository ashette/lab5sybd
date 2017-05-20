package dataBase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("rawtypes")

public class AdditionNew {

	JFrame frame;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JPanel contentPane;
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	JLabel label_3;
	JLabel label_4;
	JButton button;
	JComboBox comboBox_1;
	JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdditionNew window = new AdditionNew();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdditionNew() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 28, 86, 20);
		frame.getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 54, 86, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 85, 86, 20);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 116, 86, 20);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 145, 86, 20);
		frame.getContentPane().add(textField_4);

		label = new JLabel("New label");
		label.setBounds(68, 28, 109, 14);
		frame.getContentPane().add(label);

		label_1 = new JLabel("New label");
		label_1.setBounds(68, 54, 109, 14);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("New label");
		label_2.setBounds(68, 85, 113, 14);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("New label");
		label_3.setBounds(68, 116, 113, 14);
		frame.getContentPane().add(label_3);

		label_4 = new JLabel("New label");
		label_4.setBounds(68, 145, 113, 14);
		frame.getContentPane().add(label_4);

		button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// frame.setVisible(false);
				frame.dispose();

			}
		});
		button.setBounds(118, 189, 89, 23);
		frame.getContentPane().add(button);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(219, 28, 167, 20);
		frame.getContentPane().add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(219, 54, 167, 20);
		frame.getContentPane().add(comboBox_2);

	}

	public void setAction(ActionListener al) {
		button.addActionListener(al);
	}

	public ArrayList<String> addition(String thisTable) {

		ArrayList<String> doplist = new ArrayList<String>();
		if (thisTable.equals("sellings")) {

			// doplist.add(textField.getText());
			// doplist.add(textField_1.getText());
			doplist.add(comboBox_1.getSelectedItem().toString().split("-")[0]);
			doplist.add(comboBox_2.getSelectedItem().toString().split("-")[0]);
			doplist.add(textField_2.getText());
			doplist.add(textField_3.getText());
			doplist.add(textField_4.getText());

		} else if (thisTable.equals("listofincominggoods")) {

			// doplist.add(textField.getText());
			doplist.add(comboBox_1.getSelectedItem().toString().split("-")[0]);
			doplist.add(textField_2.getText());
			doplist.add(textField_3.getText());
			doplist.add(textField_4.getText());
			doplist.add(comboBox_2.getSelectedItem().toString().split("-")[0]);

		} else if (thisTable.equals("range")) {

			doplist.add(textField.getText());
			doplist.add(textField_1.getText());
			doplist.add(textField_2.getText());
			doplist.add(textField_3.getText());

		} else if (thisTable.equals("supply")) {

			doplist.add(textField.getText());
			// doplist.add(textField_1.getText());

		} else if (thisTable.equals("clients")) {

			doplist.add(textField.getText());
			doplist.add(textField_1.getText());

		}
		return doplist;
	}

	public ArrayList<String> update(String thisTable) {

		ArrayList<String> doplist = new ArrayList<String>();
		if (thisTable.equals("sellings")) {

			// doplist.add(textField.getText());
			// doplist.add(textField_1.getText());
			doplist.add(comboBox_1.getSelectedItem().toString().split("-")[0]);
			doplist.add(comboBox_2.getSelectedItem().toString().split("-")[0]);
			doplist.add(textField_2.getText());
			doplist.add(textField_3.getText());
			doplist.add(textField_4.getText());

		} else if (thisTable.equals("listofincominggoods")) {

			doplist.add(comboBox_1.getSelectedItem().toString().split("-")[0]);
			doplist.add(textField_2.getText());
			doplist.add(textField_3.getText());
			doplist.add(textField_4.getText());
			doplist.add(comboBox_2.getSelectedItem().toString().split("-")[0]);
			// doplist.add(textField_4.getText());

		} else if (thisTable.equals("range")) {

			doplist.add(textField.getText());
			doplist.add(textField_1.getText());
			doplist.add(textField_2.getText());
			doplist.add(textField_3.getText());

		} else if (thisTable.equals("supply")) {

			doplist.add(textField.getText());

		} else if (thisTable.equals("clients")) {

			doplist.add(textField.getText());

		}

		return doplist;
	}

	public JComboBox getComboBox1() {

		return comboBox_1;

	}

	public JComboBox getComboBox2() {

		return comboBox_2;

	}

}
