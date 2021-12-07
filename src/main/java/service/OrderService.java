package service;

import dependency_injection.annotation.DojoComponent;
import mock.MockDB;
import models.OrderDetail;

import java.util.Map;

@DojoComponent
public class OrderService {

    public void createNewOrder(OrderDetail orderDetail) {
        Map<String, OrderDetail> existingOrderDetails = MockDB.MOCK_DB_ORDER_DETAILS;
        int size = existingOrderDetails.size();
        orderDetail.setId(String.valueOf(size + 1));

        existingOrderDetails.put(orderDetail.getId(), orderDetail);
    }
}
