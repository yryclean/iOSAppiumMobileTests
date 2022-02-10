import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public static IOSDriver DesiredCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 mini");
        capabilities.setCapability(MobileCapabilityType.UDID, "73259133-FC57-42E4-AABC-A2B1E9DAA4BC");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT,30000);
        capabilities.setCapability("commandTimeouts", "12000");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/user/Desktop/UIKitCatalog.app");
//        capabilities.setCapability(MobileCapabilityType.APP, "/Users/user/Desktop/longtap.app");
        IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"),capabilities);
        return driver;
    }
}
