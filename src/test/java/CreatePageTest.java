import datagenerator.PageDataGenerator;
import dto.createpage.CreatePageRequestDto;
import dto.status.StatusRequestDto;
import enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.PaymentSuccessPage;
import utils.CurrencyFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePageTest extends BaseTest {

    private CreatePageRequestDto createPageRequestDto;
    private PaymentSuccessPage paymentSuccessPage;

    @BeforeEach
    public void setupOrder() {
        createPageRequestDto = PageDataGenerator.generateDto();
        var responseDto = apiService.createPage(createPageRequestDto);
        String orderUrl = responseDto.getUrl();
        paymentSuccessPage = new PaymentDataSetup(coreDriver).applyPayment(orderUrl);
    }

    @Test
    @DisplayName("Create payment page test")
    public void createPageTest() {
        assertThat(paymentSuccessPage.getStatusTitle().isDisplayed()).isTrue();
        var expectedPrice = CurrencyFormatter.formatCurrencyToUi(createPageRequestDto);
        assertThat(paymentSuccessPage.getOrderPrice().getText())
                .isEqualTo(expectedPrice);
    }

    @Test
    @DisplayName("Get order status test")
    public void getStatusTest() {
        StatusRequestDto statusRequestDto = new StatusRequestDto(createPageRequestDto.getOrder().getOrderId());
        var orderDto = apiService.getStatus(statusRequestDto).getOrder();
        assertThat(orderDto.getAmount()).isEqualTo(createPageRequestDto.getOrder().getAmount());
        assertThat(orderDto.getCurrency()).isEqualTo(createPageRequestDto.getOrder().getCurrency());
        assertThat(orderDto.getStatus()).isEqualTo(Status.APPROVED.getValue());
    }

}
