// Kibitkin Ilya IT3-2307
public class Customer {
    private int id;
    private String name;
    private int discount;

    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")" + "(" + discount + "%)";
    }
}

class Invoice {
    private int id;
    private double amount;
    private Customer customer;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        return this.amount - this.amount * (getCustomerDiscount() / (double) 100);
    }

    @Override
    public String toString() {
        return "Invoice[id = " + id + ", customer " + customer.toString() + ", amount = " + amount + "]";
    }

}
