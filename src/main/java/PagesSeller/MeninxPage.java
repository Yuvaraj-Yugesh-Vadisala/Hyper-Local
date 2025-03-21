package PagesSeller;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MeninxPage {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public MeninxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    final By CreateNewPost = By.xpath("//button[contains(@class,'create-new-post-btn')]/descendant::span[contains(text(),'Create New Post')]");
    final By PostName = By.xpath("(//div[contains(@class,'form-group')]/descendant::div[contains(@class,'input-wrapper')])[1]");
    final By ScheduleDate = By.xpath("(//div[contains(@class,'date-picker-input-wrapper')])[1]");
    final By TagFieldTemp = By.xpath("(//div[contains(@class,'form-group')]/descendant::div[contains(@class,'input-wrapper')])[3]");
    final By TagField= By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-add-tags')]/descendant::input)[2]");
    final By GoogleMyBusinessRadio = By.xpath("(//div[contains(@class,'checkbox-wrapper')]/label)[2]");
    final By NextButton = By.xpath("//button[contains(@class,'btn os-button')]/span[contains(text(),'Next')]");
    final By PublishPostButton = By.xpath("//button[contains(@class,'button')]/span[contains(text(),'Publish')]");
    final By MonthDropdown = By.xpath("//div[contains(@class,'select-dropdown os-mr month-dropdown')]");
    final By YearDropdown = By.xpath("//div[contains(@class,'year-dropdown')]");
    //    final By GenericHourField = By.xpath("//div[contains(@class,'pendo-track-time-picker-hour-dropdown')]");
    final By GenericHourFieldTemp = By.xpath("(//div[contains(@class,'os-hour-mins-wrapper')]/descendant::div[contains(@class,'Select__control')])[1]");
    final String GenericHourDropDown = "(//div[contains(@id,'-option-')])[%d]";
    //    final By GenericMinutesField = By.xpath("//div[contains(@class,'pendo-track-time-picker-minute-dropdown')]");
    final By GenericMinutesFieldTemp = By.xpath("(//div[contains(@class,'os-hour-mins-wrapper')]/descendant::div[contains(@class,'Select__control')])[2]");
    final String GenericMinutesDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final By MeridiemDropdown = By.xpath("(//div[contains(@class,'os-hour-mins-wrapper')]/descendant::div[contains(@class,'Select__control')])[3]");
    final By CalenderApplyButtonTemp = By.xpath("//button[contains(@class,'btn os-button')]/span[contains(text(),'Apply')]");
    final By SummaryField = By.xpath("//div[contains(@Class,'textarea-form-wrapper')]/descendant::textarea[contains(@placeholder,'Enter summary here')]");
    final String TemplateRadioButtons = "(//div[contains(@class,'post-template-selection not-selected-post')])[%d]";
    final String LibraryImages = "(//div[contains(@class,'media-library')]/descendant::div[contains(@class,'media-item')])[%d]";

    final By ChooseFromTemplate = By.xpath("(//div[contains(@class,'creative-template')]/descendant::span[contains(text(),'Choose')])[2]");  //Pendo needed
    final By ChooseFromTemplateEvents = By.xpath("(//div[contains(@class,'creative-template')]/descendant::span[contains(text(),'Choose')])[1]");
    final By ChooseFromLibrary = By.xpath("(//div[contains(@class,'creative-library')]/descendant::span[contains(text(),'Choose')])[1]");
    final By TemplateFilter = By.xpath("//button[contains(@class,'pendo_template_filters')]/div");
    final String TemplateFilterOption = ("//nav[contains(@class,'nav nav-tabs')]/descendant::span[contains(text(),'%s')]");
    final By GoogleCheckBox = By.xpath("//div[contains(@class,'checkbox-wrapper')]/input[contains(@id,'checkbox-google')]");
    final By FilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_global_filter_apply')]");
    final By TemplateChooseButton = By.xpath("//button[contains(@class,'button')]/span[contains(text(),'Choose')]");
    final By OverlayImageSaveButton = By.xpath("//button[contains(@class,'button')]/span[contains(text(),'Save')]");
    final By OverLay1ChooseTemplate = By.xpath("(//div[contains(@class,'creative-library-btn-block') and contains(text(),' creative from library')]/span[contains(text(),'Choose')])[1]");
    final By OverLay2ChooseTemplate = By.xpath("(//div[contains(@class,'creative-library-btn-block') and contains(text(),' creative from library')]/span[contains(text(),'Choose')])[2]");
    final By OverlayImageOption = By.xpath("(//div[contains(@class,'media-item not-selected')]/div)[1]");
    final By TemplateNameSearchField = By.xpath("//div[contains(@class,'contains-input-wrapper')]/descendant::input");
    final By TemplateNameSearchFieldTemp = By.xpath("(//nav[contains(@class,'nav nav-tabs')]/following-sibling::div[contains(@class,'tab-content')]/descendant::div[contains(@class,'input-wrapper')]/input)[2]");
    final By CTAField = By.xpath("//div[contains(@class,'Select__value-container css-1hwfws3')]");

    final By CTAUrlField = By.xpath("//div[contains(@class,'col-sm-12 inline-block padding')]/div[contains(@class,'input-wrapper')]");
    final By ConfigEditButton = By.xpath("(//div[contains(@class,'post-review-container')]/descendant::button)[1]");
    final By PostEditButton = By.xpath("(//div[contains(@class,'post-review-container')]/descendant::button)[2]");
    final By EventsRadio = By.xpath("(//div[contains(@class,'post-type-tab')]/descendant::div[contains(@class,'selection-tab')]/span)[2]");
    final By OfferRadio = By.xpath("(//div[contains(@class,'post-type-tab')]/descendant::div[contains(@class,'selection-tab')]/span)[3]");
    final By EventTitle = By.xpath("(//div[contains(@class,'gmb-standard-row')]/descendant::div[contains(@class,'input-wrapper')]/input)[1]");
    final By EventCTAUrl = By.xpath("(//div[contains(@class,'gmb-standard-row')]/descendant::div[contains(@class,'input-wrapper')]/input)[2]");
    final By EventScheduleDateRange = By.xpath("//div[contains(@class,'gmb-standard-row')]/descendant::div[contains(@class,'date-range-input')]/div");
    final By InvalidScheduleTimeErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'name-error-message')]/div)[1]");
    final By AddTagSavedData = By.xpath("//span[contains(@class,'pill')]/span");
    final By SummaryFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'post-summary')]/descendant::div[contains(@class,'error-msg name-error-message')]/div");
    final By CreativeMediaErrorLine = By.xpath("(//div[contains(@class,'creative-action-block is-creative-btn')])[1]");
    final By UrlEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'name-error-message')]/div)[4]");  //pendo
    final By CTAClearButton = By.xpath("//span[contains(@class,'clear-indicator')]");
    final By EventTitleEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')])[3]");
    final By EventScheduleDateEmptyErrorMessage = By.xpath("//div[contains(@class,'os-daterangepicker')]/following-sibling::div/div");
    final By CouponCode = By.xpath("(//div[contains(@class,'input-wrapper')])[4]");
    final By LinkToRedeemOffer = By.xpath("(//div[contains(@class,'input-wrapper')])[5]");
    final By TemplateNameSearchFieldTemp2 = By.xpath("(//nav[contains(@class,'nav nav-tabs')]/following-sibling::div[contains(@class,'tab-content')]/descendant::div[contains(@class,'input-wrapper')]/input)[4]");
    final By FaceBookCheckBox = By.xpath("//div[contains(@class,'checkbox-wrapper')]/input[contains(@id,'facebook')]");
    final String ImageCaptionField = ("(//div[contains(@class,'textarea-wrapper')]/textarea)[%d]");
    final By ImageCaptionErrorMessage = By.xpath("//div[contains(@class,'textarea-form-wrapper')]/following-sibling::div[contains(@class,'error-msg')]/div");
    final By CreativeSelectionField = By.xpath("(//div[contains(@class,'creative-action-block is-creative-btn')])[1]");
    final By MediaTypeDropdown = By.xpath("//div[contains(@class,'media-type-dropdown')]/descendant::div[contains(@class,'os-drodown-wrapper')]");
    final String MediaTypeOptions = ("(//div[contains(@class,'media-type-dropdown')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By VideoPostDescriptionField = By.xpath("//div[contains(@class,'textarea-form-group-wrapper post-summary video-description')]/descendant::div[contains(@class,'textarea-wrapper')]");
    final By VideoPostDescriptionFieldErrorMessage = By.xpath("//div[contains(@class,'textarea-form-group-wrapper post-summary video-description')]/descendant::div[contains(@class,'error-msg')]/div");
    final By VideoSelectorFieldErrorMessage = By.xpath("(//div[contains(@class,'creative-action-block is-creative-btn')])[1]");
    final By PostNameEmptyErrorMessage = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::div[contains(@class,'name-error-message')]/div)[1]");
    final By MultipleImagesRadioButton = By.xpath("(//div[contains(@class,'selection-tab')])[2]");
    final By PostCaptionField = By.xpath("(//div[contains(@class,'textarea-wrapper')])[1]");
    final By FacebookCheckBox = By.xpath("//div[contains(@class,'checkbox-wrapper')]/input[contains(@id,'checkbox-facebook')]");
    final By TemplateNameSearchFieldTemp3 = By.xpath("(//nav[contains(@class,'nav nav-tabs')]/following-sibling::div[contains(@class,'tab-content')]/descendant::div[contains(@class,'input-wrapper')]/input)[1]");
    final String SecondMultipleImage = ("(//div[contains(@class,'form-tabs')])[%d]");
    final By SuccessToast = By.xpath("//div[contains(@class,'toast-wrapper success-toast')]/div");
    final By ImageChooseButton = By.xpath("//div[contains(@class,'fixed-layout-footer')]/descendant::button/span[contains(text(),'Choose')]");
    final By CarousalAddButton = By.xpath("//div[contains(@class,'multi-form-header')]/descendant::button/span[contains(text(),'Add')]");
    final By VideoSelectorFromLibrary = By.xpath("(//div[contains(@class,'creative-action-block')]/descendant::span[contains(text(),'Choose')])[1]");
    final By VideoUploadField = By.xpath("(//div[contains(@class,'media-file-upload-btn-container')]/descendant::input)[1]");
    final By ThumbnailImageUploadField = By.xpath("(//div[contains(@class,'media-file-upload-btn-container')]/descendant::input)[1]");
    final By UploadProgressLoader = By.xpath("//span[contains(@class,'icon icon-loader')]");
    final By VideoTitleField = By.xpath("//div[contains(@class,'wrapper post-caption ')]/descendant::input");
    final By VideoTitleErrorMessage = By.xpath("//div[contains(@class,'wrapper post-caption')]/descendant::div[contains(@class,'error')]/div");
    final By CreativeDeleteButton = By.xpath("//div[contains(@class,'delete-icon icon icon-trash')]");
    final String CarousalDeleteButton = ("(//div[contains(@class,'multi-form-header')]/descendant::span[contains(@class,'remove')])[%d]");
    final By ConfirmationYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");


    @Step("Clicking on Create New Post")
    public void ClickOnCreateNewPost() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateNewPost));
        driver.findElement(CreateNewPost).click();
    }

    @Step("Entering Post Name")
    public void EnterPostName(String postName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PostName));
        driver.findElement(PostName).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(postName);
    }

    @Step("Selecting Google My Business")
    public void SelectGoogleMyBusiness() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GoogleMyBusinessRadio));
        driver.findElement(GoogleMyBusinessRadio).click();
    }

    @Step("Selecting Schedule Date")
    public void SelectScheduleDate(String month, String year, String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ScheduleDate));
        driver.findElement(ScheduleDate).click();
        wait.until(ExpectedConditions.elementToBeClickable(MonthDropdown));
        driver.findElement(MonthDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select') and contains(text(),'" + month + "')]")));
        driver.findElement(By.xpath("//div[contains(@id,'react-select') and contains(text(),'" + month + "')]")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(YearDropdown));
//        driver.findElement(YearDropdown).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(@class='Select__option Select__option--is-focused Select__option--is-selected css-tr4s17-option'  or @class='Select__option css-10wo9uf-option') and contains(text(),'" + year + "')]")));
//        WebElement element = driver.findElement(By.xpath("//div[(@class='Select__option Select__option--is-focused Select__option--is-selected css-tr4s17-option'  or @class='Select__option css-10wo9uf-option') and contains(text(),'" + year + "')]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0" + date + "') and not(contains(@class,'outside-month'))]")));
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0" + date + "') and not(contains(@class,'outside-month'))]")).click();
    }


    @Step("Selecting Time")
    public void TimeSelection(int Hour, int Minute, String meridiem) {
        wait.until(ExpectedConditions.elementToBeClickable(GenericHourFieldTemp));
        driver.findElement(GenericHourFieldTemp).click();

        String HourFormatter = String.format(GenericHourDropDown, Hour);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HourFormatter)));
        driver.findElement(By.xpath(HourFormatter)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(GenericMinutesFieldTemp));
        driver.findElement(GenericMinutesFieldTemp).click();

        String MinuteFormatter = String.format(GenericMinutesDropDown, Minute);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MinuteFormatter)));
        driver.findElement(By.xpath(MinuteFormatter)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MeridiemDropdown));
        driver.findElement(MeridiemDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'os-hour-mins-wrapper')]/descendant::div[contains(@class,'Select__option') and contains(text(),'" + meridiem + "')]"))).click();
    }

    @Step("Clicking on calender apply button")  //Temp
    public void ClickOnCalenderApplyButtonTemp() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CalenderApplyButtonTemp));
        driver.findElement(CalenderApplyButtonTemp).click();
    }

    @Step("Entering Tag ")
    public void EnterDesiredTextInTagField(String tag) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TagFieldTemp));
        driver.findElement(TagFieldTemp).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(tag);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }
    @Step("Entering Tag In Pulse")
    public void EnterDesiredTextInTag(String tag) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TagField));
        driver.findElement(TagField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(tag);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    @Step("Clicking on Next Button")
    public void ClickOnNextButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton));
        driver.findElement(NextButton).click();
    }



    @Step("Entering desired text in Summary Field")
    public void EnterSummary(String summary) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SummaryField));
        driver.findElement(SummaryField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(summary);
    }

    @Step("Clicking on Choose From Template")
    public void ClickOnChooseFromTemplate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChooseFromTemplate));
        driver.findElement(ChooseFromTemplate).click();
    }

    @Step("Clicking on Choose From Template when event is selected")
    public void ClickOnChooseFromTemplateEvents() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChooseFromTemplateEvents));
        driver.findElement(ChooseFromTemplateEvents).click();
    }

    @Step("Clicking on Choose From Template ")
    public void ClickOnChooseFromTemplateFacebook() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChooseFromTemplateEvents));
        driver.findElement(ChooseFromTemplateEvents).click();
    }

    @Step("Clicking on Choose From Library ")
    public void ClickOnChooseFromLibrary() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChooseFromLibrary));
        driver.findElement(ChooseFromLibrary).click();
    }

    @Step("Clicking on Template Filter")
    public void ClickOnTemplateFilter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateFilter));
        driver.findElement(TemplateFilter).click();
    }

    @Step("Selecting Template Filter")
    public void SelectTemplateFilterAttribute(String filterOption) {
        String XpathFormatter = String.format(TemplateFilterOption, filterOption);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Validate if Google checkbox is selected")
    public boolean ValidateGoogleCheckBox() {
        boolean isSelected = driver.findElement(GoogleCheckBox).isSelected();
        return isSelected;
    }

    @Step("Validate if FaceBook checkbox is selected")
    public boolean ValidateFaceBookCheckBoxIsSelected() {
        boolean isSelected = driver.findElement(FaceBookCheckBox).isSelected();
        return isSelected;
    }

    @Step("Clicking on Filter Apply Button")
    public void ClickOnFilterApplyButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FilterApplyButton));
        driver.findElement(FilterApplyButton).click();
    }

    @Step("Select desired Template")
    public void SelectTemplate(int templateNumber) {
        String TemplateRadioButton = String.format(TemplateRadioButtons, templateNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TemplateRadioButton)));
        driver.findElement(By.xpath(TemplateRadioButton)).click();
    }

    @Step("Clicking on Template Choose Button")
    public void ClickOnTemplateChooseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateChooseButton));
        driver.findElement(TemplateChooseButton).click();
    }

    @Step("Clicking on Overlay 1 Choose Template")
    public void ClickOnOverlay1ChooseTemplate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OverLay1ChooseTemplate));
        driver.findElement(OverLay1ChooseTemplate).click();
    }

    @Step("Selecting desired overlay image")
    public void SelectOverlayImage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OverlayImageOption));
        driver.findElement(OverlayImageOption).click();
    }

    @Step("Clicking on Overlay2 Choose Template")
    public void ClickOnOverlay2ChooseTemplate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OverLay2ChooseTemplate));
        driver.findElement(OverLay2ChooseTemplate).click();
    }

    @Step("Enter desired text in template name search field")
    public void EnterTemplateName(String templateName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateNameSearchField));
        Thread.sleep(2000);
        driver.findElement(TemplateNameSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(templateName);
    }

    @Step("Enter desired text in template name search field")
    public void EnterTemplateNameTemp(String templateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateNameSearchFieldTemp));
        driver.findElement(TemplateNameSearchFieldTemp).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(templateName);
    }

    @Step("Selecting CTA")
    public void SelectCTA(String CTA) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CTAField));
        driver.findElement(CTAField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(CTA);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    @Step("Entering CTA URL")
    public void EnterCTAUrl(String CTAUrl) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CTAUrlField));
        driver.findElement(CTAUrlField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(CTAUrl);
    }

    @Step("Clicking on Config Edit Button")
    public void ClickOnConfigEditButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConfigEditButton));
        driver.findElement(ConfigEditButton).click();
    }

    @Step("Clicking on Post Edit Button")
    public void ClickOnPostEditButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PostEditButton));
        driver.findElement(PostEditButton).click();
    }

    @Step("Clicking on Publish Post Button")
    public void ClickOnPublishPostButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PublishPostButton));
        driver.findElement(PublishPostButton).click();
    }

    @Step("Selecting Events Radio")
    public void SelectEventsRadio() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EventsRadio));
        driver.findElement(EventsRadio).click();
    }

    @Step("Selecting Offer Radio")
    public void SelectOfferRadio() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OfferRadio));
        driver.findElement(OfferRadio).click();
    }

    @Step("Entering Event Title")
    public void EnterEventTitle(String eventTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EventTitle));
        driver.findElement(EventTitle).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(eventTitle);
    }

    @Step("Entering Event CTA URL")
    public void EnterEventCTAUrl(String eventCTAUrl) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EventCTAUrl));
        driver.findElement(EventCTAUrl).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(eventCTAUrl);
    }

    @Step("Clicking on Event Schedule Date Range")
    public void ClickOnEventScheduleDateRange() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EventScheduleDateRange));
        driver.findElement(EventScheduleDateRange).click();
    }

    @Step("Enter desired Text in Image Caption")
    public void EnterDesiredTextInImageCaptionField(int index , String ImageCaption) {
        String XpathFormatter = String.format(ImageCaptionField, index);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(ImageCaption);
    }


    @Step("Validate Image Caption Error Message")
    public boolean ValidateVisibilityOfImageCaptionErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ImageCaptionErrorMessage));
            return driver.findElement(ImageCaptionErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }


    @Step("Checking if post name empty error message is displayed")
    public boolean IsPostNameEmptyErrorMessageDisplayed() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(PostNameEmptyErrorMessage));
            return driver.findElement(PostNameEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Is Post Name Field Accepts Only Spaces")
    public boolean IsPostNameFieldAcceptsOnlySpaces() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PostName));
            driver.findElement(PostName).click();
            String nameValue = driver.switchTo().activeElement().getAttribute("value");
            return nameValue.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Creative Selection Field Error Message")
    public boolean ValidateVisibilityOfErrorHighlightForCreativeSelectionField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.presenceOfElementLocated(CreativeSelectionField));
            String ClassName = driver.findElement(CreativeSelectionField).getDomAttribute("class");
            return ClassName.contains("error");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Is Post Name Field Accepts More Than 50 Characters")
    public boolean IsPostNameFieldAcceptsMoreThan50Characters() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PostName));
            driver.findElement(PostName).click();
            String nameValue = driver.switchTo().activeElement().getAttribute("value");
            System.out.println(nameValue);
            return nameValue.length() > 50;

        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Enter desired text in template name search field Multiple Facebook Images")
    public void EnterTemplateNameTemp3(String templateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateNameSearchFieldTemp3));
        driver.findElement(TemplateNameSearchFieldTemp3).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(templateName);
    }

    @Step("Selecting Multiple Images Radio")
    public void SelectMultipleImagesRadioButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MultipleImagesRadioButton));
        driver.findElement(MultipleImagesRadioButton).click();
    }

    @Step("Entering Post Caption")
    public void EnterPostCaption(String eventTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PostCaptionField));
        driver.findElement(PostCaptionField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(eventTitle);
    }

    @Step("Validate if Facebook checkbox is selected")
    public boolean ValidateFacebookCheckBox() {
        boolean isSelected = driver.findElement(FacebookCheckBox).isSelected();
        return isSelected;

    }

    @Step("Selecting desired carousal index")
    public void SelectDesiredCarousal(int index) {
        String XpathFormater = String.format(SecondMultipleImage,index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormater)));
        driver.findElement(By.xpath(XpathFormater)).click();
    }

    @Step("Checking if invalid schedule time error message is displayed")
    public boolean IsInvalidScheduleTimeErrorMessageDisplayed() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(InvalidScheduleTimeErrorMessage));
            return driver.findElement(InvalidScheduleTimeErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Is Empty Add tag is Visible")
    public boolean IsEmptyAddTagVisible() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(AddTagSavedData));
            return driver.findElement(AddTagSavedData).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Is Summary Field Accepts Empty Input")
    public boolean IsSummaryFieldAcceptsEmptyInput() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SummaryField));
            driver.findElement(SummaryField).click();
            String summaryValue = driver.switchTo().activeElement().getText();
            return summaryValue.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Is Summary Field Empty Error Message is Displayed")
    public boolean IsSummaryFieldEmptyErrorMessageDisplayed() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(SummaryFieldEmptyErrorMessage));
            return driver.findElement(SummaryFieldEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Is Creative Media Error Line is Displayed")
    public boolean IsCreativeMediaErrorLineDisplayed() {
        try {
            String Text = driver.findElement(CreativeMediaErrorLine).getDomAttribute("class");
            return Text.contains("has-error");
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Is URL Empty Error Message is Displayed")
    public boolean IsUrlEmptyErrorMessageDisplayed() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(UrlEmptyErrorMessage));
            return driver.findElement(UrlEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Clicking on CTA Close Button")
    public void ClickOnCTACloseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CTAClearButton));
        driver.findElement(CTAClearButton).click();
    }

    @Step("Is Event Title Empty Error Message is Displayed")
    public boolean IsEventTitleEmptyErrorMessageDisplayed() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(EventTitleEmptyErrorMessage));
            return driver.findElement(EventTitleEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Is Event Title Field Accepts Empty Input")
    public boolean IsEventTitleFieldAcceptsEmptyInput() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EventTitle));
            driver.findElement(EventTitle).click();
            String eventTitleValue = driver.switchTo().activeElement().getAttribute("value");
            return eventTitleValue.length() > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Is Event Schedule Date Empty Error Message is Displayed")
    public boolean IsEventScheduleDateEmptyErrorMessageDisplayed() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(EventScheduleDateEmptyErrorMessage));
            return driver.findElement(EventScheduleDateEmptyErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Entering Coupon Code")
    public void EnterCouponCode(String eventTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CouponCode));
        driver.findElement(CouponCode).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(eventTitle);
    }

    @Step("Entering LinkToRedeem Offer URL")
    public void EnterLinkToRedeemOfferURL(String eventCTAUrl) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LinkToRedeemOffer));
        driver.findElement(LinkToRedeemOffer).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(eventCTAUrl);
    }

    @Step("Enter desired text in template name search field Google Offer")
    public void EnterTemplateNameTemp2(String templateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateNameSearchFieldTemp2));
        driver.findElement(TemplateNameSearchFieldTemp2).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(templateName);
    }

    @Step("Selecting desired media type")
    public void SelectDesiredMediaType(int option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MediaTypeDropdown));
        driver.findElement(MediaTypeDropdown).click();
        String XpathFormatter = String.format(MediaTypeOptions, option);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Enter desired Text in Video Description field")
    public void EnterDesiredTextInVideoDescriptionField(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(VideoPostDescriptionField));
        driver.findElement(VideoPostDescriptionField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(text);
    }

    @Step("Validate Error Message for Video description Field")
    public boolean ValidateVideoDescriptionErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(VideoPostDescriptionFieldErrorMessage));
            return driver.findElement(VideoPostDescriptionFieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Error Highlight for Video Selector")
    public boolean ValidateVideoFieldIsHighlighted() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(VideoSelectorFieldErrorMessage));
            String Class = driver.findElement(VideoSelectorFieldErrorMessage).getDomAttribute("class");
            return Class.contains("error");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on the video selection choose button")
    public void ClickOnChooseVideoButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(VideoSelectorFromLibrary));
        driver.findElement(VideoSelectorFromLibrary).click();
    }

    @Step("Uploading desired video in video creative")
    public void UploadVideo(String FileName) {
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "Seller" + File.separator + FileName;
        wait.until(ExpectedConditions.presenceOfElementLocated(VideoUploadField));
        driver.findElement(VideoUploadField).sendKeys(Filepath);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(UploadProgressLoader));
    }

    @Step("Uploading desired  Image in video Thumbnail")
    public void UploadThumbnailImage(String FileName) {
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "Seller" + File.separator + FileName;
        wait.until(ExpectedConditions.presenceOfElementLocated(ThumbnailImageUploadField));
        driver.findElement(ThumbnailImageUploadField).sendKeys(Filepath);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(UploadProgressLoader));
    }

    @Step("Entering video title")
    public void EnterVideoTitle(String VideoTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(VideoTitleField));
        WebElement element = driver.findElement(VideoTitleField);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(VideoTitleField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(VideoTitle);
    }

    @Step("Validate Success message")
    public boolean ValidateSuccessToastMessage() {
        try {
            wait.until(visibilityOfElementLocated(SuccessToast));
            return driver.findElement(SuccessToast).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Video title Error message")
    public boolean ValidateVideoTitleErrorMessage() {
        try {
            wait.until(visibilityOfElementLocated(VideoTitleErrorMessage));
            return driver.findElement(VideoTitleErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Click on delete creative button")
    public void ClickOnDeleteButton(){
        wait.until(visibilityOfElementLocated(CreativeDeleteButton));
        driver.findElement(CreativeDeleteButton).click();
    }

    @Step("Select desired Template")
    public void SelectDesiredImage(int ImageIndex) {
        String Images = String.format(LibraryImages, ImageIndex);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Images)));
        driver.findElement(By.xpath(Images)).click();
    }
    @Step("Clicking on Choose From Image library")
    public void ClickOnChooseFromImageLibrary() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ImageChooseButton));
        driver.findElement(ImageChooseButton).click();
    }

    @Step("Clicking on Carousal Add Button")
    public void ClickOnCarousalAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CarousalAddButton));
        driver.findElement(CarousalAddButton).click();
    }

    @Step("Deleting Added carousal ")
    public void ClickOnDeleteCarousalButton(int index) {
        String XpathFormater= String.format(CarousalDeleteButton,index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormater)));
        WebElement element = driver.findElement(By.xpath(XpathFormater));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath(XpathFormater)).click();
    }

    @Step("Clicking on Confirmation yes Button")
    public void ClickOnConfirmationYesButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationYesButton));
        driver.findElement(ConfirmationYesButton).click();
    }
}
