package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.PresencePage;
import PagesSeller.DashboardPage;
import PagesSeller.MeninxPage;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostManagement extends BaseTest {

    private PresencePage presencePage;
    private MeninxPage meninxPage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        utils = new Utils(getDriver());
        presencePage = new PresencePage(getDriver());
        meninxPage = new MeninxPage(getDriver());
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

//        @AfterClass(alwaysRun = true)
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs Post Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: New Facebook Post Creation with Image and Video", priority = 0)
    public void CreationOfPostFacebook() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1000);
            presencePage.ClickOnPresenceTab();
            presencePage.ClickOnPostManagementTab();
            presencePage.ClickOnCreateNewPost();
            presencePage.EnterPostName("Test Post" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyy-HHmm")));
            meninxPage.SelectScheduleDate("April", "2025", "16");
            meninxPage.TimeSelection(12, 3, "am");
            presencePage.ClickOnCalenderApplyButton();
            Thread.sleep(1500);
            presencePage.ClickOnNextButtonTemp();
            if (!presencePage.ValidateErrorMessageForPartnerField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Add partner Field error message is not displayed for being empty");
                softAssert.fail("Add partner Field error message is not displayed for being empty");
            }
            presencePage.ClickOnAddPartnerButton();
            presencePage.SelectPartners(2);
            presencePage.ClickOnPartnerSaveButton();
            meninxPage.EnterDesiredTextInTag("test");
            presencePage.ClickOnNextButtonTemp();
            presencePage.ClickOnNextButtonTemp();
            if (!meninxPage.ValidateVisibilityOfErrorHighlightForCreativeSelectionField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative selection page is not Highlighted for being empty");
                softAssert.fail("Creative selection page is not Highlighted for being empty");
            }
            meninxPage.SelectDesiredMediaType(2);
            presencePage.ClickOnNextButtonTemp();
            if (!presencePage.ValidateVideoDescriptionErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Error message for video description field is not displayed");
                softAssert.fail("Error message for video description field is not displayed");
            }
            Thread.sleep(800);
            meninxPage.EnterDesiredTextInVideoDescriptionField("                ");
            presencePage.ClickOnNextButtonTemp();
            if (!presencePage.ValidateVideoDescriptionErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Error message for video description field is not displayed when only spaces are entered as input");
                softAssert.fail("Error message for video description field is not displayed when only spaces are entered as input");
            }
            meninxPage.EnterDesiredTextInVideoDescriptionField("Test Description");
            presencePage.ClickOnNextButtonTemp();
            if (!presencePage.ValidateVideoFieldIsHighlighted()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Creative video selection page is not Highlighted for being empty");
                softAssert.fail("Creative Video selection page is not Highlighted for being empty");
            }
            meninxPage.UploadVideo("Test_Video.mp4");
            Thread.sleep(1000);
            meninxPage.UploadThumbnailImage("Test_Image.jpeg");
            presencePage.ClickOnNextButtonTemp();
            if (!presencePage.ValidateVideoTitleErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Video title Error message is not displayed");
                softAssert.fail("Video title Error message is not displayed");
            }
            presencePage.EnterVideoTitle("         ");
            presencePage.ClickOnNextButtonTemp();
            if (!presencePage.ValidateVideoTitleErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Video title Error message is not displayed when only spaces are entered as input");
                softAssert.fail("Video title Error message is not displayed when only spaces are entered as input");
            }
            presencePage.EnterVideoTitle("Test Title");
            Thread.sleep(1000);
            presencePage.ClickOnNextButtonTemp();
            meninxPage.ClickOnPublishPostButton();
            if (!presencePage.ValidateSuccessMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Facebook Post with video creation Failed");
                softAssert.fail("Facebook Post with video Creation Failed");
            }
            utils.ClickOnPopUpCloseButton();
            Thread.sleep(2000);
                        //Facebook post with image
            meninxPage.ClickOnCreateNewPost();
            presencePage.EnterPostName("Test Post" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss")));
            meninxPage.SelectScheduleDate("April", "2025", "16");
            meninxPage.TimeSelection(12, 3, "am");
            presencePage.ClickOnCalenderApplyButton();
            presencePage.ClickOnAddPartnerButton();
            Thread.sleep(1500);
            presencePage.SelectPartners(2);
            presencePage.ClickOnPartnerSaveButton();
            meninxPage.EnterDesiredTextInTag("test");
            presencePage.ClickOnNextButtonTemp();
            presencePage.ClickOnNextButtonTemp();
            meninxPage.ClickOnChooseFromTemplateFacebook();
            meninxPage.ClickOnTemplateFilter();
            meninxPage.SelectTemplateFilterAttribute("Channel");
            if (!meninxPage.ValidateFaceBookCheckBoxIsSelected()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Facebook checkbox is not selected by default");
                softAssert.fail("FaceBook checkbox is not selected by default");
            }
            meninxPage.SelectTemplateFilterAttribute("Template Name");
            meninxPage.EnterTemplateName("Test Template Automation");
            meninxPage.ClickOnFilterApplyButton();
            meninxPage.SelectTemplate(1);
            meninxPage.ClickOnTemplateChooseButton();
            meninxPage.ClickOnDeleteButton();
            meninxPage.ClickOnChooseFromLibrary();
            meninxPage.SelectDesiredImage(4);
            meninxPage.ClickOnChooseFromImageLibrary();

            presencePage.ClickOnNextButtonTemp();
            if (!presencePage.ValidateVisibilityOfImageCaptionErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Image caption Error message is not displayed");
                softAssert.fail("Image caption Error message is not displayed");
            }
            meninxPage.EnterDesiredTextInImageCaptionField(1, "           ");
            if (!presencePage.ValidateVisibilityOfImageCaptionErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Image caption field accepts only spaces without any error message");
                softAssert.fail("Image caption field accepts only spaces without any error message");
            }
            meninxPage.EnterDesiredTextInImageCaptionField(1, "Test Caption");
            presencePage.ClickOnNextButtonTemp();
            Thread.sleep(2000);
            meninxPage.ClickOnConfigEditButton();
            presencePage.ClickOnNextButtonTemp();
            presencePage.ClickOnNextButtonTemp();
            meninxPage.ClickOnPostEditButton();
            presencePage.ClickOnNextButtonTemp();
            meninxPage.ClickOnPublishPostButton();
            if (!presencePage.ValidateSuccessMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Facebook Post with image creation Failed");
                softAssert.fail("Facebook Post with image Creation Failed");
            }
            utils.ClickOnPopUpCloseButton();


        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        });
    }



    // the below three flows are not optimized (pendo class needed)
//    @Epic("Seller Dashboard")
//    @Story("This flow belongs Post Creation")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(timeOut = 1200000, description = "Test: New Post Creation-Google My Business")
//    public void GooglePostCreationWithWhatsNew() {
////        utils.RetryOnFailHyperPulse((() -> {
//        SoftAssert softAssert = new SoftAssert();
//        try {
//            Thread.sleep(2500);
////            performancePage.CloseAnnouncementCloseButtonIfAvailable();
//            presencePage.ClickOnPresenceTab();
//            presencePage.ClickOnPostManagementTab();
//            meninxPage.ClickOnCreateNewPost();
//            meninxPage.ClickOnNextButton();
//            if (!meninxPage.IsPostNameEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Post Name Empty Error Message is not displayed");
//                softAssert.fail("Post Name Empty Error Message is not displayed");
//            }
//            meninxPage.EnterPostName("              ");
//            if (meninxPage.IsPostNameFieldAcceptsOnlySpaces()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Post Name Field accepts only spaces As Input");
//                softAssert.fail("Post Name Field accepts only spaces As Input");
//            }
//
//            meninxPage.EnterPostName(utils.generateRandomData("randomdata", 10).toString());
//
//            if (meninxPage.IsPostNameFieldAcceptsMoreThan50Characters()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Post Name Field accepts more than 50 characters");
//                softAssert.fail("Post Name Field accepts more than 50 characters");
//            }
//
//            meninxPage.SelectScheduleDate("February", "2025" , String.valueOf(LocalDateTime.now().getDayOfMonth()));
//            meninxPage.TimeSelection(1, 3, "am");
//            meninxPage.ClickOnCalenderApplyButtonTemp();
//
//            if (!meninxPage.IsInvalidScheduleTimeErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Invalid Schedule Time Error Message is not displayed");
//                softAssert.fail("Invalid Schedule Time Error Message is not displayed");
//            }
//
//            meninxPage.EnterDesiredTextInTagField("      ");
//            if (meninxPage.IsEmptyAddTagVisible()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Add Tag is Accepting Empty Input");
//                softAssert.fail("Add Tag is Accepting Empty Input");
//            }
//            meninxPage.EnterPostName("Test Post " + LocalDate.now());
//            meninxPage.SelectGoogleMyBusiness();
//            meninxPage.SelectScheduleDate("March", "2025", "15");
//            meninxPage.TimeSelection(12, 3, "am");
//            meninxPage.ClickOnCalenderApplyButtonTemp();
//            meninxPage.EnterDesiredTextInTagField("test");
//            meninxPage.ClickOnNextButton();
//            Thread.sleep(1000);
//            meninxPage.ClickOnNextButton();
//            if (!meninxPage.IsSummaryFieldEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Summary Field Empty Error Message is not displayed");
//                softAssert.fail("Summary Field  Empty Error Message is not displayed");
//            }
//            if (!meninxPage.IsCreativeMediaErrorLineDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Creative Media Error Line is not displayed");
//                softAssert.fail("Creative Media Error Line is not displayed");
//            }
//            meninxPage.EnterSummary("           ");
//            if (meninxPage.IsSummaryFieldAcceptsEmptyInput()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Summary Field Accepts Empty Input");
//                softAssert.fail("Summary Field Accepts Empty Input");
//            }
//            meninxPage.SelectCTA("Shop");
//            if (!meninxPage.IsUrlEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : URL Empty Error Message is not displayed");
//                softAssert.fail("URL Empty Error Message is not displayed");
//            }
//            meninxPage.EnterCTAUrl("           ");
//            if (!meninxPage.IsUrlEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : URL Empty Error Message is not displayed");
//                softAssert.fail("URL Empty Error Message is not displayed");
//            }
//            meninxPage.EnterCTAUrl("      skjfkjfss ");
//            if (!meninxPage.IsUrlEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Invalid URL  Error Message is not displayed");
//                softAssert.fail("Invalid URL  Error Message is not displayed");
//            }
//            meninxPage.ClickOnCTACloseButton();
//            meninxPage.EnterSummary("Test Summary");
//            meninxPage.ClickOnChooseFromTemplate();
//            meninxPage.ClickOnTemplateFilter();
//            meninxPage.SelectTemplateFilterAttribute("Channel");
//            if (!meninxPage.ValidateGoogleCheckBox()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Google checkbox is not selected by default");
//                softAssert.fail("Google checkbox is not selected by default");
//            }
//            meninxPage.SelectTemplateFilterAttribute("Template Name");
//            meninxPage.EnterTemplateName("Test Template101");
//            meninxPage.ClickOnFilterApplyButton();
//            meninxPage.SelectTemplate(1);
//            meninxPage.ClickOnTemplateChooseButton();
//            meninxPage.SelectCTA("Shop");
//            meninxPage.EnterCTAUrl("https://www.google.com");
//            meninxPage.ClickOnNextButton();
//            meninxPage.ClickOnConfigEditButton();
//            //validation
//            Thread.sleep(1000);
//            meninxPage.ClickOnNextButton();
//            meninxPage.ClickOnNextButton();
//            meninxPage.ClickOnPostEditButton();
//            Thread.sleep(1000);
//            meninxPage.ClickOnNextButton();
//            meninxPage.ClickOnPublishPostButton();
//        } catch (InterruptedException e) {
//            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
//        }
//        softAssert.assertAll();
////        }));
//    }
//
//
//    @Epic("Seller Dashboard")
//    @Story("This flow belongs Post Creation")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(timeOut = 1200000, description = "Test: New Post Creation-Google My Business")
//    public void GooglePostCreationWithEvents() {
////        utils.RetryOnFailHyperPulse((() -> {
//        SoftAssert softAssert = new SoftAssert();
//        try {
//            Thread.sleep(2500);
////            performancePage.CloseAnnouncementCloseButtonIfAvailable();
//            presencePage.ClickOnPresenceTab();
//            presencePage.ClickOnPostManagementTab();
//            meninxPage.ClickOnCreateNewPost();
//            meninxPage.EnterPostName("Test Post " + LocalDate.now());
//            meninxPage.SelectGoogleMyBusiness();
//            meninxPage.SelectEventsRadio();
//            meninxPage.SelectScheduleDate("March", "2025", "15");
//            meninxPage.TimeSelection(12, 3, "am");
//            meninxPage.ClickOnCalenderApplyButtonTemp();
//            meninxPage.EnterDesiredTextInTagField("test");
//            meninxPage.ClickOnNextButton();
//            meninxPage.ClickOnNextButton();
//            if(!meninxPage.IsEventTitleEmptyErrorMessageDisplayed()){
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Event Title Empty Error Message is not displayed");
//                softAssert.fail("Event Title Empty Error Message is not displayed");
//            }
//            if(!meninxPage.IsEventScheduleDateEmptyErrorMessageDisplayed()){
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Event Schedule Date Empty Error Message is not displayed");
//                softAssert.fail("Event Schedule Date Empty Error Message is not displayed");
//            }
//            meninxPage.EnterEventTitle("           ");
//            if (meninxPage.IsEventTitleFieldAcceptsEmptyInput()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Event Title Field Accepts Empty Input");
//                softAssert.fail("Event Title Field Accepts Empty Input");
//            }
//            meninxPage.EnterSummary("Test Summary");
//            meninxPage.ClickOnChooseFromTemplateEvents();     //temp
//            Thread.sleep(1000);
//            meninxPage.ClickOnTemplateFilter();
//            meninxPage.SelectTemplateFilterAttribute("Channel");
//            if (!meninxPage.ValidateGoogleCheckBox()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Google checkbox is not selected by default");
//                softAssert.fail("Google checkbox is not selected by default");
//            }
//            meninxPage.SelectTemplateFilterAttribute("Template Name");
//            Thread.sleep(1000);
//            meninxPage.EnterTemplateNameTemp("Test Template101"); //temp
//            meninxPage.ClickOnFilterApplyButton();
//            meninxPage.SelectTemplate(1);
//            meninxPage.ClickOnTemplateChooseButton();
//            meninxPage.EnterEventTitle("Test Event");
//            meninxPage.SelectCTA("Shop");
//            meninxPage.EnterEventCTAUrl("https://www.google.com");
//            meninxPage.ClickOnNextButton();
//            LocalDate StartDate = LocalDate.of(2025, 3, 10);
//            LocalDate EndDate = LocalDate.of(2025, 5, 12);
//            meninxPage.ClickOnEventScheduleDateRange();
//            dashboardPage.selectDateRange(StartDate, EndDate);
//
//        } catch (InterruptedException e) {
//            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
//        }
//        softAssert.assertAll();
////        }));
//    }
//
//
//    @Epic("Seller Dashboard")
//    @Story("This flow belongs Post Creation")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(timeOut = 1200000, description = "Test: New Post Creation-Google My Business")
//    public void GooglePostCreationWithOffer() {
////        utils.RetryOnFailHyperPulse((() -> {
//        SoftAssert softAssert = new SoftAssert();
//        try {
//            Thread.sleep(2500);
////            performancePage.CloseAnnouncementCloseButtonIfAvailable();
//            presencePage.ClickOnPresenceTab();
//            presencePage.ClickOnPostManagementTab();
//            meninxPage.ClickOnCreateNewPost();
//            meninxPage.EnterPostName("Test Post " + LocalDate.now());
//            meninxPage.SelectGoogleMyBusiness();
//            meninxPage.SelectOfferRadio();
//            meninxPage.SelectScheduleDate("March", "2025", "15");
//            meninxPage.TimeSelection(12, 3, "am");
//            meninxPage.ClickOnCalenderApplyButtonTemp();
//            meninxPage.EnterDesiredTextInTagField("test");
//            meninxPage.ClickOnNextButton();
//            meninxPage.EnterSummary("Test Summary");
//            meninxPage.ClickOnChooseFromTemplateEvents();     //temp
//            Thread.sleep(1000);
//            meninxPage.ClickOnTemplateFilter();
//            meninxPage.SelectTemplateFilterAttribute("Channel");
//            if (!meninxPage.ValidateGoogleCheckBox()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion : Google checkbox is not selected by default");
//                softAssert.fail("Google checkbox is not selected by default");
//            }
//            meninxPage.SelectTemplateFilterAttribute("Template Name");
//            Thread.sleep(1000);
//            meninxPage.EnterTemplateNameTemp2("Test Template101"); //temp
//            meninxPage.ClickOnFilterApplyButton();
//            meninxPage.SelectTemplate(1);
//            meninxPage.ClickOnTemplateChooseButton();
//            meninxPage.EnterEventTitle("Test Event1");
//            meninxPage.EnterCouponCode("Test Coupon Code");
//            meninxPage.EnterLinkToRedeemOfferURL("https://www.google.com");
//            LocalDate StartDate = LocalDate.of(2025, 3, 1);
//            LocalDate EndDate = LocalDate.of(2025, 3, 10);
//            meninxPage.ClickOnEventScheduleDateRange();
//            dashboardPage.selectDateRange(StartDate, EndDate);
//            meninxPage.ClickOnNextButton();
//            meninxPage.ClickOnPublishPostButton();
//
//        } catch (InterruptedException e) {
//            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
//        }
//        softAssert.assertAll();
////        }));
//    }
//
//    @Epic("Seller Dashboard")
//    @Story("This flow belongs Post Management")
//    @Severity(SeverityLevel.NORMAL)
//    @Test(timeOut = 1200000, description = "Test: Post Management Dashboard Operations")
//    public void PostManagementDashboardOperations() {
////        utils.RetryOnFailHyperPulse((() -> {
//        SoftAssert softAssert = new SoftAssert();
//        try {
//            Thread.sleep(2500);
////            performancePage.CloseAnnouncementCloseButtonIfAvailable();
//            presencePage.ClickOnPresenceTab();
//            presencePage.ClickOnPostManagementTab();
//
//
//        } catch (InterruptedException e) {
//            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
//        }
//        softAssert.assertAll();
////        }));
//    }
}
