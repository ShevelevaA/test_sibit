import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);
    private UrlUtil urlUtil;

    public RemoteWebDriver getDefaultChromeDriver() {
        log.trace("Initialization default driver.");
        urlUtil = new UrlUtil();
        log.info("Connect to HUB: '{}'", urlUtil.getUrlProperty("url.hub"));
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(urlUtil.getUrlProperty("url.hub")),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
