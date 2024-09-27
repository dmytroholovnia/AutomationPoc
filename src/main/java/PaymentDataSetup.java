import core.CoreDriver;
import ui.PaymentPage;
import ui.PaymentSuccessPage;

import static datagenerator.CardDataGenerator.*;

public class PaymentDataSetup {

    private CoreDriver coreDriver;

    public PaymentDataSetup(CoreDriver coreDriver) {
        this.coreDriver = coreDriver;
    }

    public PaymentSuccessPage applyPayment(String orderUrl) {
        return new PaymentPage(coreDriver.getDriver())
                .open(orderUrl)
                .enterCardNumber(getTestCardNumber())
                .enterExpiryDate(generateExpiryDate())
                .enterCvv(generateCvv())
                .enterEmail(generateEmail())
                .submit();
    }

}
