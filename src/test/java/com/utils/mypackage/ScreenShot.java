package com.utils.mypackage;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    private static final String IMAGE_LOCATION = "target\\screenshots\\";
    private static final String FILE_NAME = "Error!";

    public void takeScreenShotOfVisiblePart(WebDriver driver) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
        Date date = new Date();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(IMAGE_LOCATION + FILE_NAME + " " + dateFormat.format(date) + ".png"));
            Allure.addAttachment(FILE_NAME + " " + dateFormat.format(date) + ".png" , new FileInputStream(scrFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
