package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    @FindBy(xpath = "//*[@data-testid='card']")
    private WebElement cardInput;

    @FindBy(xpath = "//*[@data-testid='cardExpiryDate']")
    private WebElement expiryDateInput;

    @FindBy(xpath = "//*[@data-testid='cardCvv']")
    private WebElement cvvInput;

    @FindBy(xpath = "//*[@data-testid='charity-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@data-testid='submit']")
    private WebElement submitButton;

    private WebDriver driver;
    private WebDriverWait wait;

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
