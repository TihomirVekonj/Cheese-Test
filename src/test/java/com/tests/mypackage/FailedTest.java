package com.tests.mypackage;

import com.base.mypackage.TestBase;
import com.pages.mypackage.GooglePage;
import com.pages.mypackage.ResultPage;
import com.pages.mypackage.WikiPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;


public class FailedTest extends TestBase {

    private final static String TEXT = "Cheese is a dairy product produced in wide ranges of flavors, textures and forms by coagulation of the milk protein casein.";
    private final static BigInteger CHECKER = new BigInteger("1000000");
    private final static String URL = "https://www.google.com";

    @Test
    @Disabled
    public void failedTest() {
        getDriver().get(URL);
        GooglePage googlePage = new GooglePage(getDriver());

        ResultPage resultPage = googlePage.searchWord();

        Assertions.assertTrue(resultPage.findResultNumber().compareTo(CHECKER) < 0, "Error! There is less than 1M searches..");

        WikiPage wikiPage = resultPage.clickFirstResult();
        Assertions.assertTrue(wikiPage.checkParagraph().contains(TEXT), "This sentence is not present in the desired paragraph..");

    }
}
