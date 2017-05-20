package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RangeCtrler extends MainCtrler {

	@Override
	public ResultSet selectTable(Statement s) throws SQLException {
		return s.executeQuery("Select * from range");
	}

	@Override
	public void insertRow(Statement s, ArrayList<String> list) throws SQLException {
		s.executeUpdate("INSERT INTO range values(nextval('seq_range')," + list.get(0) + ",'" + list.get(1) + "','"
				+ list.get(2) + "','" + list.get(3) + "')");

	}

	@Override
	public void updateRow(Statement s, ArrayList<String> list) throws SQLException {
		s.executeUpdate("Update range set name = '" + list.get(0) + "' , factory = '" + list.get(1) + "' , model = '"
				+ list.get(2) + "' , certificate = '" + list.get(3) + "' WHERE numberofstuff = " + list.get(5) + ";");

	}

	@Override
	public void deleteRow(Statement s, int num) throws SQLException {

		s.executeUpdate("DELETE FROM range WHERE numberofstuff = " + num + ";");
	}

	@Override
	public ArrayList<InterfaceTable> loadTable(Statement s) throws SQLException {
		ArrayList<InterfaceTable> list = new ArrayList<InterfaceTable>();
		ResultSet rs = selectTable(s);
		list.clear();
		while (rs.next()) {
			Range range = new Range(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(range);
		}
		return list;

	}

}
