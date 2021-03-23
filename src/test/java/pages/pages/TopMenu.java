package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.account.AccountMenuPage;

import static org.apache.logging.log4j.LogManager.getLogger;

public class TopMenu extends BasePage{
    private static final Logger log = getLogger(AccountMenuPage.class.getName());


    public TopMenu(AndroidDriver driver) {
        super(driver);
    }

    private static final By dotMenuBtn = By.id("com.alibaba.aliexpresshd:id/menu_overflow");
    public void getDotMenu(){
        log.info("Clicking Dot Menu");
        driver.findElement(dotMenuBtn).click();
    }

    private static final By topCarBtn = By.id("com.alibaba.aliexpresshd:id/menu_shopcart");
    public void getCarMenu(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(topCarBtn));
        log.info("Clicking Dot Menu");
        driver.findElement(topCarBtn).click();
    }

    private static final By topHomeBtn = By.xpath("//android.widget.TextView[@text='Home']");
    public void getHomeMenu(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(topHomeBtn));
        log.info("Clicking Dot Menu");
        driver.findElement(topHomeBtn).click();
    }



    /*private static final By dotSettingsBtn = By.xpath("//android.widget.TextView[@text='Settings']");
    private static final By dotCarBtn = By.xpath("//android.widget.TextView[@text='Cart']");
    public void goToCarMenu(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(dotSettingsBtn));
        log.info("Clicking Cart Menu");
        driver.findElement(dotCarBtn).click();
    }*/






}
