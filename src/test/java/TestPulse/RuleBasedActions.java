package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.CampaignManagementPage;
import PagesPulse.RuleBasedActionPage;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RuleBasedActions extends BaseTest {

    private CampaignManagementPage campaignManagementPage;
    private Utils utils;
    private MeninxPage meninxPage;
    private RuleBasedActionPage ruleAction;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        campaignManagementPage = new CampaignManagementPage(getDriver());
        utils = new Utils(getDriver());
        ruleAction = new RuleBasedActionPage(getDriver());
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

    //    @AfterClass(alwaysRun = true)
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("Pulse Dashboard")
    @Story("This flow belongs Rule Based Actions")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Create a Rule based action", priority = 0)
    public void CreationOfRuleBasedBulkAction() {
//        utils.RetryOnFailHyperSeller(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1000);
            campaignManagementPage.ClickOnPaidMediaButton();
            ruleAction.ClickOnRuleBasedActionMenu();
            ruleAction.ClickOnBulkRuleButton();
            String RuleName = "TestRule " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyy-HHmm"));
            ruleAction.EnterRuleName(RuleName);
            ruleAction.EnterRuleBrief("Test Brief");
            Thread.sleep(1000);
            ruleAction.SelectingScheduleType("FIXED");
            campaignManagementPage.ClickOnConfirmationYesButton();
            LocalDate today = LocalDate.now();
            String month = today.format(DateTimeFormatter.ofPattern("MMM"));
            String year = String.valueOf(today.getYear());
            String day = String.valueOf(today.getDayOfMonth());
            ruleAction.ClickOnStartDateField();
            ruleAction.DateSelector(month, year, day);
            ruleAction.ClickOnEndDateField();
            ruleAction.DateSelector("June", "2025", "20");
            // ApplyFilter TAKE19
            ruleAction.EnterIndividualPaidThreshold("100");
            ruleAction.EnterIndividualSpendThreshold("200");
            Thread.sleep(800);
//            ruleAction.ClickOnCopyToAllForPaidLeadsThreshold();
            Thread.sleep(800);
//            ruleAction.ClickOnCopyToAllForSpendLeadsThreshold();
            ruleAction.ClickOnCreateRuleSubmitButton();
            ruleAction.EnterBulkRuleDescription("Test description");
            ruleAction.ClickOnConfirmationDoneButton();
            if (!ruleAction.ValidateBulkRuleCreationSuccessPopup()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success pop up is not displayed");
                softAssert.fail("Success pop up is not displayed");
            }
            utils.ClickOnPopUpCloseButton();
            ruleAction.ClickOnAllActionButton();
            Thread.sleep(1000);
            if(!ruleAction.ValidateBulkRuleCreationInAllActions(RuleName)){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Bulk rule creation failed");
                softAssert.fail("Bulk rule creation failed");
            }
            Thread.sleep(2500);
            ruleAction.ClickOnRefreshButton();
            ruleAction.ClickOnDownloadButton();
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
//        });
    }

    @Epic("Pulse Dashboard")
    @Story("This flow belongs Rule Based Actions")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Create a Rule based action Negative", priority = 1)
    public void CreationOfRuleBasedBulkActionNegative() {
//        utils.RetryOnFailHyperSeller(() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1000);
            campaignManagementPage.ClickOnPaidMediaButton();
            ruleAction.ClickOnRuleBasedActionMenu();
            ruleAction.ClickOnBulkRuleButton();
            ruleAction.ClickOnCreateRuleSubmitButton();
            if (!ruleAction.ValidateVisibilityOfRuleNameErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Rule Name error message is not displayed when it is empty");
                softAssert.fail("Rule Name error message is not displayed when it is empty");
            }
            ruleAction.EnterRuleName("       ");
            ruleAction.ClickOnCreateRuleSubmitButton();
            if (!ruleAction.ValidateVisibilityOfRuleNameErrorMessage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Rule Name error message is not displayed when only spaces are entered");
                softAssert.fail("Rule Name error message is not displayed when only spaces are entered as input");
            }
            String RuleName50Char = utils.generateRandomData("randomdata",50).toString();
            ruleAction.EnterRuleName(RuleName50Char);
            if (ruleAction.IsRuleNameFieldAcceptingMoreThan50Characters()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Rule Name Field is accepting more than 50 characters as input");
                softAssert.fail("Rule Name Field is accepting more than 50 characters as input");
            }

            ruleAction.EnterRuleBrief("Test Brief");
            Thread.sleep(1000);
            ruleAction.SelectingScheduleType("FIXED");
            campaignManagementPage.ClickOnConfirmationYesButton();
            LocalDate today = LocalDate.now();
            String month = today.format(DateTimeFormatter.ofPattern("MMM"));
            String year = String.valueOf(today.getYear());
            String day = String.valueOf(today.getDayOfMonth());
            ruleAction.ClickOnStartDateField();
            ruleAction.DateSelector(month, year, day);
            ruleAction.ClickOnEndDateField();
            ruleAction.DateSelector("June", "2025", "20");
            // ApplyFilter TAKE19
            ruleAction.EnterIndividualPaidThreshold("100");
            ruleAction.EnterIndividualSpendThreshold("200");
            Thread.sleep(800);
//            ruleAction.ClickOnCopyToAllForPaidLeadsThreshold();
            Thread.sleep(800);
//            ruleAction.ClickOnCopyToAllForSpendLeadsThreshold();
//            ruleAction.ClickOnCreateRuleSubmitButton();
//            ruleAction.EnterBulkRuleDescription("Test description");
//            ruleAction.ClickOnConfirmationDoneButton();
//            if (!ruleAction.ValidateBulkRuleCreationSuccessPopup()) {
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success pop up is not displayed");
//                softAssert.fail("Success pop up is not displayed");
//            }
//            utils.ClickOnPopUpCloseButton();
//            ruleAction.ClickOnAllActionButton();
//            Thread.sleep(1000);
//            if(!ruleAction.ValidateBulkRuleCreationInAllActions(RuleName50Char)){
//                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Bulk rule creation failed");
//                softAssert.fail("Bulk rule creation failed");
//            }
//            Thread.sleep(2500);
//            ruleAction.ClickOnRefreshButton();
//            ruleAction.ClickOnDownloadButton();
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
//        });
    }
}
