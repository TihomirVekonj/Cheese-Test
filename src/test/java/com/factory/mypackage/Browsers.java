package com.factory.mypackage;

import com.enums.mypackage.BrowserEnums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browsers {

    public static WebDriver switchBrowser(BrowserEnums browserEnums) {
        switch (browserEnums) {
            case EDGE:
                return new EdgeFactory().setupDriver();
            case CHROME:
                return new ChromeFactory().setupDriver();
            case FIREFOX:
                return new FirefoxFactory().setupDriver();
        }
        throw new UnsupportedOperationException("Browser type is not supported!");
    }

    public static RemoteWebDriver switchBrowserRemote(BrowserEnums browserEnums, String ipAddress) {

        switch (browserEnums) {
            case EDGE:
                return new EdgeFactory().setupRemoteDriver(ipAddress);
            case CHROME:
                return new ChromeFactory().setupRemoteDriver(ipAddress);
            case FIREFOX:
                return new FirefoxFactory().setupRemoteDriver(ipAddress);
        }
        throw new UnsupportedOperationException("Browser type is not supported!");
    }
}