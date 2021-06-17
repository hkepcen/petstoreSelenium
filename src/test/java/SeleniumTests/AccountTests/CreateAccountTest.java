package SeleniumTests.AccountTests;

import SeleniumTests.util.UserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAccountTest {

    UserFactory userFactory = new UserFactory();

    String loginName = userFactory.getUsername();
    String password = userFactory.getPassword();
    String firstname = userFactory.getFirstname();
    String lastname = userFactory.getLastname();
    String email = userFactory.getEmail();
    String street = userFactory.getStreet();
    String city = userFactory.getCity();
    String zipcode = userFactory.getZipcode();
    String country = "GERMANY";

    WebDriver driver;
    String browser = "chrome";


    public void setUp() {
        driver = SeleniumTests.util.DriverFactory.open(browser);
        driver.get("http://localhost:8080/applicationPetstore/shopping/signon.xhtml");
        driver.manage().window().maximize();
    }

    @Test
    public void createAccount() {
        setUp();
        WebElement newLoginTextbox = driver.findElement(By.id("j_idt79:newlogin"));
        newLoginTextbox.clear();
        newLoginTextbox.sendKeys(loginName);

        WebElement newPasswordTextbox = driver.findElement(By.id("j_idt79:newpassword"));
        newPasswordTextbox.sendKeys(password);

        WebElement newPasswordConfirmBox = driver.findElement(By.id("j_idt79:newpasswordagain"));
        newPasswordConfirmBox.sendKeys(password);

        WebElement createAccountButton = driver.findElement(By.name("j_idt79:j_idt84"));
        createAccountButton.click();
    }

    @Test
    public void fillInPersonalInformation() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstNameTextbox = driver.findElement(By.id("j_idt71:firstName"));
        firstNameTextbox.sendKeys(firstname);

        WebElement lastNameTextbox = driver.findElement(By.id("j_idt71:lastName"));
        lastNameTextbox.sendKeys(lastname);

        WebElement emailTextbox = driver.findElement(By.id("j_idt71:email"));
        emailTextbox.sendKeys(email);

        WebElement streetTextbox = driver.findElement(By.id("j_idt71:street1"));
        streetTextbox.sendKeys(street);

        WebElement cityTextbox = driver.findElement(By.id("j_idt71:city"));
        cityTextbox.sendKeys(city);

        WebElement zipCodeTextbox = driver.findElement(By.id("j_idt71:zipcode"));
        zipCodeTextbox.sendKeys(zipcode);

        Select dropdownCountry = new Select(driver.findElement(By.id("j_idt71:country")));
        dropdownCountry.selectByVisibleText(country);

        WebElement submitAccountButton = driver.findElement(By.name("j_idt71:j_idt104"));
        submitAccountButton.click();
    }

}
