package utils;

import dto.createpage.CreatePageRequestDto;

public class CurrencyFormatter {

    public static String formatCurrencyToUi(CreatePageRequestDto dto) {
        var value  = dto.getOrder().getAmount() / 100;
        var symbol =  dto.getOrder().getCurrency().getSymbol();
        return String.format("%.2f %s", value, symbol).replace(".", ",");
    }
}
