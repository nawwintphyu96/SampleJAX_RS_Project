package order.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import order.model.Order;
import order.service.IOrderApplicationService;
import order.service.OrderApplicationService;

@Path("orders")
public class OrderApplicationServiceFacade {
	IOrderApplicationService iApplicationService = new OrderApplicationService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Order> getAll(@QueryParam("start") int from, @QueryParam("page") int page) {

		List<Order> list = null;
		if (from != 0 && page != 0) {
			list = iApplicationService.getAllOrders();
		}

		return list;
	}

	@GET
	@Path("{oid}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("oid") int id) {
		// . . .
		Order order = iApplicationService.getOrderById(id);
		return order;
	}

	@HEAD
	@Path("{oid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void headOrder(@PathParam("oid") Integer id) {
		System.out.println("This id head from Order Application.");

	}

	@POST
	@Path("createorder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Order createOrder(Order order) {
		order = iApplicationService.createOrder(order);
		return order;
	}
}
