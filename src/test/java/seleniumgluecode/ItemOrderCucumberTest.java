package seleniumgluecode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemOrderCucumberTest {

    WebDriver driver;

    @Given("^user is logged in$")
    public void user_is_logged_in() {
        driver = SeleniumTests.util.DriverFactory.open("chrome");
        driver.get("http://127.0.0.1:8080/applicationPetstore/shopping/signon.xhtml");
        driver.manage().window().maximize();

        WebElement usernameTextbox = driver.findElement(By.id("j_idt72:login"));
        usernameTextbox.sendKeys("admin");

        WebElement passwordTextbox = driver.findElement(By.id("j_idt72:password"));
        passwordTextbox.sendKeys("admin");

        WebElement signInButton = driver.findElement(By.name("j_idt72:j_idt77"));
        signInButton.click();
    }

    @When("^user clicks on dogs$")
    public void user_clicks_on_dogs() {
        WebElement dogsHyperLink = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/ul/li[2]/h3/a"));
        dogsHyperLink.click();

    }

    @And("^selects labrador retriever$")
    public void selects_labrador_retriever() {
        WebElement labradorRetrievers = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[4]/table/tbody/tr[5]/td[1]/a"));
        labradorRetrievers.click();
    }

    @And("^selects tailed$")
    public void selects_tailed() {
        WebElement tailedLR = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[4]/table/tbody/tr[1]/td[2]/a"));
        tailedLR.click();
    }

    @And("^adds to cart$")
    public void adds_to_cart() {
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"j_idt74\"]/table[1]/tbody/tr/td[3]/a"));
        addToCart.click();
    }

    @And("^the user checks out$")
    public void the_user_checks_out() {
        WebElement checkOut = driver.findElement(By.xpath("//*[@id=\"j_idt72\"]/div/a"));
        checkOut.click();
    }

    @And("^enters credit card number and expiry date$")
    public void enters_credit_card_number_and_expiry_date() {
        WebElement ccNumber = driver.findElement(By.id("j_idt71:creditCardNumber"));
        ccNumber.sendKeys("31051997");

        WebElement expiryDate = driver.findElement(By.id("j_idt71:creditCardExpDate"));
        expiryDate.sendKeys("0531");
    }

    @And("^submits the order$")
    public void submits_the_order() {
        WebElement submitOrder = driver.findElement(By.name("j_idt71:j_idt107"));
        submitOrder.click();
    }

    @Then("^the transaction wont be committed$")
    public void transaction_wont_be_committed() {
        WebElement transactionException = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[1]/ul/li"));
        String message = transactionException.getText();

        driver.close();

        Assert.assertTrue(message.toLowerCase().contains("exception"));
    }

}
