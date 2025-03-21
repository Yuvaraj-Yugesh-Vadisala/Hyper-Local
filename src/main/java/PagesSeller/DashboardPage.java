package PagesSeller;

import UtilityClass.Utils;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils = new Utils(driver);

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    final By WeekView = By.xpath("//div[contains(@class,'pendo_feature_summary_chart_date_grouping_week')]");
    final By MonthView = By.xpath("//div[contains(@class,'pendo_feature_summary_chart_date_grouping_month')]");
    final By WeekViewSelected = By.xpath("//div[contains(@class,'checked pendo_feature_summary_chart_date_grouping_week')]");
    final By MonthViewSelected = By.xpath("//div[contains(@class,'checked pendo_feature_summary_chart_date_grouping_month')]");
    final By StatusFilter = By.xpath("//div[contains(@class,'pendo_feature_campaign_filter_dropdown')]");
    final String FilterOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By CampaignEditButton = By.xpath("(//button[contains(@class,'pendo_feature_campaign_candy_edit_budget_button')])[1]");
    final By CampaignEditPage = By.xpath("//div[contains(@class,'fixed-layout-header') and contains(text(),'Budget Settings')]");
    final By AnalyticsButton = By.xpath("(//button[contains(@class,'pendo_feature_campaign_candy_goal_performance_button')])[1]");
    final By AnalyticsPage = By.xpath("//div[contains(@class,'fixed-layout-header') and contains(text(),'Analytics')]");
    final By ViewAllCampaign = By.xpath("//button[contains(@class,'pendo_feature_campaign_card_view_all_button')]");
    final By AllCampaignTable = By.xpath("//div[contains(@class,'fixed-layout-header') and contains(text(),'All Campaigns')]");
    final By TopGoogleAds = By.xpath("//a[contains(@class,'pendo_feature_dashboard_client_performance_top')]");
    final By MeninxTab = By.xpath("//div[contains(@class,'link-wrapper')]/span[contains(text(),'Meninx')]");
    final By DateButton = By.xpath("//div[@class='date-range-input']");
    final By FirstDisplayMonthYear = By.xpath("(//div[@class='react-datepicker__current-month'])[1]");
    final By SecondDisplayMonthYear = By.xpath("(//div[@class='react-datepicker__current-month'])[2]");
    final String FirstDisplayMonthDays = "(//div[@class='react-datepicker__month-container'])" +
            "[1]/descendant::div[contains(@class,'react-datepicker__day') and @aria-disabled='false' and " +
            "not(contains(@class,'day--outside-month')) and text()='%d']";
    final String SecondDisplayMonthDays = "(//div[@class='react-datepicker__month-container'])" +
            "[2]/descendant::div[contains(@class,'react-datepicker__day') and @aria-disabled='false' and" +
            " not(contains(@class,'day--outside-month')) and text()='%d']";
    final By PreviousDateButton = By.xpath("//button[@aria-label='Previous Month']");
    final By NextDateButton = By.xpath("//button[@aria-label='Next Month']");
    final By CalenderApplyButton = By.xpath("//button[contains(@class,'pendo_feature_date_comparison_apply_button')]");
    final By SecondDateField = By.xpath("//div[contains(@class,'previous-date-range')]");


    @Step("Clicking on Week View")
    public void ClickWeekView() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WeekView));
        driver.findElement(WeekView).click();
    }

    @Step("Clicking on Month View")
    public void ClickOnMonthView() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MonthView));
        driver.findElement(MonthView).click();
    }

    @Step("Checking if Week View is selected")
    public boolean IsWeekViewSelected() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WeekViewSelected));
            return driver.findElement(WeekViewSelected).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Checking if Month View is selected")
    public boolean IsMonthViewSelected() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MonthViewSelected));
            return driver.findElement(MonthViewSelected).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting Desired Status")
    public void SelectDesiredStatus(int index) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.presenceOfElementLocated(StatusFilter));
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(StatusFilter));
        driver.findElement(StatusFilter).click();
        String statusXpath = String.format(FilterOptions, index);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(statusXpath)));
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(statusXpath)));
    }

    @Step("Clicking on Campaign Edit Button")
    public void ClickCampaignEditButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignEditButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(CampaignEditButton));
        js.executeScript("arguments[0].click();", driver.findElement((CampaignEditButton)));
    }

    @Step("Validate visibility of campaign edit page")
    public boolean ValidateVisibilityOfCampaignEditPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignEditPage));
            return driver.findElement(CampaignEditPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Campaign Edit Button")
    public void ClickAnalyticsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AnalyticsButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(StatusFilter));
        driver.findElement(AnalyticsButton).click();
    }

    @Step("Validate visibility of campaign edit page")
    public boolean ValidateVisibilityOfAnalyticsPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AnalyticsPage));
            return driver.findElement(AnalyticsPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on View all campaign button")
    public void ClickViewAllCampaign() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ViewAllCampaign));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(ViewAllCampaign));
        driver.findElement(ViewAllCampaign).click();
    }

    @Step("Validate visibility of all campaign table")
    public boolean ValidateVisibilityOfAllCampaignTable() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AllCampaignTable));
            return driver.findElement(AllCampaignTable).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on dashboard calender")
    public void ClickOnDashboardCalender() {
        wait.until(ExpectedConditions.elementToBeClickable(DateButton));
        driver.findElement(DateButton).click();
    }

    @Step("Clicking on the exact day")
    public void selectDay(int day, String dayPickerXpath) {
        String dayXPath = String.format(dayPickerXpath, day);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
        driver.findElement(By.xpath(dayXPath)).click();
    }


    @Step("Traversing to the start and end date using calender navigation buttons")
    public void selectDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        YearMonth targetMonthYear = YearMonth.from(date);
        LocalDate today = LocalDate.now().minus(1, ChronoUnit.DAYS);
        boolean outOfRange = false;

        while (true) {
            try {
                String firstDisplayedMonthYearStr = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstDisplayMonthYear)).getText();
                String secondDisplayedMonthYearStr = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondDisplayMonthYear)).getText();

                YearMonth firstDisplayedMonthYear = YearMonth.parse(firstDisplayedMonthYearStr, formatter);
                YearMonth secondDisplayedMonthYear = YearMonth.parse(secondDisplayedMonthYearStr, formatter);

                if (targetMonthYear.equals(firstDisplayedMonthYear)) {
                    selectDay(date.getDayOfMonth(), FirstDisplayMonthDays);
                    break;
                } else if (targetMonthYear.equals(secondDisplayedMonthYear)) {
                    selectDay(date.getDayOfMonth(), SecondDisplayMonthDays);
                    break;
                } else if (targetMonthYear.isBefore(firstDisplayedMonthYear)) {
//                    driver.findElement(PreviousDateButton).click();
                    WebElement prevButton = driver.findElement(PreviousDateButton);
                    if (!prevButton.isEnabled()) {
                        System.out.println("Previous date button is disabled. Selecting today's date instead.");
                        outOfRange = true;
                        break;
                    }
                    prevButton.click();
                } else
                    driver.findElement(NextDateButton).click();

            } catch (TimeoutException e) {
                System.out.println("The selected date " + date + " is out of range or disabled. Selecting today's date instead.");
                outOfRange = true;
                break;
            }

        }

        // If the selected date is out of range, select today's date
        if (outOfRange) {
            targetMonthYear = YearMonth.from(today);
            while (true) {
                try {
                    String firstDisplayedMonthYearStr = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstDisplayMonthYear)).getText();
                    String secondDisplayedMonthYearStr = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondDisplayMonthYear)).getText();

                    YearMonth firstDisplayedMonthYear = YearMonth.parse(firstDisplayedMonthYearStr, formatter);
                    YearMonth secondDisplayedMonthYear = YearMonth.parse(secondDisplayedMonthYearStr, formatter);

                    if (targetMonthYear.equals(firstDisplayedMonthYear)) {
                        selectDay(today.getDayOfMonth(), FirstDisplayMonthDays);
                        break;
                    } else if (targetMonthYear.equals(secondDisplayedMonthYear)) {
                        selectDay(today.getDayOfMonth(), SecondDisplayMonthDays);
                        break;
                    } else if (targetMonthYear.isBefore(firstDisplayedMonthYear)) {
                        driver.findElement(PreviousDateButton).click();
                    } else {
                        driver.findElement(NextDateButton).click();
                    }
                } catch (TimeoutException e) {
                    System.out.println("Error selecting today's date.");
                    break;
                }
            }
        }
    }


    @Step("Click on calender and taking date range from user")
    public void selectDateRange(LocalDate startDate, LocalDate endDate) {
        wait.until(ExpectedConditions.elementToBeClickable(DateButton));
        selectDate(startDate);
        selectDate(endDate);
    }

    @Step("Clicking on the Top Google Ads")
    public void ClickTopGoogleAds() {
        wait.until(ExpectedConditions.elementToBeClickable(TopGoogleAds));
        WebElement element = driver.findElement(TopGoogleAds);
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
        driver.findElement(TopGoogleAds).click();
    }

    @Step("Click on Meninx Tab")
    public void ClickMeninxTab() {
        wait.until(ExpectedConditions.elementToBeClickable(MeninxTab));
        driver.findElement(MeninxTab).click();
    }

}

