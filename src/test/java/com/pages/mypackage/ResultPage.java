package com.pages.mypackage;

import com.base.mypackage.BasePage;
import com.base.mypackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.math.BigInteger;


public class ResultPage extends BasePage {

    private final WebElement resultStats = driver.findElement(By.id("result-stats"));
    private final WebElement firstCheeseSearchResult = driver.findElement(By.cssSelector("h3:first-of-type"));

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public BigInteger findResultNumber() {
        String resultsNo = resultStats.getText().split(" ")[1];
        String result = resultsNo.replace(".", "");
        return new BigInteger(result);
    }

    public WikiPage clickFirstResult() {
        firstCheeseSearchResult.click();
        return new WikiPage(driver);
    }

}