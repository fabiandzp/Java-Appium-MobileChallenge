package pages.account;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pages.BasePage;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SignInPage extends BasePage {
    private static final Logger log = getLogger(SignInPage.class.getName());

    public SignInPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By email = By.id("et_email");
    private static final By password = By.id("et_password");
    private static final By signInBtn = By.id("tv_signin_btn_label");
    private static final By okBtn = By.id("android:id/button1");
    private static final By messageText = By.id("android:id/message");

    public String login(){
        driver.findElement(email).sendKeys("test86@gmail.com");
        driver.findElement(password).sendKeys("password123.!");
        driver.findElement(signInBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(okBtn));

        String message = driver.findElement(messageText).getText();
        return message;

    }


}
