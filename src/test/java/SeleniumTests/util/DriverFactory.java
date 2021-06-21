package SeleniumTests.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver open(String type) {
        if (type.equals("chrome")) {

            String driverPath = "src/test/resources/chromedriver";

            // define driver
            System.setProperty("webdriver.chrome.driver", driverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            return new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Not valid driver selected!");
        }
    }

}