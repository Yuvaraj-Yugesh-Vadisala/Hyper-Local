package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.AssertManagerPage;
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

public class AssertManager extends BaseTest {
    private PerformancePage performancePage;
    private AssertManagerPage assertManagerPage;
    private Utils utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        assertManagerPage = new AssertManagerPage(getDriver());
        performancePage = new PerformancePage(getDriver());
        utils = new Utils(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", super.HyperUATPulse);
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
//        performancePage.SelectingClient("Test OEM 2 (Test OEM 2)", 1);
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
    @Story("This flow belongs FacebookCarouselAdsWithLeads")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create FaceBook Carousel Ads With Leads", priority = 0)
    public void CreateFacebookCarouselAdsWithLeads() {
        utils.RetryOnFailHyperPulse(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(4000);
                assertManagerPage.ClickOnAssertManagerButton();
                assertManagerPage.SelectLibrary();
                assertManagerPage.SelectFacebookCarousel();
                assertManagerPage.ClickAddNewButton();
                assertManagerPage.EnterAdTemplateName(utils.generateRandomData("random", 5).toString());
                assertManagerPage.ClickOnSelectPartner();
                performancePage.ClickOnGenericOptionsSelector(2);
                assertManagerPage.SelectDesiredLanguage(1);
                assertManagerPage.SelectDesiredCreativeType(1);
                assertManagerPage.SelectDesiredLeadFormSelection(1);
                assertManagerPage.SelectingThisTemplateIsFor("Tata M&HCV", 1);
                assertManagerPage.EnterMainBodyText("MainBody Test");
                assertManagerPage.ScrollToSelectCallToActionField();
                assertManagerPage.EnterHeadlineText("This is headline", 1, 1);
                Thread.sleep(1000);
                assertManagerPage.EnterDescription("This is description", 1);
                assertManagerPage.ClickUploadImage();
                assertManagerPage.ChooseCreativeLibraryImage("Choose Creative");
                assertManagerPage.EnterHeadlineText("This is headline2", 2, 2);
                Thread.sleep(1000);
                assertManagerPage.EnterDescription("This is description2", 2);
                assertManagerPage.ClickUploadImage();
                assertManagerPage.ChooseCreativeLibraryImage("Choose Creative");
                assertManagerPage.ClickDeleteLink(3);
                assertManagerPage.SelectingDesiredSelectCallToActionDropdown("Get Quote", 1);
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.ClickingTheDeleteButton(3);
                assertManagerPage.ClickCreateButton();
                if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Facebook Carousel Template Success PopUp is not displayed.");
                    softAssert.fail("Facebook Carousel Template Success PopUp is not displayed.");
                }
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnAdTypeDropDownField();
                performancePage.ClickOnGenericOptionsSelector(2);
                performancePage.ClickOnFilterConditionFieldDropDown();
                performancePage.EnterTextInFilterConditionSearchField("contains");
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.EnterTextInFilterValueSearchField(assertManagerPage.FacebookCarouselLeadAD);
                performancePage.ClickOnFilterApplyButton();
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnFilterValueFieldDropDown();
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.ClickOnFilterApplyButton();

                if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Status is not displayed.");
                    softAssert.fail("Template Approved Status is not displayed.");
                }

                assertManagerPage.SelectFirstTemplateFromLibraryTable();
                Thread.sleep(2000);
                assertManagerPage.ClickOnArchiveTemplateButton();
                assertManagerPage.EnterCommentsInAddCommentsTextAreaField(utils.generateRandomData("random", 5).toString());
                performancePage.ClickOnConfirmationYesButton();
                if (!assertManagerPage.ValidateArchiveTemplateSuccessPopupDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archive Template Success Popup is not displayed.");
                    softAssert.fail("Archive Template Success Popup is not displayed.");
                }
                assertManagerPage.ClickOnAllActionsButton();
                if (!assertManagerPage.ValidateArchivedTemplateIsShowingInAllActionsTable()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archived Template is showing in All Actions Table.");
                    softAssert.fail("Archived Template is showing in All Actions Table.");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs FacebookCarouselAdsWithLeads")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate All Fields While Creating Facebook Carousel Ads ", priority = 0)
    public void ValidateAllFieldsWhileCreatingFacebookCarouselAds() {
                utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
                Thread.sleep(1500);

                assertManagerPage.ClickOnAssertManagerButton();
                assertManagerPage.SelectLibrary();
                assertManagerPage.SelectFacebookCarousel();
                assertManagerPage.ClickAddNewButton();

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
                assertManagerPage.EnterAdTemplateName("        ");
                assertManagerPage.EnterMainBodyText("      ");
                assertManagerPage.EnterHeadLineText(1, "      ");
                assertManagerPage.EnterDescription("      ", 1);
                performancePage.ClickOnCreateButton();
                if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Creative name field empty error message is not displayed when saving with only spaces as input.");
                    softAssert.fail("FaceBook Product Creative name field empty error message is not displayed when saving with only spaces as input.");
                }
                if (!performancePage.IsMainBodyTextEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Main body text empty error message is not displayed when saving with only spaces as input.");
                    softAssert.fail("FaceBook Product Main body text empty error message is not displayed when saving with only spaces as input.");
                }
                if (!assertManagerPage.ValidateHeadlineFieldAcceptsOnlySpaces()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Headline text empty error message is not displayed when saving with only spaces as input.");
                    softAssert.fail("FaceBook Product Headline text empty error message is not displayed when saving with only spaces as input.");
                }
                if (performancePage.ValidateDescriptionFieldAcceptsOnlySpaces()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Description field accepts only spaces as input when saving with only spaces as input");
                    softAssert.fail("FaceBook Product Description field accepts only spaces as input when saving with only spaces as input");
                }
                if (performancePage.ValidateCreativeNameFieldAcceptsMoreThan90Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative name field accepts more than 90 characters");
                    softAssert.fail("Creative name field accepts more than 90 characters");
                }
                assertManagerPage.EnterFacebookCarouselAwarenessADTemplateName(utils.generateRandomData("random", 5).toString());
                assertManagerPage.SelectDesiredLanguage(1);
                assertManagerPage.SelectDesiredCreativeType(2);
                performancePage.ClickOnConfirmationYesButton();
                assertManagerPage.SelectDesiredTemplateForDropdown(2);
//            assertManagerPage.SelectingThisTemplateIsFor("Tata M&HCV", 1);
                assertManagerPage.EnterMainBodyText("MainBody Test");
                assertManagerPage.ScrollToSelectCallToActionField();
                assertManagerPage.EnterHeadlineText("This is headline", 1, 1);
                Thread.sleep(1000);
                assertManagerPage.EnterDescription("This is description", 1);
                assertManagerPage.ClickUploadImage();
                assertManagerPage.ChooseCreativeLibraryImage("Choose Creative");
                assertManagerPage.EnterHeadlineText("This is headline2", 2, 2);
                Thread.sleep(1000);
                assertManagerPage.EnterDescription("This is description2", 2);
                assertManagerPage.ClickUploadImage();
                assertManagerPage.ChooseCreativeLibraryImage("Choose Creative");
                assertManagerPage.ClickDeleteLink(3);
                assertManagerPage.SelectingDesiredSelectCallToActionDropdown("Book Now", 1);
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.ClickingTheDeleteButton(3);
                assertManagerPage.ClickCreateButton();
                if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Success PopUp is not displayed.");
                    softAssert.fail("Template Success PopUp is not displayed.");
                }
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnAdTypeDropDownField();
                performancePage.ClickOnGenericOptionsSelector(2);
                performancePage.ClickOnFilterConditionFieldDropDown();
                performancePage.EnterTextInFilterConditionSearchField("contains");
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.EnterTextInFilterValueSearchField(assertManagerPage.FacebookCarouselAwarenessAD);
                performancePage.ClickOnFilterApplyButton();
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnFilterValueFieldDropDown();
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.ClickOnFilterApplyButton();

                if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Status is not displayed.");
                    softAssert.fail("Template Approved Status is not displayed.");
                }

                assertManagerPage.SelectFirstTemplateFromLibraryTable();
                Thread.sleep(2000);
                assertManagerPage.ClickOnArchiveTemplateButton();
                assertManagerPage.EnterCommentsInAddCommentsTextAreaField(utils.generateRandomData("random", 5).toString());
                performancePage.ClickOnConfirmationYesButton();
                if (!assertManagerPage.ValidateArchiveTemplateSuccessPopupDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archive Template Success Popup is not displayed.");
                    softAssert.fail("Archive Template Success Popup is not displayed.");
                }
                assertManagerPage.ClickOnAllActionsButton();
                if (!assertManagerPage.ValidateArchivedTemplateIsShowingInAllActionsTable()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archived Template is showing in All Actions Table.");
                    softAssert.fail("Archived Template is showing in All Actions Table.");
                }


            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }

    @Epic("Pulse Dashboard")
    @Story("This flow belongs FacebookProductAdsWithLeads")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create a Campaign Management", priority = 0)
    public void CreateFacebookProductAdsWithLeads() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(4000);
            assertManagerPage.ClickOnAssertManagerButton();
            assertManagerPage.SelectLibrary();
            assertManagerPage.SelectFacebookProductAds();
            assertManagerPage.ClickAddNewButton();
            assertManagerPage.EnterFacebookProductTemplateName(utils.generateRandomData("random", 5).toString());
            assertManagerPage.ClickOnSelectPartner();
            performancePage.ClickOnGenericOptionsSelector(2);
            assertManagerPage.SelectDesiredLanguage(1);
            assertManagerPage.SelectDesiredCreativeType(1);
            assertManagerPage.SelectDesiredLeadFormSelection(1);
            assertManagerPage.SelectingThisTemplateIsFor("Tata M&HCV", 1);
            assertManagerPage.EnterMainBodyText("MainBody Test");
            assertManagerPage.ScrollToSelectCallToActionField();
            assertManagerPage.EnterProductAdsHeadlineText("This is headline");
            Thread.sleep(1000);
            assertManagerPage.EnterDescription("This is description", 1);
//            assertManagerPage.SelectingDesiredFacebookProductAdsMediaTypeFromDropdown(1);
                assertManagerPage.ClickUploadImage();
                assertManagerPage.ChooseCreativeLibraryImage("Choose Creative");
                assertManagerPage.SelectingDesiredSelectCallToActionDropdown("Get Quote", 1);
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.ClickingTheDeleteButton(3);
                assertManagerPage.ClickCreateButton();

                if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Facebook Product Template Success PopUp is not displayed.");
                    softAssert.fail("Facebook Product Template Success PopUp is not displayed.");
                }
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnAdTypeDropDownField();
                performancePage.ClickOnGenericOptionsSelector(2);
                performancePage.ClickOnFilterConditionFieldDropDown();
                performancePage.EnterTextInFilterConditionSearchField("contains");
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.EnterTextInFilterValueSearchField(assertManagerPage.FacebookProductTemplateName);
                performancePage.ClickOnFilterApplyButton();
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnFilterValueFieldDropDown();
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.ClickOnFilterApplyButton();

                if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Status is not displayed.");
                    softAssert.fail("Template Approved Status is not displayed.");
                }

                assertManagerPage.SelectFirstTemplateFromLibraryTable();
                Thread.sleep(2000);
                assertManagerPage.ClickOnArchiveTemplateButton();
                assertManagerPage.EnterCommentsInAddCommentsTextAreaField(utils.generateRandomData("random", 5).toString());
                performancePage.ClickOnConfirmationYesButton();
                if (!assertManagerPage.ValidateArchiveTemplateSuccessPopupDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archive Template Success Popup is not displayed.");
                    softAssert.fail("Archive Template Success Popup is not displayed.");
                }
                assertManagerPage.ClickOnAllActionsButton();
                if (!assertManagerPage.ValidateArchivedTemplateIsShowingInAllActionsTable()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archived Template is showing in All Actions Table.");
                    softAssert.fail("Archived Template is showing in All Actions Table.");
                }


            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }

    @Epic("Pulse Dashboard")
    @Story("This flow belongs FacebookProductAdsWithAwareness")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate All Fields While Creating Facebook Product Ads", priority = 0)
    public void ValidateAllFieldsWhileCreatingFacebookProductAds() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(100);
            assertManagerPage.ClickOnAssertManagerButton();
            assertManagerPage.SelectLibrary();
            assertManagerPage.SelectFacebookProductAds();
            assertManagerPage.ClickAddNewButton();
            assertManagerPage.SelectDesiredCreativeType(2);
            performancePage.ClickOnCreateButton();
            if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative name field empty error message is not displayed.");
                softAssert.fail("Creative name field empty error message is not displayed.");
            }
//            if (!performancePage.IsThisTemplateIsForEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - 'This Template is for' empty error message is not displayed.");
//                softAssert.fail("'This Template is for' empty error message is not displayed.");
//            }
                if (!performancePage.IsMainBodyTextEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Product Main body text empty error message is not displayed when saving with only spaces as input.");
                    softAssert.fail("FaceBook Product Main body text empty error message is not displayed when saving with only spaces as input.");
                }
                if (!performancePage.IsHeadlineEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Headline empty error message is not displayed.");
                    softAssert.fail("Headline empty error message is not displayed.");
                }
                if (!performancePage.IsMediaEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Media empty error message is not displayed.");
                    softAssert.fail("Media empty error message is not displayed.");
                }
                if (!assertManagerPage.ValidateDestinationUrlFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Destination URL empty error message is not displayed.");
                    softAssert.fail("Destination URL empty error message is not displayed.");
                }
                if (!performancePage.IsSelectCallToActionEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Select call to action empty error message is not displayed.");
                    softAssert.fail("Select call to action empty error message is not displayed.");
                }
                assertManagerPage.EnteringDestinationURL("          ");
                performancePage.ClickOnCreateButton();
                if (!assertManagerPage.ValidateDestinationUrlFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Destination URL empty error message is not displayed.");
                    softAssert.fail("Destination URL empty error message is not displayed.");
                }
                assertManagerPage.EnterAdTemplateName(utils.generateRandomData("random", 5).toString());
                assertManagerPage.SelectDesiredLanguage(1);
                assertManagerPage.SelectDesiredCreativeType(2);
                assertManagerPage.SelectDesiredTemplateForSelection(1);
                assertManagerPage.SelectingThisTemplateIsFor("Tata Ace Gold", 1);
                assertManagerPage.EnterMainBodyText("MainBody Test");
                assertManagerPage.ScrollToSelectCallToActionField();
                assertManagerPage.EnteringDestinationURL("https://example.com");
                assertManagerPage.EnterProductAdsHeadlineText("This is headline");
                Thread.sleep(1000);
                assertManagerPage.EnterDescription("This is description", 1);
                Thread.sleep(5000);
//            assertManagerPage.SelectingDesiredFacebookProductAdsMediaTypeFromDropdown(2);
                assertManagerPage.ClickUploadImage();
                assertManagerPage.EnterTextInSearchTagsNameField("Choose Creative");
                Thread.sleep(3000);
                if (!assertManagerPage.ValidateCreativeLibraryChooseButtonIsDisabled()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Library Choose button is not disabled.");
                    softAssert.fail("Creative Library Choose button is not disabled.");
                }
                assertManagerPage.SelectCreativeLibraryImage();
                assertManagerPage.ChooseCreativeLibraryImage();
//            assertManagerPage.EnterHeadlineText("This is headline2",2,2);
                assertManagerPage.SelectingDesiredSelectCallToActionDropdown("Order Now", 1);
                Thread.sleep(2000);
                for (int i = 1; i <= 5; i++) {
                    assertManagerPage.ClickingCreativeTagsAddButton();
                }
                if (assertManagerPage.ValidateCreativeAddTagsButtonIsVisible()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Add Tags button is visible After Adding 6 Tags.");
                    softAssert.fail("Creative Add Tags button is visible After Adding 6 Tags.");
                }
                for (int i = 1; i <= 5; i++) {
                    assertManagerPage.ClickingTheDeleteButton(1);
                    Thread.sleep(1500);
                }
                assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
                assertManagerPage.ClickCreateButton();
                if (!assertManagerPage.ValidateTagValueEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Tag Value empty error message is not displayed.");
                    softAssert.fail("Tag Value empty error message is not displayed.");
                }
                assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.ClickingTheDeleteButton(3);
                assertManagerPage.ClickCreateButton();

                if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Success PopUp is not displayed.");
                    softAssert.fail("Template Success PopUp is not displayed.");
                }
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnAdTypeDropDownField();
                performancePage.ClickOnGenericOptionsSelector(2);
                performancePage.ClickOnFilterConditionFieldDropDown();
                performancePage.EnterTextInFilterConditionSearchField("contains");
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.EnterTextInFilterValueSearchField(assertManagerPage.FacebookCarouselLeadAD);
                performancePage.ClickOnFilterApplyButton();
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnFilterValueFieldDropDown();
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.ClickOnFilterApplyButton();

                if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Status is not displayed.");
                    softAssert.fail("Template Approved Status is not displayed.");
                }

                assertManagerPage.SelectFirstTemplateFromLibraryTable();
                Thread.sleep(2000);
                assertManagerPage.ClickOnArchiveTemplateButton();
                assertManagerPage.EnterCommentsInAddCommentsTextAreaField(utils.generateRandomData("random", 5).toString());
                performancePage.ClickOnConfirmationYesButton();
                if (!assertManagerPage.ValidateArchiveTemplateSuccessPopupDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archive Template Success Popup is not displayed.");
                    softAssert.fail("Archive Template Success Popup is not displayed.");
                }
                assertManagerPage.ClickOnAllActionsButton();
                if (!assertManagerPage.ValidateArchivedTemplateIsShowingInAllActionsTable()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archived Template is showing in All Actions Table.");
                    softAssert.fail("Archived Template is showing in All Actions Table.");
                }

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs GoogleSearchAds")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create a Campaign Management", priority = 0)
    public void CreateGoogleCallOnlyAds() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(4000);
            assertManagerPage.ClickOnAssertManagerButton();
            assertManagerPage.SelectLibrary();
            assertManagerPage.SelectGoogleSearchAds();
            assertManagerPage.ClickAddNewButton();
//            assertManagerPage.EnterCreativeName();
                assertManagerPage.EnterGoogleSearchAdTemplateName(utils.generateRandomData("random", 5).toString());
                assertManagerPage.ClickOnSelectPartner();
                performancePage.ClickOnGenericOptionsSelector(3);
                assertManagerPage.SelectDesiredLanguage(1);
                assertManagerPage.SelectCreativeType("Call only Ad");
                assertManagerPage.SelectCampaignFor(1);
                assertManagerPage.SelectThisTemplateFor(1);
                assertManagerPage.SelectCountryCodeDynamically(2);
                assertManagerPage.EnterPhoneNumberDynamically(2);
                assertManagerPage.EnterPhoneNumberVerificationUrlDynamically(3);
                assertManagerPage.EnterBusinessNameDynamically(3);
                assertManagerPage.EnterDescription1(2);
                assertManagerPage.EnterDescription2(3);
                assertManagerPage.EnterWebsiteUrlDynamically(2);
                assertManagerPage.EnterDomainDynamically(2);


                assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                Thread.sleep(2000);
                assertManagerPage.ClickingTheDeleteButton(3);
                assertManagerPage.ClickCreateButton();

                if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Search Ad Template Success PopUp is not displayed.");
                    softAssert.fail("Google Search Ad Template Success PopUp is not displayed.");
                }
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnAdTypeDropDownField();
                performancePage.ClickOnGenericOptionsSelector(2);
                performancePage.ClickOnFilterConditionFieldDropDown();
                performancePage.EnterTextInFilterConditionSearchField("contains");
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.EnterTextInFilterValueSearchField(assertManagerPage.GoogleSearchAd);
                performancePage.ClickOnFilterApplyButton();
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnFilterValueFieldDropDown();
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.ClickOnFilterApplyButton();

                if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Status is not displayed.");
                    softAssert.fail("Template Approved Status is not displayed.");
                }

                assertManagerPage.SelectFirstTemplateFromLibraryTable();
                Thread.sleep(2000);
                assertManagerPage.ClickOnArchiveTemplateButton();
                assertManagerPage.EnterCommentsInAddCommentsTextAreaField(utils.generateRandomData("random", 5).toString());
                performancePage.ClickOnConfirmationYesButton();
                if (!assertManagerPage.ValidateArchiveTemplateSuccessPopupDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archive Template Success Popup is not displayed.");
                    softAssert.fail("Archive Template Success Popup is not displayed.");
                }
                assertManagerPage.ClickOnAllActionsButton();
                if (!assertManagerPage.ValidateArchivedTemplateIsShowingInAllActionsTable()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archived Template is showing in All Actions Table.");
                    softAssert.fail("Archived Template is showing in All Actions Table.");
                }


            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }

    @Epic("Pulse Dashboard")
    @Story("This flow belongs GoogleResponsiveSearchAds")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate All Fields While Creating Google Responsive Search Ads", priority = 0)
    public void ValidateAllFieldsWhileCreatingGoogleResponsiveSearchAds() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
                assertManagerPage.ClickOnAssertManagerButton();
                assertManagerPage.SelectLibrary();
                assertManagerPage.SelectGoogleSearchAds();
                assertManagerPage.ClickAddNewButton();
                assertManagerPage.SelectDesiredCreativeType(2);
                assertManagerPage.ClickCreateButton();


                if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Creative name field empty error message is not displayed.");
                    softAssert.fail("Google Responsive Search Ad Creative name field empty error message is not displayed.");
                }
//            if (!performancePage.IsLeadFormSelectionEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Lead form selection empty error message is not displayed.");
//                softAssert.fail("Lead form selection empty error message is not displayed.");
//            }
                if (!performancePage.IsThisTemplateIsForEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - 'Google Responsive Search Ad This Template is for' empty error message is not displayed.");
                    softAssert.fail("Google Responsive Search Ad This Template is for' empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateFinalUrlFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Final URL empty error message is not displayed.");
                    softAssert.fail("Google Responsive Search Ad Final URL empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateDisplayUrlFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Display URL empty error message is not displayed.");
                    softAssert.fail("Google Responsive Search Ad Display URL empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateHeadline2FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Headline 2 empty error message is not displayed.");
                    softAssert.fail("Google Responsive Search Ad Headline 2 empty error message is not displayed.");
                }
                if (!assertManagerPage.ValidateDescription1FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Description 1 empty error message is not displayed.");
                    softAssert.fail("Google Responsive Search Ad Description 1 empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateDescription2FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Description 2 empty error message is not displayed.");
                    softAssert.fail("Google Responsive Search Ad Description 2 empty error message is not displayed.");
                }

                assertManagerPage.EnterFinalURL("          ");
                if (!assertManagerPage.ValidateFinalUrlInvalidUrlErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Final URL empty error message is not Displayed when Entering only Spaces as input.");
                    softAssert.fail("Google Responsive Search Ad Final URL empty error message is not Displayed when Entering only Spaces as input.");
                }
                assertManagerPage.EnterDataInDisplayURL("         ");
                assertManagerPage.EnterHeadline2("         ");
                assertManagerPage.EnterDataInDescription1Field("         ");
                assertManagerPage.ClickCreateButton();
                if (!assertManagerPage.ValidateHeadline2FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Headline 2 field accepts only spaces as input when saving with only spaces as input.");
                    softAssert.fail("Google Responsive Search Ad Headline 2 field accepts only spaces as input when saving with only spaces as input.");
                }

                if (!assertManagerPage.ValidateDescription1FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Responsive Search Ad Description 1 field accepts only spaces as input when saving with only spaces as input.");
                    softAssert.fail("Google Responsive Search Ad Description 1 field accepts only spaces as input when saving with only spaces as input.");
                }
                Thread.sleep(4000);
                assertManagerPage.SelectDesiredLanguage(1);
                assertManagerPage.EnterGoogleSearchAdTemplateName(utils.generateRandomData("random", 5).toString());
                assertManagerPage.SelectCreativeType("Responsive Search Ad");
                assertManagerPage.SelectCampaignFor(1);
                assertManagerPage.SelectThisTemplateFor(1);
                assertManagerPage.SelectFinalURLDynamically(2);
                assertManagerPage.EnterDisplayURLDynamically(2);
                assertManagerPage.EnterHeadline1Dynamically(3);
                assertManagerPage.EnterHeadline2Dynamically(3);
                assertManagerPage.EnterHeadline3Dynamically(3);
                assertManagerPage.ClickingHeadlineAddButton();
                assertManagerPage.ClickingHeadlineAddButton();
                assertManagerPage.DeletingHeadline4();
                assertManagerPage.EnterHeadline4Dynamically(3);
                assertManagerPage.PinHeadline4();
                assertManagerPage.PinPositionDynamically(2);
                assertManagerPage.EnterResponsiveSearchAdDescription1(2);
                assertManagerPage.EnterResponsiveSearchAdDescription2(3);
                assertManagerPage.ClickingDescriptionAddButton();
                assertManagerPage.ClickingDescriptionAddButton();
                assertManagerPage.DeletingDescription3();
                assertManagerPage.EnterResponsiveSearchAdDescription3(3);
                assertManagerPage.PinDescription3();
                assertManagerPage.PinPositionDynamically(3);
                assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
                assertManagerPage.ClickingTheDeleteButton(3);
//            assertManagerPage.ClickCreateButton();
//            if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Search Ad Template Success PopUp is not displayed.");
//                softAssert.fail("Google Search Ad Template Success PopUp is not displayed.");
//            }
//            performancePage.ClickOnAddFilterButton();
//            performancePage.ClickOnAdTypeDropDownField();
//            performancePage.ClickOnGenericOptionsSelector(2);
//            performancePage.ClickOnFilterConditionFieldDropDown();
//            performancePage.EnterTextInFilterConditionSearchField("contains");
//            performancePage.ClickOnGenericOptionsSelector(1);
//            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.GoogleSearchAd);
//            performancePage.ClickOnFilterApplyButton();
//            performancePage.ClickOnAddFilterButton();
//            performancePage.ClickOnFilterValueFieldDropDown();
//            performancePage.ClickOnGenericOptionsSelector(1);
//            performancePage.ClickOnFilterApplyButton();
//
//            if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Status is not displayed.");
//                softAssert.fail("Template Approved Status is not displayed.");
//            }
//
//            assertManagerPage.SelectFirstTemplateFromLibraryTable();
//            Thread.sleep(2000);
//            assertManagerPage.ClickOnArchiveTemplateButton();
//            assertManagerPage.EnterCommentsInAddCommentsTextAreaField(utils.generateRandomData("random",5).toString());
//            performancePage.ClickOnConfirmationYesButton();
//            if(!assertManagerPage.ValidateArchiveTemplateSuccessPopupDisplayed()){
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archive Template Success Popup is not displayed.");
//                softAssert.fail("Archive Template Success Popup is not displayed.");
//            }
//            assertManagerPage.ClickOnAllActionsButton();
//            if (!assertManagerPage.ValidateArchivedTemplateIsShowingInAllActionsTable()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archived Template is showing in All Actions Table.");
//                softAssert.fail("Archived Template is showing in All Actions Table.");
//            }
//
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    } //not creating


    @Epic("Pulse Dashboard")
    @Story("This flow belongs Google Performance Max Ads")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create Google Performance Max Ads")
    public void CreateGooglePerformanceMaxAds() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(4000);
            assertManagerPage.ClickOnAssertManagerButton();
            assertManagerPage.SelectLibrary();
            assertManagerPage.SelectGooglePerformanceMaxAds();
            assertManagerPage.ClickAddNewButton();
            assertManagerPage.EnterGooglePerformanceMaxAdsTemplateName(utils.generateRandomData("random", 5).toString());
            assertManagerPage.SelectDesiredLanguage(1);
//            assertManagerPage.SelectCreativeType("Responsive Search Ad");
                assertManagerPage.SelectThisTemplateFor(1);
                assertManagerPage.SelectBusinessNameDynamically(2);
                assertManagerPage.SelectDestinationURLDynamically(2);
                assertManagerPage.SelectShortHeadlineDynamically(2);
                assertManagerPage.SelectShortDescriptionDynamically(3);
                assertManagerPage.SelectFirstHeadlineDynamically(3);
                assertManagerPage.SelectSecondHeadlineDynamically(4);
                assertManagerPage.ClickingHeadlinesAddMoreButton();
                assertManagerPage.ClickingHeadlinesAddMoreButton();
                assertManagerPage.HeadlinesDeletingButton();
                assertManagerPage.SelectThirdHeadlineDynamically(2);
                assertManagerPage.SelectFirstLongHeadlineDynamically(3);
                assertManagerPage.ClickingLongHeadlinesAddMoreButton();
                assertManagerPage.ClickingLongHeadlinesAddMoreButton();
                assertManagerPage.LongHeadlinesDeletingButton();
                performancePage.ClickOnConfirmationYesButton();
                assertManagerPage.LongHeadlinesDeletingButton();
                assertManagerPage.SelectSecondLongHeadlineDynamically(4);
                assertManagerPage.SelectFirstDescriptionDynamically(2);
                assertManagerPage.ClickingDescriptionAddMoreButton();
                assertManagerPage.ClickingDescriptionAddMoreButton();
                assertManagerPage.DescriptionsDeletingButton();
                performancePage.ClickOnConfirmationYesButton();
                assertManagerPage.DescriptionsDeletingButton();
                assertManagerPage.SelectSecondDescriptionDynamically(3);
                assertManagerPage.ClickOnUploadFirstLogoImages();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("Choose Creative");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickingOnLogoImagesAddMoreButton();
                assertManagerPage.ClickingOnLogoImagesAddMoreButton();
                assertManagerPage.ClickingOnLogoImagesSecondDeleteButton();
                assertManagerPage.ClickOnUploadSecondLogoImages();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("Choose Creative");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickingOnVideosAddVideoButton();
                Thread.sleep(2000);
                assertManagerPage.EnteringFirstYouTubeURL("https://www.youtube.com/watch?v=9oBbSGg2IFI");
                Thread.sleep(2000);
                assertManagerPage.ClickYoutubePreviewButton();
                Thread.sleep(3000);
                assertManagerPage.ClosingYouTubeURL();
                Thread.sleep(2000);
                assertManagerPage.ClickingOnVideosAddVideoButton();
                assertManagerPage.ClickingOnVideosAddVideoButton();
                assertManagerPage.ClickingOnVideosSecondVideoDeleteButton();
                assertManagerPage.EnteringSecondYouTubeURL("https://www.youtube.com/watch?v=BAmOYSuWOjo");
                assertManagerPage.ClickingOnSquareMarketingAddMoreButton();
                assertManagerPage.ClickingOnSquareMarketingAddMoreButton();
                assertManagerPage.ClickOnUploadFirstSquareMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("Choose Creative");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();

                assertManagerPage.ClickingOnSquareMarketingSecondDeleteButton();
                assertManagerPage.ClickOnUploadSecondSquareMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("Choose Creative");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickingOnMarketingAddMoreButton();
                assertManagerPage.ClickingOnMarketingAddMoreButton();
                assertManagerPage.ClickOnUploadFirstMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("Marketing Images");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickingOnMarketingSecondDeleteButton();
                assertManagerPage.ClickOnUploadSecondMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("Marketing Images");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickingOnOptionalImagesToggleButton();
                assertManagerPage.ClickingOnPortraitMarketingAddMoreButton();
                assertManagerPage.ClickingOnPortraitMarketingAddMoreButton();
                assertManagerPage.ClickingOnPortraitMarketingAddMoreButton();
                assertManagerPage.ClickingOnPortraitMarketingSecondDeleteButton();
                assertManagerPage.ClickOnUploadFirstPortraitMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("960:1200");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickOnUploadSecondPortraitMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("960:1200");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickingOnLandscapeMarketingAddMoreButton();
                assertManagerPage.ClickingOnLandscapeMarketingAddMoreButton();
                assertManagerPage.ClickingOnLandscapeMarketingAddMoreButton();
                assertManagerPage.ClickingOnLandscapeMarketingSecondDeleteButton();
                assertManagerPage.ClickOnUploadFirstLandscapeMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("1200:300");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.ClickOnUploadSecondLandscapeMarketingImage();
                assertManagerPage.EnteringCreativeLibrarySearchTagName("1200:300");
                Thread.sleep(1500);
                assertManagerPage.ClickingOnTagNameImage();
                assertManagerPage.ClickingOnCreativeLibraryChooseButton();
                assertManagerPage.SelectingDesiredSelectCallToActionDropdown("Get Quote", 1);
//            Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
//            Thread.sleep(2000);
                assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
                assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
                assertManagerPage.ClickingCreativeTagsAddButton();
//            Thread.sleep(2000);
                assertManagerPage.ClickingTheDeleteButton(3);
                assertManagerPage.ClickPerformanceMaxCreateButton();

                if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Search Ad Template Success PopUp is not displayed.");
                    softAssert.fail("Google Search Ad Template Success PopUp is not displayed.");
                }
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnAdTypeDropDownField();
                performancePage.ClickOnGenericOptionsSelector(2);
                performancePage.ClickOnFilterConditionFieldDropDown();
                performancePage.EnterTextInFilterConditionSearchField("contains");
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.EnterTextInFilterValueSearchField(assertManagerPage.GooglePerformanceMaxAds);
                performancePage.ClickOnFilterApplyButton();
                performancePage.ClickOnAddFilterButton();
                performancePage.ClickOnFilterValueFieldDropDown();
                performancePage.ClickOnGenericOptionsSelector(1);
                performancePage.ClickOnFilterApplyButton();

                if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Status is not displayed.");
                    softAssert.fail("Template Approved Status is not displayed.");
                }

                assertManagerPage.SelectFirstTemplateFromLibraryTable();
                Thread.sleep(2000);
                assertManagerPage.ClickOnArchiveTemplateButton();
                assertManagerPage.EnterCommentsInAddCommentsTextAreaField(utils.generateRandomData("random", 5).toString());
                performancePage.ClickOnConfirmationYesButton();
                if (!assertManagerPage.ValidateArchiveTemplateSuccessPopupDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archive Template Success Popup is not displayed.");
                    softAssert.fail("Archive Template Success Popup is not displayed.");
                }
                assertManagerPage.ClickOnAllActionsButton();
                if (!assertManagerPage.ValidateArchivedTemplateIsShowingInAllActionsTable()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Archived Template is showing in All Actions Table.");
                    softAssert.fail("Archived Template is showing in All Actions Table.");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs Google Performance Max Ads")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate All Fields While Creating Google Performance Max Ads")
    public void ValidateAllFieldsWhileCreatingGooglePerformanceMaxAds() {
        utils.RetryOnFailHyperPulse(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(4000);
                assertManagerPage.ClickOnAssertManagerButton();
                assertManagerPage.SelectLibrary();
                assertManagerPage.SelectGooglePerformanceMaxAds();
                assertManagerPage.ClickAddNewButton();
                assertManagerPage.ClickPerformanceMaxCreateButton();

                if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Creative name field empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Creative name field empty error message is not displayed.");
                }

                if (!performancePage.IsThisTemplateIsForEmptyErrorMessageDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - 'Google Performance Max Ad This Template is for' empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad This Template is for' empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateBusinessNameFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Business Name empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Business Name empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateGoogleAdDestinationUrlFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Destination URL empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Destination URL empty error message is not displayed.");
                }


                if (!assertManagerPage.ValidateShortHeadLineFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Short Headline empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Short Headline empty error message is not displayed.");
                }


                if (!assertManagerPage.ValidateShortDescriptionFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Short Description empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Short Description empty error message is not displayed.");
                }


                if (!assertManagerPage.ValidateHeadlineWarningRedLine()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Headline warning Red line error is not displayed.");
                    softAssert.fail("Google Performance Max Ad Headline warning Red line error is not displayed.");
                }

                if (!assertManagerPage.ValidateGoogleHeadLine1FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Headline 1 empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Headline 1 empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateGoogleHeadLine2FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Headline 2 empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Headline 2 empty error message is not displayed.");
                }


                if (!assertManagerPage.ValidateLongHeadlinesWarningRedLine()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Long Headlines warning Red line error is not displayed.");
                    softAssert.fail("Google Performance Max Ad Long Headlines warning Red line error is not displayed.");
                }


                if (!assertManagerPage.ValidateLongHeadLineFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Long Headline empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Long Headline empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateDescriptionWarningRedLine()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Description warning Red line error is not displayed.");
                    softAssert.fail("Google Performance Max Ad Description warning Red line error is not displayed.");
                }

                if (!assertManagerPage.ValidateGoogleDescriptionFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Description empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Description empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateLogoImagesWarningRedLine()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Logo Images warning Red line error is not displayed.");
                    softAssert.fail("Google Performance Max Ad Logo Images warning Red line error is not displayed.");
                }


                if (!assertManagerPage.ValidateLogoImageFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Logo Image empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Logo Image empty error message is not displayed.");
                }


                if (!assertManagerPage.ValidateImagesWarningRedLine()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Images warning Red line error is not displayed.");
                    softAssert.fail("Google Performance Max Ad Images warning Red line error is not displayed.");
                }


                if (!assertManagerPage.ValidateSquareMarketingImageFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Square Marketing Image empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Square Marketing Image empty error message is not displayed.");
                }


                if (!assertManagerPage.ValidateMarketingImageFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Marketing Image empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Marketing Image empty error message is not displayed.");
                }


                assertManagerPage.EnterDataInDestinationUrlField(" ");
                assertManagerPage.EnterDataInShortHeadlineField("   ");
                assertManagerPage.EnterDataInShortDescriptionField("   ");
                assertManagerPage.EnterDataInFirstHeadlineField("   ");
                assertManagerPage.EnterDataInSecondHeadlineField("     ");
                assertManagerPage.EnterDataInDescriptionField("    ");

                assertManagerPage.ClickPerformanceMaxCreateButton();


                if (!assertManagerPage.ValidateGoogleAdDestinationUrlFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Destination URL empty error message is not displayed When giving empty input.");
                    softAssert.fail("Google Performance Max Ad Destination URL empty error message is not displayed When giving empty input.");
                }

                if (!assertManagerPage.ValidateShortHeadLineFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Short Headline empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Short Headline empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateGoogleHeadLine1FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Headline 1 empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Headline 1 empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateGoogleHeadLine2FieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Headline 2 empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Headline 2 empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateLongHeadLineFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Long Headline empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Long Headline empty error message is not displayed.");
                }

                if (!assertManagerPage.ValidateGoogleDescriptionFieldEmptyErrorMessage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Max Ad Description empty error message is not displayed.");
                    softAssert.fail("Google Performance Max Ad Description empty error message is not displayed.");
                }


                if (performancePage.ValidateCreativeNameFieldAcceptsMoreThan50Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative name field accepts more than 50 characters");
                    softAssert.fail("Creative name field accepts more than 50 characters");
                }

                assertManagerPage.EnterDataInBusinessNameField(utils.generateRandomData("random", 26).toString());
                if (assertManagerPage.ValidateBusinessNameFieldAcceptingMoreThan25Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Business Name field accepts more than 25 characters");
                    softAssert.fail("Business Name field accepts more than 25 characters");
                }


                assertManagerPage.EnterDataInDestinationUrlField(utils.generateRandomData("random", 92).toString());
                if (assertManagerPage.ValidateDestinationUrlFieldAcceptingMoreThan90Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Destination URL field accepts more than 90 characters");
                    softAssert.fail("Destination URL field accepts more than 90 characters");
                }

                assertManagerPage.EnterDataInShortHeadlineField((utils.generateRandomData("random", 63).toString()));
                if (assertManagerPage.ValidateShortHeadlineFieldAcceptingMoreThan15Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Short Headline field accepts more than 15 characters");
                    softAssert.fail("Short Headline field accepts more than 15 characters");
                }


                assertManagerPage.EnterDataInShortDescriptionField((utils.generateRandomData("random", 63).toString()));
                if (assertManagerPage.ValidateShortDescriptionFieldAcceptingMoreThan60Characters()) {

                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Short Description field accepts more than 25 characters");
                    softAssert.fail("Short Description field accepts more than 25 characters");
                }

                assertManagerPage.EnterDataInFirstHeadlineField((utils.generateRandomData("random", 32).toString()));
                if (assertManagerPage.ValidateHeadline1FieldAcceptingMoreThan30Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Headline 1 field accepts more than 30 characters");
                    softAssert.fail("Headline 1 field accepts more than 30 characters");
                }

                assertManagerPage.EnterDataInLongHeadlineField((utils.generateRandomData("random", 93).toString()));
                if (assertManagerPage.ValidateLongHeadLineFieldAcceptsMoreThan90Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Long Headline field accepts more than 90 characters");
                    softAssert.fail("Long Headline field accepts more than 90 characters");
                }

                assertManagerPage.EnterDataInGoogleDescriptionField((utils.generateRandomData("random", 93).toString()));
                if (assertManagerPage.ValidateDescriptionFieldAcceptsMoreThan90Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Description field accepts more than 90 characters");
                    softAssert.fail("Google Description field accepts more than 90 characters");
                }

                for (int i = 1; i <= 12; i++) {
                    assertManagerPage.ClickingHeadlinesAddMoreButton();
                }
                if (assertManagerPage.ValidateHeadlinesAddMoreButtonEnabledAfterAdding14Headlines()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Headlines Add More Button is enabled after adding 14 headlines");
                    softAssert.fail("Headlines Add More Button is enabled after adding 14 headlines");
                }
                for (int i = 1; i <= 12; i++) {
                    assertManagerPage.HeadlinesDeletingButton();
                }
                for (int i = 1; i <= 4; i++) {
                    assertManagerPage.ClickingLongHeadlinesAddMoreButton();
                }
                if (assertManagerPage.ValidateLongHeadlinesAddMoreButtonDisabledAfterAdding5Headlines()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Long Headlines Add More Button is disabled after adding 5 headlines");
                    softAssert.fail("Long Headlines Add More Button is disabled after adding 5 headlines");
                }
                for (int i = 1; i <= 4; i++) {
                    assertManagerPage.LongHeadlinesDeletingButton();
                }
                for (int i = 1; i <= 3; i++) {
                    assertManagerPage.ClickingDescriptionAddMoreButton();
                }
                if (assertManagerPage.ValidateDescriptionAddMoreButtonEnabledAfterAdding4Descriptions()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Description Add More Button is enabled after adding 4 descriptions");
                    softAssert.fail("Description Add More Button is enabled after adding 4 descriptions");
                }
                for (int i = 1; i <= 3; i++) {
                    assertManagerPage.DescriptionsDeletingButton();
                }
                for (int i = 1; i <= 4; i++) {
                    assertManagerPage.ClickingOnLogoImagesAddMoreButton();
                }
                if (!assertManagerPage.ValidateLogoImagesAddMoreButtonEnabledAfterAdding5LogoImages()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Logo Images Add More Button is enabled after adding 5 logo images");
                    softAssert.fail("Logo Images Add More Button is enabled after adding 5 logo images");
                }
                for (int i = 1; i <= 4; i++) {
                    assertManagerPage.ClickingOnLogoImagesSecondDeleteButton();
                }
                for (int i = 1; i <= 5; i++) {
                    assertManagerPage.ClickingOnVideosAddVideoButton();
                }
                if (!assertManagerPage.ValidateVideosAddVideoButtonEnabledAfterAdding5Videos()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Videos Add Video Button is enabled after adding 6 videos");
                    softAssert.fail("Videos Add Video Button is enabled after adding 6 videos");
                }
                for (int i = 1; i <= 4; i++) {
                    assertManagerPage.ClickingOnVideosSecondVideoDeleteButton();
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }


    //-------------------Review-------------------------------------

    @Epic("Pulse Dashboard")
    @Story("This flow belongs Facebook Carousel Ads review")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate All Features While Reviewing Facebook Carousel Ads")
    public void ValidateAllFeaturesWhileReviewingFacebookCarouselAds() {
        utils.RetryOnFailHyperPulse(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1500);
            assertManagerPage.ClickOnAssertManagerButton();
            assertManagerPage.ClickOnTemplateReviewButton();
            assertManagerPage.SelectFacebookProductAds();
            performancePage.ClickOnAddFilterButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterValueFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(8);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateUnderReviewTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Under Review Templates are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Under Review Templates are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnReviewTextButton();
            assertManagerPage.ClickOnRejectButton();
            assertManagerPage.EnterDataInCommentField("qwerty");
            assertManagerPage.ClickOnCommentAndRejectButton();
            performancePage.ClickOnConfirmationYesButton();
            if (!assertManagerPage.ValidateTemplateRejectedSuccessPopupDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Rejected Success Popup is not displayed.");
                softAssert.fail("Template Rejected Success Popup is not displayed.");
            }
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(4);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.EnterTextInFilterConditionSearchField("contains");
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.ReviewAdTemplateName);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateRejectedTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Rejected Template are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Rejected Template are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnCommentIcon();
            assertManagerPage.ClickOnCommentOnlyButton();
            if (!assertManagerPage.ValidateCommentFieldWarningRedLineDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Comment Field Warning Red Line is not displayed after clicking comment only without any data.");
                softAssert.fail("Comment Field Warning Red Line is not displayed after clicking comment only without any data.");

            }
            assertManagerPage.EnterDataInCommentField("      ");
            assertManagerPage.ClickOnCommentOnlyButton();
            Thread.sleep(2000);
            if (assertManagerPage.ValidateEmptyCommentIsAccepted()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty Comment is accepted.");
                softAssert.fail("Empty Comment is accepted.");
            }
            utils.CloseWindow(1);
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(2);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterValueFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(8);
            performancePage.ClickOnFilterApplyButton();
            assertManagerPage.ClickOnReviewTextButton();
            assertManagerPage.ClickOnApproveButton();
            performancePage.ClickOnConfirmationYesButton();
            if (!assertManagerPage.ValidateTemplateApprovedSuccessPopupDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Success Popup is not displayed.");
                softAssert.fail("Template Approved Success Popup is not displayed.");
            }
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(4);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.EnterTextInFilterConditionSearchField("contains");
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.ReviewAdTemplateName);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateApprovedTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Approved Template are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Approved Template are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnAddOrRemoveColumns();
            assertManagerPage.DeselectTableHeadingsInAddOrRemoveColumn(1);
            if (assertManagerPage.ValidateTableHeadingCountIsSameAfterDeselectingTableHeadings()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Table Heading Count is same after deselecting table headings.");
                softAssert.fail("Table Heading Count is  same after deselecting table headings.");

            }
            Thread.sleep(3000);

            assertManagerPage.ClickOnTableCompactViewButton();
            if (!assertManagerPage.ValidateTemplatesDisplayedInCardView()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Templates are displayed in Card View.");
                softAssert.fail("Templates are displayed in Card View.");
            }


        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        });

    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs Facebook Carousel Ads review")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate All Features While Reviewing Facebook Product Ads")
    public void ValidateAllFeaturesWhileReviewingFacebookProductAds() {
        utils.RetryOnFailHyperSeller(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1500);
            assertManagerPage.ClickOnAssertManagerButton();
            assertManagerPage.ClickOnTemplateReviewButton();
            assertManagerPage.SelectFacebookProductAds();
            performancePage.ClickOnAddFilterButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterValueFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(8);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateUnderReviewTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Under Review Templates are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Under Review Templates are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnReviewTextButton();
            assertManagerPage.ClickOnRejectButton();
            assertManagerPage.EnterDataInCommentField("qwerty");
            assertManagerPage.ClickOnCommentAndRejectButton();
            performancePage.ClickOnConfirmationYesButton();
            if (!assertManagerPage.ValidateTemplateRejectedSuccessPopupDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Rejected Success Popup is not displayed.");
                softAssert.fail("Template Rejected Success Popup is not displayed.");
            }
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(4);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.EnterTextInFilterConditionSearchField("contains");
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.ReviewAdTemplateName);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateRejectedTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Rejected Template are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Rejected Template are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnCommentIcon();
            assertManagerPage.ClickOnCommentOnlyButton();
            if (!assertManagerPage.ValidateCommentFieldWarningRedLineDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Comment Field Warning Red Line is not displayed after clicking comment only without any data.");
                softAssert.fail("Comment Field Warning Red Line is not displayed after clicking comment only without any data.");

            }
            assertManagerPage.EnterDataInCommentField("      ");
            assertManagerPage.ClickOnCommentOnlyButton();
            Thread.sleep(2000);
            if (assertManagerPage.ValidateEmptyCommentIsAccepted()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty Comment is accepted.");
                softAssert.fail("Empty Comment is accepted.");
            }
            utils.CloseWindow(1);
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(2);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterValueFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(8);
            performancePage.ClickOnFilterApplyButton();
            assertManagerPage.ClickOnReviewTextButton();
            assertManagerPage.ClickOnApproveButton();
            performancePage.ClickOnConfirmationYesButton();
            if (!assertManagerPage.ValidateTemplateApprovedSuccessPopupDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Success Popup is not displayed.");
                softAssert.fail("Template Approved Success Popup is not displayed.");
            }
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(4);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.EnterTextInFilterConditionSearchField("contains");
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.ReviewAdTemplateName);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateApprovedTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Approved Template are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Approved Template are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnAddOrRemoveColumns();
            assertManagerPage.DeselectTableHeadingsInAddOrRemoveColumn(1);
            if (assertManagerPage.ValidateTableHeadingCountIsSameAfterDeselectingTableHeadings()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Table Heading Count is same after deselecting table headings.");
                softAssert.fail("Table Heading Count is  same after deselecting table headings.");

            }
            Thread.sleep(3000);

            assertManagerPage.ClickOnTableCompactViewButton();
            if (!assertManagerPage.ValidateTemplatesDisplayedInCardView()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Templates are displayed in Card View.");
                softAssert.fail("Templates are displayed in Card View.");
            }
            

        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        });

    }



    @Epic("Pulse Dashboard")
    @Story("This flow belongs Google Search Ads review")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validate All Features While Reviewing Google Search Ads")
    public void ValidateAllFeaturesWhileReviewingGoogleSearchAds() {
        utils.RetryOnFailHyperSeller(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1500);
            assertManagerPage.ClickOnAssertManagerButton();
            assertManagerPage.ClickOnTemplateReviewButton();
            assertManagerPage.SelectGoogleSearchAds();
            performancePage.ClickOnAddFilterButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterValueFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(8);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateUnderReviewTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Under Review Templates are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Under Review Templates are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnReviewTextButton();
            assertManagerPage.ClickOnRejectButton();
            assertManagerPage.EnterDataInCommentField("qwerty");
            assertManagerPage.ClickOnCommentAndRejectButton();
            performancePage.ClickOnConfirmationYesButton();
            if (!assertManagerPage.ValidateTemplateRejectedSuccessPopupDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Rejected Success Popup is not displayed.");
                softAssert.fail("Template Rejected Success Popup is not displayed.");
            }
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(4);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.EnterTextInFilterConditionSearchField("contains");
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.ReviewAdTemplateName);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateRejectedTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Rejected Template are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Rejected Template are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnCommentIcon();
            assertManagerPage.ClickOnCommentOnlyButton();
            if (!assertManagerPage.ValidateCommentFieldWarningRedLineDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Comment Field Warning Red Line is not displayed after clicking comment only without any data.");
                softAssert.fail("Comment Field Warning Red Line is not displayed after clicking comment only without any data.");

            }
            assertManagerPage.EnterDataInCommentField("      ");
            assertManagerPage.ClickOnCommentOnlyButton();
            Thread.sleep(2000);
            if (assertManagerPage.ValidateEmptyCommentIsAccepted()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty Comment is accepted.");
                softAssert.fail("Empty Comment is accepted.");
            }
            utils.CloseWindow(1);
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(2);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.ClickOnFilterValueFieldDropDown();
            performancePage.ClickOnGenericOptionsSelector(8);
            performancePage.ClickOnFilterApplyButton();
            assertManagerPage.ClickOnReviewTextButton();
            assertManagerPage.ClickOnApproveButton();
            performancePage.ClickOnConfirmationYesButton();
            if (!assertManagerPage.ValidateTemplateApprovedSuccessPopupDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Template Approved Success Popup is not displayed.");
                softAssert.fail("Template Approved Success Popup is not displayed.");
            }
            assertManagerPage.ClickOnFilteredPillButton();
            performancePage.ClickOnAdTypeDropDownField();
            performancePage.ClickOnGenericOptionsSelector(4);
            performancePage.ClickOnFilterConditionFieldDropDown();
            performancePage.EnterTextInFilterConditionSearchField("contains");
            performancePage.ClickOnGenericOptionsSelector(1);
            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.ReviewAdTemplateName);
            performancePage.ClickOnFilterApplyButton();
            if (!assertManagerPage.ValidateApprovedTemplateIconDisplayedInReviewTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Approved Template are not displayed in Review Table After Applying Filter.");
                softAssert.fail("Approved Template are not displayed in Review Table After Applying Filter.");
            }
            assertManagerPage.ClickOnAddOrRemoveColumns();
            assertManagerPage.DeselectTableHeadingsInAddOrRemoveColumn(1);
            if (assertManagerPage.ValidateTableHeadingCountIsSameAfterDeselectingTableHeadings()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Table Heading Count is same after deselecting table headings.");
                softAssert.fail("Table Heading Count is  same after deselecting table headings.");

            }
            Thread.sleep(3000);

            assertManagerPage.ClickOnTableCompactViewButton();
            if (!assertManagerPage.ValidateTemplatesDisplayedInCardView()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Templates are displayed in Card View.");
                softAssert.fail("Templates are displayed in Card View.");
            }


        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        });

    }




    /// ----------------------

//    @Epic("Pulse Dashboard")
//    @Story("This flow belongs FacebookDynamicProductAdsWithAwareness")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(description = "Test: Create a Campaign Management", priority = 0)
//    public void ValidateAllFieldsWhileCreatingFacebookDynamicProductAdsWithLeads() {
////        utils.RetryOnFailHyperPulse(() -> {
//        SoftAssert softAssert = new SoftAssert();
//        try {
//            assertManagerPage.ClickOnAssertManagerButton();
//            assertManagerPage.SelectLibrary();
//            assertManagerPage.SelectFacebookDynamicProductAds();
//            assertManagerPage.ClickAddNewButton();
//            assertManagerPage.SelectDesiredCreativeType(2);
//            performancePage.ClickOnCreateButton();
//            if (!performancePage.IsCreativeNameFieldEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative name field empty error message is not displayed.");
//                softAssert.fail("Creative name field empty error message is not displayed.");
//            }
////            if (!performancePage.IsThisTemplateIsForEmptyErrorMessageDisplayed()) {
////                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - 'This Template is for' empty error message is not displayed.");
////                softAssert.fail("'This Template is for' empty error message is not displayed.");
////            }
//            if (!performancePage.IsMainBodyTextEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Dynamic Product Main body text empty error message is not displayed when saving with only spaces as input.");
//                softAssert.fail("FaceBook Dynamic Product Main body text empty error message is not displayed when saving with only spaces as input.");
//            }
//            if (!performancePage.IsHeadlineEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Dynamic Product Headline empty error message is not displayed.");
//                softAssert.fail("FaceBook Dynamic Product Headline empty error message is not displayed.");
//            }
//
//            if (!assertManagerPage.ValidateDestinationUrlFieldEmptyErrorMessage()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Dynamic Product Destination URL empty error message is not displayed.");
//                softAssert.fail("FaceBook Dynamic Product Destination URL empty error message is not displayed.");
//            }
//            if (!performancePage.IsSelectCallToActionEmptyErrorMessageDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Dynamic Product Select call to action empty error message is not displayed.");
//                softAssert.fail("FaceBook Dynamic Product Select call to action empty error message is not displayed.");
//            }
//            assertManagerPage.EnterAdTemplateName("test dpa with tag");
//            assertManagerPage.EnteringDestinationURL("          ");
//            performancePage.ClickOnCreateButton();
//            if (!assertManagerPage.ValidateDestinationUrlFieldEmptyErrorMessage()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Dynamic Product Destination URL empty error message is not displayed.");
//                softAssert.fail("FaceBook Dynamic Product Destination URL empty error message is not displayed.");
//            }
//            Thread.sleep(1500);
//            assertManagerPage.SelectDesiredTemplateForSelection(1);
//            assertManagerPage.EnterMainBodyText("MainBody Test");
//            assertManagerPage.ScrollToSelectCallToActionField();
//            assertManagerPage.EnteringDestinationURL("www.example.com");
//            assertManagerPage.EnterProductAdsHeadlineText("This is headline");
//            assertManagerPage.EnterDescription("This is description", 1);
//            assertManagerPage.SelectingDesiredSelectCallToActionDropdown("Order Now", 1);
//            assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
//            assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
//            assertManagerPage.ClickingCreativeTagsAddButton();
//            assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
//            assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
//            assertManagerPage.ClickingCreativeTagsAddButton();
//            assertManagerPage.ClickingTheDeleteButton(3);
//            performancePage.ClickOnCreateButton();
//            if(!assertManagerPage.ValidateDuplicateAdNameErrorPopUpIsDisplayed()){
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - FaceBook Dynamic Product Duplicate Ad Name Error PopUp is not displayed.");
//                softAssert.fail("FaceBook Dynamic Product Duplicate Ad Name Error PopUp is not displayed.");
//            }
//            assertManagerPage.EnterFacebookDynamicProductAwarenessADTemplateName(utils.generateRandomData("random", 5).toString());
//            assertManagerPage.ClickCreateButton();
//
//        } catch (InterruptedException e) {
//            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
//        }
//        softAssert.assertAll();
////        });
//    }


//    @Epic("Pulse Dashboard")
//    @Story("This flow belongs FacebookDynamicProductAdsWithLeads")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(description = "Test: Create a Campaign Management", priority = 0)
//    public void CreateFacebookDynamicProductAdsWithLeads() {
//        utils.RetryOnFailHyperSeller(() -> {
//        SoftAssert softAssert = new SoftAssert();
//        try {
//            Thread.sleep(4000);
//            assertManagerPage.ClickOnAssertManagerButton();
//            assertManagerPage.SelectLibrary();
//            assertManagerPage.SelectFacebookDynamicProductAds();
//            assertManagerPage.ClickAddNewButton();
//            assertManagerPage.EnterFacebookDynamicProductTemplateName(utils.generateRandomData("random", 5).toString());
//            assertManagerPage.ClickOnSelectPartner();
//            performancePage.ClickOnGenericOptionsSelector(2);
//            assertManagerPage.SelectDesiredLanguage(1);
//            assertManagerPage.SelectDesiredCreativeType(1);
//            assertManagerPage.SelectDesiredLeadFormSelection(1);
//            assertManagerPage.SelectingThisTemplateIsFor("Tata M&HCV", 1);
//            assertManagerPage.EnterMainBodyText("MainBody Test");
//            assertManagerPage.ScrollToSelectCallToActionField();
//            assertManagerPage.EnterProductAdsHeadlineText("This is headline");
//            Thread.sleep(1000);
//            assertManagerPage.EnterDescription("This is description", 1);
//////            assertManagerPage.SelectingDesiredFacebookProductAdsMediaTypeFromDropdown(1);
////            assertManagerPage.ClickUploadImage();
////            assertManagerPage.ChooseCreativeLibraryImage("Choose Creative");
//            assertManagerPage.SelectingDesiredSelectCallToActionDropdown("Get Quote", 1);
//            assertManagerPage.SelectingDesiredTagFromDropdown("Seasonal Theme", 1, 1);
//            assertManagerPage.SelectingDesiredTagValueFromDropdown(1, 1);
//            assertManagerPage.ClickingCreativeTagsAddButton();
//            assertManagerPage.SelectingDesiredTagFromDropdown("EyeCatcher", 2, 1);
//            assertManagerPage.SelectingDesiredTagValueFromDropdown(2, 1);
//            assertManagerPage.ClickingCreativeTagsAddButton();
//            assertManagerPage.ClickingTheDeleteButton(3);
//            assertManagerPage.ClickCreateButton();
//
//
//            if (!assertManagerPage.ValidateFaceBookCarouselTemplateSuccessPopUp()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Facebook Dynamic Product Template Success PopUp is not displayed.");
//                softAssert.fail("Facebook Dynamic Product Template Success PopUp is not displayed.");
//            }
//            performancePage.ClickOnAddFilterButton();
//            performancePage.ClickOnAdTypeDropDownField();
//            performancePage.ClickOnGenericOptionsSelector(2);
//            performancePage.ClickOnFilterConditionFieldDropDown();
//            performancePage.EnterTextInFilterConditionSearchField("contains");
//            performancePage.ClickOnGenericOptionsSelector(1);
//            performancePage.EnterTextInFilterValueSearchField(assertManagerPage.FacebookDynamicProductTemplateName);
//            performancePage.ClickOnFilterApplyButton();
//
//            if (!assertManagerPage.ValidateTemplateApprovedStatusIsDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Facebook Dynamic Product Template Approved Status is not displayed.");
//                softAssert.fail("Facebook Dynamic Product Template Approved Status is not displayed.");
//            }
//
//
//        } catch (InterruptedException e) {
//            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
//        }
//        softAssert.assertAll();
////        });
//    }  // not creating

}