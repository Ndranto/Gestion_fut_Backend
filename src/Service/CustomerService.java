package Service;

import model.Customer;

import java.util.List;

import Dao.CustomerDao;

public class CustomerService {

	public static List<Customer> getAllCustomers() {
		   List<Customer> Customerlist = CustomerDao.getallCustomer();
	        return Customerlist;
		
	}

	public static Customer getCustomerForId(String id) {
	 
		return null;
	}

}
