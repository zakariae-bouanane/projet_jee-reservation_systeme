package Models;

public class Appointment {
    private int id;  // Add this field for the id
    private String name;
    private String email;
    private String phone;
    private String department;
    private String doctor;
    private String date;
    private String message;


    public Appointment(String name, String email, String phone, String department, String doctor, String date, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.doctor = doctor;
        this.date = date;
        this.message = message;
    }

    // Default constructor if needed
    public Appointment() {}

    // Getters and setters for all fields
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
