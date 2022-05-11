package com.factory.mypackage;

import com.interfaces.mypackage.DriverInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeFactory extends BaseFactory implements DriverInterface {

    @Override
    public WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return maximize(driver);
    }

    @Override
    public RemoteWebDriver setupRemoteDriver(String ipAddress) {
        ChromeOptions chromeOptions = new ChromeOptions();
        try {
            return new RemoteWebDriver(new URL("http://" + ipAddress + "/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
