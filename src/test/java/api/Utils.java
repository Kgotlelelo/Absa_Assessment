package api;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class Utils {

    public static JsonObject sendGetRequest(CloseableHttpClient httpClient, String url) {
        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return JsonParser.parseString(result).getAsJsonObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}