package repository;

import dependency_injection.annotation.DojoComponent;
import mock.MockDB;
import models.Order;

import java.util.List;
import java.util.stream.Collectors;

@DojoComponent
public class OrderRepository {

    public List<Order> retrieveAllOrders() {
        return MockDB.MOCK_DB_ORDER_DETAILS.values()
                .stream()
                .map(orderDetail -> Order.builder()
                        .id(orderDetail.getId())
                        .name(orderDetail.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
