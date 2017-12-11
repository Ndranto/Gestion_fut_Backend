package Controller;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("restservices")
public class RestServices extends ResourceConfig {
	
	public RestServices() {
		packages("com.fasterxml.jackson.jaxrs.json");
		packages("com.pegaxchange.java.web.rest");
	}


}
