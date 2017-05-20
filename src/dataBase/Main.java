package dataBase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import Controllers.InterfaceController;
//import Tables.InterfaceTable;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Main {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	JFrame main;
	Connection connection;
	Statement statement;
	String thisTable;
	private JTable table;
	MainInterface controller;
	JComboBox<Integer> comboBox;
	// private ArrayList<InterfaceTable> listTable = new
	// ArrayList<InterfaceTable>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	@SuppressWarnings("unchecked")
	public void initialize() {
		main = new JFrame();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setBounds(100, 100, 717, 394);
		main.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();

		// ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 11, 681, 200);
		main.getContentPane().add(scrollPane);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setEnabled(false);
		table.setBounds(10, 11, 681, 200);
		main.getContentPane().add(table);

		JButton btnAdd = new JButton("Add New");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdditionNew addition = new AdditionNew();
				if (thisTable.equals("listofincominggoods")) {

					addition.label.setText("DateOfSupply");
					addition.label_2.setText("Price");
					addition.label_3.setText("QuantitySupply");
					addition.label_4.setText("Size");
					addition.label_1.setText("NameOfStuff");
					addition.textField.setVisible(false);
					addition.textField_1.setVisible(false);

					try {
						controller = new SupplyCtrler();
						controller.loadTable(statement);
						loadComboBoxList(addition.getComboBox1());
						controller = new RangeCtrler();
						controller.loadTable(statement);
						loadComboBoxList(addition.getComboBox2());
						controller = new LOIGCtrler();
						controller.loadTable(statement);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (thisTable.equals("sellings")) {

					addition.label.setText("NameOfStuff");
					addition.label_1.setText("ClientCard");
					addition.label_2.setText("QuantityOfSold");
					addition.label_3.setText("DateOfSelling");
					addition.label_4.setText("Sum");
					addition.textField.setVisible(false);
					addition.textField_1.setVisible(false);
					try {
						controller = new RangeCtrler();
						controller.loadTable(statement);
						loadComboBoxList(addition.getComboBox1());
						controller = new ClientsCtrler();
						controller.loadTable(statement);
						loadComboBoxList(addition.getComboBox2());
						controller = new SellingsCtrler();
						controller.loadTable(statement);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (thisTable.equals("range")) {

					addition.label.setText("Name");
					addition.label_1.setText("Factory");
					addition.label_2.setText("Model");
					addition.label_3.setText("Certificate");
					addition.label_4.setVisible(false);
					addition.textField_4.setVisible(false);
					addition.comboBox_1.setVisible(false);
					addition.comboBox_2.setVisible(false);

				} else if (thisTable.equals("supply")) {

					addition.label.setText("DateOfSupply");
					addition.label_1.setVisible(false);
					addition.textField_1.setVisible(false);
					addition.label_2.setVisible(false);
					addition.textField_2.setVisible(false);
					addition.label_3.setVisible(false);
					addition.textField_3.setVisible(false);
					addition.label_4.setVisible(false);
					addition.textField_4.setVisible(false);
					addition.comboBox_1.setVisible(false);
					addition.comboBox_2.setVisible(false);

				} else if (thisTable.equals("clients")) {

					addition.label.setText("ClientCard");
					addition.label_1.setText("Discount");
					addition.label_2.setVisible(false);
					addition.textField_2.setVisible(false);
					addition.label_3.setVisible(false);
					addition.textField_3.setVisible(false);
					addition.label_4.setVisible(false);
					addition.textField_4.setVisible(false);
					addition.comboBox_1.setVisible(false);
					addition.comboBox_2.setVisible(false);

				}

				ActionListener al = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {

							ArrayList<String> doplist = new ArrayList<String>();
							doplist.addAll(addition.addition(thisTable));

							controller.insertRow(statement, doplist);
							controller = new LOIGCtrler();
							selectTable(controller);
						} catch (Exception ex) {

							JOptionPane.showMessageDialog(null, ex.getMessage());
							ex.printStackTrace();

						}

					}
				};
				addition.setAction(al);
				addition.frame.setVisible(true);

			}
		});
		btnAdd.setBounds(10, 239, 89, 23);
		main.getContentPane().add(btnAdd);

		JButton btnUpdate = new JButton("Edit");
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					AdditionNew addition = new AdditionNew();
					addition.button.setText("Update");
					if (thisTable.equals("listofincominggoods")) {

						addition.label.setText("DateOfSupply");
						addition.label_2.setText("Price");
						addition.label_3.setText("QuantitySupply");
						addition.label_4.setText("Size");
						addition.label_1.setText("NameOfStuff");
						addition.textField.setVisible(false);
						addition.textField_1.setVisible(false);

						try {
							controller = new SupplyCtrler();
							controller.loadTable(statement);
							loadComboBoxList(addition.getComboBox1());
							controller = new RangeCtrler();
							controller.loadTable(statement);
							loadComboBoxList(addition.getComboBox2());
							controller = new LOIGCtrler();
							controller.loadTable(statement);

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (thisTable.equals("sellings")) {

						addition.label.setText("NameOfStuff");
						addition.label_1.setText("ClientCard");
						addition.label_2.setText("QuantityOfSold");
						addition.label_4.setText("Sum");
						addition.label_3.setText("DateOfSelling");

						addition.textField.setVisible(false);
						addition.textField_1.setVisible(false);
						try {
							controller = new RangeCtrler();
							controller.loadTable(statement);
							loadComboBoxList(addition.getComboBox1());
							controller = new ClientsCtrler();
							controller.loadTable(statement);
							loadComboBoxList(addition.getComboBox2());
							controller = new SellingsCtrler();
							controller.loadTable(statement);

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (thisTable.equals("range")) {

						addition.label.setText("Name");
						addition.label_1.setText("Factory");
						addition.label_2.setText("Model");
						addition.label_3.setText("Certificate");
						addition.label_4.setVisible(false);
						addition.textField_4.setVisible(false);
						addition.comboBox_1.setVisible(false);
						addition.comboBox_2.setVisible(false);

					} else if (thisTable.equals("supply")) {

						addition.label.setText("DateOfSupply");
						addition.label_1.setVisible(false);
						addition.textField_1.setVisible(false);
						addition.label_2.setVisible(false);
						addition.textField_2.setVisible(false);
						addition.label_3.setVisible(false);
						addition.textField_3.setVisible(false);
						addition.label_4.setVisible(false);
						addition.textField_4.setVisible(false);
						addition.comboBox_1.setVisible(false);
						addition.comboBox_2.setVisible(false);

					} else if (thisTable.equals("clients")) {

						addition.label.setText("Discount");
						addition.label_1.setVisible(false);
						addition.textField_1.setVisible(false);
						addition.label_2.setVisible(false);
						addition.textField_2.setVisible(false);
						addition.label_3.setVisible(false);
						addition.textField_3.setVisible(false);
						addition.label_4.setVisible(false);
						addition.textField_4.setVisible(false);
						addition.comboBox_1.setVisible(false);
						addition.comboBox_2.setVisible(false);

					}
					ActionListener al = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								ArrayList<String> doplist = addition.update(thisTable);

								doplist.add((comboBox.getSelectedItem().toString()));
								controller.updateRow(statement, doplist);
								selectTable(controller);
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null, ex.getMessage());
								ex.printStackTrace();
							}

						}
					};
					addition.setAction(al);
					addition.frame.setVisible(true);
				} catch (Exception exx) {

					exx.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(109, 239, 89, 23);
		main.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					controller.deleteRow(statement, (int) comboBox.getSelectedItem());
					selectTable(controller);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});
		btnDelete.setBounds(208, 239, 89, 23);
		main.getContentPane().add(btnDelete);
		JLabel lblselect = new JLabel("");
		lblselect.setBounds(10, 298, 681, 14);
		main.getContentPane().add(lblselect);
		comboBox = new JComboBox<Integer>();
		comboBox.setBounds(307, 240, 89, 20);
		main.getContentPane().add(comboBox);

		JButton btnSelect = new JButton("Select #1");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selection(
						"select sum (sum) as total from sellings where dateofselling between ('19.06.2017') and ('26.06.2017')");
				lblselect.setText(
						"select sum (sum) as total from sellings where dateofselling between ('19.06.2017') and ('26.06.2017')");
			}
		});
		btnSelect.setBounds(406, 239, 89, 23);
		main.getContentPane().add(btnSelect);

		JButton btnSelect_1 = new JButton("Select #2");
		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection("select * from listofincominggoods where size >= 380;");
				lblselect.setText("select * from listofincominggoods where size >= 380;");

			}
		});
		btnSelect_1.setBounds(505, 239, 89, 23);
		main.getContentPane().add(btnSelect_1);

		JButton btnSelect_2 = new JButton("Select #3");
		btnSelect_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection(
						"select quantitysupply, price from listofincominggoods where numberofstuff in (select numberofstuff from range where name like 'Table%');");
				lblselect.setText(
						"select quantitysupply, price from listofincominggoods where numberofstuff in (select numberofstuff from range where name like 'Table%');");
			}
		});
		btnSelect_2.setBounds(604, 239, 89, 23);
		main.getContentPane().add(btnSelect_2);

		JMenuBar menuBar = new JMenuBar();
		main.setJMenuBar(menuBar);

		JMenu mnConnection = new JMenu("Connection");
		menuBar.add(mnConnection);

		JMenuItem mntmNewConnection = new JMenuItem("New connection");
		mntmNewConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connect c = new Connect();
				c.frame.setVisible(true);
				main.setVisible(false);

			}
		});
		mnConnection.add(mntmNewConnection);

		JMenuItem mntmDisconnect = new JMenuItem("Disconnect");
		mntmDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (connection != null) {
						statement.close();
						connection.close();
						JOptionPane.showMessageDialog(null, "Disconnected successfully");
						Connect c = new Connect();
						c.frame.setVisible(true);
						main.setVisible(false);
					} else {

						JOptionPane.showMessageDialog(null, "NOT Connected");
						return;
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		mnConnection.add(mntmDisconnect);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		mnConnection.add(mntmExit);

		JMenu mnDirectories = new JMenu("Directories");
		menuBar.add(mnDirectories);

		JMenuItem mntmListOfGoods = new JMenuItem("List of incoming goods");
		mntmListOfGoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller = new LOIGCtrler();
				try {
					selectTable(controller);
					thisTable = "listofincominggoods";
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		});
		mnDirectories.add(mntmListOfGoods);

		JMenuItem mntmSellings = new JMenuItem("Sellings");
		mntmSellings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller = new SellingsCtrler();
				try {
					selectTable(controller);
					thisTable = "sellings";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnDirectories.add(mntmSellings);

		JMenuItem mntmRange = new JMenuItem("Range");
		mntmRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller = new RangeCtrler();
				try {
					selectTable(controller);
					thisTable = "range";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		mnDirectories.add(mntmRange);

		JMenuItem mntmClients = new JMenuItem("Clients");
		mntmClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller = new ClientsCtrler();
				try {
					selectTable(controller);
					thisTable = "clients";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		mnDirectories.add(mntmClients);

		JMenuItem mntmSupply = new JMenuItem("Supply");
		mntmSupply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				controller = new SupplyCtrler();
				try {
					selectTable(controller);
					thisTable = "supply";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		mnDirectories.add(mntmSupply);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

	}

	public void Connect() throws ClassNotFoundException, SQLException {

		String url = "";
		String username = "";
		String password = "";
		Connect c = new Connect();
		Class.forName("org.postgresql.Driver");
		url = "jdbc:postgresql://" + c.txt_server.getText() + ":" + c.txt_port.getText() + "/"
				+ c.txt_database.getText();
		username = c.txt_username.getText();
		password = c.txt_passw.getText();
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement();

		JOptionPane.showMessageDialog(null, "Подключение прошло успешно.");
		c.frame.dispose();

	}

	public void loadComboBox() {
		comboBox.removeAllItems();
		try {
			for (int i = 0; i < controller.loadTable(statement).size(); i++) {
				comboBox.addItem(controller.loadTable(statement).get(i).getPrimaryKey());

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void loadComboBoxList(JComboBox<String> cB) {

		try {
			ArrayList<InterfaceTable> list = controller.loadTable(statement);

			cB.removeAllItems();

			for (int i = 0; i < list.size(); i++) {
				cB.addItem(list.get(i).getPrimaryKey() + "-" + list.get(i).getForeignKey());

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void selectTable(MainInterface controller) throws SQLException {
		try {
			controller.loadTable(statement);
			loadComboBox();
			table.removeAll();
			table = new JTable(controller.getRowData(statement), controller.getColumnName(statement));
			main.getContentPane().add(table);
			scrollPane.setViewportView(table);
			table.updateUI();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void selection(String s) {

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> columnNames = new Vector<String>();

		try {
			ResultSet rs = statement.executeQuery(s);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(md.getColumnName(i));
			}
			columns = md.getColumnCount();
			while (rs.next()) {
				Vector<String> row = new Vector<String>(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(rs.getObject(i).toString());
				}
				data.addElement(row);
				dtm.setDataVector(data, columnNames);
			}
			rs.close();
			table.removeAll();
			table = new JTable(dtm);

			main.getContentPane().add(table);
			scrollPane.setViewportView(table);
			table.updateUI();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}
}
