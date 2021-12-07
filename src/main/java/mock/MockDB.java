package mock;

import models.Order;
import models.OrderDetail;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class MockDB {
    public static final Map<String, OrderDetail> MOCK_DB_ORDER_DETAILS;

    static {

        Map<String, OrderDetail> unmodifiableMap = Map.ofEntries(
                entry("1",
                        OrderDetail.builder()
                                .id("1")
                                .customerId("customer_001")
                                .status("pending")
                                .name("super expensive stuff")
                                .createAt("2021-12-12")
                                .build()),
                entry("2", OrderDetail.builder()
                        .id("2")
                        .customerId("customer_002")
                        .status("paid")
                        .name("super cheep stuff")
                        .createAt("2021-12-2")
                        .build())
        );
        MOCK_DB_ORDER_DETAILS = new HashMap<>(unmodifiableMap);
    }

}
