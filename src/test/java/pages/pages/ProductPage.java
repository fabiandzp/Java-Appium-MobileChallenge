package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage extends BasePage{

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By BuyNowBtn = By.id("com.alibaba.aliexpresshd:id/bt_buynow_1");
    private static final By addToCarBtn = By.id("com.alibaba.aliexpresshd:id/tv_addToCart_1");
    private static final By continueBtn = By.id("com.alibaba.aliexpresshd:id/tv_apply_options");
    private static final By option1 = By.xpath("//android.widget.CompoundButton");
    private static final By shippingDetails = By.id("com.alibaba.aliexpresshd:id/ll_shipping_layout_v2");
    private static final By option1Checked = By.xpath("//android.widget.CompoundButton[@checked='true']");

    public ShareOptions shareOptionsPoUp = new ShareOptions(driver);

    public void addProductToCar() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(BuyNowBtn));
        driver.findElement(addToCarBtn).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(shippingDetails));

        if(driver.findElement(option1) == null){
            List<AndroidElement> list = driver.findElements(option1);
            list.get(0).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(option1Checked));
            driver.findElement(continueBtn).click();
        }else {
            wait.until(ExpectedConditions.presenceOfElementLocated(option1Checked));
            driver.findElement(continueBtn).click();
        }

    }

    private static final By productPrice = By.id("com.alibaba.aliexpresshd:id/tv_product_price");
    public String checkProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(BuyNowBtn));

        String value = driver.findElement(productPrice).getText();
        return value;

    }
}
