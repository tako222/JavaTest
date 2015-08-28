package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {
    public static String fileString(String fileName) {
        InputStream is = ClassLoader.getSystemResourceAsStream(fileName);
        final StringBuilder fileString = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                fileString.append(line);
            }
        } catch (IOException e) {
        }
        return fileString.toString();
    }
}
