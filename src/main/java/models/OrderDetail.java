package models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    private String id;
    private String name;
    private String createAt;
    private String status;
    private String customerId;
}
