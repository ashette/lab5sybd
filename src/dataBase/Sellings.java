package dataBase;

import java.sql.Date;

public class Sellings implements InterfaceTable {
	
	private int numberSellings;
	private String numberOfStuff;
	private int clientCard;
	private int quantityOfSold;
	private Date dateOfSelling;
	private double sum;
	public Sellings(int numberSellings, String numberOfStuff, int clientCard, int quantityOfSold, Date date,
			double sum) {
		super();
		this.numberSellings = numberSellings;
		this.numberOfStuff = numberOfStuff;
		this.clientCard = clientCard;
		this.quantityOfSold = quantityOfSold;
		this.dateOfSelling = date;
		this.sum = sum;
	}
	public int getNumberSellings() {
		return numberSellings;
	}
	public void setNumberSellings(int numberSellings) {
		this.numberSellings = numberSellings;
	}
	public String getNumberOfStuff() {
		return numberOfStuff;
	}
	public void setNumberOfStuff(String numberOfStuff) {
		this.numberOfStuff = numberOfStuff;
	}
	public int getClientCard() {
		return clientCard;
	}
	public void setClientCard(int clientCard) {
		this.clientCard = clientCard;
	}
	public int getQuantityOfSold() {
		return quantityOfSold;
	}
	public void setQuantityOfSold(int quantityOfSold) {
		this.quantityOfSold = quantityOfSold;
	}
	public Date getDateOfSelling() {
		return dateOfSelling;
	}
	public void setDateOfSelling(Date dateOfSelling) {
		this.dateOfSelling = dateOfSelling;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	@Override
	public int getPrimaryKey() {
		
		return getNumberSellings();
	}
	@Override
	public String getForeignKey() {
		return null;
	}
	
	

}
