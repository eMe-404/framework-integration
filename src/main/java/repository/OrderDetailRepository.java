package repository;

import dependency_injection.annotation.DojoComponent;
import mock.MockDB;
import models.OrderDetail;

@DojoComponent
public class OrderDetailRepository {


    public OrderDetail retrieveOrderDetails(String id) {
        return MockDB.MOCK_DB_ORDER_DETAILS.get(id);
    }
}
