package PagesPulse;

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

public class PresencePage {

    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public PresencePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By PresenceTab = By.xpath("//div[contains(@class,'top-menu-section')]/a[contains(@href,'presence')]/div");
    final By PostTemplates = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-presence-post_templates')]/div");
    final By CreateNewTemplateButton = By.xpath("//button[contains(@class,'pendo_add_new_post_template_btn')]");
    final By TemplateNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-name')]/descendant::input");
    final By TemplateNameFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-name')]/descendant::div[contains(@class,'error')]/div");
    final By TemplateDescriptionField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-description')]/descendant::textarea");
    final By TemplateImageUploadSection = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-image')]/descendant::input");
    final By TemplateImageErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-image')]/descendant::div[contains(@class,'error')]/div");
    final By AddImageOverlayButton = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-template-image')]/descendant::button");
    final By AddOverlayButton = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component')]/descendant::div[contains(@class,'overlay-btn')]/div");
    final By OverlayImageOption = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component')]/descendant::a[contains(@class,'dropdown-item')])[1]");
    final By OverlayTextOption = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component')]/descendant::a[contains(@class,'dropdown-item')])[2]");
    final String OverlayNameField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-overlay-name')]/descendant::input[contains(@placeholder,'Overlay name')])[%d]");
    final By OverLayNameFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-overlay-name')]/descendant::div[contains(@class,'error')]/div");
    final By FacebookChannel = By.xpath("//a[contains(@class,'pendo_new_facebook_template_tab nav-item nav-link')]/div");
    final String XCoordinateField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-x-coordinate')]/descendant::input)[%d]");
    final By XCoordinateFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-x-coordinate')]/descendant::div[contains(@class,'error')]/div");
    final String YCoordinateField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-y-coordinate')]/descendant::input)[%d]");
    final By YCoordinateFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-y-coordinate')]/descendant::div[contains(@class,'error')]/div");
    final String WidthField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-width')]/descendant::input)[%d]");
    final By WidthFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-width')]/descendant::div[contains(@class,'error')]/div");
    final String HeightField = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-height')]/descendant::input)[%d]");
    final By HeightFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-height')]/descendant::div[contains(@class,'error')]/div");
    final By OverLayDeleteButton = By.xpath("(//div[contains(@class,'pendo_track_multiform_sub_component_delete_button')])[3]");
    final By GravityDropdown = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-gravity')]/descendant::button)[1]");
    final String GravityDropdownOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-gravity')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By ConfirmationYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By FontDropdown = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-font')]/descendant::button)[1]");
    final By FontSearchField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-font')]/descendant::input");
    final String FontOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-font')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By FontSizeField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-font-size')]/descendant::input");
    final By FontTypeDropdown = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-fonttype')]/descendant::button");
    final String FontTypes = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-fonttype')]/descendant::div[contains(@class,'option')])[%d]");
    final String ColorOptions = ("(//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-color')]/descendant::div[contains(@class,'option')])[%d]");
    final By ColorDropdown = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-imageoverlay-1-color')]/descendant::button");
    final By SaveButton = By.xpath("//div[contains(@class,'fixed-layout post-template-image-on-overlay-wrapper')]/descendant::button[contains(@class,'button')]/span[contains(text(),'Save')]");
    final By AddTemplateButton = By.xpath("//button[contains(@class,'button')]/span[contains(text(),'Add Template')]");
    final By PostTemplateCreationSuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By TemplateStatusToggle = By.xpath("(//label[contains(@class,'os-toggle-switch-container')]/span)[1]");


    @Step("Clicking on presence tab")
    public void ClickOnPresenceTab() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PresenceTab));
        element.click();
    }

    @Step("Clicking on facebook tab")
    public void SelectFacebookChannel() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(FacebookChannel));
        element.click();
    }

    @Step("Clicking on Post Template section")
    public void ClickOnPostTemplateSection() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PostTemplates));
        element.click();
    }

    @Step("Clicking on Create New Template button")
    public void ClickOnCreateNewTemplateButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CreateNewTemplateButton));
        element.click();
    }

    @Step("Entering template name")
    public void EnterTemplateName(String templateName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(TemplateNameField));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(templateName);
    }

    @Step("Entering template description")
    public void EnterTemplateDescription(String templateDescription) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(TemplateDescriptionField));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(templateDescription);
    }

    @Step("Uploading template image")
    public void UploadTemplateImage(String ImageName) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(TemplateImageUploadSection));
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "Pulse" + File.separator + ImageName;
        element.sendKeys(Filepath);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }

    @Step("Clicking on Add Image Overlay button")
    public void ClickOnAddImageOverlayButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddImageOverlayButton));
        element.click();
    }

    @Step("Clicking on Add Overlay button")
    public void ClickOnAddOverlayButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddOverlayButton));
        element.click();
    }

    @Step("Clicking on Add Overlay image option")
    public void ClickOnAddOverlayImageOption() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(OverlayImageOption));
        element.click();
    }

    @Step("Clicking on Add Overlay text option")
    public void ClickOnAddOverlayTextOption() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(OverlayTextOption));
        element.click();
    }

    @Step("Adding desired overlay Name")
    public void EnterOverlayName(int index, String OverlayName) {
        String XpathFormatter = String.format(OverlayNameField, index);
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(OverlayName);
    }


    @Step("Entering X Coordinate")
    public void EnterXCoordinate(String XCoordinate, int index) {
        String XpathFormatter = String.format(XCoordinateField, index);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(XCoordinate);
    }

    @Step("Entering Y Coordinate")
    public void EnterYCoordinate(String YCoordinate, int index) {
        String XpathFormatter = String.format(YCoordinateField, index);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(YCoordinate);
    }

    @Step("Entering desired width")
    public void EnterDesiredWidth(String Width, int index) {
        String XpathFormatter = String.format(WidthField, index);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(Width);
    }

    @Step("Entering desired height")
    public void EnterDesiredHeight(String height, int index) {
        String XpathFormatter = String.format(HeightField, index);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(height);
    }

    @Step("Clicking on overlay delete button")
    public void ClickOnOverlayDeleteButton() {
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(OverLayDeleteButton));
        actions.moveToElement(element).perform();
        element.click();
    }

    @Step("Selecting desired gravity")
    public void SelectGravity(int GravityIndex) throws InterruptedException {
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(GravityDropdown));
        actions.moveToElement(element).perform();
        element.click();
        String XpathFormatter = String.format(GravityDropdownOptions, GravityIndex);
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        js.executeScript("arguments[0].click();", element2);
    }

    @Step("Selecting desired font")
    public void SelectFont(int FontIndex, String FontName) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement Dropdown = wait.until(ExpectedConditions.elementToBeClickable(FontDropdown));
        actions.moveToElement(Dropdown).perform();
        Dropdown.click();
        WebElement SearchField = wait.until(ExpectedConditions.elementToBeClickable(FontSearchField));
        SearchField.click();
        SearchField.sendKeys(controlOrCommandKey + "A");
        SearchField.sendKeys(FontName);
        String XpathFormatter = String.format(FontOptions, FontIndex);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Clicking on confirmation yes button")
    public void ClickOnConfirmationYesButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ConfirmationYesButton));
        element.click();
    }

    @Step("Entering desired font size")
    public void EnterFontSize(String FontSize) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(FontSizeField));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(FontSize);
    }

    @Step("Selecting desired font type")
    public void SelectFontType(int FontTypeIndex) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement Dropdown = wait.until(ExpectedConditions.elementToBeClickable(FontTypeDropdown));
        actions.moveToElement(Dropdown).perform();
        Dropdown.click();
        String XpathFormatter = String.format(FontTypes, FontTypeIndex);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
//        WebElement DeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(OverLayDeleteButton));
//        actions.moveToElement(DeleteButton).perform();
//        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Selecting desired color")
    public void SelectColor(int ColorIndex) {
        Actions actions = new Actions(driver);
//        try {
        WebElement Dropdown = wait.until(ExpectedConditions.elementToBeClickable(ColorDropdown));
        actions.moveToElement(Dropdown).perform();
        Dropdown.click();
        String XpathFormatter = String.format(ColorOptions, ColorIndex);
        WebElement element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter))));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

//        } catch (StaleElementReferenceException e) {
//            System.out.println("StaleElementReferenceException caught. Retrying...");
//            WebElement Dropdown = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ColorDropdown)));
//            Dropdown.click();
//            String XpathFormatter = String.format(ColorOptions, ColorIndex);
//            WebElement element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter))));
//            element.click();
//        }
    }

    @Step("Clicking Save Button")
    public void ClickOnSaveButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        element.click();
    }

    @Step("Clicking Add Template Button")
    public void ClickOnAddTemplateButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddTemplateButton));
        element.click();
    }

    @Step("Validate Template creation Success Toast Message")
    public boolean ValidateSuccessMessageForTemplateCreation() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(PostTemplateCreationSuccessMessage));
            return driver.findElement(PostTemplateCreationSuccessMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Toggling template status")
    public void ToggleTemplateStatus() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(TemplateStatusToggle));
        element.click();
    }

    @Step("Validate Template Name Error Message")
    public boolean ValidateErrorMessageForTemplateNameField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(TemplateNameFieldErrorMessage));
            return driver.findElement(TemplateNameFieldErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate Template image Error Message")
    public boolean ValidateErrorMessageForTemplateImageField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(TemplateImageErrorMessage));
            return driver.findElement(TemplateImageErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
    @Step("Validate overlay Name Field Error Message")
    public boolean ValidateErrorMessageForOverlayNameField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(OverLayNameFieldErrorMessage));
            return driver.findElement(OverLayNameFieldErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate X Coordinate Field Error Message")
    public boolean ValidateXCoordinateFieldErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(XCoordinateFieldErrorMessage));
            return driver.findElement(XCoordinateFieldErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate Y Coordinate Field Error Message")
    public boolean ValidateYCoordinateFieldErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(YCoordinateFieldErrorMessage));
            return driver.findElement(YCoordinateFieldErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate Width Field Error Message")
    public boolean ValidateWidthFieldErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(WidthFieldErrorMessage));
            return driver.findElement(WidthFieldErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    @Step("Validate Height Field Error Message")
    public boolean ValidateHeightFieldErrorMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(HeightFieldErrorMessage));
            return driver.findElement(HeightFieldErrorMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }





    //PostCreation---------------------------------------------------------------------------------------------------------------------

    final By PostManagementTab = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-presence-post_management')]/descendant::label");
    final By CreateNewPostButton = By.xpath("//button[contains(@class,'button create-new-post-btn')]");
    final By PostNameField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-post-name')]/descendant::input)[2]");
    final By AddPartnersButton = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-partners')]/descendant::div[contains(@class,'outlet-selection-filed')])[3]");
    final String PartnerCheckboxes = ("(//div[contains(@class,'single-select-checkbox')])[%d]");
    final By PartnerSaveButton = By.xpath("//div[contains(@class,'fixed-layout-footer')]/button");
    final By SuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By PartnerFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-partners')]/descendant::div[contains(@class,'error')]/div");
    final By VideoTitleErrorMessage = By.xpath("//div[contains(@class,' pendo-event-tracker-common-form-component-video-title')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By VideoTitleField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-video-title')]/descendant::input");
    final By VideoPostDescriptionFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-post-description')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By ImageCaptionErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-image-caption')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]/div");
    final By NextButton2 = By.xpath("(//button[contains(@class,'button')]/span[contains(text(),'Next')])[2]");
    final By CalenderApplyButton = By.xpath("//button[contains(@class,'pendo-track-time-picker-apply-button')]");
    final By VideoSelectorFieldErrorMessage = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-video')]/div[contains(@class,'creative-action-block is-creative-btn')])[1]");



    @Step("Clicking on Post Management tab")
    public void ClickOnPostManagementTab() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PostManagementTab));
        element.click();
    }

    @Step("Clicking on Create New Post Button")
    public void ClickOnCreateNewPost() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CreateNewPostButton));
        element.click();
    }

    @Step("Entering desires Post Name")
    public void EnterPostName(String PostName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PostNameField));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(PostName);
    }

    @Step("Clicking on Add Partner Button")
    public void ClickOnAddPartnerButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddPartnersButton));
        element.click();
    }

    @Step("Selecting desired partners")
    public void SelectPartners(int PartnerIndex) {
        String XpathFormatter = String.format(PartnerCheckboxes, PartnerIndex);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        element.click();
    }

    @Step("Clicking on  Partner Save Button")
    public void ClickOnPartnerSaveButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PartnerSaveButton));
        element.click();
    }

    @Step("Validate Success message")
    public boolean ValidateSuccessMessage() {
        try {
            wait.until(visibilityOfElementLocated(SuccessMessage));
            return driver.findElement(SuccessMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Error message for partner field")
    public boolean ValidateErrorMessageForPartnerField() {
        try {
            wait.until(visibilityOfElementLocated(PartnerFieldErrorMessage));
            return driver.findElement(PartnerFieldErrorMessage).isDisplayed();
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

    @Step("Clicking on Next Button")
    public void ClickOnNextButtonTemp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton2));
        driver.findElement(NextButton2).click();
    }

    @Step("Clicking on calender apply button")
    public void ClickOnCalenderApplyButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CalenderApplyButton));
        driver.findElement(CalenderApplyButton).click();
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

    final By GoogleReviewTab = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-presence-configuration_google_review_auto')]");
    final String EditButtons = ("//button/span[contains(@class,'icon-edit1  iconbtn')]");
    final By ResponseField = By.xpath("//td[contains(@class,'responsesRule')]/descendant::input");
    final By ResponseSaveButton = By.xpath("//button/span[contains(text(),'Save')]");
    final By ResponseClearButton = By.xpath("//button/span[contains(text(),'Clear')]");
    final By ResponseSaveSuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By ResponseFieldErrorBorder = By.xpath("//td[contains(@class,'responsesRule')]/div");



    @Step("Clicking on Google Review Tab")
    public void ClickOnGoogleReviewTab() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(GoogleReviewTab));
        element.click();
    }

    @Step("Clicking on Edit Button")
    public void ClickOnEditButton(int index) {
        String XpathFormatter = String.format(EditButtons, index);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        element.click();
    }

    @Step("Entering Response")
    public void EnterResponse(String Response) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ResponseField));
        element.click();
        element.sendKeys(controlOrCommandKey + "A");
        element.sendKeys(Response);
    }

    @Step("Clicking on response Save Button")
    public void ClickOnResponseSaveButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ResponseSaveButton));
        element.click();
    }

    @Step("Clicking on response Clear Button")
    public void ClickOnResponseClearButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ResponseClearButton));
        element.click();
    }

    @Step("Validate Response Save Success Message")
    public boolean ValidateResponseSaveSuccessMessage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ResponseSaveSuccessMessage));
            return driver.findElement(ResponseSaveSuccessMessage).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
    @Step("Validate visibility of error border for response field")
    public boolean ValidateErrorBorderOfResponseField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.presenceOfElementLocated(ResponseFieldErrorBorder));
            String ClassName = driver.findElement(ResponseFieldErrorBorder).getDomAttribute("class");
            return ClassName.contains("error");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Response field accepting only spaces")
    public boolean ValidateResponseFieldAcceptingOnlySpaces() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.presenceOfElementLocated(ResponseField));
            String FieldContains = driver.findElement(ResponseField).getText();
            return FieldContains.length()>0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}
