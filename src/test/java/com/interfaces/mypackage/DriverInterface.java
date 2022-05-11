package com.interfaces.mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface DriverInterface {
    WebDriver setupDriver();
    RemoteWebDriver setupRemoteDriver(String ipAddress);
}

