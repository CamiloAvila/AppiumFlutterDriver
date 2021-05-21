import Util.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.TimeoutException;
import appium_flutter_driver.FlutterFinder;
import appium_flutter_driver.finder.FlutterElement;

import java.net.MalformedURLException;


public class AppiumTestDemo extends TestBase {

    public static void main(String[] args) {
        AppiumTestDemo demo = new AppiumTestDemo();
        demo.test1();
    }

    public void test1 (){

        try {
            switchContext("FLUTTER");

           // switchContext("NATIVE_APP");
            FlutterFinder find = new FlutterFinder(driver);
            Thread.sleep(3000);

            FlutterElement txt_username = find.byValueKey("txt_username");
            FlutterElement txt_password = find.byValueKey("txt_password");
            FlutterElement button_login = find.byValueKey("button_login");


            txt_username.sendKeys("user@yopmailcom");
            txt_password.sendKeys("123456");
            button_login.click();

            Thread.sleep(5000);

        } catch (TimeoutException | InterruptedException | MalformedURLException e) {

        }

    }

}
