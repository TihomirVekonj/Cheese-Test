package com.tests.mypackage;
import com.base.mypackage.TestBase;
import com.pages.mypackage.GooglePage;
import com.pages.mypackage.ResultPage;
import com.pages.mypackage.WikiPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class CheeseTest extends TestBase {

    private final static String TEXT = "Cheese is a dairy product produced in wide ranges of flavors, textures and forms by coagulation of the milk protein casein.";
    private final static BigInteger CHECKER = new BigInteger("1000000");
    private final static String URL = "https://www.google.com";

    @Test
    @Owner("Tihomir Vekonj")
    @Story("Testing search")
    @DisplayName("Paragraph search")
    @Description("Testing if we can find a specific paragraph on the wiki page")
    public void testPageObjects() {

        getDriver().get(URL);
        GooglePage googlePage = new GooglePage(getDriver());

        ResultPage resultPage = googlePage.searchWord();
        Assertions.assertTrue(resultPage.findResultNumber().compareTo(CHECKER) > 0, "Error! There is less than 1M searches..");

        WikiPage wikiPage = resultPage.clickFirstResult();

        Assertions.assertTrue(wikiPage.checkParagraph().contains(TEXT), "This sentence is not present in the desired paragraph..");

        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}


