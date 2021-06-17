package seleniumgluecode;

import SeleniumTests.util.UserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CreateAccountCucumberTest {

    WebDriver driver;
    UserFactory userFactory = new UserFactory();


    @Given("^user is on loginpage$")
    public void user_is_on_loginpage() {
        driver = SeleniumTests.util.DriverFactory.open("chrome");
        driver.get("http://localhost:8080/applicationPetstore/shopping/signon.xhtml");
        driver.manage().window().maximize();
    }

    @When("^user enters new username and new password$")
    public void user_enters_new_username_and_new_password() {
        WebElement logginBox = driver.findElement(By.id("j_idt79:newlogin"));
        logginBox.clear();
        logginBox.sendKeys(userFactory.getUsername());

        WebElement newPasswordBox = driver.findElement(By.id("j_idt79:newpassword"));
        newPasswordBox.sendKeys(userFactory.getPassword());

    }

    @And("^user confirms the new password$")
    public void user_confirms_the_new_password() {
        WebElement passwordConfirmBox = driver.findElement(By.id("j_idt79:newpasswordagain"));
        passwordConfirmBox.sendKeys(userFactory.getPassword());
    }

    @And("^clicks on the new account button$")
    public void clicks_on_the_new_account_button() {
        WebElement createAccountButton = driver.findElement(By.name("j_idt79:j_idt84"));
        createAccountButton.click();
    }

    @And("^completes personal information$")
    public void fillInPersonalInformation() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstNameTextbox = driver.findElement(By.id("j_idt71:firstName"));
        firstNameTextbox.sendKeys(userFactory.getFirstname());

        WebElement lastNameTextbox = driver.findElement(By.id("j_idt71:lastName"));
        lastNameTextbox.sendKeys(userFactory.getLastname());

        WebElement emailTextbox = driver.findElement(By.id("j_idt71:email"));
        emailTextbox.sendKeys(userFactory.getEmail());

        WebElement streetTextbox = driver.findElement(By.id("j_idt71:street1"));
        streetTextbox.sendKeys(userFactory.getStreet());

        WebElement cityTextbox = driver.findElement(By.id("j_idt71:city"));
        cityTextbox.sendKeys(userFactory.getCity());

        WebElement zipCodeTextbox = driver.findElement(By.id("j_idt71:zipcode"));
        zipCodeTextbox.sendKeys(userFactory.getCity());

        Select dropdownCountry = new Select(driver.findElement(By.id("j_idt71:country")));
        dropdownCountry.selectByVisibleText("GERMANY");

        WebElement submitAccountButton = driver.findElement(By.name("j_idt71:j_idt104"));
        submitAccountButton.click();
    }

    @Then("^user should be logged in$")
    public void user_should_be_logged_in() {
        WebElement loginConfirmation = driver.findElement(By.cssSelector("a[href='/applicationPetstore/shopping/showaccount.xhtml']"));
        String confirmationMessage = loginConfirmation.getText();

        driver.close();

        Assert.assertTrue(confirmationMessage.toLowerCase().contains("welcome " + userFactory.getFirstname().toLowerCase()));

    }

}
