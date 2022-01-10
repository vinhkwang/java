package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Customer;

public class CustomerList {
	List<Customer> customerList;
	public CustomerList() {
		this.customerList = new ArrayList<>();
	}
	public void add(Customer newCustomer) {
	 customerList.add(newCustomer);
 }
 	public void delete(Customer newCustomer) {
	 customerList.remove(newCustomer);
 }
 	public List<Customer> getCs() {
	return customerList;
}
	public void setCs(List<Customer> cs) {
		this.customerList = cs;
	}
   
}
