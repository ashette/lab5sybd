package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Vector;

public interface MainInterface {

	ResultSet selectTable(Statement s) throws SQLException;

	void insertRow(Statement s, ArrayList<String> list) throws SQLException;

	void updateRow(Statement s, ArrayList<String> list) throws SQLException;

	void deleteRow(Statement s, int num) throws SQLException;

	ArrayList<InterfaceTable> loadTable(Statement s) throws SQLException;

	Vector<String> getColumnName(Statement s) throws SQLException;

	Vector<Vector<String>> getRowData(Statement s) throws SQLException;

}
