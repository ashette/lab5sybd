package dataBase;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Connect {

	JFrame frame;

	JTextField txt_server;
	 JTextField txt_database;
	 JTextField txt_username;
	 JTextField txt_port;
	 JTextField txt_passw;	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connect window = new Connect();
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
	public Connect() {
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
		
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(31, 38, 46, 14);
		frame.getContentPane().add(lblServer);
		
		
		txt_server = new JTextField();
		txt_server.setText("localhost");
		txt_server.setBounds(75, 35, 86, 20);
		frame.getContentPane().add(txt_server);
		txt_server.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Database");
		lblNewLabel.setBounds(171, 38, 66, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txt_database = new JTextField();
		txt_database.setText("sklad");
		txt_database.setBounds(247, 35, 66, 20);
		frame.getContentPane().add(txt_database);
		txt_database.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(94, 99, 110, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txt_username = new JTextField();
		txt_username.setText("postgres");
		txt_username.setBounds(194, 96, 86, 20);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(94, 127, 90, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Port");
		lblNewLabel_2.setBounds(323, 38, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txt_port = new JTextField();
		txt_port.setText("5432");
		txt_port.setBounds(350, 35, 46, 20);
		frame.getContentPane().add(txt_port);
		txt_port.setColumns(10);
		
		txt_passw = new JTextField();
		txt_passw.setText("1111");
		txt_passw.setBounds(194, 124, 86, 20);
		frame.getContentPane().add(txt_passw);
		txt_passw.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main main = new Main();
				try {
					main.Connect();
				frame.dispose();	
				main.main.setVisible(true);
				
				
				} catch (ClassNotFoundException e) {					
					JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				
			}
		});
		btnConnect.setBounds(171, 190, 89, 23);
		frame.getContentPane().add(btnConnect);
		
		
		
	}
	
	
	
}
