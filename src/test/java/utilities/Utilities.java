package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    //Creating a method getScreenshot and passing two parameters
//driver and screenshotName
    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
    }

    public String takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        //Taking screenshot
        File Screenshot = ts.getScreenshotAs(OutputType.FILE);
        //Creating the path to save the file
        String destinationPath = System.getProperty("user.dir")+"\\Screenshots\\img_name.png";
        //creating destination file to save the screenshot
        File destinationFile = new File(destinationPath);
        //copying Screenshot to destination file
        FileUtils.copyFile(Screenshot, destinationFile);

        return destinationPath;
    }
}
