package PagesPulse;

import UtilityClass.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AnalyticsPage {

    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public AnalyticsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
