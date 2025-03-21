package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.PresencePage;
import PagesSeller.PerformancePage;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostTemplates extends BaseTest {

    private PerformancePage performancePage;
    private PresencePage presencePage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        utils = new Utils(getDriver());
        performancePage = new PerformancePage(getDriver());
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
    @Story("This flow belongs Post Template")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Creation of Google Post Template (Negative)", priority = 0)
    public void CreationOfPostTemplateGoogle() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1000);
            presencePage.ClickOnPresenceTab();
            presencePage.ClickOnPostTemplateSection();
            presencePage.ClickOnCreateNewTemplateButton();
            presencePage.ClickOnAddTemplateButton();
            if (!presencePage.ValidateErrorMessageForTemplateNameField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message is not displayed when template name is empty");
                softAssert.fail("Error message is not displayed when template name is empty");
            }
            String TemplateName = "TestRule " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyy-HHmm"));
            presencePage.EnterTemplateName(TemplateName);
            presencePage.EnterTemplateDescription("Test Description");
            Thread.sleep(1500);
            presencePage.ClickOnAddTemplateButton();
            if (!presencePage.ValidateErrorMessageForTemplateImageField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message is not displayed when no image is uploaded");
                softAssert.fail(" Error Message is not displayed when no image is uploaded");
            }
            presencePage.UploadTemplateImage("Test_Image_valid.jpg");
            presencePage.ClickOnAddImageOverlayButton();
            presencePage.ClickOnAddOverlayButton();
            presencePage.ClickOnAddOverlayTextOption();
            Thread.sleep(1000);
            presencePage.ClickOnAddOverlayButton();
            presencePage.ClickOnAddOverlayImageOption();
            presencePage.EnterOverlayName(1, "");
            presencePage.ClickOnSaveButton();
            if (!presencePage.ValidateErrorMessageForOverlayNameField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message is not displayed when overlay name is empty");
                softAssert.fail("Error Message is not displayed when overlay name is empty");
            }
            presencePage.EnterOverlayName(1, "     ");
            presencePage.ClickOnSaveButton();
            if (!presencePage.ValidateErrorMessageForOverlayNameField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message is not displayed when only spaces are entered in overlay name field");
                softAssert.fail("Error Message is not displayed when only spaces are entered in overlay name field");
            }
            presencePage.EnterOverlayName(1, "custom Image Overlay");
            presencePage.ClickOnSaveButton();
            if (!presencePage.ValidateXCoordinateFieldErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message is not displayed for empty X coordinate field");
                softAssert.fail("Error Message is not displayed empty X coordinate field");
            }
            presencePage.EnterXCoordinate("10", 1);
            presencePage.ClickOnSaveButton();
            if (!presencePage.ValidateYCoordinateFieldErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message is not displayed empty Y coordinate field");
                softAssert.fail("Error Message is not displayed empty Y coordinate field");
            }
            presencePage.EnterYCoordinate("10", 1);
            presencePage.ClickOnSaveButton();
            if (!presencePage.ValidateWidthFieldErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message is not displayed empty Width field");
                softAssert.fail("Error Message is not displayed empty Width field");
            }
            presencePage.EnterDesiredWidth("100", 1);
            presencePage.ClickOnSaveButton();
            if (!presencePage.ValidateHeightFieldErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message is not displayed empty height field");
                softAssert.fail("Error Message is not displayed empty height field");
            }
            presencePage.EnterDesiredHeight("100", 1);
            presencePage.EnterOverlayName(2, "custom Text Overlay");
            presencePage.EnterXCoordinate("200", 2);
            presencePage.EnterYCoordinate("250", 2);
            presencePage.SelectGravity(2);
            presencePage.SelectFont(1, "Arial");
            presencePage.EnterFontSize("25");
            presencePage.SelectFontType(2);
            presencePage.SelectColor(2);
            presencePage.ClickOnOverlayDeleteButton();
            presencePage.ClickOnConfirmationYesButton();
            presencePage.ClickOnSaveButton();
            presencePage.ClickOnAddTemplateButton();
            if (!presencePage.ValidateSuccessMessageForTemplateCreation()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success pop up is not displayed");
                softAssert.fail("Success pop up is not displayed");
            }
            utils.ClickOnPopUpCloseButton();
            Thread.sleep(1000);
            presencePage.ToggleTemplateStatus();
            Thread.sleep(1000);
            presencePage.ClickOnConfirmationYesButton();
            utils.ClickOnPopUpCloseButton();

        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        });
    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs Post Template")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Creation of Facebook Post Template ", priority = 1)
    public void CreationOfPostTemplateFacebook() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1000);
            presencePage.ClickOnPresenceTab();
            presencePage.ClickOnPostTemplateSection();
            presencePage.SelectFacebookChannel();
            presencePage.ClickOnCreateNewTemplateButton();
            String TemplateName = "TestRule " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyy-HHmm"));
            presencePage.EnterTemplateName(TemplateName);
            presencePage.EnterTemplateDescription("Test Description");
            Thread.sleep(1500);
            presencePage.UploadTemplateImage("Test_Image_valid.jpg");
            presencePage.ClickOnAddImageOverlayButton();
            presencePage.ClickOnAddOverlayButton();
            presencePage.ClickOnAddOverlayTextOption();
            Thread.sleep(1000);
            presencePage.ClickOnAddOverlayButton();
            presencePage.ClickOnAddOverlayImageOption();
            presencePage.EnterOverlayName(1, "Custom Image Overlay");
            presencePage.EnterXCoordinate("10", 1);
            presencePage.EnterYCoordinate("10", 1);
            presencePage.EnterDesiredWidth("100", 1);
            presencePage.EnterDesiredHeight("100", 1);
            presencePage.EnterOverlayName(2, "Custom Text Overlay");
            presencePage.EnterXCoordinate("200", 2);
            presencePage.EnterYCoordinate("250", 2);
            presencePage.SelectGravity(2);
            presencePage.SelectFont(1, "Arial");
            presencePage.EnterFontSize("25");
            presencePage.SelectFontType(2);
            presencePage.SelectColor(2);
            presencePage.ClickOnOverlayDeleteButton();
            presencePage.ClickOnConfirmationYesButton();
            presencePage.ClickOnSaveButton();
            presencePage.ClickOnAddTemplateButton();
            if (!presencePage.ValidateSuccessMessageForTemplateCreation()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success pop up is not displayed");
                softAssert.fail("Success pop up is not displayed");
            }
            utils.ClickOnPopUpCloseButton();
            presencePage.ToggleTemplateStatus();
            presencePage.ClickOnConfirmationYesButton();
            utils.ClickOnPopUpCloseButton();

        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        });
    }
}

