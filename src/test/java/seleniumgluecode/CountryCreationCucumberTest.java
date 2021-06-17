package seleniumgluecode;

import SeleniumTests.util.CountryFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountryCreationCucumberTest {

    private WebDriver driver;
    private String username = "admin";
    private CountryFactory countryFactory = new CountryFactory();

    @Given("^user is authenticated$")
    public void user_is_authenticated() {
        driver = SeleniumTests.util.DriverFactory.open("chrome");
        driver.get("http://127.0.0.1:8080/applicationPetstore/shopping/signon.xhtml");
        driver.manage().window().maximize();

        WebElement loginBox = driver.findElement(By.id("j_idt72:login"));
        loginBox.sendKeys(username);

        WebElement passwordBox = driver.findElement(By.id("j_idt72:password"));
        passwordBox.sendKeys(username);

        WebElement loginButton = driver.findElement(By.name("j_idt72:j_idt77"));
        loginButton.click();

        WebElement loginConf = driver.findElement(By.cssSelector("a[href='/applicationPetstore/shopping/showaccount.xhtml']"));

        Assert.assertTrue(loginConf.getText().toLowerCase().contains("welcome"));
    }

    @When("^user clicks on account$")
    public void user_clicks_on_account() {
        WebElement accountHyperLink = driver.findElement(By.cssSelector("a[href='/applicationPetstore/admin/category/search.xhtml']"));
        accountHyperLink.click();
    }

    @And("^user clicks on country$")
    public void user_clicks_on_country() {
        WebElement countryHyperLink = driver.findElement(By.cssSelector("a[href='/applicationPetstore/admin/country/search.xhtml']"));
        countryHyperLink.click();

        WebElement countryPageConf = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[4]/h3"));
        String confMessage = countryPageConf.getText();

        Assert.assertTrue(confMessage.toLowerCase().contains("country entities"));
    }

    @And("^enters country entities and clicks on create$")
    public void enters_country_entities_and_clicks_on_create() {
        WebElement isoCodeBox = driver.findElement(By.id("search:countryBeanExampleIsoCode"));
        isoCodeBox.sendKeys(countryFactory.getIsoCode());

        WebElement countryNameBox = driver.findElement(By.id("search:countryBeanExampleName"));
        countryNameBox.sendKeys(countryFactory.getCountryName());

        WebElement printableNameBox = driver.findElement(By.id("search:countryBeanExamplePrintableName"));
        printableNameBox.sendKeys(countryFactory.getPrintableName());

        WebElement threeLetterCodeBox = driver.findElement(By.id("search:countryBeanExampleIso3"));
        threeLetterCodeBox.sendKeys(countryFactory.getThreeLetterCode());

        WebElement numCodeBox = driver.findElement(By.id("search:countryBeanExampleNumcode"));
        numCodeBox.sendKeys(countryFactory.getNumCode());

        WebElement createButton = driver.findElement(By.xpath("//*[@id='search']/span[1]/span/a[2]"));
        createButton.click();
    }

    @And("^user saves the country$")
    public void user_saves_the_country() {
        WebElement saveCountryButton = driver.findElement(By.xpath("//*[@id=\"create\"]/span/a[1]"));
        saveCountryButton.click();
    }

    @Then("^there should be a new country$")
    public void there_should_be_a_new_country() {
        WebElement newCountryName = driver.findElement(By.linkText(countryFactory.getCountryName()));

        Assert.assertTrue(newCountryName.isDisplayed());

        Assertions.assertThrows(NoSuchElementException.class, () -> driver.findElement(By.linkText(countryFactory.getCountryName() + "asdfasdf")));

        driver.close();
    }

}
