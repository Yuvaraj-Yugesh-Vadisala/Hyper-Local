package TestSeller;

import BaseSetup.BaseTest;
import PagesSeller.PerformancePage;
import UtilityClass.Utils;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class Performance extends BaseTest {


    private PerformancePage performancePage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalSellerUrl);
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


    @AfterClass(alwaysRun = true)
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("Seller Dashboard")
    @Story("This flow belongs Performance Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Create a successful Performance campaign flow with Google(Call Only and Awareness)", priority = 0)
    public void CreatePerformanceCampaignWithGooglePositive() {
        utils.RetryOnFailHyperSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(2500);
                performancePage.CloseAnnouncementCloseButtonIfAvailable();
                performancePage.ClickOnCreateCampaignButton();
                Thread.sleep(1500);
                performancePage.EnterCampaignName();
                performancePage.SelectGoogleChannel();
                performancePage.SelectFixSchedule();
                performancePage.EnterAverageDailyBudget("800");
                performancePage.EnterLifeTimeBudget("4000");
                performancePage.ClickOnStartDateField();
                performancePage.DateSelector("April", "2025", "15");
                performancePage.ClickOnBudgetSettingsNextButton();
                if (!performancePage.ValidateErrorMessageEndDateField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - End date field is being saved without any value");
                    softAssert.fail("End date field is being saved without any value");
                }
                Thread.sleep(1500);
                performancePage.ClickOnBudgetSettingsTab();
                performancePage.ClickOnEndDateField();
                performancePage.DateSelector("June", "2025", "20");
                performancePage.ClickOnBudgetSettingsNextButton();
                performancePage.ClickOnCreateNewAdButton();
                performancePage.EnterCreativeName();
                performancePage.SelectCreativeType("Call only Ad");
                performancePage.SelectCampaignFor(1);
                performancePage.SelectThisTemplateFor(5);
                performancePage.SelectCountryCodeDynamically(1);
                performancePage.EnterPhoneNumberDynamically(2);
                performancePage.EnterPhoneNumberVerificationUrlDynamically(3);
                performancePage.EnterBusinessNameDynamically(1);
                performancePage.EnterDescription1(2);
                performancePage.EnterDescription2(3);
                performancePage.EnterWebsiteUrlDynamically(1);
                performancePage.EnterDomainDynamically(1);
                performancePage.ClickOnCreateButton();
                performancePage.ClickOnChooseMoreFromAdsLibraryButton();
                performancePage.SelectGoogleTemplate(1);
                performancePage.ClickOnSaveButton();
                //Creation of Responsive Search Ad
                performancePage.ClickOnCreateNewAdButtonTemp();
                performancePage.EnterCreativeName();
                performancePage.SelectCreativeType("Responsive Search Ad");
                performancePage.SelectCampaignFor(2);
                performancePage.AddFinalUrlDynamically(1);
                performancePage.EnterGoogleDisplayURlDynamically(2);  //Xpath temporary
                Thread.sleep(2000);
                performancePage.AddHeadline1Dynamically(1);
                performancePage.AddHeadline2Dynamically(2);
                performancePage.AddHeadline3Dynamically(2);
                performancePage.AddDescription1Dynamically(1);
                performancePage.AddDescription2Dynamically(2);
                performancePage.ClickOnCreateButton();
                performancePage.ClickOnAdSaveButton();
                Thread.sleep(500);
                performancePage.ClickOnLaunchButton();
                if (!performancePage.ValidateCampaignCreation()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign creation failed");
                    softAssert.fail("Campaign creation failed");
                }
                Thread.sleep(1000);
                if (!performancePage.ValidateCampaignCreation(PerformancePage.RandomCampaignName)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Created campaign is not displayed in first Row");
                    softAssert.fail(" Created campaign is not displayed in first Row");
                }

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }


    @Epic("Seller Dashboard")
    @Story("This flow belongs Performance Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Validate all fields while Creating performance campaign with Google channel", priority = 1)
    public void CreatePerformanceCampaignWithGoogleNegative() {
        utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(2000);
            performancePage.CloseAnnouncementCloseButtonIfAvailable();
            performancePage.ClickOnCreateCampaignButton();
            Thread.sleep(1500);
            performancePage.ClickOnBudgetSettingsNextButton();
            if (!performancePage.ValidateErrorMessageForCampaignName()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for Campaign Name Field is not displayed When left Empty");
                softAssert.fail("Error message for Campaign Name Field is not displayed When left Empty");
            }
            performancePage.EnterDesiredCampaignName("               ");
            performancePage.ClickOnBudgetSettingsNextButton();
            if (!performancePage.ValidateErrorMessageForCampaignName()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for Campaign Name Field is not displayed When only spaces are entered");
                softAssert.fail("Error message for Campaign Name Field is not displayed When only spaces are entered");
            }
            performancePage.EnterCampaignName();
            performancePage.SelectGoogleChannel();
            performancePage.SelectFixSchedule();
            performancePage.ClickOnBudgetSettingsNextButton();
            if (!performancePage.ValidateErrorMessageForAverageDailyBudgetField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Average Daily Budget Field not displayed");
                softAssert.fail("Error Message for empty Average daily budget field not displayed");
            }
            performancePage.EnterAverageDailyBudget("499");
            performancePage.ClickOnBudgetSettingsNextButton();
            if (!performancePage.ValidateErrorMessageForAverageDailyBudgetField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average daily budget accepts value less than 500 which is minimum without any error message");
                softAssert.fail("Average daily budget accepts value less than 500 which is minimum without any error message");
            }
            performancePage.EnterAverageDailyBudget("800");
            performancePage.EnterLifeTimeBudget("500");
            performancePage.ClickOnBudgetSettingsNextButton();
            if (!performancePage.ValidateErrorMessageForLifeTimeBudgetField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Life Time budget accepts value less tha minimum value without any error message");
                softAssert.fail("Life Time budget accepts value less tha minimum value without any error message");
            }
            performancePage.EnterLifeTimeBudget("4000");
            performancePage.ClickOnStartDateField();
            performancePage.DateSelector("April", "2025", "15");
            performancePage.ClickOnBudgetSettingsNextButton();
            if (!performancePage.ValidateErrorMessageEndDateField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - End date field is being saved without any value");
                softAssert.fail("End date field is being saved without any value");
            }
            Thread.sleep(1500);
            performancePage.ClickOnBudgetSettingsTab();
            performancePage.ClickOnEndDateField();
            performancePage.DateSelector("June", "2025", "20");
            performancePage.ClickOnBudgetSettingsNextButton();
            performancePage.ClickOnAdSaveButton();
            if (!performancePage.ValidateErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Validate Error Message for Not Selecting any Ad");
                softAssert.fail("Validate Error Message for Not Selecting any Ad");
            }
            performancePage.ClickOnCreateNewAdButton();
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForCreativeName()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Creative Name Field not displayed");
                softAssert.fail("Error Message for empty Creative name field not displayed");
            }
            performancePage.EnterDesiredCreativeName("              ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForCreativeName()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Creative Name Field not displayed when only spaces are entered");
                softAssert.fail("Error Message for Creative name field not displayed when only spaces are entered");
            }
            performancePage.EnterDesiredCreativeName(utils.generateRandomData("randomdata", 92).toString());
            if (!performancePage.ValidateCreativeNameMaxCharLimit()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative name field accepts more than 90 characters");
                softAssert.fail("Creative name field accepts more than 90 characters");
            }
            performancePage.EnterCreativeName();
            performancePage.SelectCreativeType("Call only Ad");
            performancePage.SelectCampaignFor(1);

            if (!performancePage.ValidateErrorMessageForSKUSelection()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty SKU Selection Field not displayed");
                softAssert.fail("Error Message for SKU Selection field not displayed");
            }
            performancePage.SelectThisTemplateFor(5);
            if (!performancePage.ValidateErrorMessageForCountryCodeField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Country code Field not displayed");
                softAssert.fail("Error Message for Country code field not displayed");
            }
            performancePage.EnterDesiredValueInCountryCodeField("           ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForCountryCodeField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Country code Field not displayed when only spaces are entered");
                softAssert.fail("Error Message for Country code field not displayed when only spaces are entered");
            }
            if (!performancePage.ValidateErrorMessageForPhoneNumberField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Phone number Field not displayed");
                softAssert.fail("Error Message for Empty Phone number Field not displayed");
            }
            performancePage.EnterDesiredPhoneNumber("          ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForPhoneNumberField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Phone number Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Phone number Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForPhoneNumberVerificationUrlField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Phone number url Field not displayed");
                softAssert.fail("Error Message for Empty Phone number url Field not displayed");
            }
            performancePage.EnterDesiredPhoneNumberVerificationUrl("          ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForPhoneNumberVerificationUrlField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Phone number url Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Phone number url Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForBusinessNameField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Business Name Field not displayed");
                softAssert.fail("Error Message for Empty Business Name Field not displayed");
            }
            performancePage.EnterDesiredBusinessName("          ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForBusinessNameField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Business Name Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Business Name Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForDescription1Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Description1 Field not displayed");
                softAssert.fail(" Error Message for Empty Description1 Field not displayed");
            }
            performancePage.EnterDesiredDescription1("          ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForDescription1Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Description1 Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Description1 Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForDescription2Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Description2 Field not displayed");
                softAssert.fail("Error Message for Empty Description2 Field not displayed");
            }
            performancePage.EnterDesiredDescription2("          ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForDescription2Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for  Description2 Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for  Description2 Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForWebsiteUrlField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Website Url Field not displayed");
                softAssert.fail("Error Message for Empty Website Url Field not displayed");
            }
            performancePage.EnterDesiredWebsiteUrl("          ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForWebsiteUrlField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Website Url Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Website Url Field not displayed when only spaces are entered as input");
            }
            performancePage.EnterDesiredWebsiteUrl("invalidurl.com");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForWebsiteUrlField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Website Url Field not displayed when invalid url is entered as input");
                softAssert.fail("Error Message for Website Url Field not displayed when invalid url is entered as input");
            }
            if (!performancePage.ValidateErrorMessageForDomainField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Domain Name Field not displayed");
                softAssert.fail(" Error Message for Empty Domain Name Field not displayed");
            }
            performancePage.EnterDesiredDomain("          ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForDomainField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Domain Name Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Domain Name Field not displayed when only spaces are entered as input");
            }
//            performancePage.CloseDesiredPage(2);
            performancePage.SelectCreativeType("Responsive Search Ad");
            performancePage.ClickOnConfirmationYesButton();
            performancePage.SelectCampaignFor(2);
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForFinalUrl()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Final Url Field not displayed");
                softAssert.fail("Error Message for Empty Final Url Field not displayed");
            }
            performancePage.AddDesiredFinalUrl("test.com@");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForFinalUrl()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Final Url Field not displayed when invalid url is entered");
                softAssert.fail("Error Message for Final Url Field not displayed when invalid url is entered");
            }
            performancePage.AddFinalUrlDynamically(1);
            if (!performancePage.ValidateErrorMessageForDisplayUrlField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Google Display Url Field not displayed");
                softAssert.fail("Error Message for Empty Google Display Url Field not displayed");
            }
            performancePage.EnterDesiredGoogleDisplayURl("        ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForDisplayUrlField()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Google Display Url Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Empty Google Display Url Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForHeadline1Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Headline1 Field not displayed");
                softAssert.fail("Error Message for Empty Headline1 Field not displayed");
            }
            performancePage.AddDesiredHeadline1("        ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForHeadline1Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Headline1 Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Empty Headline1 Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForHeadline2Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Headline2 Field not displayed");
                softAssert.fail("Error Message for Empty Headline2 Field not displayed");
            }
            performancePage.AddDesiredHeadline2("        ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForHeadline2Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Headline2 Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Empty Headline2 Field not displayed when only spaces are entered as input");
            }
            if (!performancePage.ValidateErrorMessageForHeadline3Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Headline3 Field not displayed");
                softAssert.fail("Error Message for Empty Headline3 Field not displayed");
            }
            performancePage.AddDesiredHeadline3("        ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.ValidateErrorMessageForHeadline3Field()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Headline3 Field not displayed when only spaces are entered as input");
                softAssert.fail("Error Message for Empty Headline3 Field not displayed when only spaces are entered as input");
            }
//            if(performancePage.ValidateErrorMessageForDescription1Field())
//            {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message for Empty Description1 Field not displayed");
//                softAssert.fail("Error Message for Empty Description1 Field not displayed");
//            }
//            performancePage.AddDesiredDescription1("        ");
            //validateDescription1 and 2 fields and pin the description fields
            //Add more description and headline fields and delete them

        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        }));
    }


    @Epic("Seller Dashboard")
    @Feature("Performance Page")
    @Story("This flow belongs Performance Campaign FaceBook Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Create a successful Performance face book campaign flow", priority = 0)
    public void CreatePerformanceCampaignWithFacebook() {
          utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(2500);
            performancePage.CloseAnnouncementCloseButtonIfAvailable();
            performancePage.ClickOnCreateCampaignButton();
            Thread.sleep(1500);
            performancePage.ClickOnBudgetSettingsNextButton();
            if (!performancePage.ValidateErrorMessageForCampaignName()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign name error message not displayed for empty field");
                softAssert.fail("Campaign name error message  not displayed for empty campaign name field");
            }
            performancePage.EnterCampaignName();
            performancePage.EnterAverageDailyBudget("789");

            performancePage.ClickOnBudgetSettingsNextButton();
            performancePage.ClickOnAdFormatCreateNewButton();

            //------------ creating fb product ad lead generation
            performancePage.EnterCreativeNameInFaceBookAdFormat("Test Creative");
            performancePage.ClickOnSelectCreativeField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnLeadFormSelectionField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnThisTemplateForField();
            performancePage.ClickOnGenericOptionsSelector(2);
            performancePage.EnterMainBodyText("${sellerDetails_area}");
//                performancePage.EnterTextInDynamicAttributeSearchField(1,"area");
//                performancePage.ClickOnDynamicPropertyOption(1);
            Thread.sleep(500);
            performancePage.EnterHeadLineText(1, "${sellerDetails_outletId}");
//                performancePage.EnterTextInDynamicAttributeSearchField(2,"zone");
//                performancePage.ClickOnDynamicPropertyOption(2);
            Thread.sleep(1000);
            performancePage.EnterDescriptionText(1, "${sellerDetails_city}");
//                performancePage.EnterTextInDynamicAttributeSearchField(3,"City");
//                performancePage.ClickOnDynamicPropertyOption(1);
            performancePage.ClickOnMediaTypeField();
            performancePage.ClickOnSelectCallToActionField();
            performancePage.ClickOnGenericOptionsSelector(3);
            performancePage.ClickOnChooseImageField(1);
            performancePage.ClickOnImageSelector();
            performancePage.ClickOnSelectedImageSaveButton();
            performancePage.ClickOnCreateButton();
            performancePage.ClickOnCreateNewTopButton();
            //------------ creating fb product ad lead generation
            performancePage.EnterCreativeNameInFaceBookAdFormat("Test Creative");
            performancePage.ClickOnSelectCreativeField();
            performancePage.ClickOnGenericOptionsSelector(2);
            Thread.sleep(2000);
            performancePage.ClickOnTemplateForField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnThisTemplateForField();
            performancePage.ClickOnGenericOptionsSelector(2);
            performancePage.EnterMainBodyText("${sellerDetails_area}");
            Thread.sleep(500);
            performancePage.EnterDestinationUrl("${sellerDetails_websiteLink}");
            performancePage.EnterHeadLineText(1, "${sellerDetails_outletId}");
            Thread.sleep(1000);
            performancePage.EnterDescriptionText(1, "${sellerDetails_city}");
            performancePage.ClickOnMediaTypeField();
            performancePage.ClickOnSelectCallToActionField();
            performancePage.ClickOnGenericOptionsSelector(3);
            performancePage.ClickOnChooseImageField(1);
            performancePage.ClickOnImageSelector();
            performancePage.ClickOnSelectedImageSaveButton();
            performancePage.ClickOnCreateButton();
            Thread.sleep(2500);

            //------------ fb carousel ad creation with lead generation
            performancePage.ClickOnFaceBookCarouselSection();
            performancePage.ClickOnAdFormatCreateNewButton();
            performancePage.EnterCreativeNameInFaceBookAdFormat("Test Creative");
            performancePage.ClickOnSelectCreativeField();
            performancePage.ClickOnGenericOptionsSelector(2);
            Thread.sleep(2000);
            performancePage.ClickOnTemplateForField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnThisTemplateForField();
            performancePage.ClickOnGenericOptionsSelector(2);
            performancePage.EnterMainBodyText("${sellerDetails_area}");
            performancePage.EnterHeadLineText(1, "${sellerDetails_outletId}");
            performancePage.EnterDescriptionText(1, "${sellerDetails_city}");
            performancePage.ClickOnChooseImageField(1);
            performancePage.ClickOnImageSelector();
            performancePage.ClickOnSelectedImageSaveButton();
            performancePage.ClickOnSelectCallToActionField();
            performancePage.ClickOnGenericOptionsSelector(3);
            performancePage.ClickOnCarouselSelector(2);
            performancePage.EnterHeadLineText(2, "${sellerDetails_outletId}");
            performancePage.EnterDescriptionText(2, "${sellerDetails_city}");
            performancePage.ClickOnChooseImageField(2);
            performancePage.ClickOnImageSelector();
            performancePage.ClickOnSelectedImageSaveButton();
            performancePage.ClickOnAddCarouselButton();
            performancePage.ClickOnDeleteCarouselButton(3);
            performancePage.ClickOnCreateButton();

            //------------ fb carousel ad creation with choose library
            performancePage.ClickOnFaceBookCarouselSection();
            performancePage.ClickOnChooseFromAdsLibraryButton();
            performancePage.ClickOnAddFilterButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.EnterTextInFilterConditionSearchField("contains");
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.EnterTextInFilterValueSearchField("Test Creative Loop take 3");
            performancePage.ClickOnFilterApplyButton();
            if (!performancePage.IsFilterResultsDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Facebook Ad Filter results are not displayed");
                Assert.fail("Facebook Ad Filter results are not displayed");
            }
            performancePage.ClickOnCreativeAdCard();
            performancePage.ClickOnSaveButton();
            performancePage.ClickOnAdSaveButton();
            performancePage.ClickOnLaunchButton();
            if (!performancePage.ValidateCampaignCreation()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FB Campaign creation failed");
                softAssert.fail("FB Campaign creation failed");
            }

        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        }));
    }


    @Epic("Seller Dashboard")
    @Feature("Performance Page")
    @Story("This flow belongs Performance Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Validate all fields while creating Performance face book campaign flow", priority = 0)
    public void ValidateAllFieldsWhileCreatePerformanceCampaignWithFacebook() {
        utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(2500);
            performancePage.CloseAnnouncementCloseButtonIfAvailable();
            performancePage.ClickOnCreateCampaignButton();
            Thread.sleep(1500);
            performancePage.ClickOnBudgetSettingsNextButton();

            if (!performancePage.isCampaignNameEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign name empty error message is not displayed");
                softAssert.fail("Campaign name empty error message is not displayed");
            }

            if (!performancePage.isAverageDailyBudgetEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average daily budget empty error message is not displayed");
                softAssert.fail("Average daily budget empty error message is not displayed");
            }
            performancePage.EnterDataInCampaignName("   ");
            if (performancePage.ValidateCampaignNameFieldAcceptingSpaces()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign name accepts only spaces as input");
                softAssert.fail("Campaign name accepts only spaces as input");
            }
            performancePage.EnterMoreThan50CharactersInCampaignName(50);
            if (performancePage.ValidateCampaignNameFieldAcceptingMoreThan50Characters()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign name accepts more than 50 characters");
                softAssert.fail("Campaign name accepts more than 50 characters");
            }
            performancePage.EnterAverageDailyBudget("     ");
            if (performancePage.ValidateDailyBudgetFieldAcceptingSpaces()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average daily budget accepts only spaces as input");
                softAssert.fail("Average daily budget accepts only spaces as input");
            }
            performancePage.ClickOnBudgetSettingsNextButton();
            performancePage.EnterAverageDailyBudget("abcdefgh");
            if (performancePage.ValidateDailyBudgetFieldAcceptingSpaces()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average daily budget accepts characters as input");
                softAssert.fail("Average daily budget accepts characters as input");
            }
            performancePage.ClickOnBudgetSettingsNextButton();
            performancePage.EnterAverageDailyBudget("-789");
            if (performancePage.ValidateDailyBudgetFieldAcceptingNegativeValue()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average daily budget accepts negative value as input");
                softAssert.fail("Average daily budget accepts negative value as input");
            }
            performancePage.EnterCampaignName();
            performancePage.ClickOnBudgetSettingsNextButton();
            performancePage.ClickOnAdSaveButton();
            if (!performancePage.IsAdEmptyTemplateErrorPopUpDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Ad empty template error message is not displayed.");
                softAssert.fail("Ad empty template error message is not displayed.");
            }
            performancePage.ClickOnCreateNewAdButton();
            performancePage.ClickOnCreateButton();
            if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative name field empty error message is not displayed.");
                softAssert.fail("Creative name field empty error message is not displayed.");
            }
            if (!performancePage.IsLeadFormSelectionEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Lead form selection empty error message is not displayed.");
                softAssert.fail("Lead form selection empty error message is not displayed.");
            }
            if (!performancePage.IsThisTemplateIsForEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - 'This Template is for' empty error message is not displayed.");
                softAssert.fail("'This Template is for' empty error message is not displayed.");
            }
            if (!performancePage.IsHeadlineEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Headline empty error message is not displayed.");
                softAssert.fail("Headline empty error message is not displayed.");
            }
            if (!performancePage.IsMediaEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Media empty error message is not displayed.");
                softAssert.fail("Media empty error message is not displayed.");
            }
            if (!performancePage.IsSelectCallToActionEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Select call to action empty error message is not displayed.");
                softAssert.fail("Select call to action empty error message is not displayed.");
            }
            performancePage.ClickOnCreateButton();
            performancePage.EnterSpacesInFaceBookAdFormatCreativeNameInFaceBookAdFormat("      ");
            performancePage.EnterMainBodyText("      ");
            performancePage.EnterHeadLineText(1, "      ");
            performancePage.EnterDescriptionText(1, "      ");
            performancePage.ClickOnCreateButton();
            if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Creative name field empty error message is not displayed when saving with only spaces as input.");
                softAssert.fail("FaceBook Product Creative name field empty error message is not displayed when saving with only spaces as input.");
            }
            if (!performancePage.IsMainBodyTextEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Main body text empty error message is not displayed when saving with only spaces as input.");
                softAssert.fail("FaceBook Product Main body text empty error message is not displayed when saving with only spaces as input.");
            }
            if (performancePage.ValidateHeadlineFieldAcceptsOnlySpaces()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Headline text empty error message is not displayed when saving with only spaces as input.");
                softAssert.fail("FaceBook Product Headline text empty error message is not displayed when saving with only spaces as input.");
            }
            if (!performancePage.ValidateDescriptionFieldAcceptsOnlySpaces()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Description field accepts only spaces as input when saving with only spaces as input");
                softAssert.fail("FaceBook Product Description field accepts only spaces as input when saving with only spaces as input");
            }
            if (performancePage.ValidateCreativeNameFieldAcceptsMoreThan90Characters()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative name field accepts more than 90 characters");
                softAssert.fail("Creative name field accepts more than 90 characters");
            }
            performancePage.ClickOnCreateButton();
            performancePage.ClickOnSelectCreativeField();
            performancePage.ClickOnGenericOptionsSelector(2);
            performancePage.EnterDestinationUrl("      ");
            performancePage.ClickOnCreateButton();
            if (performancePage.ValidateDestinationUrlFieldAcceptsOnlySpaces()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Destination url empty error message is not displayed.");
                softAssert.fail("Destination url empty error message is not displayed.");
            }
            utils.CloseWindow(2);
            performancePage.ClickOnFaceBookCarouselSection();
            performancePage.ClickOnAdFormatCreateNewButton();
            performancePage.ClickOnCreateButton();
            if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Carousel Creative name field empty error message is not displayed.");
                softAssert.fail("FaceBook Carousel Creative name field empty error message is not displayed.");
            }
            if (!performancePage.IsLeadFormSelectionEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Carousel Lead form selection empty error message is not displayed.");
                softAssert.fail("FaceBook Carousel Lead form selection empty error message is not displayed.");
            }
            if (!performancePage.IsThisTemplateIsForEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - 'FaceBook Carousel This Template is for' empty error message is not displayed.");
                softAssert.fail("FaceBook Carousel This Template is for' empty error message is not displayed.");
            }
            if (!performancePage.IsHeadlineEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Carousel Headline empty error message is not displayed.");
                softAssert.fail("FaceBook Carousel Headline empty error message is not displayed.");
            }
            if (!performancePage.IsMediaEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Carousel Media empty error message is not displayed.");
                softAssert.fail("FaceBook Carousel Media empty error message is not displayed.");
            }
            if (!performancePage.IsSelectCallToActionEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Carousel Select call to action empty error message is not displayed.");
                softAssert.fail("FaceBook Carousel Select call to action empty error message is not displayed.");
            }
            if (!performancePage.IsMainBodyTextEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Carousel Main body text empty error message is not displayed.");
                softAssert.fail("FaceBook Carousel Main body text empty error message is not displayed.");
            }
            if (performancePage.ValidateCarouselAddButtonVisibleAfterAdding10Carousel()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Carousel Add button is  visible after adding 10 carousel");
                softAssert.fail("Carousel Add button is  visible after adding 10 carousel");
            }

        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        }));
    }

}

