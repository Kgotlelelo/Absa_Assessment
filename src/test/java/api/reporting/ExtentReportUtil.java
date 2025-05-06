package api.reporting;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportUtil {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setup() {
        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));;
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reporting/apiReporting/api_automation"+ datetime+".html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void tearDown() {
        extent.flush();
    }
}
