import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ActionSheetTest extends Base {
    @Test
    public void actionSheetTest() throws MalformedURLException {
        IOSDriver driver = DesiredCapabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Destructive").click();
        Assert.assertEquals(driver.findElementByAccessibilityId("A message should be a short, complete sentence.").getText(),
                "A message should be a short, complete sentence.");
        WebElement element = driver.findElementByAccessibilityId("Destructive Choice");
        TouchAction tap = new IOSTouchAction(driver);
        tap.tap(tapOptions().withElement(element(element))).perform();
    }
}
