package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.account.AccountMenuPage;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class CarPage extends BasePage{
    private static final Logger log = getLogger(AccountMenuPage.class.getName());

    public CarPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By goItBanner = By.id("com.alibaba.aliexpresshd:id/bt_got_it");
    private static final By carResultList = By.id("com.alibaba.aliexpresshd:id/tv_product_title");
    public String getCarResults(String query){

        WebDriverWait wait = new WebDriverWait(driver, 20);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(goItBanner));
            if(driver.findElement(goItBanner).isDisplayed()) {
                driver.findElement(goItBanner).click();
            }
        }catch (Exception ex){
            System.out.println("Bla Bla bla");
        }


        wait.until(ExpectedConditions.presenceOfElementLocated(carResultList));

        List<AndroidElement> list = driver.findElements(carResultList);
        log.info("List Car Size " + list.size());
        int numberOfItems = list.size();
        int id = 0;
        for (int i=0; i < numberOfItems; i++) {
            String strValidation = list.get(i).getText();
            if (strValidation.contains(query)){
                id = i;
                break;
            }
        }

        String resultItemText = list.get(id).getText();
        log.info("Result item contains the following text -> " + resultItemText);
        return resultItemText;
    }
}
