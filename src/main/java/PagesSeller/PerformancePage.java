package PagesSeller;

import UtilityClass.Utils;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PerformancePage {

    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By ButtonSpinner = By.xpath("//i[contains(@class,'icon-spinner')]");

    final By ClientList = By.xpath("//div[contains(@class,'pendo-track_client-list')]");
    final String ClientOptions = ("(//div[contains(@class,'pendo-track_client-list')]/descendant::div[contains(@class,'option')])[%d]");
    final By AnnouncementCloseButton = By.xpath("//div[contains(@class,'announcement-widget-wrapper open')]/descendant::span[contains(@class,'close')]");
    final By CreateNewCampaignButton = By.xpath("//button[contains(@class,'pendo_feature_campaign_card_create_new_button')]");
    final By CampaignNameField = By.xpath("//div[contains(@class,'pendo-track_campaignName')]/input");
    final By GoogleRadioButton = By.xpath("//div[contains(@class,'pendo-track_channel-selection')]/descendant::input[contains(@id,'google')]");
    final By AverageDailyBudget = By.xpath("//div[contains(@class,'pendo-track_daily-budget')]/descendant::span[contains(@class,'input')]");
    final By BudgetSettingsNextButton = By.xpath("//button[contains(@class,'pendo_feature_budget_settings')]");
    final By ChooseFromAdsLibraryButton = By.xpath("//button[contains(@class,'pendo_new_choose_library_btn')] | //button[contains(@class,'pendo_new_ads_choose_library')]");
    final By ChooseMoreFromAdsLibraryButton = By.xpath("//button[contains(@class,'pendo_new_ads_choose_library')]");
    final String GoogleTemplateOptions = ("(//div[contains(@class,'checkbox-wrapper')]/input)[%d]");
    final By AdSelectionSaveButton = By.xpath("//button[contains(@class,'pendo-track_ads-selection-btn')]");
    final By AdSaveButton = By.xpath("//button[contains(@class,'pendo-track_partner_ads')]");
    final By LaunchButton = By.xpath("//button[contains(@class,'pendo-track_goal-review-launch-btn')]");
    final By FirstRowCampaignName = By.xpath("(//div[contains(@class,'first-row')]/descendant::div[contains(@class,'candy-title-name')])[1]");
    final By SuccessToast = By.xpath("//div[contains(@class,'os-toast-message')]");
    final By CreateNewAdButton = By.xpath("//button[contains(@class,'pendo_new_create_new btn')]/span");
    final By CreativeName = By.xpath("//div[contains(@class,'pendo-track_creative-name')]/input");
    final By CreativeTypeDropDown = By.xpath("//div[contains(@class,'pendo-track_creative-sub-type-selection')]");
    final By CreativeTypeOption = By.xpath("(//div[contains(@class,'Select__option')])[1]");
    final By CampaignForDropdown = By.xpath("(//div[contains(@class,'Select__single-value')])[5]");
    final String CampaignForOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By ThisTemplateForDropdown = By.xpath("//div[contains(@class,'Select__placeholder') and contains(text(),'SKU')]");
    final String ThisTemplateForDropdownOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By CountryCodeField = By.xpath("//div[contains(@class,'pendo-track_google-country-code-input')]/input");
    final String CountryCodeDynamicOptions = ("(//ul[contains(@class,'options-list')]/li)[%d]");
    final By PhoneNumberField = By.xpath("(//div[contains(@class,'input-wrapper')])[6]");
    final String PhoneNumberDynamicOptions = ("((//ul[contains(@class,'options-list')])[2]/li)[%d]");
    final By PhoneNumberVerificationUrlField = By.xpath("(//div[contains(@class,'input-wrapper')])[8]");
    final By WebsiteUrlField = By.xpath("//div[contains(@class,'pendo-track_google-website-url-input')]/input");
    final String PhoneNumberVerificationUrlDynamicOptions = ("((//ul[contains(@class,'options-list')])[3]/li)[%d]");
    final By BusinessNameField = By.xpath("//div[contains(@class,'pendo-track_google-business-name-input')]/input");
    final String BusinessNameDynamicOptions = ("((//ul[contains(@class,'options-list')])[4]/li)[%d]");
    final String Description1DynamicOption = ("((//ul[contains(@class,'options-list')])[5]/li)[%d]");
    final String Description2DynamicOption = ("((//ul[contains(@class,'options-list')])[6]/li)[%d]");
    final String WebsiteUrlDynamicOption = ("((//ul[contains(@class,'options-list')])[7]/li)[%d]");
    final By Description1Field = By.xpath("//div[contains(@class,'pendo-track_google-google-description1-input')]");
    final String Description1DynamicOptions = ("((//ul[contains(@class,'options-list')])[6]/li)[%d]");
    final By Description2Field = By.xpath("//div[contains(@class,'pendo-track_google-google-description2-input')]");
    final String Description2DynamicOptions = ("((//ul[contains(@class,'options-list')])[7]/li)[%d]");
    final By DomainField = By.xpath("//div[contains(@class,'pendo-track_google-domain-url-input')]/input");
    final By CreateButton = By.xpath("//div[contains(@class,'fixed-layout-footer')]/descendant::span[contains(text(),'Create')]");
    final String DomainDynamicOption = ("((//ul[contains(@class,'options-list')])[8]/li)[%d]");
    final By ConfirmationYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]/span");

    final By StartDateField = By.xpath("(//div[contains(@class,'date-picker-wrapper')]/descendant::img[contains(@class,'datepicker-icon')])[1]");
    final By EndDateField = By.xpath("(//div[contains(@class,'date-picker-wrapper')]/descendant::img[contains(@class,'datepicker-icon')])[2]");
    final By FixScheduleRadioRapper = By.xpath("(//div[contains(@class,'campaign-type-radio-group')]/descendant::div[contains(@class,'radio-wrapper')])[2]");
    final By MonthDropdown = By.xpath("//div[contains(@class,'select-dropdown os-mr month-dropdown')]");
    final By YearDropdown = By.xpath("(//div[contains(@class,'month-year-wrapper')]/descendant::div[contains(@class,'select-dropdown')])[2]");
    final By ErrorMessageForCampaignName = By.xpath("//div[contains(@class,'pendo-track_campaignName')]/following-sibling::div[contains(@class,'error-msg')]/div");
    final By ErrorMessageForAverageDailyBudget = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[4]");
    final By ErrorMessageForLifeTimeBudget = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[5]");
    final By LifeTimeBudgetField = By.xpath("//div[contains(@class,'maximum-spend-cap')]/descendant::span[contains(@class,'input')]");
    final By EndDateErrorMessage = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[7]");
    final By BudgetSettingsTab = By.xpath("//a[contains(@role,'tab') and contains(@data-rb-event-key,'GOAL_DEFINITION')]/descendant::div");
    final By ErrorMessage = By.xpath("//div[contains(@class,'os-toast-message')]");
    final By CreativeNameErrorMessage = By.xpath("//div[contains(@class,'pendo-track_creative-name')]/following-sibling::div[contains(@class,'error-msg')]/div");
    final By SKUSelectionErrorMessage = By.xpath("//div[contains(@class,'pendo-track-sku-selction-template')]/following-sibling::div[contains(@class,'error-msg')]/div");
    final By CountryCodeErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-country-code-input')]/parent::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final By PhoneNumberErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-phone-number-input')]/parent::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final By PhoneNumberVerificationUrlErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-phone-number-verification-url-input')]/parent::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final By BusinessNameErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-business-name-input')]/parent::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final By Description1ErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-google-description1-input')]/ancestor::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final By Description2ErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-google-description2-input')]/ancestor::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final By WebsiteUrlErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-website-url-input')]/parent::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final By DomainErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-domain-url-input')]/parent::div/following-sibling::div[contains(@class,'error-msg')]/div");

    final By FinalUrl = By.xpath("//div[contains(@class,'pendo-track_google-website-url-input')]");
    final By FinalUrlFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-website-url-input')]/ancestor::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final String FinalUrlOptions = ("(//ul[contains(@class,'options-list')]/li)[%d]");
    final By CreateNewTopButton = By.xpath("(//div[contains(@class,'oem-ads-heading-block')]/descendant::button)[1]");
    final By GoogleDisplayUrlField = By.xpath("//div[contains(@class,'pendo-track_google-domain-url-input')]");
    final By GoogleDisplayUrlFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-track_google-domain-url-input')]/ancestor::div/following-sibling::div[contains(@class,'error-msg')]/div");
    final String DisplayUrlOptions = ("(//ul[contains(@class,'options-list')]/li)[%d]");

    final By CreativeNameFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-template-name')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By LeadFormSelectionEmptyErrorMessage = By.xpath("//div[contains(@class,'form-leadselection-block')]/descendant::div[contains(@class,'error-msg name-error-message')]/div");
    final By ThisTemplateIsForEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-this-template-is-for')]/descendant::div[contains(@class,'name-error-message')] | //div[contains(@class,'pendo-track-sku-selction-template')]/following-sibling::div[contains(@class,'error-msg name-error-message')]/div");
    final By MainBodyTextEmptyErrorMessage = By.xpath("(//div[contains(@class,'textarea-form-group-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[1]");
    final By HeadlineEmptyErrorMessage = By.xpath("(//div[contains(@class,'third-row')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[1]");
    final By MediaEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-choose-image')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)[1]");
    final By SelectCallToActionEmptyErrorMessage = By.xpath("(//div[contains(@class,'creative-footer')]/descendant::div[contains(@class,'error-msg name-error-message')]/div)");
    final By AdEmptyTemplateErrorPopUp = By.xpath("//div[contains(@class,'toast-wrapper error-toast')]/div");
    final By CreativeAdCard = By.xpath("(//div[contains(@class,'ads-view-title-block')])[2]");
    final By FilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_pill_filter_submit_button')]");
    final By FilterValueSearchField = By.xpath("//div[contains(@class,'form-component-wrapper')]/descendant::input");
    final By FilterConditionSearchField = By.xpath("//div[contains(@class,'dropdown-menu ')]/descendant::input");
    final By FilterConditionFieldDropDown = By.xpath("//div[contains(@class,'condition-dropdowns')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final By AdTypeDropDownField = By.xpath("//div[contains(@class,'action-dropdown')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final By AddFilterButton = By.xpath("//button[contains(@class,'pendo_feature_filter_pill_add_button')]");
    final By AdFormatCreateNewButton = By.xpath("//button[contains(@class,'pendo_new_create_new')]");
    final By CreativeNameField = By.xpath("//div[contains(@class,'pendo-track_creative-name')]/descendant::input | //div[contains(@class,'pendo-event-tracker-common-form-component-ad-template-name')]/descendant::input");
    final By SelectCreativeField = By.xpath("//div[contains(@class,'pendo-track_creative-sub-type-selection')]/descendant::div[contains(@class,'Select__value-container')]");
    final By LeadFormSelectionField = By.xpath("//div[contains(@class,'form-leadselection-block')]/descendant::div[contains(@class,'Select__value-container')]");
    final By ThisTemplateForField = By.xpath("(//div[contains(@class,'pendo-track-sku-selction-template')]/descendant::div[contains(@class,'Select__value-container')]) |  //div[contains(text(),'Select Template For')]");
    final By MainBodyTextField = By.xpath("(//div[contains(@class,'form-component-textarea')]/descendant::textarea)[1]");
    final String HeadLineField = "(//label[contains(text(),'Headline')]/parent::div/following-sibling::div/descendant::input[contains(@adsubtype,'AD')])[%d]";
    final String DescriptionTextField = "(//label[contains(text(),'Description')]/parent::div/following-sibling::div/descendant::textarea)[%d]";
    final By MediaTypeField = By.xpath("//div[contains(@class,'formwrapper-mediatype')]/descendant::div[contains(@class,'Select__value-container')]");
    final By SelectCallToActionField = By.xpath("(//div[contains(@class,'form-component-dropdown')]/descendant::div[contains(@class,'Select__value-container')])[6] | //label[contains(text(),'Select Call to Action')]/parent::div/following-sibling::div");
    final String DynamicAttributeSearchField = "(//div[contains(@class,'textarea-form-group-wrapper')]/descendant::input)[%d]";
    final String DynamicPropertyOptions = "(//ul[contains(@class,'options-list')]/li)[%d]";
    final String GenericOptionsSelector = "(//div[contains(@class,'option')])[%d]";
    final String ChooseImageField = "(//div[contains(@class,'creative-image-wrapper')])[%d]";
    final By ImageSelector = By.xpath("(//div[contains(@class,'media-item not-selected')]/div)[1]");
    final By SelectedImageSaveButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/button)[3]");
    final By FaceBookCarouselSection = By.xpath("//a[contains(@class,'pendo_new_FACEBOOK_MPA')]");
    final By DestinationUrlField = By.xpath("(//div[contains(@class,'formwrapper-destinationurl')]/descendant::input)[2]");
    final By TemplateForField = By.xpath(" //label[text()='Template For']/parent::div/following-sibling::div/descendant::div[contains(@class,'Select__value-container')]");
    final String CarouselSelector = "(//div[contains(@class,'creative-tab-list')])[%d]";
    final By AddCarouselButton = By.xpath("//div[contains(@class,'creative-addnew')]");
    final String DeleteCarouselButton = "(//div[contains(@class,'delete-link')])[%d]";
    String PageCloseButton = "(//label[contains(@class,'pure-toggle-label icon icon-close1')])[%d]";
    final By Headline1Field = By.xpath("(//div[contains(@class,'dynamic-field-wrapper')])[3]");
    final By Headline1FieldErrorMessage = By.xpath("(//div[contains(@class,'dynamic-field-wrapper')])[3]/following-sibling::div[contains(@class,'error-msg')]/div");
    final By Headline2FieldErrorMessage = By.xpath("(//div[contains(@class,'dynamic-field-wrapper')])[4]/following-sibling::div[contains(@class,'error-msg')]/div");
    final By Headline3FieldErrorMessage = By.xpath("(//div[contains(@class,'dynamic-field-wrapper')])[5]/following-sibling::div[contains(@class,'error-msg')]/div");
    final String HeadLine1DynamicOptions = ("((//ul[contains(@class,'options-list')])[3]/li)[%d]");
    final By Headline2Field = By.xpath("(//div[contains(@class,'dynamic-field-wrapper')])[4]");
    final String HeadLine2DynamicOptions = ("((//ul[contains(@class,'options-list')])[4]/li)[%d]");
    final By Headline3Field = By.xpath("(//div[contains(@class,'dynamic-field-wrapper')])[5]");
    final String HeadLine3DynamicOptions = ("((//ul[contains(@class,'options-list')])[5]/li)[%d]");


    final By TempCreateNewAdButton = By.xpath("//span[contains(text(),'+ Create New')]");
    final By CampaignNameEmptyErrorMessage = By.xpath("(//div[contains(@class,'show-error-form')]/descendant::div[contains(@class,'name-error-message')])[1]");
    final By AverageDailyBudgetEmptyErrorMessage = By.xpath("(//div[contains(@class,'show-error-form')]/descendant::div[contains(@class,'name-error-message')])[2]");
    final By DisabledCreateButton = By.xpath("//button[@class='btn os-button  btn-primary shape-cornor medium disabled    ']");
    final By FilterValueFieldDropDown = By.xpath("//div[contains(@class,'pendo-track-filter-fincane-operator-toggle-multi-dropdown')]/descendant::button");


    //Global Variables
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    public static int RetryListener = 0;


    @Step("Selecting desired Client")
    public void SelectingClient(String ClientName, int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientList));
        driver.findElement(ClientList).click();
        driver.switchTo().activeElement().sendKeys(ClientName);
        String XpathFormatted = String.format(ClientOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Clicking on Close button of Announcement carousel if available")
    public void CloseAnnouncementCloseButtonIfAvailable() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AnnouncementCloseButton));
            driver.findElement(AnnouncementCloseButton).click();
        } catch (Exception e) {
            System.out.println("Close button not found or not visible. Skipping the click action.");
        }
    }

    @Step("Clicking on Create Campaign button")
    public void ClickOnCreateCampaignButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CreateNewCampaignButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(CreateNewCampaignButton));
        js.executeScript("arguments[0].click();", driver.findElement(CreateNewCampaignButton));
    }

    public static String RandomCampaignName;

    @Step("Entering Campaign Name")
    public void EnterCampaignName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        RandomCampaignName = "Test Campaign " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(RandomCampaignName);
    }

    @Step("EnteringCampaign Name")
    public void EnterDesiredCampaignName(String CampaignName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(CampaignName);
    }

    @Step("Selecting Google as Channel")
    public void SelectGoogleChannel() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GoogleRadioButton));
        driver.findElement(GoogleRadioButton).click();
    }

    @Step("Entering Average Daily Budget")
    public void EnterAverageDailyBudget(String Budget) {
        wait.until(ExpectedConditions.presenceOfElementLocated(AverageDailyBudget));
        driver.findElement(AverageDailyBudget).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Budget);

    }

    @Step("Entering Life time Budget")
    public void EnterLifeTimeBudget(String Budget) {
        wait.until(ExpectedConditions.presenceOfElementLocated(LifeTimeBudgetField));
        driver.findElement(LifeTimeBudgetField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Budget);

    }

    @Step("Clicking on Next button of Budget Settings")
    public void ClickOnBudgetSettingsNextButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BudgetSettingsNextButton));
        driver.findElement(BudgetSettingsNextButton).click();
    }

    @Step("Clicking on Choose from Ads Library button")
    public void ClickOnChooseFromAdsLibraryButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledCreateButton));
        wait.until(ExpectedConditions.presenceOfElementLocated(ChooseFromAdsLibraryButton));
        driver.findElement(ChooseFromAdsLibraryButton).click();
    }

    @Step("Selecting desired Google Template")
    public void SelectGoogleTemplate(int option) {
        String XpathFormatted = String.format(GoogleTemplateOptions, option);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Clicking on Save button after selecting Ad")
    public void ClickOnSaveButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AdSelectionSaveButton));
        driver.findElement(AdSelectionSaveButton).click();
    }

    @Step("Clicking on Save button after selecting Ad")
    public void ClickOnAdSaveButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AdSaveButton));
        driver.findElement(AdSaveButton).click();
    }

    @Step("Clicking Launch Button")
    public void ClickOnLaunchButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LaunchButton));
        driver.findElement(LaunchButton).click();
    }

    @Step("Validate Campaign Creation")
    public boolean ValidateCampaignCreation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessToast));
        return driver.findElement(SuccessToast).isDisplayed();
    }

    @Step("Validate Campaign Creation")
    public boolean ValidateCampaignCreation(String Created_Campaign_Name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(FirstRowCampaignName));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(FirstRowCampaignName));
        String CampaignName = driver.findElement(FirstRowCampaignName).getText();
        return CampaignName.equals(Created_Campaign_Name);
    }

    @Step("Clicking on Create New Ad button")
    public void ClickOnCreateNewAdButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CreateNewAdButton));
        driver.findElement(CreateNewAdButton).click();
    }

    @Step("Temporary")
    public void ClickOnCreateNewAdButtonTemp() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TempCreateNewAdButton));
        driver.findElement(TempCreateNewAdButton).click();
    }


    @Step("Entering Creative Name")
    public void EnterCreativeName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeName));
        driver.findElement(CreativeName).click();
        String RandomCreativeName = "Creative " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(RandomCreativeName);
    }

    @Step("Entering Creative Name")
    public void EnterDesiredCreativeName(String creativeName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeName));
        driver.findElement(CreativeName).click();
        driver.switchTo().activeElement().sendKeys(creativeName);
    }

    @Step("Selecting Creative Type")
    public void SelectCreativeType(String CreativeType) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(CreativeName)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeTypeDropDown));
        driver.findElement(CreativeTypeDropDown).click();
        driver.switchTo().activeElement().sendKeys(CreativeType);
        driver.findElement(CreativeTypeOption).click();
    }

    @Step("Selecting Campaign For")
    public void SelectCampaignFor(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignForDropdown));
        driver.findElement(CampaignForDropdown).click();
        String XpathFormatted = String.format(CampaignForOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Selecting This Template For")
    public void SelectThisTemplateFor(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ThisTemplateForDropdown));
        driver.findElement(ThisTemplateForDropdown).click();
        String XpathFormatted = String.format(ThisTemplateForDropdownOptions, option);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(XpathFormatted)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Selecting Country Code")
    public void SelectCountryCodeDynamically(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CountryCodeField));
        driver.findElement(CountryCodeField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(CountryCodeDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Selecting Country Code")
    public void EnterDesiredValueInCountryCodeField(String CountryCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CountryCodeField));
        driver.findElement(CountryCodeField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(CountryCode);
    }


    @Step("Clicking on close button of page level {level}")
    public void CloseDesiredPage(int level) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(PageCloseButton, level))));
        driver.findElement(By.xpath(String.format(PageCloseButton, level))).click();
    }

    @Step("Enter  phone number dynamically ")
    public void EnterPhoneNumberDynamically(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberField));
        driver.findElement(PhoneNumberField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(PhoneNumberDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired phone number")
    public void EnterDesiredPhoneNumber(String PhoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberField));
        driver.findElement(PhoneNumberField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(PhoneNumber);

    }

    @Step("Enter desired phone number verification Url")
    public void EnterPhoneNumberVerificationUrlDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberVerificationUrlField));
        driver.findElement(PhoneNumberVerificationUrlField).click();
        WebElement element = driver.findElement(BusinessNameField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.switchTo().activeElement().sendKeys("^");
        Thread.sleep(800);
        String XpathFormatted = String.format(PhoneNumberVerificationUrlDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired phone number verification Url")
    public void EnterDesiredPhoneNumberVerificationUrl(String Url) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(PhoneNumberVerificationUrlField));
        driver.findElement(PhoneNumberVerificationUrlField).click();
        WebElement element = driver.findElement(BusinessNameField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Url);
    }

    @Step("Enter Business name Dynamically")
    public void EnterBusinessNameDynamically(int option) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(BusinessNameField));
        WebElement element = driver.findElement(Description1Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(1000);
        driver.findElement(BusinessNameField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(BusinessNameDynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired Business name")
    public void EnterDesiredBusinessName(String BusinessName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(BusinessNameField));
        WebElement element = driver.findElement(Description1Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(1000);
        driver.findElement(BusinessNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(BusinessName);
    }

    @Step("Enter text in first description field dynamically")
    public void EnterDescription1(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description1Field));
        WebElement element = driver.findElement(Description2Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description1Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Description1DynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter text in first description field")
    public void EnterDesiredDescription1(String Description1) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description1Field));
        WebElement element = driver.findElement(Description2Field);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description1Field).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Description1);

    }

    @Step("Enter text in Second description field dynamically")
    public void EnterDescription2(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description2Field));
        WebElement element = driver.findElement(WebsiteUrlField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description2Field).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Description2DynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter text in Second description field")
    public void EnterDesiredDescription2(String Description2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Description2Field));
        WebElement element = driver.findElement(WebsiteUrlField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(Description2Field).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Description2);

    }

    @Step("Enter Website Url Dynamically")
    public void EnterWebsiteUrlDynamically(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WebsiteUrlField));
        WebElement element = driver.findElement(DomainField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(WebsiteUrlField).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(WebsiteUrlDynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
    }

    @Step("Enter Website Url")
    public void EnterDesiredWebsiteUrl(String WebsiteUrl) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WebsiteUrlField));
        WebElement element = driver.findElement(DomainField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(WebsiteUrlField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(WebsiteUrl);

    }

    @Step("Enter Domain Dynamically")
    public void EnterDomainDynamically(int option) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(DomainField));
        driver.findElement(DomainField).click();
        driver.switchTo().activeElement().sendKeys("^");
        Thread.sleep(500);
        String XpathFormatted = String.format(DomainDynamicOption, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        WebElement element = driver.findElement(By.xpath(XpathFormatted));
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Enter Desired Domain ")
    public void EnterDesiredDomain(String DomainName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DomainField));
        driver.findElement(DomainField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(DomainName);
    }

    @Step("Click on Create Ad button")
    public void ClickOnCreateButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateButton));
        driver.findElement(CreateButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ButtonSpinner));
    }

    @Step("Clicking on Choose from Ads Library button")
    public void ClickOnChooseMoreFromAdsLibraryButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ChooseMoreFromAdsLibraryButton));
        driver.findElement(ChooseMoreFromAdsLibraryButton).click();
    }


    @Step("Clicking on start date field")
    public void ClickOnStartDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(StartDateField));
        driver.findElement(StartDateField).click();
    }

    @Step("Clicking on End date field")
    public void ClickOnEndDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(EndDateField));
        driver.findElement(EndDateField).click();
    }


    @Step("Selecting Start Date ")
    public void DateSelector(String month, String year, String date) {
        wait.until(ExpectedConditions.elementToBeClickable(MonthDropdown));
        driver.findElement(MonthDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select') and contains(text(),'" + month + "')]")));
        driver.findElement(By.xpath("//div[contains(@id,'react-select') and contains(text(),'" + month + "')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(YearDropdown));
        driver.findElement(YearDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Select__option') and contains(text(),'" + year + "')]")));
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'Select__option') and contains(text(),'" + year + "')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0" + date + "') and not(contains(@class,'outside-month'))]")));
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0" + date + "') and not(contains(@class,'outside-month'))]")).click();
    }

    @Step("Selecting Fix Schedule")
    public void SelectFixSchedule() {
        wait.until(ExpectedConditions.elementToBeClickable(FixScheduleRadioRapper));
        driver.findElement(FixScheduleRadioRapper).click();
    }

    @Step("Validating Error Message for Campaign Name")
    public boolean ValidateErrorMessageForCampaignName() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForCampaignName));
            return driver.findElement(ErrorMessageForCampaignName).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Average Daily  budget field")
    public boolean ValidateErrorMessageForAverageDailyBudgetField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForAverageDailyBudget));
            return driver.findElement(ErrorMessageForAverageDailyBudget).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Life time budget field")
    public boolean ValidateErrorMessageForLifeTimeBudgetField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForLifeTimeBudget));
            return driver.findElement(ErrorMessageForLifeTimeBudget).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for End date field")
    public boolean ValidateErrorMessageEndDateField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EndDateErrorMessage));
            return driver.findElement(EndDateErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Budget Settings Tab")
    public void ClickOnBudgetSettingsTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BudgetSettingsTab));
        driver.findElement(BudgetSettingsTab).click();
    }

    @Step("Validate Error Message")
    public boolean ValidateErrorMessage() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(ErrorMessage));
            return driver.findElement(ErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Creative Name")
    public boolean ValidateErrorMessageForCreativeName() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(CreativeNameErrorMessage));
            return driver.findElement(CreativeNameErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating maximum character limit for Creative Name")
    public boolean ValidateCreativeNameMaxCharLimit() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(CreativeNameField));
            driver.findElement(CreativeNameField).click();
            String nameValue = driver.switchTo().activeElement().getAttribute("value");
            System.out.println(nameValue);
            return nameValue.length() > 90;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for SKU Selection Field")
    public boolean ValidateErrorMessageForSKUSelection() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SKUSelectionErrorMessage));
            return driver.findElement(SKUSelectionErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for CountryCode")
    public boolean ValidateErrorMessageForCountryCodeField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(CountryCodeErrorMessage));
            return driver.findElement(CountryCodeErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Phone Number field")
    public boolean ValidateErrorMessageForPhoneNumberField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(PhoneNumberErrorMessage));
            return driver.findElement(PhoneNumberErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Phone Number Verification Url Field")
    public boolean ValidateErrorMessageForPhoneNumberVerificationUrlField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(PhoneNumberVerificationUrlErrorMessage));
            return driver.findElement(PhoneNumberVerificationUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Business Name field")
    public boolean ValidateErrorMessageForBusinessNameField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(BusinessNameErrorMessage));
            return driver.findElement(BusinessNameErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for description1 Field ")
    public boolean ValidateErrorMessageForDescription1Field() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(Description1ErrorMessage));
            return driver.findElement(Description1ErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for description2 Field ")
    public boolean ValidateErrorMessageForDescription2Field() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(Description2ErrorMessage));
            return driver.findElement(Description2ErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Website Url field ")
    public boolean ValidateErrorMessageForWebsiteUrlField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(WebsiteUrlErrorMessage));
            return driver.findElement(WebsiteUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for domain field")
    public boolean ValidateErrorMessageForDomainField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(DomainErrorMessage));
            return driver.findElement(DomainErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Adding final Url")
    public void AddFinalUrlDynamically(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(FinalUrl)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(FinalUrlOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Adding desired final Url")
    public void AddDesiredFinalUrl(String final_url) {
        wait.until(ExpectedConditions.elementToBeClickable(FinalUrl)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(final_url);

    }

    @Step("Adding Google Display Url")
    public void EnterGoogleDisplayURlDynamically(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(GoogleDisplayUrlField)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(DisplayUrlOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Adding desired Google Display Url")
    public void EnterDesiredGoogleDisplayURl(String DisplayUrl) {
        wait.until(ExpectedConditions.elementToBeClickable(GoogleDisplayUrlField)).click();
        driver.switchTo().activeElement().sendKeys(DisplayUrl);
    }

    @Step("Enter HeadLine1 Dynamically")
    public void AddHeadline1Dynamically(int option) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Headline3Field)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Headline1Field)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(HeadLine1DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired HeadLine1 ")
    public void AddDesiredHeadline1(String Headline1) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Headline3Field)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Headline1Field)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Headline1);
    }

    @Step("Enter HeadLine2 Dynamically")
    public void AddHeadline2Dynamically(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(Headline2Field)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(HeadLine2DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired HeadLine2 ")
    public void AddDesiredHeadline2(String Headline1) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Headline3Field)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Headline2Field)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Headline1);
    }

    @Step("Enter HeadLine3 Dynamically")
    public void AddHeadline3Dynamically(int option) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Description1Field)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Headline3Field)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(HeadLine3DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired HeadLine3")
    public void AddDesiredHeadline3(String Headline1) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Headline3Field)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Headline3Field)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Headline1);
    }

    @Step("Enter Description1 Dynamically")
    public void AddDescription1Dynamically(int option) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(Description2Field));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Description2Field)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Description1Field)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Description1DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired Description1")
    public void AddDesiredDescription(String Description1) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Description2Field)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Description1Field)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Description1);
    }

    @Step("Enter Description2 Dynamically")
    public void AddDescription2Dynamically(int option) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.elementToBeClickable(Description2Field)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(Description2DynamicOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        WebElement element = driver.findElement(By.xpath(XpathFormatted));
        js.executeScript("arguments[0].click();", element);
//        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Enter desired  Description2")
    public void AddDesiredDescription2(String Description2) {
        wait.until(ExpectedConditions.elementToBeClickable(Description2Field)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Description2);
    }

    @Step("Clicking on Confirmation Yes Button")
    public void ClickOnConfirmationYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmationYesButton)).click();
    }

    @Step("Validating Error Message for Final url Field")
    public boolean ValidateErrorMessageForFinalUrl() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(FinalUrlFieldErrorMessage));
            return driver.findElement(FinalUrlFieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for Display url Field")
    public boolean ValidateErrorMessageForDisplayUrlField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(GoogleDisplayUrlFieldErrorMessage));
            return driver.findElement(GoogleDisplayUrlFieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for HeadLine Field")
    public boolean ValidateErrorMessageForHeadline1Field() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(Headline1FieldErrorMessage));
            return driver.findElement(Headline1FieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for HeadLine Field")
    public boolean ValidateErrorMessageForHeadline2Field() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(Headline2FieldErrorMessage));
            return driver.findElement(Headline2FieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Error Message for HeadLine Field")
    public boolean ValidateErrorMessageForHeadline3Field() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(Headline3FieldErrorMessage));
            return driver.findElement(Headline3FieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating campaign name empty error message is displayed")
    public boolean isCampaignNameEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignNameEmptyErrorMessage));
            return driver.findElement(CampaignNameEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating average daily budget empty error message is displayed")
    public boolean isAverageDailyBudgetEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AverageDailyBudgetEmptyErrorMessage));
            return driver.findElement(AverageDailyBudgetEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Entering Campaign Name")
    public void EnterDataInCampaignName(String Text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        driver.switchTo().activeElement().sendKeys(Text);
    }

    @Step("Validate name is field is accepting spaces")
    public boolean ValidateCampaignNameFieldAcceptingSpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(CampaignNameField));
            driver.findElement(CampaignNameField).click();
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Entering more than 50 characters in Campaign Name")
    public void EnterMoreThan50CharactersInCampaignName(int count) {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        driver.switchTo().activeElement().sendKeys(generateRandomData("randomdata", count));
    }


    @Step("Validate name is field is accepting more than 50 characters")
    public boolean ValidateCampaignNameFieldAcceptingMoreThan50Characters() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(CampaignNameField));
            driver.findElement(CampaignNameField).click();
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 50;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public StringBuilder generateRandomData(String useCase, int count) {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk0123456789";
        StringBuilder result = new StringBuilder();
        String fixedPart = "QATesting";
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            result.append(randomChar);
        }
        if (useCase.equalsIgnoreCase("email")) {
            return result.append("@gmail.com");
        } else if (useCase.equalsIgnoreCase("randomdata")) {
            return new StringBuilder(fixedPart).append(result);
        }
        return result;
    }

    @Step("Validate daily budget is field is accepting spaces")
    public boolean ValidateDailyBudgetFieldAcceptingSpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(AverageDailyBudget));
            driver.findElement(AverageDailyBudget).click();
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate daily budget is field is accepting negative value")
    public boolean ValidateDailyBudgetFieldAcceptingNegativeValue() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(AverageDailyBudget));
            driver.findElement(AverageDailyBudget).click();
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.contains("-");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on AdFormat Create New button")
    public void ClickOnAdFormatCreateNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdFormatCreateNewButton)).click();
    }

    @Step("Entering creative name")
    public void EnterCreativeNameInFaceBookAdFormat(String creativeName) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeNameField)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(generateRandomData("randomdata", 10));
    }

    @Step("Entering creative name")
    public void EnterSpacesInFaceBookAdFormatCreativeNameInFaceBookAdFormat(String creativeName) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeNameField)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(creativeName);
    }

    @Step("Clicking on Select Creative field")
    public void ClickOnSelectCreativeField() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectCreativeField)).click();
    }

    @Step("Clicking on Lead Form Selection field")
    public void ClickOnLeadFormSelectionField() {
        wait.until(ExpectedConditions.elementToBeClickable(LeadFormSelectionField)).click();
    }

    @Step("Clicking on This Template For field")
    public void ClickOnThisTemplateForField() {
        wait.until(ExpectedConditions.elementToBeClickable(ThisTemplateForField)).click();
    }

    @Step("Entering main body text")
    public void EnterMainBodyText(String mainBodyText) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(DescriptionTextField, 1)))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(MainBodyTextField)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(mainBodyText);
    }

    @Step("Entering headline text")
    public void EnterHeadLineText(int option, String headlineText) {//check
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(String.format(DescriptionTextField, 1))));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(DescriptionTextField, option)))).perform();
        String XpathFormatted = String.format(HeadLineField, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatted))).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(headlineText);
    }

    @Step("Entering description text")
    public void EnterDescriptionText(int Option, String descriptionText) {//check
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(SelectCallToActionField)).perform();
        String XpathFormatted = String.format(DescriptionTextField, Option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted))).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(descriptionText);
    }


    @Step("Clicking on Media Type field")
    public void ClickOnMediaTypeField() {
        wait.until(ExpectedConditions.elementToBeClickable(MediaTypeField)).click();
    }

    @Step("Clicking on Select Call to Action field")
    public void ClickOnSelectCallToActionField() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SelectCallToActionField)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(SelectCallToActionField)).click();
    }

    @Step("Clicking on dynamic attribute search field {0} if available")
    public void EnterTextInDynamicAttributeSearchField(int index, String Text) {
        By fieldLocator = By.xpath(String.format(DynamicAttributeSearchField, index));
        wait.until(ExpectedConditions.elementToBeClickable(fieldLocator));
        driver.findElement(fieldLocator).click();
        driver.switchTo().activeElement().sendKeys(Text);
    }

    @Step("Clicking on dynamic property option {0} if available")
    public void ClickOnDynamicPropertyOption(int index) {
        By optionLocator = By.xpath(String.format(DynamicPropertyOptions, index));
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        driver.findElement(optionLocator).click();
    }

    @Step("Clicking on generic option ")
    public void ClickOnGenericOptionsSelector(int index) {
        By optionLocator = By.xpath(String.format(GenericOptionsSelector, index));
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        driver.findElement(optionLocator).click();
    }

    @Step("Clicking on choose image field")
    public void ClickOnChooseImageField(int index) { //check
        By optionLocator = By.xpath(String.format(ChooseImageField, index));
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    @Step("Clicking on image selector")
    public void ClickOnImageSelector() {
        wait.until(ExpectedConditions.elementToBeClickable(ImageSelector));
        driver.findElement(ImageSelector).click();
    }

    @Step("Clicking on selected image save button")
    public void ClickOnSelectedImageSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectedImageSaveButton));
        driver.findElement(SelectedImageSaveButton).click();
    }

    @Step("Clicking on Facebook carousel section")
    public void ClickOnFaceBookCarouselSection() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated((DisabledCreateButton)));
        wait.until(ExpectedConditions.elementToBeClickable(FaceBookCarouselSection));
        driver.findElement(FaceBookCarouselSection).click();
    }

    @Step("Clicking on create new top button")
    public void ClickOnCreateNewTopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewTopButton));
        driver.findElement(CreateNewTopButton).click();
    }

    @Step("Adding final Url")
    public void AddFinalUrl(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(FinalUrl)).click();
        driver.switchTo().activeElement().sendKeys("^");
        String XpathFormatted = String.format(FinalUrlOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatted)));
        driver.findElement(By.xpath(XpathFormatted)).click();
    }

    @Step("Entering Destination Url")
    public void EnterDestinationUrl(String DestinationUrl) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(HeadLineField, 1)))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(DestinationUrlField)).click();
        driver.switchTo().activeElement().sendKeys(DestinationUrl);
    }

    @Step("Clicking on Template For field")
    public void ClickOnTemplateForField() {
        wait.until(ExpectedConditions.elementToBeClickable(TemplateForField)).click();
    }

    @Step("Clicking on Carousel Selector")
    public void ClickOnCarouselSelector(int option) {
        String XpathFormatted = String.format(CarouselSelector, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatted))).click();
    }

    @Step("Clicking on Add Carousel Button")
    public void ClickOnAddCarouselButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddCarouselButton)).click();
    }


    @Step("Clicking on Delete Carousel Button")
    public void ClickOnDeleteCarouselButton(int option) {
        String XpathFormatted2 = String.format(CarouselSelector, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatted2))).click();
        String XpathFormatted = String.format(DeleteCarouselButton, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatted))).click();
    }

    @Step("Clicking on Add Filter Button")
    public void ClickOnAddFilterButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddFilterButton));
        wait.until(ExpectedConditions.elementToBeClickable(AddFilterButton)).click();
    }

    @Step("Clicking on Ad Type Drop Down Field In Filter")
    public void ClickOnAdTypeDropDownField() {
        wait.until(ExpectedConditions.elementToBeClickable(AdTypeDropDownField)).click();
    }

    @Step("Clicking on Filter Condition Field Drop Down")
    public void ClickOnFilterConditionFieldDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterConditionFieldDropDown)).click();
    }

    @Step("Entering text in Filter Condition Search Field")
    public void EnterTextInFilterConditionSearchField(String Text) throws InterruptedException {
        Thread.sleep(1500);
//        wait.until(ExpectedConditions.elementToBeClickable(FilterConditionSearchField)).click();
        driver.switchTo().activeElement().sendKeys(Text);
    }

    @Step("Entering text in Filter Value Search Field")
    public void EnterTextInFilterValueSearchField(String Text) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(FilterValueSearchField)).click();
        Thread.sleep(1500);
        driver.switchTo().activeElement().sendKeys(Text);
    }

    @Step("Clicking on Filter Apply Button")
    public void ClickOnFilterApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterApplyButton)).click();
    }

    @Step("Validating is Filter Results are displayed")
    public boolean IsFilterResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeAdCard));
            return driver.findElement(CreativeAdCard).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting Creative Ad Card")
    public void ClickOnCreativeAdCard() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeAdCard)).click();
    }

    @Step("Checking if creative name field empty error message is displayed")
    public boolean IsCreativeNameFieldEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeNameFieldEmptyErrorMessage));
            return driver.findElement(CreativeNameFieldEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking if lead form selection empty error message is displayed")
    public boolean IsLeadFormSelectionEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LeadFormSelectionEmptyErrorMessage));
            return driver.findElement(LeadFormSelectionEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking if 'This Template is for' empty error message is displayed")
    public boolean IsThisTemplateIsForEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ThisTemplateIsForEmptyErrorMessage));
            return driver.findElement(ThisTemplateIsForEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking if main body text empty error message is displayed")
    public boolean IsMainBodyTextEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MainBodyTextEmptyErrorMessage));
            return driver.findElement(MainBodyTextEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking if headline empty error message is displayed")
    public boolean IsHeadlineEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(HeadlineEmptyErrorMessage));
            return driver.findElement(HeadlineEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking if media empty error message is displayed")
    public boolean IsMediaEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MediaEmptyErrorMessage));
            return driver.findElement(MediaEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Checking if select call to action empty error message is displayed")
    public boolean IsSelectCallToActionEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SelectCallToActionEmptyErrorMessage));
            return driver.findElement(SelectCallToActionEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validating is Creative Name Field Accepts Only Spaces as Input")
    public boolean ValidateCreativeNameFieldAcceptsOnlySpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(CreativeNameField));
            driver.findElement(CreativeNameField).click();
            driver.switchTo().activeElement().sendKeys(Keys.SPACE);
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating is Main Body Text Field Accepts Only Spaces as Input")
    public boolean ValidateMainBodyTextFieldAcceptsOnlySpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(MainBodyTextField));
            driver.findElement(MainBodyTextField).click();
            driver.switchTo().activeElement().sendKeys(Keys.SPACE);
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating is Headline Field Accepts Only Spaces as Input")
    public boolean ValidateHeadlineFieldAcceptsOnlySpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(HeadLineField, 1))));
            driver.findElement(By.xpath(String.format(HeadLineField, 1))).click();
            driver.switchTo().activeElement().sendKeys(Keys.SPACE);
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            System.out.println("data :" + Count + ": data");
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating is Description Field Accepts Only Spaces as Input")
    public boolean ValidateDescriptionFieldAcceptsOnlySpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(DescriptionTextField, 1))));
            driver.findElement(By.xpath(String.format(DescriptionTextField, 1))).click();
            driver.switchTo().activeElement().sendKeys(Keys.SPACE);
            String Count = driver.switchTo().activeElement().getText();
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating is creative name field accepts more than 90 characters")
    public boolean ValidateCreativeNameFieldAcceptsMoreThan90Characters() {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(CreativeNameField)).perform();
            wait.until(ExpectedConditions.presenceOfElementLocated(CreativeNameField));
            driver.findElement(CreativeNameField).click();
            driver.switchTo().activeElement().sendKeys(generateRandomData("randomdata", 91));
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 90;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating is Destination Url field accepts only spaces")
    public boolean ValidateDestinationUrlFieldAcceptsOnlySpaces() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(DestinationUrlField)).click();
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Carousel Add Button Visible After Adding 10 Carousel")
    public boolean ValidateCarouselAddButtonVisibleAfterAdding10Carousel() {
        try {
            for (int i = 1; i <= 8; i++) {
                ClickOnAddCarouselButton();
            }
            Thread.sleep(2000);
            return driver.findElement(AddCarouselButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException | InterruptedException e) {
            return false;
        }
    }

    @Step("Validating Ad Empty Template Error Pop Up is Displayed")
    public boolean IsAdEmptyTemplateErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AdEmptyTemplateErrorPopUp));
            return driver.findElement(AdEmptyTemplateErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



    @Step("Validating is creative name field accepts more than 50 characters")
    public boolean ValidateCreativeNameFieldAcceptsMoreThan50Characters() {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(CreativeNameField)).perform();
            wait.until(ExpectedConditions.presenceOfElementLocated(CreativeNameField));
            driver.findElement(CreativeNameField).click();
            driver.switchTo().activeElement().sendKeys(generateRandomData("randomdata", 51));
            String Count = driver.switchTo().activeElement().getDomAttribute("value");
            return Count.length() > 50;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Filter Value Field Drop Down")
    public void ClickOnFilterValueFieldDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterValueFieldDropDown)).click();
    }

}




