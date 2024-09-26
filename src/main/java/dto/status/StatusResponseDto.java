package dto.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.createpage.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusResponseDto {
    private OrderDto order;
}
