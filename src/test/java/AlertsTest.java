import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AlertsTest extends Base {

    @Test
    public void alertsTest() throws MalformedURLException {
        IOSDriver driver = DesiredCapabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Simple']")).click();
        Assert.assertEquals(driver.findElement(By.name("A Short Title Is Best")).getText(), "A Short Title Is Best");
        Assert.assertEquals(driver.findElement(By.name("A message should be a short, complete sentence.")).getText(), "A message should be a short, complete sentence.");
        WebElement element = driver.findElement(By.name("OK"));
        TouchAction tap = new IOSTouchAction(driver);
        tap.tap(tapOptions().withElement(element(element))).perform();
    }
}
