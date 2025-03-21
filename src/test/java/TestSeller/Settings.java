package TestSeller;

import BaseSetup.BaseTest;
import PagesSeller.LMSPage;
import PagesSeller.PerformancePage;
import PagesSeller.SettingsPage;
import UtilityClass.Utils;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class Settings extends BaseTest {

    private PerformancePage performancePage;
    private SettingsPage settingsPage;
    private Utils utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        super.CheckingHyperUATToken();
        getDriver().get(HyperLocalSellerUrl);
        settingsPage = new SettingsPage(getDriver());
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


    //    @AfterClass(alwaysRun = true)
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("Seller Dashboard")
    @Story("This flow belongs Settings")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut = 1200000, description = "Test: Validate Settings Properties", priority = 0)
    public void ValidateSettingsProperties() {
//        utils.RetryOnFailHyperSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            Thread.sleep(1500);
            settingsPage.ClickOnSettingsIcon();
            settingsPage.ClickOnSettingsOption();
            settingsPage.ClickOnUserProfile();
            settingsPage.ClickOnUpdateName();
            settingsPage.ClickOnSubmitButton();
            if (!settingsPage.CheckUpdateNameFieldEmptyErrorPopUpIsDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Update Name Field Empty Error PopUp Not Displayed");
                softAssert.fail("Update Name Field Empty Error PopUp Not Displayed");
            }
            settingsPage.EnterNameInUpdateNameField("      ");
            settingsPage.ClickOnSubmitButton();
            if (settingsPage.IsUserNameTextFieldAcceptingEmptyInput()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Update Name Field Accepting Empty Input");
                softAssert.fail("Update Name Field Accepting Empty Input");
            }
            settingsPage.ClickOnUpdateName();
            settingsPage.EnterNameInUpdateNameField("YUVARAJ");
            settingsPage.ClickOnSubmitButton();
//            settingsPage.ClickOnUpdatePrimaryContact();
            Thread.sleep(3000);
            settingsPage.ClickOnUpdateEmailText();

            if (!settingsPage.IsErrorPopUpDisplayedWhenUpdatingEmailWithoutPhoneNumber()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error PopUp Not Displayed When Updating Email Without Phone Number");
                softAssert.fail("Error PopUp Not Displayed When Updating Email Without Phone Number");
            }
            settingsPage.ClickOnDealerDetails();

            settingsPage.EnterEmailIdInEmailField("  ");
            settingsPage.ClickOnSaveButton();
            if (!settingsPage.IsEmailIdEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Email Id Empty Error Message Not Displayed");
                softAssert.fail("Email Id Empty Error Message Not Displayed");
            }

            settingsPage.EnterEmailIdInEmailField(" akmdagmail.com");
            if (!settingsPage.IsEmailIdEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid Email Id Error Message Not Displayed");
                softAssert.fail("Invalid Email Id Error Message Not Displayed");
            }


            settingsPage.EnterEmailIdInEmailField("oemTest1@gmail.com");

            settingsPage.EnterDataInAddressField("");
            settingsPage.ClickOnSaveButton();
            if (!settingsPage.IsAddressFieldEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Address Field Empty Error Message Not Displayed");
                softAssert.fail("Address Field Empty Error Message Not Displayed");
            }


            settingsPage.EnterDataInAddressField("         ");
            settingsPage.ClickOnSaveButton();
            if (settingsPage.IsAddressFieldAcceptingEmptyInput()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Address Field Accepts Empty Input");
                softAssert.fail("Address Field Accepts Empty Input");

            }

            settingsPage.ClickOnAgentDetails();
            settingsPage.ClickOnAgentsAddButton();
            settingsPage.EnterDataInSalesAgentNameField(3, "Praveen Choudhary");
            settingsPage.EnterDataInSalesAgentPhoneNumberField(4, "9664328257");
            settingsPage.EnterDataInSalesAgentEmailField(5, "something1234@gmail.com");
            Thread.sleep(1500);
            settingsPage.ClickOnAgentSaveButton();
            if (!settingsPage.IsDuplicateAgentErrorPopUpDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Duplicate Agent Error PopUp Not Displayed");
                softAssert.fail("Duplicate Agent Error PopUp Not Displayed");
            }

            settingsPage.ClickOnSalesAgentDeleteIcon();
            settingsPage.ClickOnYesButton();
            settingsPage.EnterDataInSalesAgentNameField(1, "");
            settingsPage.EnterDataInSalesAgentPhoneNumberField(2, "");
            settingsPage.EnterDataInSalesAgentEmailField(3, "");
            settingsPage.ClickOnAgentSaveButton();

            if (!settingsPage.IsAgentNameEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Agent Name Empty Error Message Not Displayed");
                softAssert.fail("Agent Name Empty Error Message Not Displayed");
            }
            if (!settingsPage.IsAgentPhoneNumberEmptyErrorMessageDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Agent Phone Number Empty Error Message Not Displayed");
                softAssert.fail("Agent Phone Number Empty Error Message Not Displayed");
            }
            settingsPage.EnterDataInSalesAgentNameField(1, "Praveen Choudhary");
            settingsPage.EnterDataInSalesAgentPhoneNumberField(2, "9664328257");
            settingsPage.EnterDataInSalesAgentEmailField(3, "something1234@gmail.com");
            settingsPage.ClickOnAgentSaveButton();
            Thread.sleep(2000);
            settingsPage.ClickOnConfirmButton();
            if (!settingsPage.IsAgentDetailsSavedSuccessPopUpDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Agent Details Saved Success PopUp Not Displayed");
                softAssert.fail("Agent Details Saved Success PopUp Not Displayed");
            }
            settingsPage.EnterDataInSalesAgentEmailField(2, "");
            settingsPage.ClickOnAgentSaveButton();
            if (!settingsPage.IsEmailAddressCantRemoveErrorPopUpDisplayed()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Email Address Cant Remove Error PopUp Not Displayed");
                softAssert.fail("Email Address Cant Remove Error PopUp Not Displayed");
            }
            Thread.sleep(1500);
            settingsPage.EnterDataInSalesAgentEmailField(2, "something1234@gmail.com");
            settingsPage.ClickOnAgentSaveButton();

            Thread.sleep(2000);


            settingsPage.ClickOnAgentsAddButton();
            settingsPage.ClickOnAgentsAddButton();
            settingsPage.ClickOnAgentsAddButton();

            settingsPage.ClickOnAgentsAddButton();

            if (settingsPage.IsUserAbleToAddMoreThan5Agents()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User Able To Add More Than 5 Agents");
                softAssert.fail("User Able To Add More Than 5 Agents");
            }

            settingsPage.ClickOnBillingDetails();

            settingsPage.EnterDataInBillingEntryNameField("");
            settingsPage.EnterDataInBillingEmailField("");
            settingsPage.EnterDataInBillingGstNumberField("");

            settingsPage.ClickOnSaveButton();
            if(!settingsPage.IsBillingEntryNameEmptyErrorMessageDisplayed()){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Billing Entry Name Empty Error Message Not Displayed");
                softAssert.fail("Billing Entry Name Empty Error Message Not Displayed");
            }
            if(!settingsPage.IsBillingEmailEmptyErrorMessageDisplayed()){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Billing Email Empty Error Message Not Displayed");
                softAssert.fail("Billing Email Empty Error Message Not Displayed");
            }

            if(!settingsPage.IsBillingGSTNumberEmptyErrorMessageDisplayed()){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Billing Gst Number Empty Error Message Not Displayed");
                softAssert.fail("Billing Gst Number Empty Error Message Not Displayed");
            }


            settingsPage.EnterDataInBillingEntryNameField("     ");
            settingsPage.EnterDataInBillingEmailField("       ");
            settingsPage.EnterDataInBillingGstNumberField("     ");


            if(settingsPage.IsBillingNameFieldAcceptsEmptyInput()){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Billing Name Field Accepts Empty Input");
                softAssert.fail("Billing Name Field Accepts Empty Input");
            }

            if(settingsPage.IsBillingEmailFieldAcceptsEmptyInput()){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Billing Email Field Accepts Empty Input");
                softAssert.fail("Billing Email Field Accepts Empty Input");
            }

            if(settingsPage.IsBillingGSTNumberFieldAcceptsEmptyInput()){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Billing GST Number Field Accepts Empty Input");
                softAssert.fail("Billing GST Number Field Accepts Empty Input");
            }

            settingsPage.ClickOnSaveButton();








            settingsPage.EnterDataInBillingEntryNameField("tets");
            settingsPage.EnterDataInBillingEmailField("test@onlinesales.ai");
            settingsPage.EnterDataInBillingGstNumberField("29ABCDE1234F2Z5");
            settingsPage.ClickOnBillingTaxTypeDropDown();

//            settingsPage.EnterDataInBillingInvoiceTaxTypeSearchField("IGST");
            settingsPage.SelectOption(1);

            settingsPage.ClickOnSaveButton();

            if(!settingsPage.IsBillingDetailsSavedSuccessPopUpDisplayed()){
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Billing Details Saved Success PopUp Not Displayed");
                softAssert.fail("Billing Details Saved Success PopUp Not Displayed");
            }



        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
//        }));
    }

}
