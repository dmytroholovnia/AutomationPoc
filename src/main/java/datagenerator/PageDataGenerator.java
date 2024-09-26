package datagenerator;

import dto.createpage.CreatePageRequestDto;
import dto.createpage.OrderDto;
import dto.createpage.PageCustomizationRequestDto;

import java.util.UUID;

import static utils.Constants.COMPANY_NAME;
import static utils.Currency.EUR;

public class PageDataGenerator extends BaseGenerator {

    public static CreatePageRequestDto generateDto() {
        return CreatePageRequestDto.builder()
                .order(OrderDto.builder()
                        .orderId(UUID.randomUUID())
                        .amount((double) faker.number().numberBetween(100, 9999))
                        .currency(EUR)
                        .orderDescription(faker.book().title())
                        .build())
                .pageCustomization(PageCustomizationRequestDto.builder()
                        .publicName(COMPANY_NAME)
                        .build())
                .build();
    }
}
