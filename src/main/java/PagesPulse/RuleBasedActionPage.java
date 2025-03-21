package PagesPulse;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class RuleBasedActionPage {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public RuleBasedActionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;


    final By RuleBasedActionMenu = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-rule-based_actions_paid_media')]");
    final By CreateBulkRuleButton = By.xpath("//button[contains(@class,'pendo_new_ifttt_rule_cretion_btn')]");
    final By RuleNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-rule-name')]/descendant::input");
    final By RuleBriefField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-rule-brief')]/descendant::input");
    final String ScheduleTypeRadios = ("//div[contains(@class,'pendo-event-tracker-common-form-component-schedule-type')]/descendant::label[contains(@for,'%s')]");
    final By IndividualPaidThresholdField = By.xpath("(//td[contains(@class,'enter-threshold-value inputText')]/descendant::input)[1]");
    final By IndividualSpendThresholdField = By.xpath("(//td[contains(@class,'enter-threshold-value inputText')]/descendant::input)[2]");
    final By CopyToAllIconPaidThreshold = By.xpath("(//span[contains(@class,'icon icon icon-copy copy-opt-icon-btn')])[1]");
    final By CopyToAllIconSpendThreshold = By.xpath("(//span[contains(@class,'icon icon icon-copy copy-opt-icon-btn')])[2]");
    final By CopyToAllButtonPaidThreshold = By.xpath("//a[contains(@class,'pendo_new_copy_to_all dropdown-item')]");
    final By CopyToAllButtonSpendThreshold = By.xpath("(//a[contains(@class,'pendo_new_copy_to_all dropdown-item')])[2]");
    final By CreateRuleSubmitButton = By.xpath("//button[contains(@class,'pendo_feature_rule_creation_submit_button')]");
    final By BulkRuleDescription = By.xpath("//div[contains(@class,'modal-dialog-centered bootstrap-modal confirmation-modal-wrapper bulk-action')]/descendant::textarea");
    final By ConfirmationDoneButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By BulkRuleSuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By StartDateField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-start-date')]/descendant::div[contains(@class,'date-picker-input-wrapper')]");
    final By EndDateField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-end-date')]/descendant::div[contains(@class,'date-picker-input-wrapper')]");
    final By MonthDropdown = By.xpath("//div[contains(@class,'select-dropdown os-mr month-dropdown')]");
    final By YearDropdown = By.xpath("(//div[contains(@class,'month-year-wrapper')]/descendant::div[contains(@class,'select-dropdown')])[2]");
    final By AllActionButton = By.xpath("//button[contains(@class,'pendo_new_all_actions_ifttt button')]");
    final By AllActionFirstRuleName = By.xpath("(//div[contains(@class,'pendo-track-react-table-filter-button')]/following-sibling::div[contains(@class,'table-body-parent-section')]/descendant::div[contains(@class,'ellipsis-cell-overflow d-align-center')]/descendant::span)[2]");
    final By RefreshButton = By.xpath("//button[contains(@class,'pendo-track-react-table-refresh-button')]");
    final By DownloadButton = By.xpath("(//span[contains(@class,'icon icon-download')])[1]");
    final By RuleNameErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-rule-name')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By RuleBriefErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-rule-brief')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");

    @Step("Clicking on Rule Based Action Menu")
    public void ClickOnRuleBasedActionMenu() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(RuleBasedActionMenu));
        element.click();
    }

    @Step("Clicking on Create bulk rule button")
    public void ClickOnBulkRuleButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CreateBulkRuleButton));
        element.click();
    }

    @Step("Entering desired rule name")
    public void EnterRuleName(String RuleName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(RuleNameField));
        element.click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(RuleName);
    }

    @Step("Entering desired rule Brief")
    public void EnterRuleBrief(String RuleName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(RuleBriefField));
        element.click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(RuleName);
    }

    @Step("Selecting desired Schedule Type")
    public void SelectingScheduleType(String ScheduleType) {
        String XpathFormatter = String.format(ScheduleTypeRadios, ScheduleType);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        element.click();
    }

    @Step("Entering desired Individual Paid Threshold Value")
    public void EnterIndividualPaidThreshold(String ThresholdValue) {
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(IndividualPaidThresholdField));
        actions.moveToElement(element).perform();
        element.click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(ThresholdValue);
    }

    @Step("Entering desired Individual Spend Threshold Value")
    public void EnterIndividualSpendThreshold(String ThresholdValue) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(IndividualSpendThresholdField));
        element.click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(ThresholdValue);
    }

    @Step("Clicking on copy to all")
    public void ClickOnCopyToAllForPaidLeadsThreshold() {
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(IndividualPaidThresholdField));
        actions.moveToElement(element).perform();
        WebElement CopyIcon = wait.until(ExpectedConditions.elementToBeClickable(CopyToAllIconPaidThreshold));
        CopyIcon.click();
        WebElement CopyToAllButton = wait.until(ExpectedConditions.elementToBeClickable(CopyToAllButtonPaidThreshold));
        CopyToAllButton.click();
    }

    @Step("Clicking on copy to all")
    public void ClickOnCopyToAllForSpendLeadsThreshold() {
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(IndividualSpendThresholdField));
        actions.moveToElement(element).perform();
        WebElement CopyIcon = wait.until(ExpectedConditions.elementToBeClickable(CopyToAllIconSpendThreshold));
        CopyIcon.click();
        WebElement CopyToAllButton = wait.until(ExpectedConditions.elementToBeClickable(CopyToAllButtonSpendThreshold));
        CopyToAllButton.click();
    }

    @Step("Clicking create rule submit button")
    public void ClickOnCreateRuleSubmitButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CreateRuleSubmitButton));
        element.click();
    }

    @Step("Entering desired Bulk rule description")
    public void EnterBulkRuleDescription(String Description) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BulkRuleDescription));
        element.click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Description);
    }

    @Step("Entering desired Bulk rule description")
    public void ClickOnConfirmationDoneButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ConfirmationDoneButton));
        element.click();
    }

    @Step("Validate Bulk Rule creation")
    public boolean ValidateBulkRuleCreationSuccessPopup() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(BulkRuleSuccessMessage));
            return driver.findElement(BulkRuleSuccessMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Clicking on Start date field")
    public void ClickOnStartDateField() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(StartDateField));
        element.click();
    }

    @Step("Clicking on end date field")
    public void ClickOnEndDateField() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(EndDateField));
        element.click();
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

    @Step("Clicking on the All Action button")
    public void ClickOnAllActionButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AllActionButton));
        element.click();
    }

    @Step("Validate Bulk Rule creation in All Actions")
    public boolean ValidateBulkRuleCreationInAllActions(String RuleName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AllActionFirstRuleName));
            String FirstRuleName = driver.findElement(AllActionFirstRuleName).getText();
            System.out.println(FirstRuleName);
            System.out.println(RuleName);
            return FirstRuleName.equals(RuleName);
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Clicking refresh button")
    public void ClickOnRefreshButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(RefreshButton));
        element.click();
    }

    @Step("Clicking download button")
    public void ClickOnDownloadButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(DownloadButton));
        element.click();
    }

    @Step("Validate Visibility of Rule Name error Message")
    public boolean ValidateVisibilityOfRuleNameErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(RuleNameErrorMessage));
            return driver.findElement(RuleNameErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate Visibility of Rule Brief error Message")
    public boolean ValidateVisibilityOfRuleBriefErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(RuleBriefErrorMessage));
            return driver.findElement(RuleBriefErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate Is Rule Name Field Accepting More Than 50 Characters")
    public boolean IsRuleNameFieldAcceptingMoreThan50Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(RuleNameField));
        driver.findElement(RuleNameField).click();
        String Text = driver.findElement(RuleNameField).getAttribute("value");
        return Text.length()>50;

    }


}



