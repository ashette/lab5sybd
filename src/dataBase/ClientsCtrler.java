package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

public class ClientsCtrler extends MainCtrler {

	@Override
	public ResultSet selectTable(Statement s) throws SQLException {

		return s.executeQuery("Select * from clients");
	}

	@Override
	public void insertRow(Statement s, ArrayList<String> list) throws SQLException {
		s.executeUpdate("INSERT INTO clients values(" + list.get(0) + ",'" + list.get(1) + "')");

	}

	@Override
	public void updateRow(Statement s, ArrayList<String> list) throws SQLException {
		s.executeUpdate(
				"Update clients set  discount = '" + list.get(0) + "'where clientcard = '" + list.get(1) + "';");

	}

	@Override
	public void deleteRow(Statement s, int num) throws SQLException {
		s.executeUpdate("DELETE FROM clients WHERE clientcard = " + num + ";");

	}

	@Override
	public ArrayList<InterfaceTable> loadTable(Statement s) throws SQLException {
		ArrayList<InterfaceTable> list = new ArrayList<InterfaceTable>();
		ResultSet rs = selectTable(s);
		list.clear();
		while (rs.next()) {
			Clients client = new Clients(rs.getInt(1), rs.getInt(2));
			list.add(client);
		}
		return list;
	}

}
