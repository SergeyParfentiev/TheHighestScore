package action;

import database.MySQLConnector;
import table.Order;
import java.util.ArrayList;
import java.util.List;

public class FillTable {

    private int countryId;
    private MySQLConnector mySQLConnector = MySQLConnector.getInstance();
    private List<Order> orders = new ArrayList<>();

    public String showOrders() {
        System.out.println("Country id: " + countryId);
        orders = mySQLConnector.getOrders(countryId);
//        if(1 == countryId) {
//            orders.add(new Order("firstName", "first", 20.1));
//            orders.add(new Order("secondName", "second", 1.6));
//            orders.add(new Order("thirdName", "third", 74.9));
//        } else {
//            orders.add(new Order("fourthName", "fourth", 33.7));
//            orders.add(new Order("fifthName", "fifth", 7.4));
//            orders.add(new Order("sixthName", "sixth", 92.4));
//        }
        return "success";
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
