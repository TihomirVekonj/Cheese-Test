package com.pages.mypackage;

import com.base.mypackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {

    private final WebElement resultStats = driver.findElement(By.name("q"));

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public ResultPage searchWord() {
        resultStats.sendKeys("cheese");
        resultStats.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }

}
