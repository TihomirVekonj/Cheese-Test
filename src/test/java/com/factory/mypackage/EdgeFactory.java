package com.factory.mypackage;

import com.interfaces.mypackage.DriverInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class EdgeFactory extends BaseFactory implements DriverInterface {

    @Override
    public WebDriver setupDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return maximize(driver);
    }

    @Override
    public RemoteWebDriver setupRemoteDriver(String ipAddress) {
        EdgeOptions edgeOptions = new EdgeOptions();
        try {
            return new RemoteWebDriver(new URL("http://" + ipAddress + "/wd/hub"), edgeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
