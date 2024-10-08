package dto.createpage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import enums.Currency;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    @JsonProperty("order_id")
    private UUID orderId;
    private Double amount;
    private Currency currency;
    @JsonProperty("order_description")
    private String orderDescription;
    private String status;
}
