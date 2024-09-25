import datagenerator.PageDataGenerator;
import dto.createpage.CreatePageRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatePageTest extends BaseTest {

    @Test
    @DisplayName("Create payment page")
    public void createPageTest() {
        CreatePageRequestDto requestDto = PageDataGenerator.generateDto();
        var responseDto = apiService.createPage(requestDto);
        assertThat(responseDto.getGuid()).isEqualTo(requestDto.getOrder().getOrderId());
    }

}
