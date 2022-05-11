package com.factory.mypackage;

import org.openqa.selenium.WebDriver;

public class BaseFactory {

    public WebDriver maximize(WebDriver driver) {
        driver.manage().window().maximize();
        return driver;
    }
}
