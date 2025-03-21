package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.CampaignManagementPage;
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

public class CampaignManagement extends BaseTest {

    private CampaignManagementPage campaignManagementPage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        campaignManagementPage = new CampaignManagementPage(getDriver());
        utils = new Utils(getDriver());
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
    @Story("This flow belongs Campaign Management")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Create a Campaign Management", priority = 0)
    public void CreateCampaignManagement() {
        utils.RetryOnFailHyperPulse(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(4000);
                campaignManagementPage.ClickOnPaidMediaButton();
                campaignManagementPage.ClickOnCampaignManagementButton();
                campaignManagementPage.ClickOnCreateCampaignButton();
                campaignManagementPage.EnterCampaignName("randomdata", 5);
                campaignManagementPage.EnterCampaignBrief("This is a test campaign");
                campaignManagementPage.ClickOnChooseChannelField();
                campaignManagementPage.EnterDataInChooseChannelSearchField("Google");
                campaignManagementPage.SelectOption(1);
                campaignManagementPage.ClickOnStrategySettingsCheckBox();
                campaignManagementPage.ClickOnFixedSchedule();
                campaignManagementPage.ClickOnStartDateField();
                campaignManagementPage.DateSelector("April", "2025", "15");
                campaignManagementPage.ClickOnEndDateField();
                campaignManagementPage.DateSelector("June", "2025", "30");
                campaignManagementPage.ClickOnNextButton();
                campaignManagementPage.ClickOnConfirmationYesButton();
                campaignManagementPage.ClickOnAddPartnersButton();
                Thread.sleep(2000);
                campaignManagementPage.ClickOnAddFilterButton();
                campaignManagementPage.ClickOnAdTypeDropDownField();
                campaignManagementPage.SelectOption(3);
                campaignManagementPage.ClickOnFilterConditionFieldDropDown();
//            campaignManagementPage.EnterTextInFilterConditionSearchField("Zone");
                campaignManagementPage.SelectOption(1);
                campaignManagementPage.EnterTextInFilterValueSearchField("East");
                campaignManagementPage.ClickOnFilterApplyButton();
                campaignManagementPage.SelectPartner(2);
                campaignManagementPage.SelectPartner(3);
                campaignManagementPage.SelectPartner(4);
                campaignManagementPage.ClickOnAddPartnerSaveButton();
                campaignManagementPage.EnterAverageDailyBudget("500", 1);
                campaignManagementPage.ClickOnAverageDailyBudgetCopyIcon(1);
                campaignManagementPage.ClickOnCopyToAllButton(1);
                campaignManagementPage.EnterLifeTimeBudget("2500", 2);
                campaignManagementPage.ClickOnAverageDailyBudgetCopyIcon(2);
                campaignManagementPage.ClickOnCopyToAllButton(2);
                campaignManagementPage.ClickOnPartnerSelectionNextButton();
                campaignManagementPage.ClickOnChooseFromAdLibraryButton();
                campaignManagementPage.SelectAd(2);
                campaignManagementPage.ClickOnAdSaveButton();
                if (!campaignManagementPage.VerifyAdSavedSuccessPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Responsive Ad Saved Success Pop is Not Displayed");
                    softAssert.fail("Responsive Ad Saved Success Pop is Not Displayed");
                }
                campaignManagementPage.ClickOnCallAdSection();
                campaignManagementPage.ClickOnChooseFromAdLibraryButton();
                campaignManagementPage.SelectAd(2);
                campaignManagementPage.ClickOnAdSaveButton();
                if (!campaignManagementPage.VerifyAdSavedSuccessPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Call Ad Saved Success Pop is Not Displayed");
                    softAssert.fail("Call Ad Saved Success Pop is Not Displayed");
                }
//            campaignManagementPage.ClickOnGooglePerformanceAd();
//            campaignManagementPage.ClickOnChooseFromAdLibraryButton();
//            campaignManagementPage.SelectAd(2);
//            campaignManagementPage.ClickOnAdSaveButton();
//            if (campaignManagementPage.VerifyAdSavedSuccessPopUpIsDisplayed()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Google Performance Ad Saved Success Pop is Not Displayed");
//                softAssert.fail("Google Performance Ad Saved Success Pop is Not Displayed");
//            }
                campaignManagementPage.ClickOnStep2AdsNextButton();
                campaignManagementPage.ClickOnAdNewAudienceButton();
                campaignManagementPage.EnterAudienceName("randomdata");
                campaignManagementPage.ClickOnFromAgeField();
                campaignManagementPage.SelectOption(2);
                campaignManagementPage.ClickOnToAgeField();
                campaignManagementPage.SelectOption(4);
                campaignManagementPage.SelectGender(2);
                campaignManagementPage.ClickOnAudienceCreationSaveButton();
                campaignManagementPage.ClickOnConfirmationYesButton();
                Thread.sleep(2000);
                campaignManagementPage.EnterDataInSearchField(campaignManagementPage.AudienceName);
                if (!campaignManagementPage.IsCreatedAudienceDisplayedInTableFirstRow()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Created Audience is not displayed in table");
                    softAssert.fail("Created Audience is not displayed in table");
                }
                campaignManagementPage.SelectAudience(1);
                campaignManagementPage.ClickOnReviewAndLaunchButton();
                campaignManagementPage.ClickOnLaunchCampaignButton();
                if (campaignManagementPage.VerifyCampaignLaunchSuccessPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Launch Success Pop Up is not displayed");
                    softAssert.fail("Campaign Launch Success Pop Up is not displayed");
                }
                campaignManagementPage.ClickOnAllActionsButton();
                campaignManagementPage.ClickOnAddFilterButton();
                campaignManagementPage.ClickOnAdTypeDropDownField();
                campaignManagementPage.SelectOption(2);
                campaignManagementPage.EnterTextInFilterSearchField(campaignManagementPage.CampaignName);
                campaignManagementPage.ClickOnFilterApplyButton();
                if (!campaignManagementPage.IsCreatedCampaignDisplayedAfterApplyingFilter()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Created Campaign is not displayed after applying filter in all actions");
                    softAssert.fail("Created Campaign is not displayed after applying filter in all actions");
                }
                campaignManagementPage.ClickOnRefreshButton();
                campaignManagementPage.ClickOnCampaignViewButton();
                Thread.sleep(2000);
                campaignManagementPage.ClickOnAdsTabSwitcher();
                Thread.sleep(2000);
                if (!campaignManagementPage.ValidateCreatedPartnersCount(6)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Created Partners Ad count is not as expected");
                    softAssert.fail("Created Partners Ad count is not as expected");
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }

    @Epic("Pulse Dashboard")
    @Story("This flow belongs Campaign Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create a Campaign Management", priority = 0)
    public void ValidateAllFieldsWhileCreatingCampaign() {
        utils.RetryOnFailHyperPulse(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(1500);
                campaignManagementPage.ClickOnPaidMediaButton();
                campaignManagementPage.ClickOnCampaignManagementButton();
                campaignManagementPage.ClickOnCreateCampaignButton();
                campaignManagementPage.ClickOnNextButton();
                if (campaignManagementPage.VerifyCampaignNameEmptyErrorMessageIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Name Empty Error Message is not displayed");
                    softAssert.fail("Campaign Name Empty Error Message is not displayed");
                }
                if (campaignManagementPage.VerifyCampaignBriefEmptyErrorMessageIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Brief Empty Error Message is not displayed");
                    softAssert.fail("Campaign Brief Empty Error Message is not displayed");
                }
                if (campaignManagementPage.VerifyChooseChannelEmptyErrorMessageIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Choose Channel Empty Error Message is not displayed");
                    softAssert.fail("Choose Channel Empty Error Message is not displayed");
                }
                campaignManagementPage.EnterDataInCampaignName("      ");
                if (campaignManagementPage.IsCampaignNameFieldAcceptingEmptySpacesAsInput()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Name Field is accepting empty spaces as input");
                    softAssert.fail("Campaign Name Field is accepting empty spaces as input");
                }
                campaignManagementPage.EnterDataInCampaignName(utils.generateRandomData("randomdata", 105).toString());
                if (campaignManagementPage.IsCampaignNameFieldAcceptingMoreThan100Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Name Field is accepting more than 100 characters as input");
                    softAssert.fail("Campaign Name Field is accepting more than 100 characters as input");
                }
                campaignManagementPage.EnterCampaignBrief("        ");
                if (campaignManagementPage.IsCampaignBriefFieldAcceptingEmptySpacesAsInput()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Brief Field is accepting empty spaces as input");
                    softAssert.fail("Campaign Brief Field is accepting empty spaces as input");
                }
                campaignManagementPage.EnterCampaignBrief(utils.generateRandomData("randomdata", 205).toString());
                if (campaignManagementPage.IsCampaignBriefFieldAcceptingMoreThan200Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Brief Field is accepting more than 200 characters as input");
                    softAssert.fail("Campaign Brief Field is accepting more than 200 characters as input");
                }
                campaignManagementPage.EnterCampaignName("randomdata", 5);
                campaignManagementPage.EnterCampaignBrief("This is a test campaign");
                campaignManagementPage.ClickOnChooseChannelField();
                campaignManagementPage.EnterDataInChooseChannelSearchField("Google");
                campaignManagementPage.SelectOption(1);
                campaignManagementPage.ClickOnStrategySettingsCheckBox();
                campaignManagementPage.ClickOnFixedSchedule();
                campaignManagementPage.ClickOnStartDateField();
                campaignManagementPage.DateSelector("April", "2025", "15");
                campaignManagementPage.ClickOnEndDateField();
                campaignManagementPage.DateSelector("June", "2025", "30");
                campaignManagementPage.ClickOnNextButton();
                campaignManagementPage.ClickOnConfirmationYesButton();
                campaignManagementPage.ClickOnPartnerSelectionNextButton();
                if (!campaignManagementPage.VerifyAddPartnersErrorPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Add Partners Error Pop Up is not displayed");
                    softAssert.fail("Add Partners Error Pop Up is not displayed");
                }
                campaignManagementPage.ClickOnAddPartnersButton();
                campaignManagementPage.ClickOnAddPartnerSaveButton();
                if (!campaignManagementPage.VerifySavePartnersEmptyErrorPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Save Partners Empty Error Pop Up is not displayed");
                    softAssert.fail("Save Partners Empty Error Pop Up is not displayed");
                }
                campaignManagementPage.ClickOnAddFilterButton();
                campaignManagementPage.ClickOnFilterApplyButton();
                if (!campaignManagementPage.VerifyAddFilterValueFieldEmptyErrorMessageIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty Filter Error Message is not displayed");
                    softAssert.fail("Empty Filter Error Message is not displayed");
                }
                campaignManagementPage.ClickOnAdTypeDropDownField();
                campaignManagementPage.SelectOption(3);
                campaignManagementPage.ClickOnFilterConditionFieldDropDown();
//            campaignManagementPage.EnterTextInFilterConditionSearchField("Zone");
                campaignManagementPage.SelectOption(1);
                campaignManagementPage.EnterTextInFilterValueSearchField("East");
                campaignManagementPage.ClickOnFilterApplyButton();
                campaignManagementPage.SelectPartner(2);
                campaignManagementPage.SelectPartner(3);
                campaignManagementPage.SelectPartner(4);
                campaignManagementPage.ClickOnAddPartnerSaveButton();
                Thread.sleep(2000);
                campaignManagementPage.ClickOnPartnerSelectionNextButton();
                if (!campaignManagementPage.VerifyAverageDailyBudgetErrorPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average Daily Budget Error Pop Up is not displayed");
                    softAssert.fail("Average Daily Budget Error Pop Up is not displayed");
                }
                if (!campaignManagementPage.VerifyAverageDailyBudgetFieldIsAcceptingCharacters(1)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average Daily Budget Field is accepting characters");
                    softAssert.fail("Average Daily Budget Field is accepting characters");
                }
                campaignManagementPage.EnterAverageDailyBudget("     ", 1);
                if (!campaignManagementPage.VerifyAverageDailyBudgetFieldIsAcceptingSpaces(1)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average Daily Budget Field is accepting spaces");
                    softAssert.fail("Average Daily Budget Field is accepting spaces");
                }
                campaignManagementPage.EnterAverageDailyBudget("-500", 1);
                if (!campaignManagementPage.VerifyAverageDailyBudgetFieldIsAcceptingNegativeValue(1)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Average Daily Budget Field is accepting negative value");
                    softAssert.fail("Average Daily Budget Field is accepting negative value");
                }
                campaignManagementPage.ClickOnAverageDailyBudgetCopyIcon(1);
                campaignManagementPage.ClickOnCopyToAllButton(1);
                campaignManagementPage.EnterLifeTimeBudget("10", 2);
                campaignManagementPage.ClickOnPartnerSelectionNextButton();
                if (!campaignManagementPage.VerifyLifeTimeBudgetWarningIconIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Life Time Budget Warning Icon is not displayed");
                    softAssert.fail("Life Time Budget Warning Icon is not displayed");
                }
                campaignManagementPage.EnterLifeTimeBudget("abcdef", 2);
                if (!campaignManagementPage.VerifyLifeTimeBudgetFieldIsAcceptingCharacters(2)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Life Time Budget Field is accepting characters");
                    softAssert.fail("Life Time Budget Field is accepting characters");
                }
                campaignManagementPage.EnterLifeTimeBudget("     ", 2);
                if (!campaignManagementPage.VerifyLifeTimeBudgetFieldIsAcceptingSpaces(2)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Life Time Budget Field is accepting spaces");
                    softAssert.fail("Life Time Budget Field is accepting spaces");
                }
                campaignManagementPage.EnterLifeTimeBudget("-2500", 2);
                if (!campaignManagementPage.VerifyLifeTimeBudgetFieldIsAcceptingNegativeValue(2)) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Life Time Budget Field is accepting negative value");
                    softAssert.fail("Life Time Budget Field is accepting negative value");
                }
                campaignManagementPage.ClickOnAverageDailyBudgetCopyIcon(2);
                campaignManagementPage.ClickOnCopyToAllButton(2);
                campaignManagementPage.ClickOnPartnerSelectionNextButton();
                Thread.sleep(3000);
                campaignManagementPage.ClickOnStep2AdsNextButton();
                if (!campaignManagementPage.VerifyAdsMinimumErrorPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Ads Minimum Error Pop Up is not displayed");
                    softAssert.fail("Ads Minimum Error Pop Up is not displayed");
                }
                campaignManagementPage.ClickOnChooseFromAdLibraryButton();
                campaignManagementPage.ClickOnAdSaveButton();
                if (!campaignManagementPage.VerifyResponsiveAdsMinimumErrorPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Responsive Ads Minimum Error Pop Up is not displayed");
                    softAssert.fail("Responsive Ads Minimum Error Pop Up is not displayed");
                }
                campaignManagementPage.SelectAd(2);
                campaignManagementPage.ClickOnAdSaveButton();
                campaignManagementPage.ClickOnCallAdSection();
                campaignManagementPage.ClickOnChooseFromAdLibraryButton();
                campaignManagementPage.ClickOnAdSaveButton();
                if (!campaignManagementPage.VerifyCallAdsMinimumErrorPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Call Ads Minimum Error Pop Up is not displayed");
                    softAssert.fail("Call Ads Minimum Error Pop Up is not displayed");
                }
                campaignManagementPage.SelectAd(2);
                Thread.sleep(3000);
                campaignManagementPage.ClickOnAdSaveButton();
                campaignManagementPage.ClickOnStep2AdsNextButton();
                if (!campaignManagementPage.VerifyReviewAndLunchButtonIsEnabledWithoutSelectingAnyAudience()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Review and Launch Button is Enabled Without Selecting any Audience");
                    softAssert.fail("Review and Launch Button is Enabled Without Selecting any Audience");
                }
                campaignManagementPage.ClickOnAdNewAudienceButton();
                campaignManagementPage.ClickOnAudienceCreationSaveButton();
                if (!campaignManagementPage.VerifyAudienceNameEmptyErrorMessageIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Audience Name Empty Error Message is not displayed");
                    softAssert.fail("Audience Name Empty Error Message is not displayed");
                }
                campaignManagementPage.EnterDataInAudienceName("     ");
                campaignManagementPage.ClickOnAudienceCreationSaveButton();
                if (!campaignManagementPage.VerifyAudienceNameEmptyErrorMessageIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Audience Name Empty Error Message is not displayed");
                    softAssert.fail("Audience Name Empty Error Message is not displayed");
                }
                if (campaignManagementPage.VerifyFromAgeIsHavingBiggerAgeValueThanToAge()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - From Age is having bigger age value than To Age");
                    softAssert.fail("From Age is having bigger age value than To Age");
                }
                campaignManagementPage.SelectOption(4);
                Thread.sleep(1500);
                campaignManagementPage.EnterDataInAudienceName("Test123");
                campaignManagementPage.ClickOnAudienceCreationSaveButton();
                campaignManagementPage.ClickOnConfirmationYesButton();
                if (!campaignManagementPage.VerifyDuplicateAudienceNameErrorPopUpIsDisplayed()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Audience Name Empty Error Message is not displayed");
                    softAssert.fail("Audience Name Empty Error Message is not displayed");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });

    }

}
