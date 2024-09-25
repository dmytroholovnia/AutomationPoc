package dto.createpage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.Currency;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @JsonProperty("order_id")
    private UUID orderId;
    private Integer amount;
    private Currency currency;
    @JsonProperty("order_description")
    private String orderDescription;
}
