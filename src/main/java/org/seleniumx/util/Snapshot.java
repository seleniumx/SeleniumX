package org.seleniumx.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Date;

public class Snapshot extends Start {
    public static void takeSnapShot(String screenshotName) throws Exception {
        Date date = new Date();
        long time = date.getTime();
        File file = new File("FailedSnapshots");
        if (!file.exists()) {
            file.mkdirs();
        }
        File snapshot = new File("FailedSnapshots" + File.separator + "Snapshot_" + screenshotName + "_" + time+".png");
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(snapshot.toURI());
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
