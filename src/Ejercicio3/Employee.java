package Ejercicio3;

public class Employee {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Double salary;
    private Boolean active = false;

    public Employee() {
    }

    public Employee(Long id, String username, String password, String email, Double salary, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.salary = salary;
        this.active = active != null ? active : this.active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
