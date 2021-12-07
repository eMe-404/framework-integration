package service;

import dependency_injection.annotation.DojoComponent;
import mock.MockDB;

@DojoComponent
public class OrderValidationService {
    public boolean validateOrders() {
        return MockDB.MOCK_DB_ORDER_DETAILS.size() > 0;
    }
}
