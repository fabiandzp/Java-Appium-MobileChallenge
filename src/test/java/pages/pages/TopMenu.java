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
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(topCarBtn));
        log.info("Clicking Car Menu");
        driver.findElement(topCarBtn).click();
    }

    private static final By topHomeBtn = By.xpath("//android.widget.TextView[@text='Home']");
    public void getHomeMenu(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(topHomeBtn));
        log.info("Clicking Home Menu");
        driver.findElement(topHomeBtn).click();
    }

    private static final By topShareBtn = By.id("com.alibaba.aliexpresshd:id/menu_wish_list_group_share");
    public void getShareMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(topShareBtn));
        log.info("Clicking Share Menu");
        driver.findElement(topShareBtn).click();
    }


}
