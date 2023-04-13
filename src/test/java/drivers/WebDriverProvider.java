package drivers;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {
    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void initConfig() {
        if (config.getRemoteUrl() != null) {
            Configuration.remote = config.getRemoteUrl();
        }
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = option;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true));

        Configuration.browserCapabilities.merge(capabilities);

        Configuration.holdBrowserOpen = true;

    }
}
