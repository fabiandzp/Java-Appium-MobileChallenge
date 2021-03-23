package pages.account;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pages.BasePage;

import static org.apache.logging.log4j.LogManager.getLogger;

public class AccountPage extends BasePage {
    private static final Logger log = getLogger(SignInPage.class.getName());

    public AccountPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By container = By.id("com.alibaba.aliexpresshd:id/scroll_sns_container");
    public boolean checkRegisterLogInPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(container));

        boolean userNotLogged = false;
        if (driver.findElement(container).isDisplayed()){
            userNotLogged = true;
        }

        return userNotLogged;
    }

    private static final By SignInBtn = By.id("btn_sign_in");
    public void goToLoginPage(){
        log.info("Clicking SignIn Button");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SignInBtn));
        driver.findElement(SignInBtn).click();
    }

}
