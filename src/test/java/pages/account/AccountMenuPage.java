package pages.account;

import pages.interactions.SimpleScreenSwipe;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pages.BasePage;

import static org.apache.logging.log4j.LogManager.getLogger;

public class AccountMenuPage extends BasePage {
    private static final Logger log = getLogger(AccountMenuPage.class.getName());


    public AccountMenuPage(AndroidDriver driver) {
        super(driver);
    }

    public static final By singInLinkBtn = By.id("tv_un_login");
    public void goToRegisterLoginPage(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(singInLinkBtn));
        log.info("Clicking Sing In Button");
        driver.findElement(singInLinkBtn).click();
    }

    private static final By walletBtn = By.id("com.alibaba.aliexpresshd:id/iv_my_wallet");
    private static final By settingsBtn = By.id("rl_settings");
    public void goToSettingsPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(walletBtn));

        log.info("Swipe UP");
        SimpleScreenSwipe simpleScreenSwipe = new SimpleScreenSwipe(driver);
        simpleScreenSwipe.swipeScreen(SimpleScreenSwipe.Direction.UP);

        log.info("Clicking Settings Button");
        driver.findElement(settingsBtn).click();
    }
}
