package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Navigation extends BasePage {
    private static final Logger log = getLogger(Navigation.class.getName());
    private static final By btnAccount = By.id("navigation_my_ae");
    private static final By btnHome = By.id("navigation_home");
    private static final By btnCar = By.id("com.alibaba.aliexpresshd:id/navigation_cart");

    public Navigation(AndroidDriver driver) {
        super(driver);
    }

    public void goToAccountMenu(){
        log.info("Click Account Button Menu");
        driver.findElement(btnAccount).click();
    }

    public void goToHomeMenu() {
        log.info("Click Home Button Menu");
        driver.findElement(btnHome).click();
    }

    public void goToCarMenu() {
        log.info("Click CAR Button Menu");
        driver.findElement(btnCar).click();
    }
}
