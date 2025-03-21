package PagesSeller;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LMSPage {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(driver);

    public LMSPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    final By LeadsButton = By.xpath("(//a[contains(@class,'pendo_feature_header_nav')]/span)[1]");
    final By CallIcon = By.xpath("(//button[contains(@class,'pendo_feature_lms_v3_call_lead_button')]/span)[1]");
    final By WhatsappIcon = By.xpath("(//button[contains(@class,'pendo_feature_lms_v3_whatsapp_button')]/span)[1]");
    final By ToDoListIcon = By.xpath("(//button[contains(@class,'pendo_feature_lms_v3_reminder_button')])[1]");
    final By DatePickerField = By.xpath("(//div[contains(@class,'pendo_feature_lms_v3_reminder_date_picker')]/div)[1]");
    final By MonthField = By.xpath("(//div[contains(@class,'month-dropdown')]/div)[1]");
    final String GenericOptionSelector = "(//div[contains(@id,'-option-')])[%d]";
    final String DaySelector = "(//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))])[%d]";
    final By NoteField = By.xpath("//textarea[contains(@class,'pendo_feature_lms_v3_reminder_note_text_area')]");
    final By ToDoDoneButton = By.xpath("//button[contains(@class,'pendo_feature_lms_v3_reminder_save_button')]/span");
    final By NotesIcon = By.xpath("(//button[contains(@class,'pendo_feature_lms_v3_notes_button ')]/span)[1]");
    final By LeadNotesTextField = By.xpath("//div[contains(@class,'textarea-wrapper ')]/textarea");
    final By LeadsNoteSaveButton = By.xpath("(//button[contains(@class,'pendo_feature_lms_v3_notes_save_button')])[1]");
    final By Loader = By.xpath("//div[contains(@class,'overlay-loader-window-wrapper')]");
    final By ContactCopyIcon = By.xpath("(//span[contains(@class,'copy-to-clipboard-icon')])[1]");
    final By CopyContactSuccessPopUp = By.xpath("//div[contains(@class,'success-toast')]");
    final By FilterIcon = By.xpath("//div[contains(@class,'pendo_feature_lms_v3_filter')]/button");
    final String FilterOptions = "(//div[contains(@class,'available-filters')]/descendant::a)[%d]";
    final By FilterOptionsNameField = By.xpath("//div[contains(@class,'contains-input-wrapper')]/descendant::input");
    final By FilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_global_filter_apply')]");
    final By LeadCard = By.xpath("//div[contains(@class,'pendo_feature_lms_v3_lead_card lead-v3-card-wrapper') and contains(@class,'fully-loaded')]");
    final By ToDoListRadioButton = By.xpath("//div[contains(@class,'pendo_feature_lms_v3_pivot_by_todo_list')]/descendant::label");
    final By LeadCardName = By.xpath("(//div[contains(@class,'pendo_feature_lms_v3_lead_card lead-v3-card-wrapper')]/descendant::span)[1]");
    final By MarkAsDoneCheckBox = By.xpath("//div[contains(@class,'pendo_feature_lms_v3_mark_as_done_button')]/div");
    final By MarkAsDoneSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast-container--bottom-left')]/div");
    final By MarkAsDoneUndoButton = By.xpath("//button[contains(@class,'reminder-undo-button')]");
    final By CardStatusIcon = By.xpath("//div[contains(@class,'align-self-start')]/div");
    final By CardSectionSaveButton = By.xpath("(//button[contains(@class,'pendo_feature_lms_v3_save_lead_button')])");
    final By LeadUpdatedSuccessPopUp = By.xpath("//div[contains(@class,'toast-wrapper success-toast')]");
    final By CardStatusDropdown = By.xpath("//div[contains(@class,'pendo_feature_lms_v3_status')]/descendant::div[contains(@class,'os-select-dropdown ')]");
    final By FollowUpRadioButton = By.xpath("//input[contains(@id,'checkbox-leadStatus-Follow Up')]/parent::div/descendant::label");
    final By TestDriveScheduledRadioButton = By.xpath("//input[contains(@id,'checkbox-leadStatus-Test Drive Scheduled')]/parent::div/descendant::label");
    final By TestDriveCompleted = By.xpath("//input[contains(@id,'checkbox-leadStatus-Test Drive Completed')]/parent::div/descendant::label");
    final By NegotiationCheckBox = By.xpath("//input[contains(@id,'checkbox-leadStatus-Negotiation')]/parent::div/descendant::label");
    final By BookingDoneRadioButton = By.xpath("//input[contains(@id,'checkbox-leadStatus-Booking Done')]/parent::div/descendant::label");
    final By DownloadReportIcon = By.xpath("//button[contains(@class,'pendo_feature_lms_v3_download_leads_button')]");
    final By DisabledDownloadButton = By.xpath("//button[contains(@class,'btn os-button  btn-primary shape-cornor medium disabled    ')]");
    final By DownloadButton = By.xpath("//div[contains(@class,'file-download-status-bar')]/descendant::button");
    final By DownloadCloseButton = By.xpath("//span[contains(@class,'dismiss-icon')]");


    @Step("Click on Leads Button")
    public void ClickOnLeadsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LeadsButton)).click();
    }


    @Step("Click on Call Icon")
    public void ClickOnCallIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(CallIcon)).click();
    }

    @Step("Is Call Alert displayed")
    public boolean IsCallAlertDisplayed() throws InterruptedException {
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();
        return true;

    }

    @Step("Click on Whatsapp Icon")
    public void ClickOnWhatsappIcon() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(WhatsappIcon)).click();
        Thread.sleep(4000);
    }

    @Step("Is Whatsapp Page is displayed")
    public boolean IsWhatsappPageDisplayed() {
        String OriginalWindow = driver.getWindowHandle();
        for (String Handle : driver.getWindowHandles()) {
            driver.switchTo().window(Handle);
            if (!Handle.equals(OriginalWindow)) {
                driver.close();
                driver.switchTo().window(OriginalWindow);
                return true;

            }
        }
        return false;
    }

    @Step("Click on To Do List Icon")
    public void ClickOnToDoListIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(ToDoListIcon)).click();
    }

    @Step("Click on Date Picker Field")
    public void ClickOnDatePickerField() {
        wait.until(ExpectedConditions.elementToBeClickable(DatePickerField)).click();
    }

    @Step("Click on Month Field")
    public void ClickOnMonthField() {
        wait.until(ExpectedConditions.elementToBeClickable(MonthField)).click();
    }


    @Step("Selecting Month from Month Drop Down: {0}")
    public void SelectOption(int Option) {
        By OptionSelector = By.xpath(String.format(GenericOptionSelector, Option));
        wait.until(ExpectedConditions.elementToBeClickable(OptionSelector)).click();
    }

    @Step("Selecting Day from Date Picker: {0}")
    public void SelectDay(int DayNo) {
        By Day = By.xpath(String.format(DaySelector, DayNo));
        wait.until(ExpectedConditions.elementToBeClickable(Day)).click();
    }

    @Step("Enter Note in Note Field")
    public void EnterNoteInNoteField(String Note) {
        wait.until(ExpectedConditions.elementToBeClickable(NoteField)).click();
        driver.findElement(NoteField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(NoteField).sendKeys(Note);
    }

    @Step("Click on To Do Done Button")
    public void ClickOnToDoDoneButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ToDoDoneButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Loader));

    }

    @Step("Click on Notes Icon")
    public void ClickOnNotesIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(NotesIcon)).click();
    }


    @Step("Validate is To Do List Data is Reflected in Notes")
    public boolean IsToDoListDataReflectedInNotes(String Note) throws InterruptedException {
        Thread.sleep(2000);
        ClickOnNotesIcon();
        wait.until(ExpectedConditions.elementToBeClickable(LeadNotesTextField)).click();
        String Notes = driver.findElement(LeadNotesTextField).getText();
        return Notes.equals(Note);
    }

    @Step("Enter Data in Lead Notes Text Field")
    public void EnterDataInLeadNotesTextField(String Note) {
        wait.until(ExpectedConditions.elementToBeClickable(LeadNotesTextField)).click();
        driver.findElement(LeadNotesTextField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(LeadNotesTextField).sendKeys(Note);
    }

    @Step("Is Lead Notes Field Accepts Empty Space as Input")
    public boolean IsLeadNotesFieldAcceptsEmptySpace() {
        wait.until(ExpectedConditions.elementToBeClickable(LeadNotesTextField)).click();
        String Notes = driver.findElement(LeadNotesTextField).getText();
        return Notes.trim().isEmpty();
    }


    @Step("Click on Leads Note Save Button")
    public void ClickOnLeadsNoteSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LeadsNoteSaveButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Loader));
    }


    @Step("Click on Contact Copy Icon")
    public void ClickOnContactCopyIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(ContactCopyIcon)).click();
    }


    @Step("Is Copy Contact Success Pop Up Displayed")
    public boolean IsCopyContactSuccessPopUpDisplayed() {

        try {
            wait.until(visibilityOfElementLocated(CopyContactSuccessPopUp));
            return driver.findElement(CopyContactSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Filter Icon")
    public void ClickOnFilterIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterIcon)).click();
    }


    @Step("Selecting Name Filter Option")
    public void SelectNameFilterOption(int Option) {
        By FilterOption = By.xpath(String.format(FilterOptions, Option));
        wait.until(ExpectedConditions.elementToBeClickable(FilterOption)).click();
    }


    @Step("Enter Name in Filter Options")
    public void EnterNameInFilterOptions(String Name) {
        wait.until(ExpectedConditions.elementToBeClickable(FilterOptionsNameField)).click();
        driver.findElement(FilterOptionsNameField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(FilterOptionsNameField).sendKeys(Name);
    }


    @Step("Click on Filter Apply Button")
    public void ClickOnFilterApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FilterApplyButton)).click();
    }


    @Step("Is Lead Card Displayed")
    public boolean IsLeadCardDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LeadCard));
            return driver.findElement(LeadCard).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting current month in Date Picker")
    public void SelectCurrentMonthInDatePicker() {
        int CurrentMonthNumber = LocalDate.now().getMonthValue();
        By OptionSelector = By.xpath(String.format(GenericOptionSelector, CurrentMonthNumber));
        wait.until(ExpectedConditions.elementToBeClickable(OptionSelector)).click();
    }

    @Step("Selecting current day in Date Picker")
    public void SelectCurrentDay() {
        int CurrentDay = LocalDate.now().getDayOfMonth();
        By Day = By.xpath(String.format(DaySelector, CurrentDay));
        wait.until(ExpectedConditions.elementToBeClickable(Day)).click();
    }


    @Step("Click on To Do List Radio Button")
    public void ClickOnToDoListRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ToDoListRadioButton)).click();
    }


    @Step("Validate is Lead Card is Reflected in To Do List")
    public boolean IsLeadCardReflectedInToDoList(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LeadCard));
        String LeadName = driver.findElement(LeadCardName).getText();
        return LeadName.equals(Name);
    }


    @Step("Click on Mark As Done Check Box")
    public void ClickOnMarkAsDoneCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(MarkAsDoneCheckBox)).click();
    }


    @Step("Is Mark As Done Success Pop Up Displayed")
    public boolean IsMarkAsDoneSuccessPopUpDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(MarkAsDoneSuccessPopUp));
            return driver.findElement(MarkAsDoneSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Mark As Done Undo Button")
    public void ClickOnMarkAsDoneUndoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MarkAsDoneUndoButton)).click();
    }


    @Step("Click on Card Status Icon")
    public void ClickOnCardStatusIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(CardStatusIcon)).click();
    }


    @Step("Click on Card Section Save Button")
    public void ClickOnCardSectionSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CardSectionSaveButton)).click();
    }


    @Step("Is Lead Updated Success Pop Up Displayed")
    public boolean IsLeadUpdatedSuccessPopUpDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(LeadUpdatedSuccessPopUp));
            return driver.findElement(LeadUpdatedSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Card Status Dropdown")
    public void ClickOnCardStatusDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(CardStatusDropdown)).click();
    }


    @Step("Click on Follow Up Radio Button")
    public void ClickOnFollowUpRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FollowUpRadioButton)).click();
    }

    @Step("Validate is Lead Card is Reflected in Follow Up")
    public boolean IsLeadCardReflectedInFollowUp(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LeadCard));
        String LeadName = driver.findElement(LeadCardName).getText();
        return LeadName.equals(Name);
    }


    @Step("Click on Test Drive Scheduled Radio Button")
    public void ClickOnTestDriveScheduledRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(TestDriveScheduledRadioButton)).click();
    }


    @Step("Validate is Lead Card is Reflected in Test Drive Scheduled")
    public boolean IsLeadCardReflectedInTestDriveScheduled(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LeadCard));
        String LeadName = driver.findElement(LeadCardName).getText();
        return LeadName.equals(Name);
    }


    @Step("Click on Test Drive Completed Radio Button")
    public void ClickOnTestDriveCompletedRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(TestDriveCompleted)).click();
    }

    @Step("Validate is Lead Card is Reflected in Test Drive Completed")
    public boolean IsLeadCardReflectedInTestDriveCompleted(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LeadCard));
        String LeadName = driver.findElement(LeadCardName).getText();
        return LeadName.equals(Name);
    }


    @Step("Click on Negotiation Check Box")
    public void ClickOnNegotiationCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(NegotiationCheckBox)).click();
    }

    @Step("Validate is Lead Card is Reflected in Negotiation")
    public boolean IsLeadCardReflectedInNegotiation(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LeadCard));
        String LeadName = driver.findElement(LeadCardName).getText();
        return LeadName.equals(Name);
    }


    @Step("Click on Booking Done Radio Button")
    public void ClickOnBookingDoneRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BookingDoneRadioButton)).click();
    }

    @Step("Validate is Lead Card is Reflected in Booking Done")
    public boolean IsLeadCardReflectedInBookingDone(String Name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LeadCard));
        String LeadName = driver.findElement(LeadCardName).getText();
        return LeadName.equals(Name);
    }


    @Step("Click on Download Report Icon")
    public void ClickOnDownloadReportIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(DownloadReportIcon)).click();
    }


    @Step("Clicking on Download Button")
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

    @Step("Click on Download Close Button")
    public void ClickOnDownloadCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DownloadCloseButton)).click();
    }


    @Step("Is Download Enabled While no Lead Data Avaiable")
    public boolean IsDownloadEnabledWhileNoLeadDataAvailable() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DownloadReportIcon));
            String Text = driver.findElement(DownloadReportIcon).getDomAttribute("class");
            System.out.println("Text: " + Text);
            return Text.contains("disabled");
        } catch (Exception e) {
            return false;
        }
    }
}