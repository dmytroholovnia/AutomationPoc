package datagenerator;

import dto.createpage.CreatePageRequestDto;
import dto.createpage.OrderDto;
import dto.createpage.PageCustomizationRequestDto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

import static utils.Constants.COMPANY_NAME;
import static utils.Currency.USD;

public class PageDataGenerator {

    public static CreatePageRequestDto generateDto() {
        return CreatePageRequestDto.builder()
                .order(OrderDto.builder()
                        .orderId(UUID.randomUUID())
                        .amount(Integer.valueOf(RandomStringUtils.randomNumeric(3)))
                        .currency(USD)
                        .orderDescription("Ticket to Ride")
                        .build())
                .pageCustomization(PageCustomizationRequestDto.builder()
                        .publicName(COMPANY_NAME)
                        .build())
                .build();
    }
}
