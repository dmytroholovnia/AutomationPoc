package ui;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class PaymentSuccessPage extends BasePage {

    @FindBy(xpath = "//*[@data-testid='status-title']")
    private WebElement statusTitle;

    @FindBy(xpath = "//*[contains(@class, 'StatusSuccess')]//*[@data-testid='price_major']")
    private WebElement orderPrice;

    public PaymentSuccessPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(statusTitle));
    }
}
