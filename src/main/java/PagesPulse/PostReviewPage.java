package PagesPulse;

import UtilityClass.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class PostReviewPage {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(null);

    public PostReviewPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By PostReviewTab = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-presence-post_reviews_seller')]");
    final By ViewButton = By.xpath("(//button[contains(@class,'pendo_new_review_btn button')])[1]");
    final By ApproveButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/button/span[contains(text(),'Approve')])[2]");
    final By RejectButton = By.xpath("(//div[contains(@class,'fixed-layout-footer')]/button/span[contains(text(),'Reject')])[2]");
    final By ApproveSuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By RejectionSuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By SortByDropdown = By.xpath("(//div[contains(@class,'container-sort-wrapper')]/descendant::div[contains(@class,'posts-sort-dropdown')])[1]");
    final String SortByOptions = ("(//div[contains(@class,'container-sort-wrapper')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By ChannelDropdown = By.xpath("(//div[contains(@class,'container-filter-wrapper')]/descendant::div[contains(@class,'posts-sort-dropdown')])[1]");
    final By StatusDropdown = By.xpath("(//div[contains(@class,'container-filter-wrapper')]/descendant::div[contains(@class,'posts-sort-dropdown')])[2]");
    final String StatusOptions = ("(//div[contains(@class,'container-filter-wrapper')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By CommentField = By.xpath("//div[contains(@class,'review-comments-wrapper')]/descendant::textarea");
    final By CommentAndRejectButton = By.xpath("(//div[contains(@class,'review-comments-wrapper')]/descendant::button)[1]");
    final By AddCommentButton = By.xpath("(//button[contains(@class,'pendo_new_add-comment-btn button')])[1]");
    final By CommentOnlyButton = By.xpath("//div[contains(@class,'pendo_feature_review_comment_only_button')]");
    final By CommentDrawerCloseButton = By.xpath("//div[contains(@class,'drawer-open review-comment-drawer')]/descendant::label");


    @Step("Clicking on post Review Tab")
    public void ClickOnPostReviewTab() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PostReviewTab));
        element.click();
    }

    @Step("Clicking on View Button")
    public void ClickOnViewButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ViewButton));
        element.click();
    }

    @Step("Clicking on Approve Button")
    public void ClickOnApproveButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ApproveButton));
        element.click();
    }

    @Step("Clicking on Reject Button")
    public void ClickOnRejectButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(RejectButton));
        element.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }

    @Step("Verifying Approve Success Message")
    public boolean ValidateApproveSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ApproveSuccessMessage));
        return driver.findElement(ApproveSuccessMessage).isDisplayed();
    }

    @Step("Verifying Rejection Success Message")
    public boolean ValidateRejectSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RejectionSuccessMessage));
        return driver.findElement(RejectionSuccessMessage).isDisplayed();
    }

    @Step("Select desired channel from Dropdown")
    public void SelectChannel(String channel) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ChannelDropdown));
        element.click();
        By Channel = By.xpath("//div[contains(@class,'posts-sort-dropdown')]/descendant::div[contains(text(),'" + channel + "')]");
        WebElement channelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Channel));
        channelElement.click();
    }

    @Step("Sorting Post Table")
    public void SortPostTable(int index) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SortByDropdown));
        element.click();
        String XpathFormatter = String.format(SortByOptions ,index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired status from dropdown")
    public void SelectingDesiredStatus(int index) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(StatusDropdown));
        element.click();
        String XpathFormatter = String.format(StatusOptions ,index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering Comment in Comment Field")
    public void EnterComment(String comment) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CommentField));
        element.sendKeys(comment);
    }

    @Step("Clicking on Comment and Reject Button")
    public void ClickOnCommentAndRejectButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CommentAndRejectButton));
        element.click();
    }

    @Step("Clicking on Add comment Button")
    public void ClickOnAddCommentButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommentButton));
        element.click();
    }

    @Step("Clicking on commentOnly button")
    public void ClickOnAddCommentOnlyButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CommentOnlyButton));
        element.click();
    }
    @Step("Clicking on CommentOnly drawer close button")
    public void ClickOnCommentOnlyDrawerCloseButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CommentDrawerCloseButton));
        element.click();
    }

    @Step("Validate Comment error highlight")
    public boolean ValidateCommentErrorHighlight() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(CommentField));
            String Class = driver.findElement(CommentField).getDomAttribute("class");
            return Class.contains("error");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
