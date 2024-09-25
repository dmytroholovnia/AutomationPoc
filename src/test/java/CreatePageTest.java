import datagenerator.PageDataGenerator;
import dto.createpage.CreatePageRequestDto;
import dto.status.StatusRequestDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePageTest extends BaseTest {

    private static CreatePageRequestDto createPageRequestDto;

    @BeforeAll
    public static void setupData() {
        createPageRequestDto = PageDataGenerator.generateDto();
    }

    @Test
    @DisplayName("Create payment page test")
    public void createPageTest() {
        var responseDto = apiService.createPage(createPageRequestDto);
        assertThat(responseDto.getGuid()).isEqualTo(createPageRequestDto.getOrder().getOrderId());
    }

    @Test
    @DisplayName("Get order status test")
    public void getStatusTest() {
        //TODO get order status
        StatusRequestDto statusRequestDto = new StatusRequestDto(UUID.randomUUID());
        var responseDto = apiService.getStatus(statusRequestDto);
        assertThat(responseDto.getAmount()).isEqualTo(createPageRequestDto.getOrder().getAmount());
        assertThat(responseDto.getCurrency()).isEqualTo(createPageRequestDto.getOrder().getCurrency());
    }

}
