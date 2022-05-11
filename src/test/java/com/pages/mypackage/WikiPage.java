package com.pages.mypackage;

import com.base.mypackage.BasePage;
import com.base.mypackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiPage extends BasePage {

    final private WebElement paragraphWiki = driver.findElement(By.cssSelector("p:nth-of-type(2)"));

    public WikiPage(WebDriver driver){
        super(driver);
    }

    public String checkParagraph(){
        return paragraphWiki.getText();
    }
}
