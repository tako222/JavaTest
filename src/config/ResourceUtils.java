package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public enum ResourceUtils {
    RESOURCE("src/config/ApplicationResources.properties"),;

    final private Properties properties;

    private ResourceUtils(final String filePath) {
        properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * キーに該当する値を取得
     *
     * @param key キー
     * @return 該当値
     */
    public String getString(final String key) {
        return this.properties.getProperty(key);
    }

    /**
     * キーに該当する値をパラメータの箇所を置換した上で取得
     * ※パラメータの箇所は指定パラメータをキーとして該当する値がある場合はその値、
     * ない場合は指定パラメータを値としてそのまま置換
     *
     * @param key キー
     * @param params パラメータ
     * @return 該当値
     */
    public String getString(final String key, String... params) {
        String value = getString(key);
        for (int i = 0; i < params.length; i++) {
            final String param = getString(params[i]);
            if (StringUtils.isEmpty(param)) {
                value = value.replace("{" + i + "}", params[i]);
            } else {
                value = value.replace("{" + i + "}", param);
            }
        }
        return value;
    }
}
