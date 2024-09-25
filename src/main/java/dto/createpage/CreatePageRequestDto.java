package dto.createpage;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePageRequestDto {
    private OrderRequestDto order;
    @JsonProperty("page_customization")
    private PageCustomizationRequestDto pageCustomization;
}
