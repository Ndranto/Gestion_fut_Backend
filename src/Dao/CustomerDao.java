package Dao;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import model.Customer;

public class CustomerDao {
	public CustomerDao()
	{
		   Customer user1 = new Customer();
           user1.setId("1");
           user1.setAge(20);
           user1.setName("raj");
           
           Customer user2 = new Customer();
           user2.setId("2");
           user2.setAge(21);
           user2.setName("ram");
           
           usersMap.put("1", user1);
           usersMap.put("2", user2);
		
	}
	  static HashMap<String, Customer> usersMap = new HashMap<String, Customer>();

	public static List<Customer> getallCustomer() {
		   List<Customer> userList = new ArrayList<Customer>(usersMap.values());
	        return userList;
	
	}
	
}
