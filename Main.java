import java.util.*;
import java.util.PriorityQueue;
import java.io.*;
import java.text.*;

class Main {


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Hospital hospital = new Hospital("Your Hospital Name", "Hospital Location");
    Admin admin = new Admin("Admin Name", 30, "Male", "admin@example.com", "1234567890", "Admin Address", "admin", "admin123");
    Doctor doctor = new Doctor(1, "Dr. Smith", 35, "Male", "dr.smith@example.com", "1234567890", "123 Main St", "Cardiology", true);
    Doctor doctor2 = new Doctor(2, "Dr. George", 40, "Male", "dr.george@example.com", "1234567890", "123 Main St", "Onthropology", true);


    PriorityQueue<Patient> emergencyQueue = new PriorityQueue<>();

    hospital.setAdmin(admin);

    while (true) {
        System.out.println("Welcome to Hospital Management System!");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Hospital Management");
        System.out.println("3. Login as Doctor");
        System.out.println("4. Login as Patient");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  

        switch (choice) {
            case 1:
                System.out.print("Enter Admin username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Enter Admin password: ");
                String adminPassword = scanner.nextLine();
                if (admin.authenticate(adminUsername, adminPassword)) {
                    adminMenu(admin, hospital);
                } else {
                    System.out.println("Login failed. Please check your username and password.");
                }
                break;

            case 2:

                HospitalMenu(hospital , emergencyQueue);

                break;
            case 3:
                // Patient login logic
                break;
            case 4:
                System.out.println("Exiting Hospital Management System. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }
    }

     

}
    public static void adminMenu(Admin admin, Hospital hospital) {
        Scanner scanner = new Scanner(System.in);
        List<Doctor> doctors = new ArrayList<>(); 
      //  BSTNode appointmentRoot = null; 
         Invoice invoice = new Invoice(1,123,new Date(), 50.0, 100.0, 30.0, 20.0);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. Monitor Doctor Availability");
            System.out.println("4. Calculate Profit/Loss");
            System.out.println("5. Logout");


            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                admin.addDoctor(1, "John Doe", 45, "Male", "john@example.com", "1234567890", "123 Main St", "Cardiology", true);
                admin.addDoctor(2, "Dr. George", 40, "Male", "dr.george@example.com", "1234567890", "123 Main St", "Onthropology", true);
             break;
                case 2:
                    System.out.print("Enter the ID of the doctor to remove: ");
                int doctorIdToRemove = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                admin.removeDoctor(doctorIdToRemove);
                break;
                case 3:
                    admin.monitorDoctorAvailability();
                    break;
                case 4:
                   System.out.println("Calculating Profit/Loss:");
                   System.out.print("Enter total cost incurred: ");
                   double totalCost = scanner.nextDouble();
                   double totalIncome = invoice.totalInvoice();
                   admin.calculateProfitLoss(invoice, totalCost);
                    break;
                case 5:

    
                System.out.println("Logging out from admin account.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }

        }

         

    }

     public static void HospitalMenu(Hospital hospital , PriorityQueue<Patient> emergencyQueue){

                 Scanner scanner = new Scanner(System.in);
                LinkedList<Patient> patients = new LinkedList<>();
                List<Doctor> doctors = new ArrayList<>();
                Doctor doctor = new Doctor(1, "Dr. Smith", 35, "Male", "dr.smith@example.com", "1234567890", "123 Main St", "Cardiology", true);
               Invoice invoice = new Invoice(1,123,new Date(), 50.0, 100.0, 30.0, 20.0);
                Prescription prescription = new Prescription("Fever " , "2 tablets" , " Panadol " , 2 , true, false);
                
                Patient p = new Patient(11 , "Ali" , 19 , "Male" , 1 , "Fever" , "ali@gmail.com" , "3567255" , "xyz" , prescription , invoice );
                Appointment appointment = new Appointment(new Date() , doctor , p);
                Patient emergencyPatient1 = new Patient(34 , "Maleeha" , 22 , "Female" , 3 , "Allergy " , "maleeha@gmail.com" , "837932" , "xyz" , prescription , invoice);
                 Patient emergencyPatient2 = new Patient(32 , "Taha" , 18 , "Male" , 2 , "Chest Infection " , "taha@gmail.com" , "2227932" , "xyz" , prescription , invoice);
                


                 while (true) {
                    System.out.println();
            System.out.println("Hospital Menu:");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. Reschedule Appointment");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Register Patient");
            System.out.println("5. Admit Patient");
            System.out.println("6. Discharge Patient");
            System.out.println("7. Patient Status");
            System.out.println("8. Add Emergency Patient");
            System.out.println("9. Treat Emergency Patients");
            System.out.println("10. Doctor Availability");
            System.out.println("11. Total Patients");

            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                hospital.scheduleAppointment(appointment);
             break;
                case 2:
                   hospital.rescheduleAppointment(appointment);
                break;
                case 3:
                    hospital.cancelAppointment(appointment);
                    break;
                
                case 4:
                    
                  hospital.registerPatient(p);
                    break;
                case 5:
                    hospital.admitPatient(p);

                break;

                 case 6:
                    
                  hospital.dischargePatient(p);
                    break;
                case 7:
                    hospital.patientStatus(p);

                break;


                 case 8:
                    
                  hospital.addEmergencyPatients(p);
                  hospital.addEmergencyPatients(emergencyPatient1);
                  hospital.addEmergencyPatients(emergencyPatient2);

                    break;
                case 9:
                    hospital.treatEmergencyPatients();

                break;

            case 10:
                    hospital.doctorAvailability(doctor);

                break;


                case 11:
                    hospital.totalPatients();


                System.out.println("Logging out from Hospital Management.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number in between 1 and 12.");
            }

        }
 

        }



      
    }

class Appointment {
    private static int counter = 1;
    private int appointmentId;
    private Date date;
    private Doctor doctor;
    private Patient patient;
    private BSTNode root;

    public Appointment(Date date, Doctor doctor, Patient patient) {
        this.appointmentId = counter++;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String toString() {
        return "Appointment ID: " + appointmentId + "\nDate: " + date + "\nDoctor: " + doctor.getName() + "\nPatient: " + patient.getName();
    }

    public void viewDetails(){
        System.out.println("Date : " +getDate());
        System.out.println("Doctor : " +doctor.getName());
        System.out.println("Patient: " +patient.getName());
    }


    public void schedule(Appointment appointment) {
        root = insert(root, appointment);
    }

    public void reschedule(int appointmentId, Date newDate) {
        root = rescheduleAppointment(root, appointmentId, newDate);
    }

    public void cancel(int appointmentId) {
        root = cancelAppointment(root, appointmentId);
    }

    public Appointment search(int appointmentId) {
        return searchAppointment(root, appointmentId);
    }

    public void inorder() {
        inorderTraversal(root);
    }

    private BSTNode insert(BSTNode root, Appointment appointment) {
        if (root == null) {
            return new BSTNode(appointment);
        }

        if (appointment.getDate().compareTo(root.appointment.getDate()) < 0) {
            root.left = insert(root.left, appointment);
        } else {
            root.right = insert(root.right, appointment);
       }

        return root;
    }

    private BSTNode rescheduleAppointment(BSTNode root, int appointmentId, Date newDate) {
        if (root == null) {
            return null;
        }

        if (appointmentId == root.appointment.getAppointmentId()) {
            root.appointment.setDate(newDate);
        } else if (appointmentId < root.appointment.getAppointmentId()) {
            root.left = rescheduleAppointment(root.left, appointmentId, newDate);
        } else {
            root.right = rescheduleAppointment(root.right, appointmentId, newDate);
        }

        return root;
    }

    private BSTNode cancelAppointment(BSTNode root, int appointmentId) {
        if (root == null) {
            return null;
        }

        if (appointmentId == root.appointment.getAppointmentId()) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.appointment = findMin(root.right).appointment;
            root.right = deleteMin(root.right);
        } else if (appointmentId < root.appointment.getAppointmentId()) {
            root.left = cancelAppointment(root.left, appointmentId);
        } else {
            root.right = cancelAppointment(root.right, appointmentId);
        }

        return root;
    }

    private Appointment searchAppointment(BSTNode root, int appointmentId) {
        if (root == null || root.appointment.getAppointmentId() == appointmentId) {
            return root != null ? root.appointment : null;
        }

        if (appointmentId < root.appointment.getAppointmentId()) {
            return searchAppointment(root.left, appointmentId);
        }

        return searchAppointment(root.right, appointmentId);
    }

    public void sortAppointments() {
        inorderTraversal(root);
    }

    private BSTNode findMin(BSTNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private BSTNode deleteMin(BSTNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

    private void inorderTraversal(BSTNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.appointment);
            inorderTraversal(root.right);
        }
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

    




   
