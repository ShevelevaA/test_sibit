import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class UrlUtil {

    private static final Logger log = LoggerFactory.getLogger(UrlUtil.class);

    public String getUrlProperty(final String propertyName) {
        log.trace("Load property");
        Properties property = new Properties();
        try {
            property.load(this.getClass().getResourceAsStream("connection.properties"));
        } catch (IOException e) {
            log.error("Can't load 'connection.properties'.");
            e.printStackTrace();
        }
        return property.getProperty(propertyName);
    }
}
