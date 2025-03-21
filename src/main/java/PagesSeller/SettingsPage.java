package PagesSeller;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage {

    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    final By SettingsIcon = By.xpath("//a[contains(@class,'pendo_feature_header_nav settingsTitle')]");
    final By SettingsOption = By.xpath("//a[contains(@id,'header-menu-settings')]");
    final By UserProfile = By.xpath("//a[contains(@href,'SETTINGS_USER_PROFILE')]");
    final By UpdateName = By.xpath("//button[contains(@class,'pendo_feature_user_profile_update_name_link')]");
    final By UpdateNameField = By.xpath("//div[contains(@class,'input-wrapper')]/descendant::input");
    final By SubmitButton = By.xpath("//button[contains(@class,'pendo_feature_user_profile_update_name_submit')]");
    final By UpdateNameFieldEmptyErrorPopUp = By.xpath("//div[contains(@class,'os-toast-container')]");
    final By UserNameTextField = By.xpath("//div[contains(@class,'name-content')]/div[contains(@class,'non-edit-mode-text')]");
    final By UpdatePrimaryContact = By.xpath("//button[contains(@class,'pendo_feature_user_profile_update_mobile_link')]");
    final By UpdateEmailText = By.xpath("//button[contains(@class,'pendo_feature_user_profile_update_email_link')]/span");
    final By EmailErrorPopUp = By.xpath("//div[contains(@class,'os-toast-container')]");
    final By DealerDetails = By.xpath("//a[contains(@href,'SETTINGS_SELLER_PROFILE')]");
    final By EmailIdField = By.xpath("//div[contains(@class,'input-wrapper')]/descendant::input");
    final By EmailIdEmptyErrorMessage = By.xpath("//div[contains(@class,'input-wrapper')]/following-sibling::div[contains(@class,'error-msg name-error-message')]/div");
    final By SaveButton = By.xpath("//button[contains(@class,'pendo_feature_seller_details_save_btn')]");
    final By DisabledSaveButton = By.xpath("//button[contains(@class,'pendo_feature_seller_details_save_btn') and contains(@class,'disabled')]");
    final By AddressField = By.xpath("//div[contains(@class,'textarea-wrapper ')]/textarea");
    final By AddressFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'textarea-form-wrapper')]/following-sibling::div[contains(@class,'error-msg name-error-message')]");
    final By AgentDetails = By.xpath("//a[contains(@href,'SETTINGS_AGENT_DETAILS')]");
    final By AgentsAddButton = By.xpath("//button[contains(@class,'pendo_feature_agent_details_add_new_row')]/span");
    final String SalesAgentNameField = "(//div[contains(@class,'input-wrapper')]/descendant::input)[%d]";
    final String SalesAgentPhoneNumberField = "(//div[contains(@class,'input-wrapper')]/descendant::input)[%d]";
    final String SalesAgentEmailField = "(//div[contains(@class,'input-wrapper')]/descendant::input)[%d]";
    final By SalesAgentDeleteIcon = By.xpath("(//button[contains(@class,'pendo_feature_agent_details_remove_row')]/span)[1]");
    final By AgentSaveButton = By.xpath("//button[contains(@class,'pendo_feature_agent_details_cta')]/span");
    final By ConfirmButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]/span");
    final By YesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]/span");

    final By DisabledYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn') and contains(@class,'disabled')]");
    final By AgentDetailsSavedSuccessPopUp = By.xpath("//div[contains(@class,'toast-wrapper success-toast')]");

    final By AgentNameEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[1]");

    final By AgentPhoneNumberEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[2]");
    final By DuplicateAgentErrorPopUp = By.xpath("//div[contains(@class,'toast-wrapper error-toast')]/div");
    final By EmailAddressCantRemoveError = By.xpath("//div[contains(@class,'toast-wrapper error-toast')]/div");
    final By BillingDetailsText = By.xpath("//a[contains(@href,'SETTINGS_BILLING_DETAILS')]");
    final By BillingEntryNameField = By.xpath("(//div[contains(@class,'input-wrapper')]/descendant::input)[1]");
    final By BillingEmailField = By.xpath("(//div[contains(@class,'input-wrapper')]/descendant::input)[2]");
    final By BillingGstNumberField = By.xpath("(//div[contains(@class,'input-wrapper')]/descendant::input)[3]");
    final By BillingTaxTypeDropDown = By.xpath("(//div[contains(@class,'os-select-dropdown')]/div)[2]");
    final By BillingInvoiceTaxTypeSearchField = By.xpath("(//div[contains(@class,'os-select-dropdown')]/descendant::input)[2]");
    final String GenericOptionSelector = "(//div[contains(@id,'-option-')])[%d]";

    final By BillingEntryNameEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[1]");

    final By BillingEmailEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[2]");
    final By BillingGSTNumberEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[3]");
    final By BillingDetailsSavedSuccessPopUp = By.xpath("//div[contains(@class,'toast-wrapper success-toast')]/div");


    @Step("Click on Settings Icon")
    public void ClickOnSettingsIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SettingsIcon));
        driver.findElement(SettingsIcon).click();
    }


    @Step("Click on Settings Option")
    public void ClickOnSettingsOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SettingsOption));
        driver.findElement(SettingsOption).click();
    }


    @Step("Click on User Profile")
    public void ClickOnUserProfile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserProfile));
        driver.findElement(UserProfile).click();
    }


    @Step("Click on Update Name")
    public void ClickOnUpdateName() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdateName));
        driver.findElement(UpdateName).click();
    }


    @Step("Enter Name in Update Name Field")
    public void EnterNameInUpdateNameField(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UpdateNameField));
        driver.findElement(UpdateNameField).click();
        driver.findElement(UpdateNameField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(UpdateNameField).sendKeys(Name);
    }


    @Step("Click on Submit Button")
    public void ClickOnSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
        driver.findElement(SubmitButton).click();
    }


    @Step("Check Update Name Field Empty Error PopUp")
    public boolean CheckUpdateNameFieldEmptyErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(UpdateNameFieldEmptyErrorPopUp));
            return driver.findElement(UpdateNameFieldEmptyErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Is User Name Text Field is Accepting Empty Input")
    public boolean IsUserNameTextFieldAcceptingEmptyInput() {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameTextField));
        String UserName = driver.findElement(UserNameTextField).getText();
        return UserName.trim().isEmpty();

    }


    @Step("Click on Update Primary Contact")
    public void ClickOnUpdatePrimaryContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UpdatePrimaryContact));
        driver.findElement(UpdatePrimaryContact).click();
    }


    @Step("Click on Update Email Text")
    public void ClickOnUpdateEmailText() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdateEmailText));
        driver.findElement(UpdateEmailText).click();
    }


    @Step("Is Error Pop Up Displayed When Updating Email Without Phone Number")
    public boolean IsErrorPopUpDisplayedWhenUpdatingEmailWithoutPhoneNumber() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EmailErrorPopUp));
            return driver.findElement(EmailErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Dealer Details")
    public void ClickOnDealerDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(DealerDetails));
        driver.findElement(DealerDetails).click();
    }


    @Step("Enter Email Id in Email Field")
    public void EnterEmailIdInEmailField(String EmailId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailIdField));
        driver.findElement(EmailIdField).click();
        driver.findElement(EmailIdField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(EmailIdField).sendKeys(EmailId);
    }


    @Step("Check Email Id Empty Error Message Is Displayed")
    public boolean IsEmailIdEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EmailIdEmptyErrorMessage));
            return driver.findElement(EmailIdEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Save Button")
    public void ClickOnSaveButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        driver.findElement(SaveButton).click();
        ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledSaveButton));

    }


    @Step("Enter Data in Address Field")
    public void EnterDataInAddressField(String Address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddressField));
        driver.findElement(AddressField).click();
        driver.findElement(AddressField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(AddressField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(AddressField).sendKeys(Address);
    }


    @Step("Check Address Field Empty Error Message Is Displayed")
    public boolean IsAddressFieldEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddressFieldEmptyErrorMessage));
            return driver.findElement(AddressFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Address Field Accepting Empty Input")
    public boolean IsAddressFieldAcceptingEmptyInput() {
        String Address = driver.findElement(AddressField).getText();
        return Address.trim().isEmpty();
    }


    @Step("Click on Agent Details")
    public void ClickOnAgentDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(AgentDetails));
        driver.findElement(AgentDetails).click();
    }


    @Step("Click on Add Button in Agents")
    public void ClickOnAgentsAddButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(AgentsAddButton));
        driver.findElement(AgentsAddButton).click();
        Thread.sleep(1500);
    }


    @Step("Enter Data in Sales Agent Name Field")
    public void EnterDataInSalesAgentNameField(int Option, String Name) {

        By NameXpath = By.xpath(String.format(SalesAgentNameField, Option));
        wait.until(ExpectedConditions.elementToBeClickable(NameXpath));
        driver.findElement(NameXpath).click();
        driver.findElement(NameXpath).sendKeys(Keys.CONTROL + "a");
        driver.findElement(NameXpath).sendKeys(Keys.BACK_SPACE);
        driver.findElement(NameXpath).sendKeys(Name);
    }


    @Step("Enter Data in Sales Agent Phone Number Field")
    public void EnterDataInSalesAgentPhoneNumberField(int Option, String PhoneNumber) {

        By PhoneNumberXpath = By.xpath(String.format(SalesAgentPhoneNumberField, Option));
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberXpath));

        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberXpath));
        driver.findElement(PhoneNumberXpath).click();
        driver.findElement(PhoneNumberXpath).sendKeys(Keys.CONTROL + "a");
        driver.findElement(PhoneNumberXpath).sendKeys(Keys.BACK_SPACE);
        driver.findElement(PhoneNumberXpath).sendKeys(PhoneNumber);
    }


    @Step("Enter Data in Sales Agent Email Field")
    public void EnterDataInSalesAgentEmailField(int Option, String Email) {


        By EmailXpath = By.xpath(String.format(SalesAgentEmailField, Option));
        wait.until(ExpectedConditions.elementToBeClickable(EmailXpath));

        wait.until(ExpectedConditions.elementToBeClickable(EmailXpath));
        driver.findElement(EmailXpath).click();
        driver.findElement(EmailXpath).sendKeys(Keys.CONTROL + "a");
        driver.findElement(EmailXpath).sendKeys(Keys.BACK_SPACE);
        driver.findElement(EmailXpath).sendKeys(Email);
    }


    @Step("Click on Delete Icon in Sales Agent")
    public void ClickOnSalesAgentDeleteIcon() {
        driver.findElement(By.xpath("(//div[contains(@class,'input-wrapper')]/descendant::input)[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(SalesAgentDeleteIcon));
        driver.findElement(SalesAgentDeleteIcon).click();
    }


    @Step("Click on Save Button in Agents")
    public void ClickOnAgentSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AgentSaveButton));
        driver.findElement(AgentSaveButton).click();
    }


    @Step("Click on Confirm Button")
    public void ClickOnConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmButton));
        driver.findElement(ConfirmButton).click();
    }


    @Step("Click on Yes Button")
    public void ClickOnYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YesButton));
        driver.findElement(YesButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledYesButton));
    }


    @Step("Check Agent Details Saved Success PopUp Is Displayed")
    public boolean IsAgentDetailsSavedSuccessPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AgentDetailsSavedSuccessPopUp));
            return driver.findElement(AgentDetailsSavedSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Check Agent Name Empty Error Message Is Displayed")
    public boolean IsAgentNameEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AgentNameEmptyErrorMessage));
            return driver.findElement(AgentNameEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Check Agent Phone Number Empty Error Message Is Displayed")
    public boolean IsAgentPhoneNumberEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AgentPhoneNumberEmptyErrorMessage));
            return driver.findElement(AgentPhoneNumberEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Check Duplicate Agent Error PopUp Is Displayed")
    public boolean IsDuplicateAgentErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DuplicateAgentErrorPopUp));
            return driver.findElement(DuplicateAgentErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Check Email Address Cant Remove Error PopUp Is Displayed")
    public boolean IsEmailAddressCantRemoveErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAddressCantRemoveError));
            return driver.findElement(EmailAddressCantRemoveError).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Check Is User Able Add More Than 5 Agents")
    public boolean IsUserAbleToAddMoreThan5Agents() {
        try {
            Thread.sleep(2000);
            return driver.findElement(AgentsAddButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException | InterruptedException e) {
            return false;
        }
    }


    @Step("Click on Billing Details")
    public void ClickOnBillingDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(BillingDetailsText));
        driver.findElement(BillingDetailsText).click();
    }


    @Step("Enter Data in Billing Entry Name Field")
    public void EnterDataInBillingEntryNameField(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BillingEntryNameField));
        driver.findElement(BillingEntryNameField).click();
        driver.findElement(BillingEntryNameField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(BillingEntryNameField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(BillingEntryNameField).sendKeys(Name);
    }


    @Step("Enter Data in Billing Email Field")
    public void EnterDataInBillingEmailField(String Email) {
        wait.until(ExpectedConditions.elementToBeClickable(BillingEmailField));
        driver.findElement(BillingEmailField).click();
        driver.findElement(BillingEmailField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(BillingEmailField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(BillingEmailField).sendKeys(Email);
    }

    @Step("Enter Data in Billing GST Number Field")
    public void EnterDataInBillingGstNumberField(String GstNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BillingGstNumberField));
        driver.findElement(BillingGstNumberField).click();
        driver.findElement(BillingGstNumberField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(BillingGstNumberField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(BillingGstNumberField).sendKeys(GstNumber);
    }


    @Step("Click on Billing Tax Type DropDown")
    public void ClickOnBillingTaxTypeDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(BillingTaxTypeDropDown));
        driver.findElement(BillingTaxTypeDropDown).click();
    }


    @Step("Enter Data in Billing Invoice Tax Type Search Field")
    public void EnterDataInBillingInvoiceTaxTypeSearchField(String TaxType) {
        wait.until(ExpectedConditions.elementToBeClickable(BillingInvoiceTaxTypeSearchField));
        driver.findElement(BillingInvoiceTaxTypeSearchField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(TaxType);
    }

    @Step("Selecting Option GST Type Drop Down")
    public void SelectOption(int Option) {
        By OptionSelector = By.xpath(String.format(GenericOptionSelector, Option));
        wait.until(ExpectedConditions.elementToBeClickable(OptionSelector)).click();
    }


    @Step("Check Billing Entry Name Empty Error Message Is Displayed")
    public boolean IsBillingEntryNameEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BillingEntryNameEmptyErrorMessage));
            return driver.findElement(BillingEntryNameEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Check Billing Email Empty Error Message Is Displayed")

    public boolean IsBillingEmailEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BillingEmailEmptyErrorMessage));
            return driver.findElement(BillingEmailEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Check Billing GST Number Empty Error Message Is Displayed")
    public boolean IsBillingGSTNumberEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BillingGSTNumberEmptyErrorMessage));
            return driver.findElement(BillingGSTNumberEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Is Billing Name Field Accepts Empty Input")
    public boolean IsBillingNameFieldAcceptsEmptyInput() {
        String Name = driver.findElement(BillingEntryNameField).getDomAttribute("value");
        return Name.trim().isEmpty();
    }


    @Step("Is Billing Email Field Accepts Empty Input")
    public boolean IsBillingEmailFieldAcceptsEmptyInput() {
        String Email = driver.findElement(BillingEmailField).getDomAttribute("value");
        return Email.trim().isEmpty();
    }

    @Step("Is Billing GST Number Field Accepts Empty Input")
    public boolean IsBillingGSTNumberFieldAcceptsEmptyInput() {
        String GSTNumber = driver.findElement(BillingGstNumberField).getDomAttribute("value");
        return GSTNumber.trim().isEmpty();
    }


    @Step("Check Billing Details Saved Success PopUp Is Displayed")
    public boolean IsBillingDetailsSavedSuccessPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BillingDetailsSavedSuccessPopUp));
            return driver.findElement(BillingDetailsSavedSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}