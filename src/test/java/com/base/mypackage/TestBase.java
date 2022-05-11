package com.base.mypackage;

import com.enums.mypackage.BrowserEnums;
import com.extensions.mypackage.ScreenshotExtension;
import com.factory.mypackage.Browsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;

@ExtendWith(ScreenshotExtension.class)
public abstract class TestBase {

    public static String browser = System.getProperty("browser");
    public static String driverType = System.getProperty("remote");
    public static String ipAddress = System.getProperty("ip");
    private static final BrowserEnums DEFAULT_BROWSER = BrowserEnums.CHROME;
    private static final String DEFAULT_IP_ADDRESS = "192.168.0.132:4444";
    public static WebDriver driver = getDriverType(driverType);
    public WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

    @BeforeEach
    public void startDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterEach
    public void closeDriver() {
//        driver.close();
    }

    public  WebDriver getDriver() {
        return driver;
    }

    private static BrowserEnums getBrowserEnum(String browser) {
        for(BrowserEnums enumValues : BrowserEnums.values()) {
            if(enumValues.stringBrowser.equalsIgnoreCase(browser)) {
                return enumValues;
            }
        }
        return DEFAULT_BROWSER;
    }

    private static WebDriver getDriverType(String driverString) {
        if(Objects.equals(driverString, "true")) {
            if(ipAddress==null) {
                ipAddress = DEFAULT_IP_ADDRESS;
            }
            driver = Browsers.switchBrowserRemote(getBrowserEnum(browser),ipAddress);
        } else{
            driver = Browsers.switchBrowser(getBrowserEnum(browser));
        }
        return driver;
    }
}
