package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

public class LOIGCtrler extends MainCtrler {

	@Override
	public ResultSet selectTable(Statement s) throws SQLException {
		return s.executeQuery(
				"select l.numberlist, r.name, s.dateofsupply, l.price, l.quantitysupply, l.size from listofincominggoods l"
						+ " join supply s on s.numberofsupply = l.numberofsupply join range r on r.numberofstuff = l.numberofstuff");
	}

	@Override
	public void insertRow(Statement s, ArrayList<String> list) throws SQLException {
		s.executeUpdate("insert into listofincominggoods values(nextval('seq_list')," + list.get(0) + ",'" + list.get(1)
				+ "','" + list.get(2) + "','" + list.get(3) + "','" + list.get(4) + "')");

	}

	@Override
	public void updateRow(Statement s, ArrayList<String> list) throws SQLException {
		s.executeUpdate("update listofincominggoods set numberofsupply = '" + list.get(0) + "' , price = '"
				+ list.get(1) + "' , quantitysupply= '" + list.get(2) + "' , size = '" + list.get(3)
				+ "' ,numberofstuff = '" + list.get(4) + "' WHERE numberlist = " + list.get(5) + ";");

	}

	@Override
	public void deleteRow(Statement s, int num) throws SQLException {

		s.executeUpdate("DELETE FROM listofincominggoods WHERE numberlist = " + num + ";");
	}

	@Override
	public ArrayList<InterfaceTable> loadTable(Statement s) throws SQLException {

		ArrayList<InterfaceTable> list = new ArrayList<InterfaceTable>();
		ResultSet rs = selectTable(s);
		list.clear();
		while (rs.next()) {

			ListOfIncomingGoods listOfGoods = new ListOfIncomingGoods(rs.getInt(1), rs.getString(2), rs.getDate(3),
					Double.parseDouble(rs.getString(4)), rs.getInt(5), Double.parseDouble(rs.getString(6)));
			list.add(listOfGoods);

		}
		return list;

	}

}
