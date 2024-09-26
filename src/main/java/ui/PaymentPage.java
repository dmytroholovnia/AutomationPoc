package ui;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class PaymentPage {

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

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public PaymentPage open(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
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

    public void submit() {
        submitButton.click();
    }

}
