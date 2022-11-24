package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

	AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void globalSetup() throws IOException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/src/test/resources/apps");
		File app = new File(appDir.getCanonicalPath(), "flutter_gallery_Android.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "J7AXGF04D445VNY");
		caps.setCapability(MobileCapabilityType.UDID, "J7AXGF04D445VNY");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("fullReset", true);

		try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void globalTearDown() {
        driver.closeApp();
	}

}