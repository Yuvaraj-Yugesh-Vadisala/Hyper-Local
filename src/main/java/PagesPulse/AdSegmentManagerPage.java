package PagesPulse;

import UtilityClass.Utils;
import org.openqa.selenium.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Locale;

public class AdSegmentManagerPage {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public AdSegmentManagerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By SegmentManager = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-advertiser-segment_manager')]/descendant::label");
    final By AddNewSegmentButton = By.xpath("//button[contains(@class,'pendo-feature-kam-add-segment-float-button-click button')]");
    final By SegmentNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-segment-name')]/descendant::div[contains(@class,'input')]");
    final By EveryOneToggle = By.xpath("(//div[contains(@class,'radio-wrapper')])[2]");
    final By AddSegmentElementButton = By.xpath("//div[contains(@class,'pendo-track-segment-column-add-button')]");
    final String SegmentElements = ("(//div[contains(@class,'scrollable-content')]/descendant::div[contains(@class,'menu-item-right')])[%d]");


    @Step("Clicking on Segment Manager")
    public void ClickOnSegmentManager() {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentManager));
        driver.findElement(SegmentManager).click();
    }

    @Step("Clicking on Add New Segment Button")
    public void ClickOnAddNewSegmentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddNewSegmentButton));
        driver.findElement(AddNewSegmentButton).click();
    }

    @Step("Entering Segment Name")
    public void EnterSegmentName(String SegmentName) {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentNameField));
        driver.findElement(SegmentNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(SegmentName);
    }

    @Step("Clicking on Everyone toggle for segment visibility")
    public void SelectEveryOneToggle() {
        wait.until(ExpectedConditions.elementToBeClickable(EveryOneToggle));
        driver.findElement(EveryOneToggle).click();
    }

    @Step("Clicking on Add segments Elements button")
    public void ClickOnAddSegmentElementButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddSegmentElementButton));
        driver.findElement(AddSegmentElementButton).click();
    }
    @Step("Select desired segment element")
    public void SelectDesiredSegmentOption(int optionNo) {
        String formattedXpath = String.format(String.valueOf(SegmentElements), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    final By DeleteAddedSegmentElementButton = By.xpath("//div[contains(@class,'pendo_ott_feature_remove_rule_action_button')]");
    final By ElementSearchField = By.xpath("//div[contains(@class,'popover-body')]/descendant::div[contains(@class,'input-wrapper')]");
    final By SegmentValueField = By.xpath("//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'input-wrapper')]");
    final By SegmentSaveButton = By.xpath("//button[contains(@class,'pendo-feature-kam-segment-creation-form-save-click button')]");
    final By ConditionDropdown = By.xpath("//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'drodown-wrapper')]");
    final By ValueDropdown = By.xpath("(//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'Select__input-container')])[2]");
    final String ConditionOptions = ("(//div[contains(@class,'Select__menu-list')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final String ValueOptions = ("(//div[contains(@class,'Select__menu-list')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By EligibleMerchantCount = By.xpath("//div[contains(@class,'eligible-merchant-count-loader animated-bg')]");
    final By SuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By ErrorMessageForEmptyField = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final String SegmentMenu = ("(//td[contains(@class,'segmentAction')]/descendant::div[contains(@class,'dropdown')])[%d]");
    final By SegmentEditButton = By.xpath("//a[contains(@class,'pendo-feature-kam-segment-edit-option')]");
    final By SegmentDuplicateButton = By.xpath("//a[contains(@class,'pendo-feature-kam-segment-duplicate-option')]");
    final By SegmentEditPage = By.xpath("//div[contains(@class,'drawer-header drawer-flex')]/descendant::span[contains(text(),'Edit')]");
    final By DownloadMerchantListButton = By.xpath("//a[contains(@class,'pendo-feature-kam-segment-download-merchants-option')]");
    final By DownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button')]");
    final By DisabledDownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button') and contains(@class,'disabled')]");
    final By ErrorMessageForSegmentNameField = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By ErrorMessageForSegmentElement = By.xpath("//div[contains(@class,'pendo-track-segment-empty-error')]");
    final By ErrorMessageForSegmentAttributeValue= By.xpath("//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By AddFilterButton = By.xpath("//button[contains(@class,'pendo_feature_payment_user_transaction_log_filter_button button')]");
    final By FilterSegmentNameField = By.xpath("(//div[contains(@class,'filter-button-wrapper')]/descendant::input)[1]");
    final By FilterVisibilityTab = By.xpath("(//a[contains(@class,'nav-item')]/div)[2]");
    final String VisibilityOptions = ("(//div[contains(@class,'radio-group')]/descendant::label)[%d]");
    final By FilterEligiblePartnerCountTab = By.xpath("(//a[contains(@class,'nav-item')]/div)[3]");
    final By PartnerCountMinField = By.xpath("(//div[contains(@class,'filter-button-wrapper')]/descendant::input)[5]");
    final By PartnerCountMaxField = By.xpath("(//div[contains(@class,'filter-button-wrapper')]/descendant::input)[6]");
    final By FilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_global_filter_apply button')]");
    final By FirstRowValue = By.xpath("(//div[contains(@class,'ellipsis-cell')]/descendant::span)[1]");

    @Step("Clicking on cross icon to delete added segment element")
    public void ClickOnCrossIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(DeleteAddedSegmentElementButton));
        driver.findElement(DeleteAddedSegmentElementButton).click();
    }
    @Step("Entering Segment element Name")
    public void EnterDesiredElementName(String SegmentName) {
        wait.until(ExpectedConditions.elementToBeClickable(ElementSearchField));
        driver.findElement(ElementSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(SegmentName);
    }

    @Step("Clicking on condition dropdown")
    public void ClickOnConditionDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ConditionDropdown));
        driver.findElement(ConditionDropdown).click();
    }

    @Step("Clicking on Value dropdown")
    public void ClickOnValueDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ValueDropdown));
        driver.findElement(ValueDropdown).click();
    }

    @Step("Select desired condition")
    public void SelectDesiredSegmentCondition(int optionNo) {
        String formattedXpath = String.format(String.valueOf(ConditionOptions), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Select desired Value from dropdown")
    public void SelectDesiredSegmentValue(int optionNo) {
        String formattedXpath = String.format(String.valueOf(ValueOptions), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Entering Segment Value")
    public void EnterSegmentValue(String SegmentValue) {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentValueField));
        driver.findElement(SegmentValueField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(SegmentValue);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(EligibleMerchantCount));
    }

    @Step("Clicking on Segment Save button")
    public void ClickOnSegmentSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentSaveButton));
        driver.findElement(SegmentSaveButton).click();
    }

    @Step("Validate visibility of Success message for segment name")
    public boolean ValidateVisibilityOfSuccessPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopUp));
            return driver.findElement(SuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }










    @Step("Validate visibility of Error message for segment name")
    public boolean ValidateErrorMessageForEmptyField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForEmptyField));
            return driver.findElement(ErrorMessageForEmptyField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public static StringBuilder RandomSegmentName;
    public final static String SegmentName = String.valueOf(RandomSegmentName);


    @Step("Entering Segment Name")
    public void EnterSegmentName(String Segment, int count) {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentNameField));
        driver.findElement(SegmentNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        RandomSegmentName = generateRandomData(Segment, count);
        driver.switchTo().activeElement().sendKeys(RandomSegmentName);
    }

    public StringBuilder generateRandomData(String useCase, int count) {
        String ALPHANUMERIC_STRING = "0123456789";
        StringBuilder result = new StringBuilder();
        String fixedPart = useCase;
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            result.append(randomChar);
        }

        return new StringBuilder(fixedPart).append(result);
    }


    @Step("Click on three  dots")
    public void ClickOnThreeDots(int optionNo) {
        String formattedXpath = String.format(String.valueOf(SegmentMenu), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Clicking on Segment edit button")
    public void ClickOnSegmentEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentEditButton));
        driver.findElement(SegmentEditButton).click();
    }

    @Step("Clicking on merchant download button")
    public void ClickOnMerchantDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DownloadMerchantListButton));
        driver.findElement(DownloadMerchantListButton).click();
    }

    @Step("Clicking on  download button")
    public boolean ClickOnDownloadButton() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
            ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledDownloadButton));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(DownloadButton));
            driver.findElement(DownloadButton).click();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @Step("Clicking on Segment duplicate button")
    public void ClickOnSegmentDuplicateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentDuplicateButton));
        driver.findElement(SegmentDuplicateButton).click();
    }

    @Step("Validate visibility of edit page")
    public boolean ValidateVisibilityEditPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SegmentEditPage));
            return driver.findElement(SegmentEditPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error message for segment name field")
    public boolean ValidateErrorMessageForSegmentNameField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForSegmentNameField));
            return driver.findElement(ErrorMessageForSegmentNameField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error message for segment Element")
    public boolean ValidateErrorMessageForSegmentElement() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForSegmentElement));
            return driver.findElement(ErrorMessageForSegmentElement).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error message for segment Attribute Value")
    public boolean ValidateErrorMessageForSegmentAttributeValue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForSegmentAttributeValue));
            return driver.findElement(ErrorMessageForSegmentAttributeValue).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Segment Filter button")
    public void ClickOnSegmentFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddFilterButton));
        driver.findElement(AddFilterButton).click();
    }

    @Step("Entering Segment Name in Filter")
    public void EnterFilterSegmentName(String SegmentName) {
        wait.until(ExpectedConditions.elementToBeClickable(FilterSegmentNameField));
        driver.findElement(FilterSegmentNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(SegmentName);
    }

    @Step("Clicking on Segment Filter Visibility tab")
    public void ClickOnFilterVisibilityTab() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterVisibilityTab));
        driver.findElement(FilterVisibilityTab).click();
    }


    @Step("Clicking on Segment Filter Eligible Partner tab")
    public void ClickOnFilterEligiblePartnerTab() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterEligiblePartnerCountTab));
        driver.findElement(FilterEligiblePartnerCountTab).click();
    }

    @Step("Selecting desired visibility option")
    public void SelectDesiredVisibilityOption(int Option) {
        String formattedXpath = String.format((VisibilityOptions), Option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Entering Partner Count Min")
    public void EnterPartnerCountMin(String PartnerCountMin) {
        wait.until(ExpectedConditions.elementToBeClickable(PartnerCountMinField));
        driver.findElement(PartnerCountMinField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(PartnerCountMin);
    }

    @Step("Entering Partner Count Max")
    public void EnterPartnerCountMax(String PartnerCountMax) {
        wait.until(ExpectedConditions.elementToBeClickable(PartnerCountMaxField));
        driver.findElement(PartnerCountMaxField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(PartnerCountMax);
    }

    @Step("Clicking on FilterApplyButton")
    public void ClickOnFilterApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterApplyButton));
        driver.findElement(FilterApplyButton).click();
    }

    @Step("Validate Filter applied successfully")
    public boolean ValidateVisibilityOfFilterResult() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FirstRowValue));
            String FirstRowSegmentName = driver.findElement(FirstRowValue).getText();
            return FirstRowSegmentName.equals("QA Automation");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


}





