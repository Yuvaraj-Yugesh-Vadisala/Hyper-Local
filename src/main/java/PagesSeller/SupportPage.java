package PagesSeller;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SupportPage {


    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public SupportPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    final By SupportIcon = By.xpath("//a[contains(@id,'header-menu-support')]/descendant::span[contains(@class,'icon-support')]");

    final By CreateNewTicket = By.xpath("(//button[contains(@class,'table-fixed-btn')]/span)[1]");
    final By SubjectField = By.xpath("//div[contains(@class,'input-wrapper')]/descendant::input");
    final By ClassificationDropDownField = By.xpath("(//div[contains(@class,'os-select-dropdown')]/div)[2]");
    final String GenericOptionSelector = "(//div[contains(@id,'-option-')])[%d]";
    final By CCDropDownField = By.xpath("(//div[contains(@class,'os-select-dropdown')]/div)[3]");
    final By DescriptionIframe =By.xpath("//iframe[contains(@id,'tiny-react_')]");

    final By DescriptionField = By.xpath("//body[contains(@id,'tinymce')]/p");
    final By EditorLoader = By.xpath("//div[contains(@class,'rich-text-editor-loader')]/div");
    final By UploadFile = By.xpath("//div[contains(@class,'media-file-upload-btn-wrapper')]/descendant::input");
    final By UploadInProgress = By.xpath("//div[contains(@class,'media-progress-block upload-in-progress')]");
    final By CreateTicketButton = By.xpath("//button[contains(@class,'pendo-feature-kam-segment-creation-form-save-click')]");
    final By TicketCreatedSuccessPopUp = By.xpath("//div[contains(@class,'os-toast-message')]");
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By SearchTable = By.xpath("//div[contains(@class,'table-search-input')]/descendant::input");
    final By TableFirstRow = By.xpath("//tbody[contains(@role,'rowgroup')]/tr[contains(@role,'row')]");
    final By ViewDetailsButton = By.xpath("//td[contains(@class,'viewDetailsLink')]/button");
    final By TicketDetailsPage = By.xpath("//div[contains(@class,'list-detail-layout-container')]");
    final By SubjectEmptyErrorMessage = By.xpath("//div[contains(@class,'input-wrapper')]/parent::div/descendant::div[contains(@class,'name-error-message')]");
    final By ClassificationEmptyErrorMessage = By.xpath("//div[contains(@class,'os-drodown-wrapper   ')]/parent::div/descendant::div[contains(@class,'name-error-message')]");
    final By DescriptionEmptyErrorMessage = By.xpath("//div[contains(@class,'text-editor-wrapper')]/parent::div/descendant::div[contains(@class,'name-error-message')]");
    final By TicketFormEmptyErrorPopUp = By.xpath("//div[contains(@class,'os-toast-message')]");
    final By UploadedFileCloseButton = By.xpath("//span[contains(@class,'cursor-pointer')]/descendant::span[contains(@class,'icon-close1')]");

    @Step("Click on Support Icon")
    public void ClickOnSupportIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SupportIcon));
        driver.findElement(SupportIcon).click();
    }



    @Step("Click on Create New Ticket")
    public void ClickOnCreateNewTicket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateNewTicket));
        driver.findElement(CreateNewTicket).click();
    }


public String TicketName ;
    @Step("Enter Data in SubjectField Field")
    public void EnterDataInSubjectField(String Data,int Count) {
        wait.until(ExpectedConditions.elementToBeClickable(SubjectField));
        driver.findElement(SubjectField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        TicketName = String.valueOf(utils.generateRandomData(Data,Count));
        driver.switchTo().activeElement().sendKeys(TicketName);
    }


    @Step("Click on Classification DropDown Field")
    public void ClickOnClassificationDropDownField() {
        wait.until(ExpectedConditions.elementToBeClickable(ClassificationDropDownField));
        driver.findElement(ClassificationDropDownField).click();
    }



    @Step("Selecting Option from Drop Down")
    public void SelectOption(int Option) {
        By OptionSelector = By.xpath(String.format(GenericOptionSelector, Option));
        wait.until(ExpectedConditions.elementToBeClickable(OptionSelector)).click();
    }


    @Step("Enter Data in Classification Search Field")
    public void EnterDataInClassificationSearchField(String Data) {
        driver.switchTo().activeElement().sendKeys(Data);
    }



    @Step("Enter Data in CC Search Field")
    public void ClickOnCCDropDownField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(CCDropDownField));
        driver.findElement(CCDropDownField).click();
        driver.switchTo().activeElement().sendKeys(Data);

    }

      @Step("Enter Data in Description Field")
    public void EnterDataInDescriptionField(String Data) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(EditorLoader));
        WebElement Iframe = driver.findElement(DescriptionIframe);
        driver.switchTo().frame(Iframe);
        wait.until(ExpectedConditions.elementToBeClickable(DescriptionField));
        driver.findElement(DescriptionField).click();
        driver.switchTo().activeElement().sendKeys(Data);
        driver.switchTo().defaultContent();
    }

    @Step("Upload File in Attachment Field ")
    public void UploadFileInAttachmentField(String FileName) {
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Attachements')]"));
        Actions action = new Actions(driver);
        action.moveToElement( element).perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(UploadInProgress));
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "Pulse" + File.separator + FileName;
        driver.findElement(UploadFile).sendKeys(Filepath);
    }

    @Step("Click on Create Ticket Button")
    public void ClickOnCreateTicketButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateTicketButton));
        driver.findElement(CreateTicketButton).click();
    }


    @Step("Verify Ticket Created Successfull PopUp Is Displayed")

    public boolean VerifyTicketCreatedSuccessPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
            wait.until(ExpectedConditions.visibilityOfElementLocated(TicketCreatedSuccessPopUp));
            return driver.findElement(TicketCreatedSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }    }


    @Step("Enter Data in Search Field")
    public void EnterDataInSearchField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(SearchTable));
        driver.findElement(SearchTable).click();
        driver.switchTo().activeElement().sendKeys(Data);
    }


    @Step("Is Table First Row Displayed")
    public boolean IsTableFirstRowDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TableFirstRow));
            return driver.findElement(TableFirstRow).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



    @Step("Click on View Details Button")
    public void ClickOnViewDetailsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ViewDetailsButton));
        driver.findElement(ViewDetailsButton).click();
    }


    @Step("Is Ticket Details Page Displayed")
    public boolean IsTicketDetailsPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TicketDetailsPage));
            return driver.findElement(TicketDetailsPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



    @Step("Is Subject Empty Error Message Displayed")
    public boolean IsSubjectEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SubjectEmptyErrorMessage));
            return driver.findElement(SubjectEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Is Classification Empty Error Message Displayed")
    public boolean IsClassificationEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ClassificationEmptyErrorMessage));
            return driver.findElement(ClassificationEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



    @Step("Is Description Empty Error Message Displayed")
    public boolean IsDescriptionEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionEmptyErrorMessage));
            return driver.findElement(DescriptionEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Enter Spaces in Subject Field Field")
    public void EnterSpacesInSubjectField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(SubjectField));
        driver.findElement(SubjectField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Data);
    }


    @Step("Is Subject Field Accepting Empty Spaces As input")
    public boolean IsSubjectFieldAcceptingEmptySpacesAsInput() {
        wait.until(ExpectedConditions.elementToBeClickable(SubjectField));
        driver.findElement(SubjectField).click();
        String Text = driver.findElement(SubjectField).getDomAttribute("value");
        return Text.trim().isEmpty();
    }



    @Step("Verify Ticket Form Empty Error PopUp Is Displayed")
    public boolean VerifyTicketFormEmptyErrorPopUpIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TicketFormEmptyErrorPopUp));
            return driver.findElement(TicketFormEmptyErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

@Step("Is Upload File Field Visible After Uploading 5 Files")
    public boolean IsUploadFileFieldVisibleAfterUploading5Files() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(UploadFile));
            return driver.findElement(UploadFile).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Uploaded File Close Button")
    public void ClickOnUploadedFileCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(UploadedFileCloseButton));
        driver.findElement(UploadedFileCloseButton).click();
    }
}
