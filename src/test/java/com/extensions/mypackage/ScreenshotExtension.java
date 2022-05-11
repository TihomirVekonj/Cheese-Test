package com.extensions.mypackage;

import com.base.mypackage.TestBase;
import com.utils.mypackage.ScreenShot;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import java.util.Optional;


public class ScreenshotExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        TestBase testbase = (TestBase) context.getRequiredTestInstance();

        try {
            new ScreenShot().takeScreenShotOfVisiblePart(testbase.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            testbase.getDriver().quit();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestBase tb = (TestBase) context.getRequiredTestInstance();
        tb.getDriver().quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }
}
