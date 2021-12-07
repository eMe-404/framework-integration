package models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Order {
    private String id;
    private String name;
}
