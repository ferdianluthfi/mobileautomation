package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Home extends BaseTest {
	@Test(testName = "Open Shrine Gallery")
	public void test1() {
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(900, 470)).waitAction().moveTo(PointOption.point(300, 470)).release().perform();
		MobileElement shirineCarrousel = driver.findElementByXPath("//android.widget.HorizontalScrollView");
		shirineCarrousel.click();
		MobileElement goBackButton = driver
				.findElementByXPath("//android.widget.Button[@content-desc=\"Back to Gallery\"]");
		goBackButton.isDisplayed();
	}

	@Test(testName = "Add to cart")
	public void test2() {
		TouchAction action = new TouchAction(driver);
		MobileElement buttonNext = driver.findElementByXPath("//android.widget.Button[@content-desc=\"NEXT\"]");
		buttonNext.click();

		while (driver
				.findElementsByXPath(
						"//android.widget.Button[@content-desc=\"Walter henley (white)\n" + "$38, Add to cart\"]")
				.size() == 0) {
			action.press(PointOption.point(600, 470)).waitAction().moveTo(PointOption.point(30, 470)).release()
					.perform();
		}

		MobileElement buttonProduct = driver.findElementByXPath(
				"//android.widget.Button[@content-desc=\"Walter henley (white)\n" + "$38, Add to cart\"]");
		buttonProduct.click();

		MobileElement buttonCart = driver
				.findElementByXPath("//android.widget.Button[contains(@content-desc,'Shopping cart')]");
		buttonCart.click();

		MobileElement textItems = driver.findElementByXPath(
				"//android.view.View[@content-desc=\"Walter henley (white)\n" + "Quantity: 1\n" + "x $38\"]");
		textItems.isDisplayed();
		
		driver.navigate().back();

	}

	@Test(testName = "Add to cart after filter")
	public void test3() {
		TouchAction action = new TouchAction(driver);
		MobileElement buttonOptions = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Open menu\"]");
		buttonOptions.click();
		
		MobileElement buttonAccesoris = driver.findElementByXPath("//android.widget.Button[@content-desc=\"ACCESSORIES\"]");
		buttonAccesoris.click();
		
		//somehow the element is blocking other element so we have to do this before can select the peroduct
		buttonOptions.click();
		buttonOptions.click();
		
		while (driver
				.findElementsByXPath(
						"//android.widget.Button[@content-desc=\"Shrug bag\n"
						+ "$198, Add to cart\"]")
				.size() == 0) {
			action.press(PointOption.point(600, 470)).waitAction().moveTo(PointOption.point(30, 470)).release()
					.perform();
		}

		MobileElement buttonProduct = driver.findElementByXPath(
				"//android.widget.Button[@content-desc=\"Shrug bag\n"
				+ "$198, Add to cart\"]");
		buttonProduct.click();

		MobileElement buttonCart = driver
				.findElementByXPath("//android.widget.Button[contains(@content-desc,'Shopping cart')]");
		buttonCart.click();

		MobileElement textItems = driver.findElementByXPath(
				"//android.view.View[contains(@content-desc,'Shrug bag')]");
		textItems.isDisplayed();

	}
	
	@Test(testName = "Check total items")
	public void test4() {
		MobileElement textItems = driver.findElementByXPath(
				"//android.view.View[@content-desc=\"TOTAL\n"
				+ "$264.16\"]");
		textItems.isDisplayed();
	}
	
	@Test(testName = "Clear Shopping Cart")
	public void test5() {
		MobileElement textItems = driver.findElementByXPath(
				"//android.widget.Button[@content-desc=\"CLEAR CART\"]");
		textItems.click();
		MobileElement buttonCart = driver
				.findElementByXPath("//android.widget.Button[contains(@content-desc,'Shopping cart')]");
		buttonCart.click();
		
		MobileElement textFinalTotal = driver.findElementByXPath(
				"//android.view.View[@content-desc=\"TOTAL\n"
				+"$0.00\"]");
		textFinalTotal.isDisplayed();
		
	}
	
	

}