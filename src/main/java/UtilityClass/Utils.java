package UtilityClass;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.time.Duration;


public class Utils {

    WebDriver driver;
    WebDriverWait wait;
    public static int RetryListener = 0;


    public Utils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By ControlCenterNavButton = By.xpath("//div[contains(@class,'top-menu-section')]/a[contains(@href,'controlCenter')]/div");
    final By PageCloseButton = By.xpath("(//label[contains(@class,'pure-toggle-label icon icon-close1')])[1]");


    @Step("Clicking on pop up close button")
    public void ClickOnPopUpCloseButton() {
        try {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
        }
        catch (Exception e) {
            System.out.println("Pop up not found");
        }
    }
    public void ChangeLanguage() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        Thread.sleep(2000);
        Robot robot = new Robot();
        for (int i = 1; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    public StringBuilder generateRandomData(String useCase, int count) {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk0123456789";
        StringBuilder result = new StringBuilder();
        String fixedPart = "QATesting";
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            result.append(randomChar);
        }
        if (useCase.equalsIgnoreCase("email")) {
            return result.append("@gmail.com");
        } else if (useCase.equalsIgnoreCase("randomdata")) {
            return new StringBuilder(fixedPart).append(result);
        }
        return result;
    }

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Clicking on Control Canter")
    public void ClickOnControlCenterNavButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ControlCenterNavButton));
        driver.findElement(ControlCenterNavButton).click();
    }
    @Step("Clicking on cross button to close the page")
    public void ClickOnCrossButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PageCloseButton));
        driver.findElement(PageCloseButton).click();
    }

    String WindowCloseButton = "(//label[contains(@class,'pure-toggle-label icon icon-close1')])[%d]";

    @Step("Clicking on close button of window level {level}")
    public void CloseWindow(int level) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(WindowCloseButton, level))));
        driver.findElement(By.xpath(String.format(WindowCloseButton, level))).click();
    }


    private static String HyperLocalSellerUrl = "https://hyperlocal-demo.onlinesales.ai/";

    public void RetryOnFailHyperSeller(Runnable action) {
        int attempts = 0;
        boolean success = false;
        String Message = "";
        while (attempts < 3 && !success) {
            try {
                action.run();
                success = true;
            } catch (Exception e) {
                Message = e.getClass().getSimpleName();
                attempts++;
                RetryListener++;
                TakeScreenshotOnSoftAssertion("Test Failed due to " + Message + " Attempt: " + attempts);
                if (System.getProperty("HyperLocalSellerUrl") != null)
                    HyperLocalSellerUrl = System.getProperty("HyperLocalSellerUrl");
                driver.navigate().to(HyperLocalSellerUrl);
            }
        }
        if (!success) {
            Assert.fail("Action failed after multiple attempts due to: " + Message);
        }
    }

        public String HyperLocalPulseUrl = "https://hyperlocal-demo-pulse.onlinesales.ai/";

        public void RetryOnFailHyperPulse (Runnable action){
            int attempts = 0;
            boolean success = false;
            String Message = "";
            while (attempts < 3 && !success) {
                try {
                    action.run();
                    success = true;
                } catch (Exception e) {
                    Message = e.getClass().getSimpleName();
                    attempts++;
                    RetryListener++;
                    TakeScreenshotOnSoftAssertion("Test Failed due to " + Message + " Attempt: " + attempts);
                    if (System.getProperty("HyperLocalPulseUrl") != null)
                        HyperLocalPulseUrl = System.getProperty("HyperLocalPulseUrl");
                    driver.navigate().to(HyperLocalPulseUrl);
                }
            }
            if (!success) {
                Assert.fail("Action failed after multiple attempts due to: " + Message);
            }
        }

        }


