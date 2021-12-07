import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.RestAssured;
import java.time.LocalDate;
import models.OrderDetail;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdersResourceTest {
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:28080";
    }

    @Test
    void should_return_root_resources() {
        given().
                get("/orders").
        then().
                statusCode(is(HttpStatus.SC_OK)).
                body("id", hasItems("1", "2"));
    }

    @Test
    void should_return_specific_sub_resource_given_order_id() {
        given().
                get("/orders/1").
        then().
                statusCode(is(HttpStatus.SC_OK)).
                body("id", is(equalTo("1"))).
                body("name", is(notNullValue())).
                body("customerId", is(notNullValue())).
                body("status", is(notNullValue()));

    }


    @Test
    void should_return_404_not_found_status_code_given_unknown_url() {
        given().
                get("/unknown/some/url").
        then().
                statusCode(is(HttpStatus.SC_NOT_FOUND));

    }

    @Test
    void should_successfully_save_new_order_given_create_order_post_request() {
        final String newOrderName = "my new order";
        final OrderDetail newOrder = OrderDetail.builder()
                .name(newOrderName)
                .createAt(LocalDate.now().toString())
                .status("created")
                .customerId("customer_001")
                .build();

        given().
                body(newOrder).
                post("/orders").
        then().
                statusCode(is(HttpStatus.SC_OK));

        given()
                .get("/orders")
        .then()
                .body("name", hasItem(newOrderName));

    }
}