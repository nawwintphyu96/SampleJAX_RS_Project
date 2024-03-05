package order.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		packages("order.rest");
	}

}
