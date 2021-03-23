package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver){
        this.driver = driver;
    }

}
