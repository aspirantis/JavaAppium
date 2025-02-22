package lib;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected Platform Platform;
    protected RemoteWebDriver driver;

    @Before
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        this.Platform = new Platform();
        this.rotateScreenPortrait();
        this.openWikiWebPageForMobileWeb();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    protected void rotateScreenPortrait() {
        if (driver instanceof AndroidDriver) {
            AndroidDriver driver = (AndroidDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void rotateScreenLandscape() {
        if (driver instanceof AndroidDriver) {
            AndroidDriver driver = (AndroidDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void backgroundApp(int seconds) {
        if (driver instanceof AndroidDriver) {
            AndroidDriver driver = (AndroidDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            System.out.println("Method backgroundApp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void openWikiWebPageForMobileWeb() {
        if (Platform.getInstance().isMW()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());

        }
    }

}
