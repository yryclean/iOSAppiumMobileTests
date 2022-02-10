import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SlidersTest extends Base {


    @Test
    public void slidersTest() throws MalformedURLException {

        IOSDriver driver = DesiredCapabilities();
        driver.findElementByAccessibilityId("Sliders").click();
        IOSElement slider = (IOSElement)driver.findElement(By.xpath("//XCUIElementTypeSlider"));
        slider.setValue("0%");
        slider.setValue("1%"); //100=1, 50=0.5 and etc.
        Assert.assertEquals(slider.getAttribute("value"), "100%");

    }
}
