package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoreDriver {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (this.driver == null) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
        }
        return driver;
    }

    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

}
