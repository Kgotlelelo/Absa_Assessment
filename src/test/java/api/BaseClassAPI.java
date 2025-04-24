package api;

import api.reporting.ExtentReportUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClassAPI {

    protected CloseableHttpClient httpClient;

    @BeforeClass
    public void setUp() {
        // Initialize the HTTP client
        httpClient = HttpClients.createDefault();

        // Initialize the Extent Report
        ExtentReportUtil.setup();
    }

    @AfterClass
    public void tearDown() {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Finalize the Extent Report
        ExtentReportUtil.tearDown();
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