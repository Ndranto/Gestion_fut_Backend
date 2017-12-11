package Controller;

import javax.ws.rs.*;

import javax.ws.rs.core.*;
import Service.*;
import java.util.List;

import model.Customer;
@Path("/Customer")

public class CustomerRessource extends Application {
	    @GET
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Customer getCustomerForId(@PathParam("id") String id) {
	        Customer user = CustomerService.getCustomerForId(id);
	        return user;
	    }
	    @GET
	    @Produces("application/json") 
	    @Path("/list")
	    public List<Customer> getAllUsers() {
	        List<Customer> userList = CustomerService.getAllCustomers();
	        return userList;
	    }
}
