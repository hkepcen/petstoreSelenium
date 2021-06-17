package SeleniumTests.AccountTests;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {

    WebDriver driver;
    String browser = "chrome";
    String username = "admin";
    String password = "admin";

    @Test
    public void Login() {
        WebElement loginButton =  driver.findElement(By.xpath("//*[@id=\"j_idt13\"]/div/div/div[2]/ul[2]/li[3]/a"));
        loginButton.click();

        WebElement usernameTextbox = driver.findElement(By.id("j_idt72:login"));
        usernameTextbox.sendKeys(username);

        WebElement passwordTextbox = driver.findElement(By.id("j_idt72:password"));
        passwordTextbox.sendKeys(password);

        WebElement signInButton = driver.findElement(By.name("j_idt72:j_idt77"));
        signInButton.click();

        WebElement loginConfirmation = driver.findElement(By.cssSelector("a[href='/applicationPetstore/shopping/showaccount.xhtml']"));
        String confirmationMessage = loginConfirmation.getText();

        Assertions.assertTrue(confirmationMessage.toLowerCase().contains("welcome " + username));

    }

    @Before
    public void setUp() {
        driver = SeleniumTests.util.DriverFactory.open(browser);
        driver.get("http://localhost:8080/applicationPetstore/shopping/main.xhtml");
        driver.manage().window().maximize();
    }

}
