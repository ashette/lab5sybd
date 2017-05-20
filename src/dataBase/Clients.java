package dataBase;

public class Clients implements InterfaceTable {
	
	private int clientCard;
	private int discount;
	public Clients(int clientCard, int discount) {
		super();
		this.clientCard = clientCard;
		this.discount = discount;
	}
	public int getClientCard() {
		return clientCard;
	}
	public void setClientCard(int clientCard) {
		this.clientCard = clientCard;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public int getPrimaryKey() {
		
		return clientCard;
	}
	@Override
	public String getForeignKey() {
		return getDiscount()+"%";
	}

}
