package api;

import api.reporting.ExtentReportUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class GoldenRetrieverImageTest extends BaseClassAPI {

    @Test
    public void GoldenRetrieverImageTest(){

        ExtentReportUtil.createTest("API request to produce a random image / link for the sub-breed “golden”");

       // String url = getConfigPropertyValue("Framework.properties", "apiUrl");
        String url = "https://dog.ceo/api/breed/retriever/golden/images/random";
        System.out.println("end point is as follows as "+url);

        JsonObject response = Utils.sendGetRequest(httpClient, url);

        if (response != null) {
            String imageUrl = response.get("message").getAsString();
            System.out.println("Random image of a golden retriever: " + imageUrl);
            ExtentReportUtil.logPass("Golden retriever image retrieved successfully: " + imageUrl);
        } else {
            ExtentReportUtil.logFail("Failed to retrieve golden retriever image.");
        }
    }

}
