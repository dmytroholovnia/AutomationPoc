package ui;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Getter
public class PaymentPage extends BasePage {

    @FindBy(id = "ccnumber")
    private WebElement cardInput;

    @FindBy(xpath = "//input[@data-testid='cardExpiryDate']")
    private WebElement expiryDateInput;

    @FindBy(id = "cvv2")
    private WebElement cvvInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@data-testid='submit']")
    private WebElement submitButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage open(String url) {
        driver.get(url);
        wait.until(visibilityOf(submitButton));
        return this;
    }

    public PaymentPage enterCardNumber(String cardNumber) {
        cardInput.sendKeys(cardNumber);
        return this;
    }

    public PaymentPage enterExpiryDate(String date) {
        expiryDateInput.sendKeys(date);
        return this;
    }

    public PaymentPage enterCvv(String cvv) {
        cvvInput.sendKeys(cvv);
        return this;
    }

    public PaymentPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public PaymentSuccessPage submit() {
        submitButton.click();
        return new PaymentSuccessPage(driver);
    }

}
