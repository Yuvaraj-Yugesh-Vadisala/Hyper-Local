package TestPulse;

import BaseSetup.BaseTest;
import PagesPulse.AdSegmentManagerPage;
import UtilityClass.Utils;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdSegmentManager extends BaseTest {

    private AdSegmentManagerPage adSegmentManagerPage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalPulseUrl);
        utils = new Utils(getDriver());
        adSegmentManagerPage = new AdSegmentManagerPage(getDriver());
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
    @Story("This flow belongs Segment manager")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Segment Manager Operations")
    public void SegmentManagerOperations() {
        utils.RetryOnFailHyperPulse(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(1000);
                utils.ClickOnControlCenterNavButton();
                adSegmentManagerPage.ClickOnSegmentManager();
                adSegmentManagerPage.ClickOnAddNewSegmentButton();
                adSegmentManagerPage.ClickOnSegmentSaveButton();
                if (!adSegmentManagerPage.ValidateErrorMessageForEmptyField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - No Error Message is displayed for empty segment name");
                    Assert.fail("No Error Message is displayed for empty segment name");
                }
                utils.ClickOnPopUpCloseButton();
                adSegmentManagerPage.EnterSegmentName("         ");
                adSegmentManagerPage.ClickOnSegmentSaveButton();
                if (!adSegmentManagerPage.ValidateErrorMessageForEmptyField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - segment is being created with only spaces in segment name");
                    Assert.fail("segment is being created with only spaces in segment name");
                }
                utils.ClickOnPopUpCloseButton();
                adSegmentManagerPage.EnterSegmentName("TestSegment"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyy-HHmm")));
                Thread.sleep(1000);
                adSegmentManagerPage.SelectEveryOneToggle();
                adSegmentManagerPage.ClickOnSegmentSaveButton();
                if (!adSegmentManagerPage.ValidateErrorMessageForSegmentElement()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - segment creation is being Without selecting any segment element");
                    Assert.fail("segment creation is being Without selecting any segment element");
                }
                adSegmentManagerPage.ClickOnAddSegmentElementButton();
                adSegmentManagerPage.SelectDesiredSegmentOption(1);
                adSegmentManagerPage.ClickOnSegmentSaveButton();
                if (!adSegmentManagerPage.ValidateErrorMessageForSegmentAttributeValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - segment creation is being Without selecting or adding any segment attribute value");
                    Assert.fail("segment creation is being Without selecting or adding any segment attribute value");
                }
                Thread.sleep(1000);
                adSegmentManagerPage.ClickOnCrossIcon();
                adSegmentManagerPage.ClickOnAddSegmentElementButton();
                adSegmentManagerPage.EnterDesiredElementName("Targeting Type");
                adSegmentManagerPage.SelectDesiredSegmentOption(1);
                adSegmentManagerPage.ClickOnConditionDropdown();
                adSegmentManagerPage.SelectDesiredSegmentCondition(2);
                adSegmentManagerPage.ClickOnValueDropdown();
                adSegmentManagerPage.SelectDesiredSegmentValue(2);

                adSegmentManagerPage.ClickOnAddSegmentElementButton();
                adSegmentManagerPage.EnterDesiredElementName("Remaining Wallet Balance");
                adSegmentManagerPage.SelectDesiredSegmentOption(1);

                adSegmentManagerPage.EnterSegmentValue("100");
                adSegmentManagerPage.ClickOnSegmentSaveButton();
                if (!adSegmentManagerPage.ValidateVisibilityOfSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - segment creation failed");
                    Assert.fail("segment creation failed");
                }
                utils.ClickOnPopUpCloseButton();
                adSegmentManagerPage.ClickOnThreeDots(1);
                Thread.sleep(1000);
                adSegmentManagerPage.ClickOnSegmentEditButton();
                if (!adSegmentManagerPage.ValidateVisibilityEditPage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Edit page is not visible");
                    softAssert.fail("Edit page is not visible");
                }
                utils.ClickOnCrossButton();
                adSegmentManagerPage.ClickOnThreeDots(1);
                adSegmentManagerPage.ClickOnSegmentDuplicateButton();
                adSegmentManagerPage.ClickOnSegmentSaveButton();
                if (!adSegmentManagerPage.ValidateVisibilityOfSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - segment duplication failed");
                    softAssert.fail("segment duplication failed");
                }
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1500);
                adSegmentManagerPage.ClickOnThreeDots(1);
                adSegmentManagerPage.ClickOnMerchantDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (adSegmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Processing Failed or download button took more than 2 minutes to be enabled");
                    softAssert.fail("Processing Failed or download button took more than 2 minutes to be enabled");
                }
                adSegmentManagerPage.ClickOnSegmentFilterButton();
                adSegmentManagerPage.EnterFilterSegmentName("QA Automation");
                adSegmentManagerPage.ClickOnFilterVisibilityTab();
                adSegmentManagerPage.SelectDesiredVisibilityOption(3);
                adSegmentManagerPage.ClickOnFilterEligiblePartnerTab();
                adSegmentManagerPage.EnterPartnerCountMin("100");
                adSegmentManagerPage.EnterPartnerCountMax("300");
                adSegmentManagerPage.ClickOnFilterApplyButton();
                if (!adSegmentManagerPage.ValidateVisibilityOfFilterResult()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Filter result is not visible");
                    softAssert.fail("Filter result is not visible");
                }

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }



}
