import com.fasterxml.jackson.databind.ObjectMapper;
import dto.createpage.CreatePageRequestDto;
import dto.createpage.OrderRequestDto;
import dto.createpage.PageCustomizationRequestDto;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePageTest {

    private Service service;

    @BeforeEach
    public void setup() {
        service = new Service();
    }

    @Test
    public void createPageTest() {
        CreatePageRequestDto requestDto = generateDto();
        String json = getJson(requestDto);

        var responseDto = service.createPage(json);
        assertThat(responseDto.getGuid()).isEqualTo(requestDto.getOrder().getOrderId());
    }

    private CreatePageRequestDto generateDto() {
        return CreatePageRequestDto.builder()
                .order(OrderRequestDto.builder()
                        .orderId(UUID.randomUUID())
                        .amount(Integer.valueOf(RandomStringUtils.randomNumeric(3)))
                        .currency(Currency.USD.name())
                        .orderDescription("Ticket to Ride")
                        .build())
                .pageCustomization(PageCustomizationRequestDto.builder()
                        .publicName(Constants.COMPANY_NAME)
                        .build())
                .build();
    }

    @SneakyThrows
    private String getJson(Object requestDto) {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(requestDto);
    }
}
