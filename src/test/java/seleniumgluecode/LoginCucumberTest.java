package seleniumgluecode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginCucumberTest {

    WebDriver loginDriver;


    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        loginDriver = SeleniumTests.util.DriverFactory.open("chrome");
        loginDriver.get("http://localhost:8080/applicationPetstore/shopping/main.xhtml");
        loginDriver.manage().window().maximize();
    }

    @When("^user navigates to loginpage$")
    public void user_navigates_to_loginpage() {
        WebElement loginButton =  loginDriver.findElement(By.xpath("//*[@id=\"j_idt13\"]/div/div/div[2]/ul[2]/li[3]/a"));
        loginButton.click();
    }

    @And("^user enters username and password$")
    public void user_enters_username_and_password() {
        WebElement usernameTextbox = loginDriver.findElement(By.id("j_idt72:login"));
        usernameTextbox.sendKeys("admin");

        WebElement passwordTextbox = loginDriver.findElement(By.id("j_idt72:password"));
        passwordTextbox.sendKeys("admin" + Keys.RETURN);
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() {
        WebElement loginConfirmation = loginDriver.findElement(By.cssSelector("a[href='/applicationPetstore/shopping/showaccount.xhtml']"));
        String confirmationMessage = loginConfirmation.getText();

        loginDriver.close();

        Assert.assertTrue(confirmationMessage.toLowerCase().contains("welcome admin"));
    }

}
