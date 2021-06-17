package seleniumgluecode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryCreationCucumberTest {

    WebDriver driver;
    String categoryName = "Katgorie";
    String categoryDescription = "Kategoriebeschreibung";

    @Given("^user is already logged in$")
    public void user_is_already_logged_in() {
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

    @When("^user clicks on category$")
    public void user_clicks_on_category() {
        WebElement accountSettings = driver.findElement(By.xpath("//*[@id=\"j_idt13\"]/div/div/div[2]/ul[1]/li[1]/a"));
        accountSettings.click();

        WebElement categoryHyperLink = driver.findElement(By.linkText("Category"));
        categoryHyperLink.click();

    }

    @And("^enters required information and clicks on create$")
    public void enters_required_information_and_clicks_on_create() {
        WebElement categoryNameBox = driver.findElement(By.id("search:categoryBeanExampleName"));
        categoryNameBox.sendKeys(categoryName);

        WebElement definitionBox = driver.findElement(By.id("search:categoryBeanExampleDescription"));
        definitionBox.sendKeys(categoryDescription);

        WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/a[2]"));
        createNewButton.click();
    }

    @And("^user saves the category$")
    public void user_saves_the_category() {
        WebElement saveCategory = driver.findElement(By.xpath("//*[@id=\"create\"]/span/a[1]"));
        saveCategory.click();
    }

    @Then("^there should be a new category$")
    public void there_should_be_a_new_category() {
        WebElement newCategoryItem = driver.findElement(By.linkText(categoryName));

        Assert.assertEquals(newCategoryItem.getText(), categoryName);
                driver.close();
    }

}
