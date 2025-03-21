package PagesPulse;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CampaignManagementPage {

    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public CampaignManagementPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    final By PaidMediaButton = By.xpath("//div[contains(@class,'top-menu-section')]/a[contains(@href,'paidMedia')]/div");
    final By CampaignManagementButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-campaign-management')]/div");
    final By CreateCampaignButton = By.xpath("//button[contains(@class,'pendo_new_campaign_create_campaign_btn')]");
    final By CampaignNameField = By.xpath("(//div[contains(@class,'input-wrapper')]/descendant::input)[1]");
    final By CampaignBriefField = By.xpath("(//div[contains(@class,'input-wrapper')]/descendant::input)[2]");
    final By AwarenessRadioButton = By.xpath("//div[contains(@class,'pendo_new_objective_awareness')]/descendant::label");
    final By ChooseChannelField = By.xpath("//div[contains(@class,'campaign-launch__channel ')]/descendant::div[contains(@class,'Select__input-container')]");
    final String GenericOptionSelector = "(//div[contains(@id,'-option-')])[%d]";
    final By StrategySettingsCheckBox = By.xpath("//input[contains(@id,'checkbox-inputData.allowPartnerToModifyStrategy')]/parent::div/descendant::label");
    final By FixedSchedule = By.xpath("(//input[contains(@class,'os-custom-radio ')]/parent::div/descendant::label)[6]");
    final By StartDateField = By.xpath("(//div[contains(@class,'date-picker-wrapper')]/descendant::img[contains(@class,'datepicker-icon')])[1]");
    final By EndDateField = By.xpath("(//div[contains(@class,'date-picker-wrapper')]/descendant::img[contains(@class,'datepicker-icon')])[2]");
    final By MonthDropdown = By.xpath("//div[contains(@class,'select-dropdown os-mr month-dropdown')]");
    final By YearDropdown = By.xpath("(//div[contains(@class,'month-year-wrapper')]/descendant::div[contains(@class,'select-dropdown')])[2]");
    final By NextButton = By.xpath("//div[contains(@class,'fixed-layout-footer')]/descendant::button");
    final By ConfirmationYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]/span");
    final By AddPartnersButton = By.xpath("//div[contains(@class,'oem-add-partner-campaign')]/descendant::button");
    final By AddFilterButton = By.xpath("(//button[contains(@class,'pendo_feature_filter_pill_add_button')])[2]");
    final By AdTypeDropDownField = By.xpath("//div[contains(@class,'action-dropdown')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final By FilterConditionFieldDropDown = By.xpath("//div[contains(@class,'condition-dropdowns')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final By FilterValueSearchField = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::input)[2]");
    final By FilterSearchField = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::input)");
    final By FilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_pill_filter_submit_button')]");
    final String PartnerRadioButton = "(//label[contains(@for,'TableWrapper_partnerTable-')])[%d]";
    final By AddPartnerSaveButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/descendant::button)[3]");
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final String AverageDailyBudgetField = "(//div[contains(@class,'input-wrapper')]/descendant::input)[%d]";
    final String LifeTimeBudgetField = "(//div[contains(@class,'input-wrapper')]/descendant::input)[%d]";
    final String AverageDailyBudgetCopyIcon = "(//div[contains(@class,'partner-copy-opt-dropdown')]/descendant::button)[%d]";
    final String CopyToAllButton = "(//a[contains(@class,'pendo_new_copy_to_all')])[%d]";
    final By PartnerSelectionNextButton = By.xpath("//button[contains(@class,'pendo_oem_console_campaign_budget_settings_save_btn')]/span");
    final By ChooseFromAdLibraryButton = By.xpath("//button[contains(@class,'choose-library-btn')]");
    final String ResponsiveSearchAd = "(//div[contains(@class,'verified-block')]/div)[%d]";
    final By AdSaveButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/descendant::button)[3]");
    final By AdSavedSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By CallAdSection = By.xpath("//a[contains(@class,'pendo_new_CALL_ONLY_AD nav-item')]");
    final By GooglePerformanceAd = By.xpath("//a[contains(@class,'pendo_new_PERFORMANCE_MAX nav-item nav-link')]");
    final By Step2AdsNextButton = By.xpath("//button[contains(@class,'pendo_oem_console_campaign_ad_settings_save_btn')]/span");
    final By AdNewAudienceButton = By.xpath("(//button[contains(@class,'pendo_new_audience_create_btn')])[1]");
    final By AudienceNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-name')]/descendant::input");
    final By FromAgeField = By.xpath("(//div[contains(@class,'os-select-dropdown')]/descendant::div[contains(@class,'Select__control')])[1]");
    final By ToAgeField = By.xpath("(//div[contains(@class,'os-select-dropdown')]/descendant::div[contains(@class,'Select__control')])[2]");
    final String GenderOption = "(//div[contains(@class,'pendo-event-tracker-common-form-component-output-gender')]/descendant::div[contains(@class,'radio-wrapper')])";
    final By AudienceCreationSaveButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/descendant::button)[3]");
    final By DisabledAudienceCreationSaveButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/descendant::button[contains(@class,'disabled')])");
    final By AudienceTableSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input')]/descendant::input");
    final By AudienceTableResults = By.xpath("(//td[contains(@class,'ellipses-large universalText')])[1]");
    final String AudienceSelector = "(//input[contains(@id,'os-table-')]/parent::div/descendant::label)[%d]";
    final By ReviewAndLaunchButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/descendant::button)[2]");
    final By LaunchCampaignButton = By.xpath("//button[contains(@class,'pendo_new_launch_campaign_btn')]");
    final By CampaignLaunchSuccessPopUp = By.xpath("//div[contains[@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By AllActionsButton = By.xpath("//button[contains(@class,'pendo_new_all_actions_btn')]/span");
    final By CampaignViewButton = By.xpath("//button[contains(@class,'pendo_new_view_actions')]/span");
    final By RefreshButton = By.xpath("//button[contains(@class,'pendo-track-react-table-refresh-button')]/span");
    final By AdsTabSwitcher = By.xpath("//a[contains(@data-rb-event-key,'ADS_TABLE')]/div");
    final By Partners = By.xpath("//a[contains(@data-rb-event-key,'ADS_TABLE')]/parent::nav/following-sibling::div[contains(@class,'tab-content')]/descendant::td[@class='universalText' and contains(@data-sticky-td,'true')]");
    final By CampaignNameEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-campaign-name')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By CampaignBriefEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-campaign-brief')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By ChooseChannelEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-choose-channel')]/descendant::div[contains(@class,'name-error-message')]");
    final By AddPartnersErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By SavePartnersErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By AddFilterValueFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-track-filter-fincane-operator-input')]/parent::div/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By AverageDailyBudgetErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By AverageDailyBudgetWarningIcon = By.xpath("(//span[contains(@class,'icon-warning-filled')])[1]");
    final By LifeTimeBudgetWarningIcon = By.xpath("(//span[contains(@class,'icon-warning-filled')])[2]");
    final By AdsMinimumErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ResponsiveAdsMinimumErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By CallAdsMinimumErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By AdsNextButton = By.xpath("//button[contains(@class,'pendo_oem_console_campaign_budget_settings_save_btn')]/span");
    final By DuplicateAudienceNameErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By AudienceNameEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-name')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");

    @Step("Click on Paid Media Button")
    public void ClickOnPaidMediaButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PaidMediaButton));
        driver.findElement(PaidMediaButton).click();
    }


    @Step("Click on Campaign Management Button")
    public void ClickOnCampaignManagementButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignManagementButton));
        driver.findElement(CampaignManagementButton).click();
    }


    @Step("Click on Create Campaign Button")
    public void ClickOnCreateCampaignButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateCampaignButton));
        driver.findElement(CreateCampaignButton).click();
    }


    public String CampaignName;

    @Step("Enter Campaign Name")
    public void EnterCampaignName(String Data, int Count) {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        CampaignName = String.valueOf(utils.generateRandomData(Data, Count));
        driver.findElement(CampaignNameField).sendKeys(CampaignName);
    }


    @Step("Enter Campaign Brief")
    public void EnterCampaignBrief(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignBriefField));
        driver.findElement(CampaignBriefField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.findElement(CampaignBriefField).sendKeys(Data);
    }



    @Step("Click on Awareness Radio Button")
    public void ClickOnAwarenessRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AwarenessRadioButton));
        driver.findElement(AwarenessRadioButton).click();
    }
    @Step("Click on Choose Channel Field")
    public void ClickOnChooseChannelField() {
        wait.until(ExpectedConditions.elementToBeClickable(ChooseChannelField));
        driver.findElement(ChooseChannelField).click();
    }
    @Step("Entering Data in Choose Channel Search Field")
    public void EnterDataInChooseChannelSearchField(String Data) {
        driver.switchTo().activeElement().sendKeys(Data);
    }
    @Step("Selecting Option from Drop Down")
    public void SelectOption(int Option) {
        By OptionSelector = By.xpath(String.format(GenericOptionSelector, Option));
        wait.until(ExpectedConditions.elementToBeClickable(OptionSelector)).click();
    }
    @Step("Click on Strategy Settings Check Box")
    public void ClickOnStrategySettingsCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(StrategySettingsCheckBox));
        driver.findElement(StrategySettingsCheckBox).click();
    }
    @Step("Click on Fixed Schedule Radio Button")
    public void ClickOnFixedSchedule() {
        wait.until(ExpectedConditions.elementToBeClickable(FixedSchedule));
        driver.findElement(FixedSchedule).click();
    }
    @Step("Clicking on start date field")
    public void ClickOnStartDateField() {
        WebElement element = driver.findElement(StartDateField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
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
    @Step("Click on Next Button")
    public void ClickOnNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));
        driver.findElement(NextButton).click();
    }
    @Step("Clicking on Confirmation Yes Button")
    public void ClickOnConfirmationYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmationYesButton)).click();
    }
    @Step("Click on Add Partners Button")
    public void ClickOnAddPartnersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddPartnersButton));
        driver.findElement(AddPartnersButton).click();
    }
    @Step("Clicking on Add Filter Button")
    public void ClickOnAddFilterButton() {
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
    @Step("Entering text in Filter Value Search Field")
    public void EnterTextInFilterSearchField(String Text) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(FilterSearchField)).click();
        Thread.sleep(1500);
        driver.switchTo().activeElement().sendKeys(Text);
    }
    @Step("Clicking on Filter Apply Button")
    public void ClickOnFilterApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterApplyButton)).click();
    }
    @Step("Selecting Partner")
    public void SelectPartner(int Partner) {
        By PartnerSelector = By.xpath(String.format(PartnerRadioButton, Partner));
        wait.until(ExpectedConditions.elementToBeClickable(PartnerSelector)).click();
    }
    @Step("Click on Add Partner Save Button")
    public void ClickOnAddPartnerSaveButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(AddPartnerSaveButton)).click();
        ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }
    @Step("Enter Average Daily Budget")
    public void EnterAverageDailyBudget(String Data, int Count) {
        By AverageDailyBudgetFieldSelector = By.xpath(String.format(AverageDailyBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(AverageDailyBudgetFieldSelector));
        driver.findElement(AverageDailyBudgetFieldSelector).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.findElement(AverageDailyBudgetFieldSelector).sendKeys(Data);
    }


    @Step("Enter Life Time Budget")
    public void EnterLifeTimeBudget(String Data, int Count) {
        By LifeTimeBudgetFieldSelector = By.xpath(String.format(LifeTimeBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(LifeTimeBudgetFieldSelector));
        driver.findElement(LifeTimeBudgetFieldSelector).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.findElement(LifeTimeBudgetFieldSelector).sendKeys(Data);
    }


    @Step("Click on Average Daily Budget Copy Icon")
    public void ClickOnAverageDailyBudgetCopyIcon(int Count) {
        By AverageDailyBudgetCopyIconSelector = By.xpath(String.format(AverageDailyBudgetCopyIcon, Count));
        wait.until(ExpectedConditions.elementToBeClickable(AverageDailyBudgetCopyIconSelector)).click();
    }



    @Step("Click on Copy To All Button")
    public void ClickOnCopyToAllButton(int Count) {
        By CopyToAllButtonSelector = By.xpath(String.format(CopyToAllButton, Count));
        wait.until(ExpectedConditions.elementToBeClickable(CopyToAllButtonSelector)).click();
    }



    @Step("Click on Partner Selection Next Button")
    public void ClickOnPartnerSelectionNextButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(PartnerSelectionNextButton)).click();
        ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));

    }



    @Step("Click on Choose From Ad Library Button")
    public void ClickOnChooseFromAdLibraryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ChooseFromAdLibraryButton)).click();
    }


    @Step("Selecting Responsive Search Ad")
    public void SelectAd(int Ad) {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(180));
        By ResponsiveSearchAdSelector = By.xpath(String.format(ResponsiveSearchAd, Ad));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(ResponsiveSearchAdSelector)).click();
    }


    @Step("Click on Ad Save Button")
    public void ClickOnAdSaveButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(AdSaveButton)).click();
        ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }


    @Step("Verify Ad Saved Success Pop Up is Displayed")
    public boolean VerifyAdSavedSuccessPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AdSavedSuccessPopUp));
            return driver.findElement(AdSavedSuccessPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Click on Call Ad Section")

    public void ClickOnCallAdSection() {
        wait.until(ExpectedConditions.elementToBeClickable(CallAdSection)).click();
    }


    @Step("Click on Google Performance Ad")
    public void ClickOnGooglePerformanceAd() {
        wait.until(ExpectedConditions.elementToBeClickable(GooglePerformanceAd)).click();
    }



    @Step("Click on Ads Next Button")
    public void ClickOnStep2AdsNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Step2AdsNextButton)).click();
    }


    @Step("Click on New Audience Button")
    public void ClickOnAdNewAudienceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdNewAudienceButton)).click();
    }



    public String AudienceName;

    @Step("Enter Audience Name")
    public void EnterAudienceName(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(AudienceNameField)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        AudienceName = utils.generateRandomData(Data, 6).toString();
        driver.findElement(AudienceNameField).sendKeys(AudienceName);
    }


    @Step("Click on From Age Field")
    public void ClickOnFromAgeField() {
        wait.until(ExpectedConditions.elementToBeClickable(FromAgeField)).click();
    }


    @Step("Click on To Age Field")
    public void ClickOnToAgeField() {
        wait.until(ExpectedConditions.elementToBeClickable(ToAgeField)).click();
    }


    @Step("Selecting Gender")
    public void SelectGender(int Option) {
        By Gender = By.xpath(String.format(GenderOption, Option));
        wait.until(ExpectedConditions.elementToBeClickable(Gender));
        driver.findElement(Gender).click();
    }


    @Step("Click on Audience Creation Save Button")
    public void ClickOnAudienceCreationSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AudienceCreationSaveButton)).click();

    }



    @Step("Enter Data in Search Field")
    public void EnterDataInSearchField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(AudienceTableSearchField)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.findElement(AudienceTableSearchField).sendKeys(Data);
    }



    @Step("Verify Is Created Audience Displayed In Table First Row ")
    public boolean IsCreatedAudienceDisplayedInTableFirstRow() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AudienceTableResults));
            return driver.findElement(AudienceTableResults).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Selecting Audience")
    public void SelectAudience(int OptionNo) {
        By Selector = By.xpath(String.format(AudienceSelector, OptionNo));
        wait.until(ExpectedConditions.elementToBeClickable(Selector)).click();
    }


    @Step("Click on Review And Launch Button")
    public void ClickOnReviewAndLaunchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ReviewAndLaunchButton)).click();
    }


    @Step("Click on Launch Campaign Button")
    public void ClickOnLaunchCampaignButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LaunchCampaignButton)).click();
    }


    @Step("Verify Campaign Launch Success Pop Up is Displayed")
    public boolean VerifyCampaignLaunchSuccessPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignLaunchSuccessPopUp));
            return driver.findElement(CampaignLaunchSuccessPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Click on All Actions Button")
    public void ClickOnAllActionsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AllActionsButton)).click();
    }



    @Step("Click on Campaign View Button")
    public void ClickOnCampaignViewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignViewButton)).click();
    }

    @Step("Is Created Campaign Is Displayed After Applying Filter")
    public boolean IsCreatedCampaignDisplayedAfterApplyingFilter() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignViewButton));
            return driver.findElement(CampaignViewButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Click on Refresh Button")
    public void ClickOnRefreshButton() throws InterruptedException {
        Thread.sleep(60000);
        wait.until(ExpectedConditions.elementToBeClickable(RefreshButton)).click();
    }


    @Step("Click on Ads Tab Switcher")
    public void ClickOnAdsTabSwitcher() {

        wait.until(ExpectedConditions.elementToBeClickable(AdsTabSwitcher)).click();
    }


    @Step("Validate Created Partners Count")
    public boolean ValidateCreatedPartnersCount(int Count) {
        List<WebElement> elements = driver.findElements(Partners);
        System.out.println("Count is : " + elements.size());
        return elements.size() == Count;
    }



    @Step("Verify Campaign Name Empty Error Message is Displayed")
    public boolean VerifyCampaignNameEmptyErrorMessageIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignNameEmptyErrorMessage));
            return driver.findElement(CampaignNameEmptyErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Verify Campaign Brief Empty Error Message is Displayed")
    public boolean VerifyCampaignBriefEmptyErrorMessageIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignBriefEmptyErrorMessage));
            return driver.findElement(CampaignBriefEmptyErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Verify Choose Channel Empty Error Message is Displayed")
    public boolean VerifyChooseChannelEmptyErrorMessageIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ChooseChannelEmptyErrorMessage));
            return driver.findElement(ChooseChannelEmptyErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Enter Campaign Name")
    public void EnterDataInCampaignName(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        driver.findElement(CampaignNameField).sendKeys(Data);
    }


    @Step("Validate Is Campaign Name Field Accepting Empty Spaces As Input")
    public boolean IsCampaignNameFieldAcceptingEmptySpacesAsInput() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        String Text = driver.findElement(CampaignNameField).getAttribute("value");
        return Text.trim().isEmpty();
    }


    @Step("Validate Is Campaign Name Field Accepting More Than 100 Characters")
    public boolean IsCampaignNameFieldAcceptingMoreThan100Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignNameField));
        driver.findElement(CampaignNameField).click();
        String Text = driver.findElement(CampaignNameField).getAttribute("value");
        return Text.length() > 100;

    }


    @Step("Validate Is Campaign Brief Field Accepting More Than 100 Characters")
    public boolean IsCampaignBriefFieldAcceptingMoreThan200Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignBriefField));
        driver.findElement(CampaignBriefField).click();
        String Text = driver.findElement(CampaignBriefField).getAttribute("value");
        return Text.length() > 200;

    }


    @Step("Validate Is Campaign Brief Field Accepting Empty Spaces As Input")
    public boolean IsCampaignBriefFieldAcceptingEmptySpacesAsInput() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignBriefField));
        driver.findElement(CampaignBriefField).click();
        String Text = driver.findElement(CampaignBriefField).getAttribute("value");
        return Text.trim().isEmpty();
    }


    @Step("Verify Add Partners Error Pop Up is Displayed")
    public boolean VerifyAddPartnersErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddPartnersErrorPopUp));
            return driver.findElement(AddPartnersErrorPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Verify Save Partners Empty Error Pop Up is Displayed")
    public boolean VerifySavePartnersEmptyErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SavePartnersErrorPopUp));
            return driver.findElement(SavePartnersErrorPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }




    @Step("Verify Add Filter Value Field Empty Error Message is Displayed")
    public boolean VerifyAddFilterValueFieldEmptyErrorMessageIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddFilterValueFieldEmptyErrorMessage));
            return driver.findElement(AddFilterValueFieldEmptyErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Verify Average Daily Budget Error Pop Up is Displayed")
    public boolean VerifyAverageDailyBudgetErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AverageDailyBudgetErrorPopUp));
            return driver.findElement(AverageDailyBudgetErrorPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Verify Average Daily Budget Warning Icon is Displayed")
    public boolean VerifyAverageDailyBudgetWarningIconIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AverageDailyBudgetWarningIcon));
            return driver.findElement(AverageDailyBudgetWarningIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Verify Average Daily Budget Field is Accepting Characters")
    public boolean VerifyAverageDailyBudgetFieldIsAcceptingCharacters(int Count) {
        By AverageDailyBudgetFieldSelector = By.xpath(String.format(AverageDailyBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(AverageDailyBudgetFieldSelector));
        driver.findElement(AverageDailyBudgetFieldSelector).click();
        String Text = driver.findElement(AverageDailyBudgetFieldSelector).getAttribute("value");
        return Text.length() > 0;
    }


    @Step("Verify Average Daily Budget Field is Accepting Spaces")
    public boolean VerifyAverageDailyBudgetFieldIsAcceptingSpaces(int Count) {
        By AverageDailyBudgetFieldSelector = By.xpath(String.format(AverageDailyBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(AverageDailyBudgetFieldSelector));
        driver.findElement(AverageDailyBudgetFieldSelector).click();
        String Text = driver.findElement(AverageDailyBudgetFieldSelector).getAttribute("value");
        return Text.trim().isEmpty();
    }


    @Step("Verify Average Daily Budget Field is Accepting Negative Value")
    public boolean VerifyAverageDailyBudgetFieldIsAcceptingNegativeValue(int Count) {
        By AverageDailyBudgetFieldSelector = By.xpath(String.format(AverageDailyBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(AverageDailyBudgetFieldSelector));
        driver.findElement(AverageDailyBudgetFieldSelector).click();
        String Text = driver.findElement(AverageDailyBudgetFieldSelector).getAttribute("value");
        return Text.contains("-");
    }



    @Step("Verify Life Time Budget Warning Icon is Displayed")
    public boolean VerifyLifeTimeBudgetWarningIconIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LifeTimeBudgetWarningIcon));
            return driver.findElement(LifeTimeBudgetWarningIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Verify Life Time Budget Field is Accepting Characters")
    public boolean VerifyLifeTimeBudgetFieldIsAcceptingCharacters(int Count) {
        By LifeTimeBudgetFieldSelector = By.xpath(String.format(LifeTimeBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(LifeTimeBudgetFieldSelector));
        driver.findElement(LifeTimeBudgetFieldSelector).click();
        String Text = driver.findElement(LifeTimeBudgetFieldSelector).getAttribute("value");
        return Text.length() > 0;
    }

    @Step("Verify Life Time Budget Field is Accepting Spaces")
    public boolean VerifyLifeTimeBudgetFieldIsAcceptingSpaces(int Count) {
        By LifeTimeBudgetFieldSelector = By.xpath(String.format(LifeTimeBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(LifeTimeBudgetFieldSelector));
        driver.findElement(LifeTimeBudgetFieldSelector).click();
        String Text = driver.findElement(LifeTimeBudgetFieldSelector).getAttribute("value");
        return Text.trim().isEmpty();
    }

    @Step("Verify Life Time Budget Field is Accepting Negative Value")

    public boolean VerifyLifeTimeBudgetFieldIsAcceptingNegativeValue(int Count) {
        By LifeTimeBudgetFieldSelector = By.xpath(String.format(LifeTimeBudgetField, Count));
        wait.until(ExpectedConditions.elementToBeClickable(LifeTimeBudgetFieldSelector));
        driver.findElement(LifeTimeBudgetFieldSelector).click();
        String Text = driver.findElement(LifeTimeBudgetFieldSelector).getAttribute("value");
        return Text.contains("-");
    }



    @Step("Verify Ads Minimum Error Pop Up is Displayed")
    public boolean VerifyAdsMinimumErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AdsMinimumErrorPopUp));
            return driver.findElement(AdsMinimumErrorPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Verify Responsive Ads Minimum Error Pop Up is Displayed")
    public boolean VerifyResponsiveAdsMinimumErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ResponsiveAdsMinimumErrorPopUp));
            return driver.findElement(ResponsiveAdsMinimumErrorPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Verify Call Ads Minimum Error Pop Up is Displayed")

    public boolean VerifyCallAdsMinimumErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CallAdsMinimumErrorPopUp));
            return driver.findElement(CallAdsMinimumErrorPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Verify Review and lunch button is Enabled Without selecting Any Audience")
    public boolean VerifyReviewAndLunchButtonIsEnabledWithoutSelectingAnyAudience() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ReviewAndLaunchButton));
        String Xpath = driver.findElement(ReviewAndLaunchButton).getDomAttribute("class");
        return Xpath.contains("disabled");

    }



    @Step("Click on Ads Next Button")
    public void ClickOnAdsNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdsNextButton)).click();
    }


    @Step("Enter Data in Audience Name")
    public void EnterDataInAudienceName(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(AudienceNameField)).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.findElement(AudienceNameField).sendKeys(Data);
    }



    @Step("Verify Duplicate Audience Name Error Pop Up is Displayed")
    public boolean VerifyDuplicateAudienceNameErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DuplicateAudienceNameErrorPopUp));
            return driver.findElement(DuplicateAudienceNameErrorPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    @Step("Verify Audience Name Empty Error Message is Displayed")
    public boolean VerifyAudienceNameEmptyErrorMessageIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AudienceNameEmptyErrorMessage));
            return driver.findElement(AudienceNameEmptyErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Verify is From age is Having Bigger age Value Than To age")
    public boolean VerifyFromAgeIsHavingBiggerAgeValueThanToAge() {
        wait.until(ExpectedConditions.elementToBeClickable(FromAgeField));
        driver.findElement(FromAgeField).click();
        int FromAgeMax = 0;
        int ToAgeMax = 0;
        int[] FromAgeArray = driver.findElements(By.xpath("(//div[contains(@id,'-option-')])")).stream().mapToInt(e -> Integer.parseInt(e.getText().trim())).toArray();

        for (int i : FromAgeArray) {
            if (i > FromAgeMax)
                FromAgeMax = Math.max(FromAgeMax, i);
        }
//        SelectOption(FromAgeArray.length);
//        System.out.println(FromAgeArray.length);
        wait.until(ExpectedConditions.elementToBeClickable(ToAgeField));
        driver.findElement(ToAgeField).click();
        int[] ToAgeArray = driver.findElements(By.xpath("(//div[contains(@id,'-option-')])")).stream().mapToInt(e -> Integer.parseInt(e.getText().trim())).toArray();
        for (int i : ToAgeArray) {
            if (i > ToAgeMax)
                ToAgeMax = Math.max(ToAgeMax, i);
        }
//        SelectOption(ToAgeArray.length);
//        System.out.println(ToAgeArray.length);
        return FromAgeMax > ToAgeMax;
    }


}
