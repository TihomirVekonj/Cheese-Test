package com.factory.mypackage;

import com.interfaces.mypackage.DriverInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxFactory extends BaseFactory implements DriverInterface {

    @Override
    public WebDriver setupDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return maximize(driver);
    }

    @Override
    public RemoteWebDriver setupRemoteDriver(String ipAddress) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        try {
            return new RemoteWebDriver(new URL("http://" + ipAddress + "/wd/hub"), firefoxOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
