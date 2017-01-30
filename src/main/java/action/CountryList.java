package action;

import database.MySQLConnector;
import table.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryList {

    private MySQLConnector mySQLConnector = MySQLConnector.getInstance();
    private List<Country> countries = new ArrayList<>();

    public String showCountries() {
        countries = mySQLConnector.getCountries();
        return "success";
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
