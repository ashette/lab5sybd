package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

public class SupplyCtrler extends MainCtrler {

	@Override
	public ResultSet selectTable(Statement s) throws SQLException {

		return s.executeQuery("Select * from supply");
	}

	@Override
	public void insertRow(Statement s, ArrayList<String> list) throws SQLException {

		s.executeUpdate("INSERT INTO supply values(nextval('seq_range')" + ",'" + list.get(0) + "')");

	}

	@Override
	public void updateRow(Statement s, ArrayList<String> list) throws SQLException {

		s.executeUpdate(
				"Update supply set dateofsupply = '" + list.get(0) + "' WHERE numberofsupply = " + list.get(1) + ";");

	}

	@Override
	public void deleteRow(Statement s, int num) throws SQLException {

		s.executeUpdate("DELETE FROM supply WHERE numberofsupply = " + num + ";");

	}

	@Override
	public ArrayList<InterfaceTable> loadTable(Statement s) throws SQLException {

		ArrayList<InterfaceTable> list = new ArrayList<InterfaceTable>();
		ResultSet rs = selectTable(s);
		list.clear();
		while (rs.next()) {

			Supply supply = new Supply(rs.getInt(1), rs.getDate(2));
			list.add(supply);

		}
		return list;
	}

}
