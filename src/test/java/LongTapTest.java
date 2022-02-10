import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class LongTapTest extends Base{

    @Test
    public void basicsTest() throws MalformedURLException, InterruptedException {
        IOSDriver driver = DesiredCapabilities();

        MobileElement longTap = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Long tap']"));
        IOSTouchAction tap = new IOSTouchAction(driver);
        tap.longPress(longPressOptions().withElement(element(longTap)).withDuration(Duration.ofSeconds(2))).release().perform();
        MobileElement name = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeSwitch[@index='1']"));
        tap.tap(tapOptions().withElement(element(name))).perform();
        MobileElement email = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeSwitch[@index='3']"));
        tap.tap(tapOptions().withElement(element(email))).perform();
        Assert.assertEquals(email.getAttribute("value"), "0");
        Assert.assertEquals(name.getAttribute("value"), "0");

    }
}
