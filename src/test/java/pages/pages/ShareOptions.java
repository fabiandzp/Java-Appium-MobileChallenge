package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.clipboard.ClipboardContentType;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.account.AccountMenuPage;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class ShareOptions extends BasePage{
    private static final Logger log = getLogger(AccountMenuPage.class.getName());

    public ShareOptions(AndroidDriver driver) {
        super(driver);
    }

    private static final By shareOptiosBtns = By.xpath("//android.widget.TextView[@resource-id='com.alibaba.aliexpresshd:id/tv_app_name']");
    public String clickShareMoreOptions(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(shareOptiosBtns));
        List<AndroidElement> list = driver.findElements(shareOptiosBtns);
        list.get(0).click();
        String sharelink = (driver.getClipboard(ClipboardContentType.PLAINTEXT));
        log.info(sharelink);
        return sharelink;
    }
}
