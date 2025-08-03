import java.util.*;
import java.io.*;
import java.text.*;


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
        this.root = null;
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
    if (root == null) {
        return null;
    }

    if (root.appointment.getAppointmentId() == appointmentId) {
        return root.appointment;
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


