package Util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class TestBase {

    public static String appPtah = "/flutterlogin-debug.apk";
    public static AndroidDriver<MobileElement> driver;
    public  ExtentReports extent;
    public ExtentTest logger;

    private String reportDirectory = "reports";
    private String reportFormat = "html";
    private String testName = "Flutter Automation";
    private String udid = "";
    private String deviceName = "";


    public AndroidDriver<MobileElement> setup () throws MalformedURLException {

        File rootFile = new File("");
        File appFile = new File(rootFile.getAbsolutePath() + appPtah);
        appPtah = appFile.getAbsolutePath();
        DesiredCapabilities flutterCapabilities = new DesiredCapabilities();
        flutterCapabilities.setCapability( "deviceName", deviceName );
        flutterCapabilities.setCapability( "platformName", "Android" );
        flutterCapabilities.setCapability( "reportDirectory", reportDirectory );
        flutterCapabilities.setCapability( "reportFormat", reportFormat );
        flutterCapabilities.setCapability( "testName", testName );
        flutterCapabilities.setCapability("automationName", "Flutter");
        flutterCapabilities.setCapability("noReset", "true");
        flutterCapabilities.setCapability("skipUnlock","true");
        flutterCapabilities.setCapability("udid",udid);
        flutterCapabilities.setCapability("app",appPtah);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), flutterCapabilities);
        return driver;
    }

    public static void switchContext(String context) throws MalformedURLException {
        TestBase tb = new TestBase();
        tb.setup();
        driver.getContext();
        Set<String> con = driver.getContextHandles();
        for (String c : con) {
            if (c.contains(context)) {
                driver.context(c);
                break;
            }
        }


    }
}
