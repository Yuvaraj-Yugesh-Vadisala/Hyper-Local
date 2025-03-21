package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.PresencePage;
import UtilityClass.Utils;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.Cookie;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class GoogleAutoresponder extends BaseTest {

    private PresencePage presencePage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        utils = new Utils(getDriver());
        presencePage = new PresencePage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", super.HyperUAT);
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod(alwaysRun = true)
    public void ResetPage(ITestResult result) throws InterruptedException, AWTException {
        getDriver().navigate().to(HyperLocalPulseUrl);
        if (!Language.equals("en")) {
            utils.ChangeLanguage();
        }
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Started @Test: " + result.getMethod().getMethodName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished @Test: " + result.getMethod().getMethodName());
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs Google review - Auto responder")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Google Review - Auto Responder")
    public void GoogleReviewAutoResponderOperations() {
        utils.RetryOnFailHyperPulse(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(1000);
                presencePage.ClickOnPresenceTab();
                presencePage.ClickOnGoogleReviewTab();
                presencePage.ClickOnEditButton(1);
                presencePage.ClickOnResponseSaveButton();
                if (!presencePage.ValidateErrorBorderOfResponseField()) {
                    utils.TakeScreenshotOnSoftAssertion("soft Assertion : Response Field border is not highlighted when kept empty");
                    softAssert.fail("Response Field border is not highlighted when kept empty");
                }
                presencePage.EnterResponse("                ");
                presencePage.ClickOnResponseSaveButton();
                if (presencePage.ValidateResponseFieldAcceptingOnlySpaces()) {
                    utils.TakeScreenshotOnSoftAssertion("soft Assertion : Response Field accepting only spaces");
                    softAssert.fail("Response Field accepting only spaces");
                }
                presencePage.EnterResponse("The experience was very poor");
                presencePage.ClickOnResponseSaveButton();
                if (!presencePage.ValidateResponseSaveSuccessMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("soft Assertion : Response Save Success Message not displayed");
                    softAssert.fail("Response Save Success Message not displayed");
                }
                utils.ClickOnPopUpCloseButton();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }

}
