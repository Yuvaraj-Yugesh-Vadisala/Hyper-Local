package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.PostReviewPage;
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

public class PostReview extends BaseTest {

    private PostReviewPage reviewPage;
    private PresencePage presencePage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        presencePage = new PresencePage(getDriver());
        reviewPage = new PostReviewPage(getDriver());
        utils = new Utils(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", super.HyperUATPulse);
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
    @Story("This flow belongs Post Review")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Review of Created Post", priority = 0)
    public void PostReview() {
        utils.RetryOnFailHyperPulse(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(1000);
                presencePage.ClickOnPresenceTab();
                reviewPage.ClickOnPostReviewTab();
                reviewPage.SelectChannel("Google");
                reviewPage.ClickOnViewButton();
                reviewPage.ClickOnApproveButton();
                presencePage.ClickOnConfirmationYesButton();
                if(!reviewPage.ValidateApproveSuccessMessage()){
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Post Approve Success message not displayed");
                    softAssert.fail("Post Approval Success Message not displayed");
                }
                utils.ClickOnPopUpCloseButton();
                reviewPage.SelectChannel("Facebook");
                reviewPage.ClickOnViewButton();
                reviewPage.ClickOnRejectButton();
                reviewPage.EnterComment("Automation Rejection");
                reviewPage.ClickOnCommentAndRejectButton();
                presencePage.ClickOnConfirmationYesButton();
                if(!reviewPage.ValidateRejectSuccessMessage()){
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Post Approve Success message not displayed");
                    softAssert.fail("Post Approval Success Message not displayed");
                }
                utils.ClickOnPopUpCloseButton();

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }

    @Epic("Pulse Dashboard")
    @Story("This flow belongs Post Review")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Review of Created Post", priority = 1)
    public void PostReviewDashboard() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1000);
            presencePage.ClickOnPresenceTab();
            reviewPage.ClickOnPostReviewTab();
            reviewPage.SelectChannel("Facebook");
            reviewPage.ClickOnAddCommentButton();
            reviewPage.ClickOnAddCommentOnlyButton();
            if (!reviewPage.ValidateCommentErrorHighlight()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Comment Field is not highlighted when kept empty");
                softAssert.fail("Comment Field is not highlighted when kept empty");
            }
            reviewPage.EnterComment("Automation comment");
            reviewPage.ClickOnAddCommentOnlyButton();
            Thread.sleep(1500);
            reviewPage.ClickOnCommentOnlyDrawerCloseButton();
            reviewPage.SortPostTable(3);
            reviewPage.SelectingDesiredStatus(1);

        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        });
    }
}

