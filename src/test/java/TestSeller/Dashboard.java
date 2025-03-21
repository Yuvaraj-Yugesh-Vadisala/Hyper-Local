package TestSeller;

import BaseSetup.BaseTest;
import PagesSeller.DashboardPage;
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

public class Dashboard extends BaseTest {
    private DashboardPage dashboardPage;
    private PerformancePage performancePage;
    private Utils utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalSellerUrl);
        dashboardPage = new DashboardPage(getDriver());
        performancePage = new PerformancePage(getDriver());
        utils = new Utils(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", super.HyperUAT);
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
        performancePage.SelectingClient("EAT Tata Motors", 2);
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

//            @AfterClass(alwaysRun = true)
    public void TearDown() {
        getDriver().quit();
    }

    @Epic("Seller Dashboard")
    @Story("This flow belongs Performance Dashboard Operations")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Validate all Performance dashboard operation", priority = 0)
    public void ValidateAllPerformanceDashboardOperations() {
//        utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(2500);
            performancePage.CloseAnnouncementCloseButtonIfAvailable();
            LocalDate StartDate = LocalDate.of(2024, 5, 10);
            LocalDate EndDate = LocalDate.of(2025, 2, 10);
            dashboardPage.ClickOnDashboardCalender();
            dashboardPage.selectDateRange(StartDate, EndDate);
            Thread.sleep(800);
            dashboardPage.ClickWeekView();
            if (!dashboardPage.IsWeekViewSelected()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Week View is not selected");
                softAssert.fail("Week View is not selected");
            }
            Thread.sleep(500);
            dashboardPage.ClickOnMonthView();
            if (!dashboardPage.IsMonthViewSelected()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Month View is not selected");
                softAssert.fail("Month View is not selected");
            }
            dashboardPage.SelectDesiredStatus(2);
            dashboardPage.ClickCampaignEditButton();
            if (!dashboardPage.ValidateVisibilityOfCampaignEditPage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign Edit Page is not visible");
                softAssert.fail("Campaign Edit Page is not visible");
            }
            utils.CloseWindow(1);
            Thread.sleep(500);
            dashboardPage.ClickAnalyticsButton();
            if (!dashboardPage.ValidateVisibilityOfAnalyticsPage()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Analytics Page is not visible");
                softAssert.fail("Analytics Page is not visible");
            }
            utils.CloseWindow(1);
            dashboardPage.ClickViewAllCampaign();
            if (!dashboardPage.ValidateVisibilityOfAllCampaignTable()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion -All Campaign Page is not visible");
                softAssert.fail("All Campaign Page is not visible");
            }
            utils.CloseWindow(1);
            Thread.sleep(1000);
            dashboardPage.ClickTopGoogleAds();



        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
//        }));
    }

    @Epic("Seller Dashboard")
    @Story("This flow belongs Meninx Dashboard Operations")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Validate all Meninx dashboard operation", priority = 0)   //Pending
    public void ValidateAllMeninxDashboardOperations() {
//        utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(2500);
            performancePage.CloseAnnouncementCloseButtonIfAvailable();
            LocalDate StartDate = LocalDate.of(2024, 6, 15);
            LocalDate EndDate = LocalDate.of(2024, 10, 10);
            dashboardPage.ClickOnDashboardCalender();
            dashboardPage.selectDateRange(StartDate, EndDate);
            Thread.sleep(800);
            dashboardPage.ClickMeninxTab();


        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
//        }));
    }








}
