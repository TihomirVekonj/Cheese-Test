package com.factory.mypackage;

import com.interfaces.mypackage.DriverInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeHeadlessFactory extends BaseFactory implements DriverInterface {

    @Override
    public WebDriver setupDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless","--window-size=1920,1200");
        WebDriverManager.edgedriver().setup();

        return new EdgeDriver(options);
    }

    @Override
    public RemoteWebDriver setupRemoteDriver(String ipAddress) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless","--window-size=1920,1200");
        try {
            return new RemoteWebDriver(new URL("http://" + ipAddress + "/wd/hub"), edgeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
