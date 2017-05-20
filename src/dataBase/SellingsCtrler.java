package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SellingsCtrler extends MainCtrler {

	@Override
	public ResultSet selectTable(Statement s) throws SQLException {
		return s.executeQuery("select s.numbersellings, r.name, c.clientcard, s.quantityofsold, s.dateofselling, s.sum"
				+ " from sellings s join range r on r.numberofstuff = s.numberofstuff join clients c on c.clientcard = s.clientcard");
	}

	@Override
	public void insertRow(Statement s, ArrayList<String> list) throws SQLException {

		s.executeUpdate("INSERT INTO sellings values(nextval('seq_sellings')," + list.get(0) + ",'" + list.get(1)
				+ "','" + list.get(2) + "','" + list.get(3) + "','" + list.get(4) + "')");

	}

	@Override
	public void updateRow(Statement s, ArrayList<String> list) throws SQLException {

		s.executeUpdate("Update sellings set numberofstuff = '" + list.get(0) + "' , clientcard = '" + list.get(1)
				+ "' , quantityofsold= '" + list.get(2) + "' , dateofselling = '" + list.get(3) + "' ,sum = "
				+ list.get(4) + " WHERE numbersellings = " + list.get(5) + ";");

	}

	@Override
	public void deleteRow(Statement s, int num) throws SQLException {

		s.executeUpdate("DELETE FROM sellings WHERE numbersellings = " + num + ";");

	}

	@Override
	public ArrayList<InterfaceTable> loadTable(Statement s) throws SQLException {

		DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
		ArrayList<InterfaceTable> list = new ArrayList<InterfaceTable>();
		ResultSet rs = selectTable(s);
		list.clear();
		while (rs.next()) {
			java.util.Date parsed;
			try {
				parsed = format.parse(rs.getString(5));
				java.sql.Date date = new java.sql.Date(parsed.getTime());
				Sellings sellings = new Sellings(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), date,
						Double.parseDouble(rs.getString(6)));
				list.add(sellings);
			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return list;

	}

}
