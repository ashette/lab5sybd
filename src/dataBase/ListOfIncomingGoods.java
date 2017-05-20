package dataBase;

import java.sql.Date;


public class ListOfIncomingGoods implements InterfaceTable {
	
	private int numberList;
	private Date numberOfSupply;
	private double price;
	private int quantitySupply;
	private double size;
	private String numberOfStuff;
	
	public ListOfIncomingGoods(int numberList, String numberOfStuff, Date numberOfSupply, double price, int quantitySupply, double size) {
		super();
		this.numberList = numberList;
		this.numberOfSupply = numberOfSupply;
		this.price = price;
		this.quantitySupply = quantitySupply;
		this.size = size;
		this.numberOfStuff = numberOfStuff;
	}

	public int getNumberList() {
		return numberList;
	}

	public void setNumberList(int numberList) {
		this.numberList = numberList;
	}

	public Date getNumberOfSupply() {
		return numberOfSupply;
	}

	public void setNumberOfSupply(Date numberOfSupply) {
		this.numberOfSupply = numberOfSupply;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantitySupply() {
		return quantitySupply;
	}

	public void setQuantitySupply(int quantitySupply) {
		this.quantitySupply = quantitySupply;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getNumberOfStuff() {
		return numberOfStuff;
	}

	public void setNumberOfStuff(String numberOfStuff) {
		this.numberOfStuff = numberOfStuff;
	}

	@Override
	public int getPrimaryKey() {
		
		return getNumberList();
	}

	@Override
	public String getForeignKey() {
		return null;
	}
	

}
