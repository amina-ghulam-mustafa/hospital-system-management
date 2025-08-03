import java.util.*;
import java.io.*;
import java.text.*;


class Admin extends Person {
    private String username;
    private String password;
    private List<Patient> patients;
    private List<Doctor> doctors;
    private Appointment appointment;

    public Admin(String name, int age, String gender, String email, String contactInfo, String address,
                 String username, String password) {
        super(0, name, age, gender, email, contactInfo, address); // ID set to 0 for admin
        this.username = username;
        this.password = password;
        this.patients = new ArrayList<>();
        this.appointment = appointment;
        this.doctors = new ArrayList<>();
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
    public List<Doctor> getDoctors() {
    return doctors;
}

    public void login(String username , String password) {
        String u = "admin";
        String p = "admin1234";

        if (username.equals(u) && password.equals(p)) {
            System.out.println("Login successful! Welcome, " + username + "!");
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public void addDoctor(int id, String name, int age, String gender, String email, String contactInfo, String address, String specialization, boolean availability) {
        Doctor doctor = new Doctor(id, name, age, gender, email, contactInfo, address, specialization, availability);
        doctors.add(doctor);
        System.out.println("Doctor added successfully: " + doctor.getName());
    }

    public void removeDoctor(int id) {
        Iterator<Doctor> iterator = doctors.iterator();
        while (iterator.hasNext()) {
            Doctor doctor = iterator.next();
            if (doctor.getId() == id) {
                iterator.remove();
                System.out.println("Doctor removed successfully: " + doctor.getName());
                return;
            }
        }
        System.out.println("Doctor with ID " + id + " not found.");
    }
    
    public void monitorDoctorAvailability() {
    System.out.println("Doctor Availability:");
    for (Doctor doctor : doctors) {
       String availabilityStatus;
         if(doctor.isAvailable()) {
           availabilityStatus = "Available";
        } else {
            availabilityStatus = "Not Available";
        }

        System.out.println(doctor.getName() + ": " + doctor.isAvailable());
    }
    }


    public void generateBasicReports(BSTNode appointmentRoot, List<Doctor> doctors) {
        System.out.println("Basic Reports - Number of Appointments per Doctor:");
        for (Doctor doctor : doctors) {
            int appointmentCount = countAppointmentsForDoctor(appointmentRoot, doctor.getId());
            System.out.println(doctor.getName() + ": " + appointmentCount + " appointments");
        }
    }

    // Helper method to count appointments for a specific doctor
    private int countAppointmentsForDoctor(BSTNode root, int doctorId) {
        return countAppointments(root, doctorId);
    }

    // Helper method to recursively count appointments for a specific doctor
    private int countAppointments(BSTNode root, int doctorId) {
        if (root == null) {
            return 0;
        }

        // Count appointments in the left and right subtrees
        int leftCount = countAppointments(root.left, doctorId);
        int rightCount = countAppointments(root.right, doctorId);

        // Count the current appointment if it belongs to the specified doctor
        if (root.appointment.getDoctor().getId() == doctorId) {
            return leftCount + rightCount + 1;
        } else {
            return leftCount + rightCount;
        }
    }

   


    public void calculateProfitLoss(Invoice invoice , double totalCost) {
        double totalIncome = invoice.totalInvoice();
        double profitLoss = totalIncome - totalCost;

        System.out.println("Income Breakdown:");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("----------------------------------");

        if (profitLoss > 0) {
            System.out.println("Profit: $" + profitLoss);
        } else if (profitLoss < 0) {
            System.out.println("Loss: $" + Math.abs(profitLoss));
        } else {
            System.out.println("No profit or loss.");
        }
    }

    @Override
    void viewDetails() {
        System.out.println("Admin Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Email: " + getEmail());
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Address: " + getAddress());
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }



    class BSTNode {
    Appointment appointment;
    BSTNode left;
    BSTNode right;

    public BSTNode(Appointment appointment) {
        this.appointment = appointment;
        this.left = null;
        this.right = null;
    }
}
}