package lk.ijse.spring.dto;

public class DriverDTO {
    private String id;
    private String name;
    private double Salary;
    private String contact;
    private String address;

    public DriverDTO() {
    }

    public DriverDTO(String id, String name, double salary, String contact, String address) {
        this.id = id;
        this.name = name;
        Salary = salary;
        this.contact = contact;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Salary=" + Salary +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
