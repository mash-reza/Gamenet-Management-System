package sample.database;

public class Customer {
    private int id;
    private String name;
    private long charge;
    private String phone;

    public Customer(int id, String name, long charge, String phone) {
        this.id = id;
        this.name = name;
        this.charge = charge;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCharge() {
        return charge;
    }

    public void setCharge(long charge) {
        this.charge = charge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
