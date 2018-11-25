import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ConfigurationTest {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationTest.class);
    private UrlUtil urlUtil;

    @BeforeSuite
    public void beforeSuite() {
        log.debug("BEFORE_SUITE: Init driver.");
        DriverFactory driverFactory = new DriverFactory();
        WebDriverRunner.setWebDriver(driverFactory.getDefaultChromeDriver());
    }

    @BeforeClass
    public void beforeClass() {
        log.debug("BEFORE_CLASS: Init UrlUtil.");
        urlUtil = new UrlUtil();
    }

    @BeforeMethod
    public void beforeMethod() {
        log.debug("BEFORE_METHOD: Open content.");
        WebDriver driver = WebDriverRunner.getWebDriver();
        String url = urlUtil.getUrlProperty("url.webapp");
        log.info("Connect to: '{}'", url);
        driver.get(url);
    }

    @AfterSuite
    public void afterSuite() {
        log.debug("AFTER_SUITE: Driver quit.");
        WebDriverRunner.getWebDriver().quit();
    }
}
