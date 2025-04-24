package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

public class WebUtilities {
    //Declaration Of variables
    private WebDriver driver;;

    // GetDriver Method
    public WebDriver getWebDriver(){
        return  driver;
    }
    public void setDriver(String browser) {

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

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }


    // Navigate to Url Method
    public void navigateToUrl(String url){
//        driver.manage().deleteAllCookies();
        driver.get(url);


        driver.findElement(By.xpath("//button[normalize-space()='Add User']")).click();
    }

}
