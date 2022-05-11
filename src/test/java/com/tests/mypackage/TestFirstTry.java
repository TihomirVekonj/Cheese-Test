package com.tests.mypackage;

import com.base.mypackage.TestBase;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.math.BigInteger;
import java.time.Duration;

public class TestFirstTry {

    @Test
    @Owner("Tihomir Vekonj")
    @DisplayName("First try")
    @Disabled
    public void testSelenium() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Digital Archer\\Work\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        String url = "https://www.google.com";
        driver.get(url);
        driver.findElement(By.name("q")).sendKeys("cheese");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        String resultsNo = driver.findElement(By.id("result-stats")).getText().split(" ")[1];
        String result = resultsNo.replace(".", "");

        //Big integers ought to be compared
        BigInteger newStat = new BigInteger(result);
        BigInteger checker = new BigInteger("1000000");

        //JUnit assertions
        Assertions.assertTrue(newStat.compareTo(checker)>0, "Error! There is less than 1M searches..");
        //Outputs 1 if the search results are greater than 1M, if not test fails???

        //with partialLinkText
        //driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();

        driver.findElement(By.cssSelector("h3:first-of-type")).click();
        String text = "Cheese is a dairy product produced in wide ranges of flavors, textures and forms by coagulation of the milk protein casein.";
        String firstParagraph = driver.findElement(By.cssSelector("p:nth-of-type(2)")).getText();

        Assertions.assertTrue(firstParagraph.contains(text), "This sentence is not present in the desired paragraph");
        //if it contains the sentence, outputs TRUE

        driver.quit();
    }
}
