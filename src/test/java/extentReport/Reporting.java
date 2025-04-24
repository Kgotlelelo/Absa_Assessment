package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Reporting {

    public ExtentSparkReporter spark;
    public ExtentReports extent;

    // creates report
    public static ExtentReports initializeExtentReports(String ReportName){

        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));;
        //ExtentSparkReporter spark = new ExtentSparkReporter(ReportName);
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reporting/webReporting/"+ReportName+"_automation"+ datetime+".html");
        ExtentReports extent = new ExtentReports();


        extent.attachReporter(spark);
        return extent;





    }



    //capture screenshots
    public static Media CaptureScreenShot(WebDriver driver)throws IOException {

        System.out.println("Capture screenshot ");
        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(sFile)));
        String endcodedString = Base64.getEncoder().encodeToString(fileContent);
        return MediaEntityBuilder.createScreenCaptureFromBase64String(endcodedString).build();

       /* return null;*/
    }



}
