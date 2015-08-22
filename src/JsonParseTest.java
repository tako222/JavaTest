import java.io.IOException;
import java.util.List;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
 
public class JsonParseTest {

    public static void test(){
        JsonObject jo = getWeatherResult();
        System.out.println(jo);
    }
    
    private static JsonObject getWeatherResult() {
 
        ApacheHttpTransport transport = new ApacheHttpTransport();
        HttpRequestFactory factory = transport
                .createRequestFactory(new HttpRequestInitializer() {
                    public void initialize(HttpRequest request) throws IOException {
                        request.setConnectTimeout(0);
                        request.setReadTimeout(0);
                        request.setParser(new JacksonFactory().createJsonObjectParser());
                    }
                });
 
        try {
            String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=400040";
            HttpRequest request = factory.buildGetRequest(new GenericUrl(url));
            HttpResponse response = request.execute();
            JsonObject json = response.parseAs(JsonObject.class);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public static class JsonObject {
        @Key//("pinpointLocations")
        public List<PinpointLocations> pinpointLocations;
 
        public static class PinpointLocations {
            @Key public String link;
            @Key public String name;
        }
        
        @Override
        public String toString() {
            StringBuilder temp = new StringBuilder();
            for (PinpointLocations pl : this.pinpointLocations) {
                temp.append("[link=").append(pl.link).append(", name=").append(pl.name).append("]\n");
            }
            return temp.toString();
        }
    }
}