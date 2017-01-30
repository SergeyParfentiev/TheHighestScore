package table;

public class Order {

    private String fullName;
    private String name;
    private double cost;

    public Order() {
    }

    public Order(String fullName, String name, double cost) {
        this.fullName = fullName;
        this.name = name;
        this.cost = cost;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
