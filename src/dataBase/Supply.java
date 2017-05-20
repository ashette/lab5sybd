package dataBase;

import java.sql.Date;

public class Supply implements InterfaceTable {

	private int numberOfSupply;
	private Date dateOfSupply;
	public Supply(int numberOfSupply, Date dateOfSupply) {
		super();
		this.numberOfSupply = numberOfSupply;
		this.dateOfSupply = dateOfSupply;
	}
	public int getNumberOfSupply() {
		return numberOfSupply;
	}
	public void setNumberOfSupply(int numberOfSupply) {
		this.numberOfSupply = numberOfSupply;
	}
	public Date getDateOfSupply() {
		return dateOfSupply;
	}
	public void setDateOfSupply(Date dateOfSupply) {
		this.dateOfSupply = dateOfSupply;
	}
	@Override
	public int getPrimaryKey() {
		
		return getNumberOfSupply();
	}
	@Override
	public String getForeignKey() {
		return getDateOfSupply().toString();
	}
}
