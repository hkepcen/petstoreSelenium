package SeleniumTests.util;

import com.github.javafaker.Faker;

public class CountryFactory {

    Faker faker = new Faker();

    String isoCode = faker.country().countryCode2().toUpperCase();
    String printableName = faker.country().name();
    String countryName = printableName.toUpperCase();
    String threeLetterCode = faker.country().countryCode3().toUpperCase();
    String numCode = faker.code().isbn10().substring(0,3);

    public String getIsoCode() {
        return isoCode;
    }

    public String getPrintableName() {
        return printableName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getThreeLetterCode() {
        return threeLetterCode;
    }

    public String getNumCode() {
        return numCode;
    }
}
