package models;

import dependency_injection.annotation.DojoComponent;
import repository.OrderDetailRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/order")
@DojoComponent
public class OrderResource {


    private OrderDetailRepository orderDetailRepository;

    @Inject
    public OrderResource(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderResource() {
    }

    @GET
    public OrderDetail getDetail(String id) {
        return orderDetailRepository.retrieveOrderDetails(id);
    }
}
