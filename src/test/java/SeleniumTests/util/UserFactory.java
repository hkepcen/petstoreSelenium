package SeleniumTests.util;

import com.github.javafaker.Faker;

public class UserFactory {

    Faker faker = new Faker();

    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String username = firstname.toLowerCase();
    String password = firstname.substring(0, 3) + lastname.substring(3, 5);
    String email = firstname.toLowerCase() + "_55@gmail.com";
    String city = "München";
    String street = faker.address().streetAddress();
    String zipcode = "85406";

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }
}
