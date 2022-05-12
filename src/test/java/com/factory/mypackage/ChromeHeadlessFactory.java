package com.factory.mypackage;

import com.interfaces.mypackage.DriverInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeHeadlessFactory extends BaseFactory implements DriverInterface {

    @Override
    public WebDriver setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless","--window-size=1920,1200");
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver(options);
    }

    @Override
    public RemoteWebDriver setupRemoteDriver(String ipAddress) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless","--window-size=1920,1200");
        try {
            return new RemoteWebDriver(new URL("http://" + ipAddress + "/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}



