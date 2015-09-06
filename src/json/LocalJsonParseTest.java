package json;
import java.io.IOException;

import util.FileUtil;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.Key;

public class LocalJsonParseTest {
    public static void test() {
        String jsonFileString = FileUtil.fileString("resource.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Test obj = mapper.readValue(jsonFileString, Test.class);
            System.out.println(obj);
        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Test {
    @Key
    public int id;
    @Key
    public String name;

    @Override
    public String toString() {
        return "Test [id=" + id + ", name=" + name + "]";
    }
}
