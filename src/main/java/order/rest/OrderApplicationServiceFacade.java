package order.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import order.model.Order;
import order.service.IOrderApplicationService;
import order.service.OrderApplicationService;

@Path("orders")
public class OrderApplicationServiceFacade {
	IOrderApplicationService iApplicationService = new OrderApplicationService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("start") int from, @QueryParam("page") int page) {

		List<Order> list = null;
		if (from != 0 && page != 0) {
			list = iApplicationService.getAllOrders();
		}

		Response response = Response.ok(list).build();
		return response;
	}

	@GET
	@Path("{oid}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getOrder(@PathParam("oid") int id) {
		// . . .
		Order order = iApplicationService.getOrderById(id);
		Response response = Response.ok(order).build();
		return response;
	}

	@HEAD
	@Path("{oid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response headOrder(@PathParam("oid") Integer id) {
		System.out.println("This id head from Order Application.");
		Response response = Response.ok().build();
		return response;

	}

	@POST
	@Path("createorder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createOrder(Order order) {
		order = iApplicationService.createOrder(order);
		Response resopnse = Response.ok(order).build();
		return resopnse;
	}

	@OPTIONS
	@Path("{oid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response optionOrder(@PathParam("oid") Integer id) {
		System.out.println("This is from optionOrder method.");
		Response response = Response.ok().build();
		return response;
	}
}
