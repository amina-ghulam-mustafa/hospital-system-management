 import java.util.*;
import java.io.*;
import java.text.*;



 class Patient extends Person {
    private Prescription prescription;
    private Invoice invoice;
    private List<Appointment> appointments;
    private String condition;
    private int severity;
    private Patient next;

    public Patient(int id, String name, int age, String gender, int severity , String condition , String email, String contactInfo, String address, Prescription prescription, Invoice invoice) {
        super(id, name, age, gender, email, contactInfo, address);
        this.prescription = prescription;
        this.condition = condition;
        this.invoice = invoice;
        appointments = new ArrayList<>();
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getCondition() {
        return condition;
    }

    public int getSeverity() {
        return severity;
    }

    public Patient getNext() {
        return next;
    }

    public void setNext(Patient next) {
        this.next = next;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void viewAppointment() {
        System.out.println("Appointments for patient " + getName() + ":");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public void checkInvoices() {
        System.out.println("Invoice for this patient is : ");
        invoice.printInvoice();
    }

    public void viewPrescriptions() {
        prescription.printPrescription();
    }

    @Override
    public void viewDetails() {
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Email: " + getEmail());
        System.out.println("Contact Info: " + getContactInfo());
        System.out.println("Address: " + getAddress());
        System.out.println("Condition : " + getCondition());
    }

    public String record() {
        return "Patient ID: " + getId() + "\n " + "Name: " + getName() + "Age: " + getAge() + "Gender: " + getGender() + "Email: " + getEmail() + "Contact Info: " + getContactInfo() + "Address: " + getAddress() + "Condition : " + getCondition() + "Invoice : " + getInvoice() + "Prescription : " + getPrescription();
    }

    public void feedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide your feedback:");
        String feedback = scanner.nextLine();
        System.out.println("Thank you for your feedback: " + feedback);
    }

    public void choosePaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                payWithCash();
                break;
            case 2:
                payWithCreditCard();
                break;
            case 3:
                payWithDebitCard();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void payWithCash() {
        System.out.println("Payment successful via Cash.");
        
    }

    private void payWithCreditCard() {
        System.out.println("Payment successful via Credit Card.");
        
    }

    private void payWithDebitCard() {
        System.out.println("Payment successful via Debit Card.");
   
    }
}