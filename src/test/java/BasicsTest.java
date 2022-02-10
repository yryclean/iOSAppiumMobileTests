import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class BasicsTest extends Base{

    @Test
    public void basicsTest() throws MalformedURLException {
        IOSDriver driver = DesiredCapabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Text Entry").click();
        driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys("Hello");
        TouchAction tap = new TouchAction<>(driver);
        WebElement okButton = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']"));
        tap.tap(tapOptions().withElement(element(okButton))).perform();
        driver.findElementByAccessibilityId("Confirm / Cancel").click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@name,'A message should')]")).getText(),
                "A" + " message should be a short, complete sentence.");
        driver.findElementByAccessibilityId("Confirm").click();
    }
}
