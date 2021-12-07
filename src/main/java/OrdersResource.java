import dependency_injection.annotation.DojoComponent;
import models.Order;
import models.OrderDetail;
import models.OrderResource;
import repository.OrderRepository;
import service.OrderService;
import service.OrderValidationService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;

@Path("/orders")
@DojoComponent
public class OrdersResource {
    private final OrderRepository orderRepository;
    private final OrderValidationService validationService;
    private final OrderService orderService;

    @Inject
    public OrdersResource(OrderRepository orderRepository,
                          OrderValidationService validationService,
                          OrderService orderService) {

        this.orderRepository = orderRepository;
        this.validationService = validationService;
        this.orderService = orderService;
    }

    @GET
    public List<Order> retrieveAllOrders() {
        if (validationService.validateOrders()) {

            return orderRepository.retrieveAllOrders();
        } else {
            return Collections.emptyList();
        }
    }

    @Path("/{id}")
    public OrderResource retrieveOrderDetail(@PathParam("id") String id) {
        return new OrderResource();
    }

    @POST
    public void createNewOrder(OrderDetail orderDetail) {
        orderService.createNewOrder(orderDetail);
    }
}
