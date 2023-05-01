package config;

import org.aeonbits.owner.Config;
@EmulationConfig.LoadPolicy(EmulationConfig.LoadType.MERGE)
@Config.Sources({
        "classpath:${env}.properties"
})

public interface EmulationConfig extends Config {
    @Key("appiumServer")
    String appiumServer();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String getOsVersion();

    @Key("appPath")
    String appPath();
    @Key("appUrl")
    String appUrl();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}
