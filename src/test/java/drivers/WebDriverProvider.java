package drivers;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverProvider {
    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void initConfig() {
        if (config.getRemoteUrl() != null) {
            Configuration.remote = config.getRemoteUrl();
        }
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();


//        Configuration.holdBrowserOpen = true;

    }
}
