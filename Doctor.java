import java.util.*;
import java.io.*;
import java.text.*;


class Doctor extends Person {
    private Queue<Patient> patientQueue;
    private String specialization;
    private boolean availability;

    public Doctor(int id, String name, int age, String gender, String email, String contactInfo, String address, String specialization, boolean availability) {
        super(id, name, age, gender, email, contactInfo, address);
        this.specialization = specialization;
        this.availability = true; 
        patientQueue = new LinkedList<>();
    }

    public void setAvailable(boolean availability) {
        this.availability = availability;
    }

     public boolean isAvailable() {
        return availability;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void addPatientToQueue(Patient patient) {
        patientQueue.offer(patient);
        System.out.println("Patient " + patient.getName() + " added to the queue.");
    }

    public void readPatientHistoryFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Patient History:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading patient history file: " + e.getMessage());
        }
    }

    public void examinePatient(Patient patient, String patientHistoryFilePath) {
        System.out.println("Examining patient: " + patient.getName());
        readPatientHistoryFromFile(patientHistoryFilePath);
        
    }

    public void prescribeMedicine(Patient patient, String medicine) {
        System.out.println("Prescribing " + medicine + " for patient: " + patient.getName());
        
    }

    public void viewAppointmentSchedule() {
       
        System.out.println("Viewing appointment schedule...");
    }

    @Override
    public void viewDetails() {
    System.out.println("Doctor Details:");
    System.out.println("ID: " + getId());
    System.out.println("Name: " + getName());
    System.out.println("Age: " + getAge());
    System.out.println("Gender: " + getGender());
    System.out.println("Email: " + getEmail());
    System.out.println("Contact Info: " + getContactInfo());
    System.out.println("Address: " + getAddress());
    System.out.println("Specialization: " + getSpecialization());
    if (isAvailable()) {
        System.out.println("Availability: Available");
    } else {
        System.out.println("Availability: Not Available");
    }
}

}