import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashMap;

public class ScrollTest extends Base{

    @Test
    public void scrollTest() throws MalformedURLException, InterruptedException {
        IOSDriver driver = DesiredCapabilities();
        HashMap<String, Object>scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("name", "Web View");
        driver.executeScript("mobile:scroll", scrollObject);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Web View']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
        driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
        driver.findElementByAccessibilityId("Blue color component value").sendKeys("105");
        Assert.assertEquals(driver.findElementByAccessibilityId("Blue color component value").getText(), "105");
    }
}
