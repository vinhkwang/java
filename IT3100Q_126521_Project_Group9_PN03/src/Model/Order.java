package Model;

public class Order {
	protected int customerId;
	protected int billboardId;
	protected String nameOfCustomer;
	protected int numberOfBillboard;
	protected double totalPrice;
    
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBillboardId() {
		return billboardId;
	}

	public void setBillboardId(int billboardId) {
		this.billboardId = billboardId;
	}

	public String getNameOfCustomer() {
		return nameOfCustomer;
	}

	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}

	public int getNumberOfBillboard() {
		return numberOfBillboard;
	}

	public void setNumberOfBillboard(int numberOfBillboard) {
		this.numberOfBillboard = numberOfBillboard;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
