import datagenerator.PageDataGenerator;
import dto.createpage.CreatePageRequestDto;
import dto.status.StatusRequestDto;
import org.junit.jupiter.api.*;
import ui.PaymentPage;
import utils.Constants;

import java.util.UUID;

import static datagenerator.CardDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreatePageTest extends BaseTest {

    private static CreatePageRequestDto createPageRequestDto;

    @BeforeAll
    public static void setupData() {
        createPageRequestDto = PageDataGenerator.generateDto();
    }

    @Test
    @Order(1)
    @DisplayName("Create payment page test")
    public void createPageTest() {
        var responseDto = apiService.createPage(createPageRequestDto);
        assertThat(responseDto.getGuid()).isNotNull();
//        assertThat(responseDto.getUrl()).contains(Constants.BASE_URI);
        assertThat(responseDto.getUrl()).isNotEmpty();
        String orderUrl = responseDto.getUrl();

        new PaymentPage(driver)
                .open(orderUrl)
                .enterCardNumber(getTestCardNumber())
                .enterExpiryDate(generateExpiryDate())
                .enterCvv(generateCvv())
                .enterEmail(generateEmail())
                .submit();
        System.out.println("test");
    }

    @Test
    @Order(2)
    @DisplayName("Get order status test")
    public void getStatusTest() {
        StatusRequestDto statusRequestDto = new StatusRequestDto(createPageRequestDto.getOrder().getOrderId());
        var responseDto = apiService.getStatus(statusRequestDto);
        assertThat(responseDto.getOrder().getAmount()).isEqualTo(createPageRequestDto.getOrder().getAmount());
        assertThat(responseDto.getOrder().getCurrency()).isEqualTo(createPageRequestDto.getOrder().getCurrency());
    }

}
