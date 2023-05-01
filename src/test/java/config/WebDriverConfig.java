package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})
public interface WebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("Chrome")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();
}
