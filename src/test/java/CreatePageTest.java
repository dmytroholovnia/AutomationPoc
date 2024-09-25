import datagenerator.PageDataGenerator;
import dto.createpage.CreatePageRequestDto;
import dto.status.StatusRequestDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.PaymentPage;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePageTest extends BaseTest {

    private static CreatePageRequestDto createPageRequestDto;
    private PaymentPage paymentPage;

    @BeforeAll
    public static void setupData() {
        createPageRequestDto = PageDataGenerator.generateDto();
    }

    @Test
    @DisplayName("Create payment page test")
    public void createPageTest() {
        var responseDto = apiService.createPage(createPageRequestDto);
//        assertThat(responseDto.getGuid()).isEqualTo(createPageRequestDto.getOrder().getOrderId());
        String orderUrl = responseDto.getUrl();
//        driver.get(orderUrl);
        paymentPage = new PaymentPage(driver);

        paymentPage
                .open(orderUrl)
                .enterCardNumber("4067429974719265")
                .enterExpiryDate("12/34")
                .enterCvv("123")
                .enterEmail("example1@test.com");
        System.out.println("test");
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
