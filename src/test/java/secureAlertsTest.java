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

public class secureAlertsTest extends Base {

    @Test
    public void alertsTest() throws MalformedURLException {
        IOSDriver driver = DesiredCapabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Secure Text Entry']")).click();
        Assert.assertEquals(driver.findElement(By.name("A Short Title Is Best")).getText(), "A Short Title Is Best");
        Assert.assertEquals(driver.findElement(By.name("A message should be a short, complete sentence.")).getText(), "A message should be a short, complete sentence.");
        driver.findElement(By.xpath("//XCUIElementTypeSecureTextField")).sendKeys("hell");
        Assert.assertFalse(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).isEnabled());

    }

        @Test
        public void alert2Test() throws MalformedURLException, InterruptedException {
            IOSDriver driver = DesiredCapabilities();
            driver.findElementByAccessibilityId("Alert Views").click();
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Secure Text Entry']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeSecureTextField")).sendKeys("hello");
            Assert.assertTrue(driver.findElement(By.name("OK")).isEnabled());
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.name("OK"));
            TouchAction tap = new IOSTouchAction(driver);
            tap.tap(tapOptions().withElement(element(element))).perform();
    }

    }
