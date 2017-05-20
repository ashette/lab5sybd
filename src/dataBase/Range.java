package dataBase;

public class Range implements InterfaceTable {

	private int numberOfStuff;
	private String name;
	private String factory;
	private String model;
	private String certificate;
	
	public Range(int numberOfStuff, String name, String factory, String model, String certificate) {
		super();
		this.numberOfStuff = numberOfStuff;
		this.name = name;
		this.factory = factory;
		this.model = model;
		this.certificate = certificate;
	}

	public int getNumberOfStuff() {
		return numberOfStuff;
	}

	public void setNumberOfStuff(int numberOfStuff) {
		this.numberOfStuff = numberOfStuff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Override
	public int getPrimaryKey() {
		
		return getNumberOfStuff();
	}

	@Override
	public String getForeignKey() {
		return getName();
	}
	
	
	
	
}
