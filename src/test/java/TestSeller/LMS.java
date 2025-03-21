package TestSeller;

import BaseSetup.BaseTest;
import PagesSeller.LMSPage;
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

public class LMS extends BaseTest {


    private PerformancePage performancePage;
    private LMSPage lmsPage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalSellerUrl);
        lmsPage = new LMSPage(getDriver());
        performancePage = new PerformancePage(getDriver());
        utils = new Utils(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", super.HyperUAT);
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
        performancePage.SelectingClient("Test OEM 3 (Test OEM 3)", 1);
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


    //    @AfterClass(alwaysRun = true)
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("Seller Dashboard")
    @Story("This flow belongs LMS")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Modify LMS Data", priority = 0)
    public void ModifyLMSData() {
//        utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(2500);
            performancePage.CloseAnnouncementCloseButtonIfAvailable();
            lmsPage.ClickOnLeadsButton();
            performancePage.SelectingClient("All Dealers", 1);
            Thread.sleep(20000);
            lmsPage.ClickOnFilterIcon();
            lmsPage.SelectNameFilterOption(5);
            lmsPage.EnterNameInFilterOptions("Arpit");
            lmsPage.ClickOnFilterApplyButton();
            if (!lmsPage.IsLeadCardDisplayed()) {
                softAssert.fail("Soft Assert: The Lead Card is not Displayed After Applying Filter");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card is not Displayed After Applying Filter");
            }

//                lmsPage.ClickOnCallIcon();
//                if(lmsPage.IsCallAlertDisplayed()) {
//                    softAssert.fail("Soft Assert: The Call Alert is not Displayed");
//                    utils.TakeScreenshotOnSoftAssertion("The Call Alert is not Displayed");
//                }
            lmsPage.ClickOnWhatsappIcon();
            if (!lmsPage.IsWhatsappPageDisplayed()) {
                softAssert.fail("Soft Assert: The Whatsapp Redirected Page is not Displayed");
                utils.TakeScreenshotOnSoftAssertion("The Whatsapp Redirected Page is not Displayed");
            }

            lmsPage.ClickOnToDoListIcon();
            lmsPage.ClickOnDatePickerField();
            lmsPage.ClickOnMonthField();
            lmsPage.SelectOption(3);
            lmsPage.SelectDay(28);
            lmsPage.EnterNoteInNoteField("Test Note");
            lmsPage.ClickOnToDoDoneButton();
            if (!lmsPage.IsToDoListDataReflectedInNotes("Test Note")) {
                softAssert.fail("Soft Assert: The ToDo List Data is not Reflected in Notes");
                utils.TakeScreenshotOnSoftAssertion("The ToDo List Data is not Reflected in Notes");
            }
            lmsPage.ClickOnLeadsNoteSaveButton();
            lmsPage.ClickOnNotesIcon();
            lmsPage.EnterDataInLeadNotesTextField("          ");
            lmsPage.ClickOnLeadsNoteSaveButton();
            Thread.sleep(1500);
            lmsPage.ClickOnNotesIcon();
            if (lmsPage.IsLeadNotesFieldAcceptsEmptySpace()) {
                softAssert.fail("Soft Assert: The Lead Notes Text Field is Accepting Only Spaces As Input");
                utils.TakeScreenshotOnSoftAssertion("The Lead Notes Text Field is Accepting Only Spaces As Input");
            }
            lmsPage.ClickOnLeadsNoteSaveButton();
            lmsPage.ClickOnContactCopyIcon();
            if (!lmsPage.IsCopyContactSuccessPopUpDisplayed()) {
                softAssert.fail("Soft Assert: The Contact Copy Success Pop is not Displayed");
                utils.TakeScreenshotOnSoftAssertion("The Contact Copy Success Pop Alert is not Displayed");
            }

            lmsPage.ClickOnToDoListIcon();
            lmsPage.ClickOnDatePickerField();
            lmsPage.ClickOnMonthField();
            lmsPage.SelectCurrentMonthInDatePicker();
            lmsPage.SelectCurrentDay();
            lmsPage.ClickOnToDoDoneButton();

            lmsPage.ClickOnToDoListRadioButton();
            if (!lmsPage.IsLeadCardReflectedInToDoList("Arpit")) {
                softAssert.fail("Soft Assert: The Lead Card with Current data is not updated in to do list");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card with Current data is not updated in to do list");
            }
            lmsPage.ClickOnMarkAsDoneCheckBox();
            if (!lmsPage.IsMarkAsDoneSuccessPopUpDisplayed()) {
                softAssert.fail("Soft Assert: The Mark As Done Success Pop Up is not Displayed");
                utils.TakeScreenshotOnSoftAssertion("The Mark As Done Success Pop Up is not Displayed");
            }

            lmsPage.ClickOnMarkAsDoneUndoButton();

            if (!lmsPage.IsLeadCardDisplayed()) {
                softAssert.fail("Soft Assert: The Lead Card is not Displayed After Clicking Undo ");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card is not Displayed After Clicking Undo");
            }

            lmsPage.ClickOnCardStatusIcon();
            lmsPage.EnterDataInLeadNotesTextField("          ");
            lmsPage.ClickOnCardSectionSaveButton();

            if (lmsPage.IsLeadUpdatedSuccessPopUpDisplayed()) {
                softAssert.fail("Soft Assert: The Notes Field is Accepting Only Spaces As Input and Saving");
                utils.TakeScreenshotOnSoftAssertion("The Notes Field is Accepting Only Spaces As Input and Saving");
            }

            lmsPage.ClickOnCardStatusDropdown();
            lmsPage.SelectOption(1);
            if (lmsPage.IsLeadUpdatedSuccessPopUpDisplayed()) {
                softAssert.fail("Soft Assert: Lead Card Status Update Success Pop Up is not Displayed");
                utils.TakeScreenshotOnSoftAssertion("Lead Card Status Update Success Pop Up is not Displayed");
            }

            lmsPage.ClickOnFollowUpRadioButton();
            if (!lmsPage.IsLeadCardReflectedInFollowUp("Arpit")) {
                softAssert.fail("Soft Assert: The Lead Card with Current data is not updated in Follow Up");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card with Current data is not updated in Follow Up");
            }
            lmsPage.ClickOnFollowUpRadioButton();


            lmsPage.ClickOnCardStatusDropdown();
            lmsPage.SelectOption(2);
            lmsPage.ClickOnTestDriveScheduledRadioButton();
            if (!lmsPage.IsLeadCardReflectedInTestDriveScheduled("Arpit")) {
                softAssert.fail("Soft Assert: The Lead Card with Current data is not updated in Test Drive Scheduled");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card with Current data is not updated in Test Drive Scheduled");
            }
            lmsPage.ClickOnTestDriveScheduledRadioButton();


            lmsPage.ClickOnCardStatusDropdown();
            lmsPage.SelectOption(3);
            Thread.sleep(1000);
            lmsPage.ClickOnTestDriveCompletedRadioButton();
            if (!lmsPage.IsLeadCardReflectedInTestDriveCompleted("Arpit")) {
                softAssert.fail("Soft Assert: The Lead Card with Current data is not updated in Test Drive Completed");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card with Current data is not updated in Test Drive Completed");
            }

            lmsPage.ClickOnTestDriveCompletedRadioButton();


            lmsPage.ClickOnCardStatusDropdown();
            lmsPage.SelectOption(4);
            Thread.sleep(1000);
            lmsPage.ClickOnNegotiationCheckBox();
            if (!lmsPage.IsLeadCardReflectedInNegotiation("Arpit")) {
                softAssert.fail("Soft Assert: The Lead Card with Current data is not updated in Negotiation");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card with Current data is not updated in Negotiation");
            }
            lmsPage.ClickOnNegotiationCheckBox();


            lmsPage.ClickOnCardStatusDropdown();
            lmsPage.SelectOption(5);
            Thread.sleep(1000);
            lmsPage.ClickOnBookingDoneRadioButton();
            if (!lmsPage.IsLeadCardReflectedInBookingDone("Arpit")) {
                softAssert.fail("Soft Assert: The Lead Card with Current data is not updated in Booking Done");
                utils.TakeScreenshotOnSoftAssertion("The Lead Card with Current data is not updated in Booking Done");
            }
            lmsPage.ClickOnBookingDoneRadioButton();
            lmsPage.ClickOnDownloadReportIcon();
            if (!lmsPage.ClickOnDownloadButton()) {
                utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Processing Failed or download button took more than 2 minutes to be enabled");
                softAssert.fail("Processing Failed or download button took more than 2 minutes to be enabled");
            }
            lmsPage.ClickOnDownloadCloseButton();
            lmsPage.ClickOnMarkAsDoneCheckBox();
            if (!lmsPage.IsDownloadEnabledWhileNoLeadDataAvailable()) {
                softAssert.fail("Soft Assert: The Download Button is Enabled While No Lead Data is Available");
                utils.TakeScreenshotOnSoftAssertion("The Download Button is Enabled While No Lead Data is Available");
            }
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
//        }));
    }


}
