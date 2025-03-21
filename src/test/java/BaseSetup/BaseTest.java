package BaseSetup;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static String HyperLocalSellerUrl = "https://hyperlocal-demo.onlinesales.ai/";
    public static String HyperLocalPulseUrl = "https://hyperlocal-demo-pulse.onlinesales.ai/";

    public String UserName = "ankit@frugaltesting.com";
    public String Password = "Frugal@123";
    public String Language = "en";



    public String HyperUAT = "5755390002c306f30da64f780d16ba50";
    public String HyperUATPulse = "7c7ea4dd30dd31a10a6dc55dbc92e928";


    public static WebDriver getDriver() {
        return driver.get();
    }

    public void Setup() {

        if (System.getProperty("HyperLocalSellerUrl") != null)
            HyperLocalSellerUrl = System.getProperty("HyperLocalSellerUrl");

        if (System.getProperty("HyperLocalPulseUrl") != null)
            HyperLocalPulseUrl = System.getProperty("HyperLocalPulseUrl");

        if (System.getProperty("Language") != null)
            Language = System.getProperty("Language");


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1280,720");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        if (!Language.equals("en")) {
            options.addArguments("--lang=" + Language);
        }
        driver.set(new ChromeDriver(options));
        getDriver().manage().window().maximize();
    }

    @BeforeSuite()
    public void setupEnvironment() throws IOException {
        File allureResultsDir = new File("allure-results");

        if (allureResultsDir.exists())
            deleteDirectory(allureResultsDir);

        allureResultsDir.mkdir();

        Properties props = new Properties();
        props.setProperty("HyperLocalSellerUrl", HyperLocalSellerUrl);
        props.setProperty("HyperLocalPulseUrl", HyperLocalPulseUrl);
        props.setProperty("Platform", System.getProperty("os.name"));

        try (FileWriter writer = new FileWriter("allure-results" + File.separator + "environment.properties")) {
            props.store(writer, "Test Environment Details");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void CheckingHyperUATToken() {
        RestAssured.baseURI = "https://osapi.onlinesales.ai/hadesV2";
        Response response = RestAssured.given()
                .queryParam("statusTypes[]", "ACTIVE")
                .queryParam("agencyId", "399")
                .queryParam("offset", "0")
                .queryParam("limit", "2")
                .header("Accept", "application/json")
                .header("Cache-Control", "no-cache")
                .header("Content-Type", "application/json")
                .header("Pragma", "no-cache")
                .header("Sec-Fetch-Mode", "cors")
                .header("x-referer", "platform")
                .header("x-ua-token", HyperUAT)
                .header("x-ubid", "unique12345")
                .get("/clients");
        System.out.println("Hyper Status code is : " + response.statusCode());
        if (response.statusCode() != 200) {
            Assert.fail("Invalid Hyper UAT token");
        }
    }


}
