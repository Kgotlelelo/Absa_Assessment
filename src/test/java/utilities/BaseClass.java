package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import extentReport.Reporting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import pageObjects.UserPageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    WebActions webActions = new WebActions();
    public static ExtentReports repo;
    public static ExtentTest node;
    public Properties prop = new Properties();
    public static Scenario scenario;
    public Reporting reporting;

    public WebDriver launchbrowser(String url, String browser) throws Exception {

        System.out.println(browser);
        System.out.println(url);
       // String browser = "edge";

        java.util.Date date = new java.util.Date();
        System.out.println(new Timestamp(date.getTime()));
        reporting = new Reporting();
        repo = Reporting.initializeExtentReports("AssessmentReport.html");
        /*ExtentTest test = repo.createTest(scenario.getName() + new Timestamp(date.getTime())).assignAuthor("Kgotlelelo-Ratshoshi");*/
        ExtentTest test = repo.createTest("test" + new Timestamp(date.getTime())).assignAuthor("Kgotlelelo-Ratshoshi");
        node = test.createNode("ABSA Assessment");


           /* repo = Reporting.initializeExtentReports("reporting/AssessmentReport.html");
            ExtentTest test = repo.createTest("Assessment").assignAuthor("Kgotlelelo");
            node = test.createNode(scenario.getName());*/


        try {
            switch (browser.toUpperCase()) {
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    System.out.println("web driver launched");
                    break;
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.out.println("web driver launched");
                    break;
                case "EDGE":
                    //  WebDriverManager.edgedriver().browserVersion("135.0.3179.54").setup();
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                    options.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(); // declare delegate
                    System.out.println("web driver launched");
                    break;


            }
            driver.manage().window().maximize();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }


        Thread.sleep(2000);
        driver.get(url);
       // driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
        Thread.sleep(4000);
        System.out.println(driver);

        return driver;

    }



    public String getConfigPropertyValue(String propertyFileName, String propertyName) {
        String Value = null;
        try {
            FileInputStream fileIS = new FileInputStream(new File(propertyFileName));
            Properties prop = new Properties();
            prop.load(fileIS);

            Value = prop.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println("Unable to launch as Framework.Properties is not properly configured");
            System.exit(0);
        }

        return Value;
    }

    }

