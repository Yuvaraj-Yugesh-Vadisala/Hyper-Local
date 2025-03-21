package TestSeller;

import BaseSetup.BaseTest;
import PagesSeller.PerformancePage;
import PagesSeller.SettingsPage;
import PagesSeller.SupportPage;
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

public class Support extends BaseTest {

    private PerformancePage performancePage;
    private SupportPage supportPage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalSellerUrl);
        supportPage = new SupportPage(getDriver());
        performancePage = new PerformancePage(getDriver());
        utils = new Utils(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", super.HyperUAT);
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
        performancePage.SelectingClient("Test OEM 2 (Test OEM 2)", 1);
    }

    @BeforeMethod(alwaysRun = true)
    public void ResetPage(ITestResult result) throws InterruptedException, AWTException {
        getDriver().navigate().to(HyperLocalSellerUrl);
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


    @Epic("Seller Dashboard")
    @Story("This flow belongs support")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate Support Properties", priority = 0)
    public void ValidateSupportProperties() {
        utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            supportPage.ClickOnSupportIcon();
            supportPage.ClickOnCreateNewTicket();
            supportPage.ClickOnCreateTicketButton();
            if (!supportPage.VerifyTicketFormEmptyErrorPopUpIsDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Ticket Form Empty Error Pop Up is not displayed");
                softAssert.fail("Ticket Form Empty Error Pop Up is not displayed");
            }
            if (!supportPage.IsSubjectEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Subject Empty Error Message is not displayed");
                softAssert.fail("Subject Empty Error Message is not displayed");
            }
            if (!supportPage.IsClassificationEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Classification Empty Error Message is not displayed");
                softAssert.fail("Classification Empty Error Message is not displayed");
            }
            if (!supportPage.IsDescriptionEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Description Empty Error Message is not displayed");
                softAssert.fail("Description Empty Error Message is not displayed");
            }
            supportPage.EnterSpacesInSubjectField("       ");
            if (supportPage.IsSubjectFieldAcceptingEmptySpacesAsInput()) {
                utils.TakeScreenshotOnSoftAssertion("Subject Field is accepting empty spaces as input");
                softAssert.fail("Subject Field is accepting empty spaces as input");
            }

            supportPage.EnterDataInSubjectField("randomdata", 6);
            supportPage.ClickOnClassificationDropDownField();
            supportPage.EnterDataInClassificationSearchField("Dashboard");
            supportPage.SelectOption(1);
            supportPage.ClickOnCCDropDownField("Testingqa@gmail.com");
            supportPage.SelectOption(1);
            supportPage.EnterDataInDescriptionField("Test Description");
            supportPage.UploadFileInAttachmentField("img.png");
            supportPage.ClickOnUploadedFileCloseButton();
            supportPage.UploadFileInAttachmentField("img.png");
            supportPage.UploadFileInAttachmentField("img.png");
            supportPage.UploadFileInAttachmentField("img.png");
            supportPage.UploadFileInAttachmentField("img.png");
            supportPage.UploadFileInAttachmentField("img.png");
            if (supportPage.IsUploadFileFieldVisibleAfterUploading5Files()) {
                utils.TakeScreenshotOnSoftAssertion("Upload File Field is visible after uploading 5 files");
                softAssert.fail("Upload File Field is visible after uploading 5 files");
            }
            supportPage.ClickOnCreateTicketButton();
            if (!supportPage.VerifyTicketCreatedSuccessPopUpIsDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Ticket Created Success Pop Up is not displayed");
                softAssert.fail("Ticket Created Success Pop Up is not displayed");
            }
            supportPage.EnterDataInSearchField(supportPage.TicketName);
            if (!supportPage.IsTableFirstRowDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Ticket is not displayed in table");
                softAssert.fail("Ticket is not displayed in table");
            }
            supportPage.ClickOnViewDetailsButton();
            if (!supportPage.IsTicketDetailsPageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Ticket Details Page is not displayed");
                softAssert.fail("Ticket Details Page is not displayed");
            }
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        }));
    }

}
