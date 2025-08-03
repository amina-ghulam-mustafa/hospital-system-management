import java.util.*;
import java.io.*;
import java.text.*;


class Hospital {

    private String name;
    private String location;
    private Patient patient;
    private Patient head;
    private int totalPatients;
    private Doctor doctor;
    private Admin admin;
    private Appointment appointment;
    private PriorityQueue<Patient> emergencyQueue;
    private boolean isAdmit;

    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
        emergencyQueue = new PriorityQueue<>(new PatientComparator());
        
    }
    public Hospital(String name, String location, Patient patient , Doctor doctor, Appointment appointment) {
        this.name = name;
        this.location = location;
        this.patient = patient;
        this.doctor= doctor;
        this.appointment=appointment;

        emergencyQueue = new PriorityQueue<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDoctor(Doctor doctor){

        this.doctor = doctor;

    }

    public Doctor getDoctor(){

        return doctor;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

     public Appointment getAppointments() {
        return appointment;
    }

    public void scheduleAppointment(Appointment appointment) {
      appointment.viewDetails();
      System.out.println("Appointment is scheduled!");
    }

    public void rescheduleAppointment(Appointment appointment) {
       appointment.viewDetails();
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter new date : ");
        String newDate = sc.next();
        
       System.out.println("Appointment is Rescheduled on the " +newDate + " Date !");
    }

    public void cancelAppointment(Appointment appointment) {
        appointment.viewDetails();
               System.out.println("Appointment is Cancelled!");

}
    public Appointment searchAppointment(int appointmentId) {
    
        return appointment.search(appointmentId);
    }

     public void doctorAvailability(Doctor doctor){
      System.out.println(doctor.getName());
      if(doctor.isAvailable()){
        System.out.println("Avaialable");
      } else{
        System.out.println("Not Avaialable");
      }
  }

    public void printAppointments() {
        appointment.inorder();
    }

    public boolean isAdmit(){
        return isAdmit;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getTotalPatients() {
        return totalPatients;
    }

    public void registerPatient(Patient patient) {
        if (head == null) {
            head = patient;
        } else {
            Patient current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(patient);
        }

        totalPatients++;

        patient.viewDetails();

        System.out.println("Patient is registered!");

        Prescription prescription = patient.getPrescription();

        if (prescription.getAdmit()) {
            admitPatient(patient);
        }
    }

    public void admitPatient(Patient admitPatient) {
        if (head == null) {
            head = admitPatient;
        } else {
            Patient current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(admitPatient);
        }
        System.out.println();
        admitPatient.viewDetails();

        System.out.println("Patient is admitted!");

        isAdmit = true ;

    }

    public void dischargePatient(Patient dischargePatient) {
        if (head == null) {
            throw new NoSuchElementException("There are no patients in the hospital!");
        } else if (head.equals(dischargePatient)) {
            head = head.getNext();
            totalPatients--;

            dischargePatient.viewDetails();
                System.out.println("Patient is discharged");

        } else {
            Patient current = head;
            while (current.getNext() != null) {
                if (current.getNext().equals(dischargePatient)) {
                    current.setNext(current.getNext().getNext());
                    totalPatients--;
                    return;
                }
                current = current.getNext();

                dischargePatient.viewDetails();
                System.out.println("Patient is discharged");
            }

            System.out.println("Patient not found in the hospital!");
            isAdmit = false;
        }
    }

    public void patientStatus(Patient patient) {
        if (isAdmit()) {
            System.out.println(patient.getName() + " is admitted!");
        } else {
            System.out.println(patient.getName() + " is discharged!");
        }
    }

    public void addEmergencyPatients(Patient patient) {


        emergencyQueue.add(patient);
        patient.viewDetails();
        System.out.println("Emergency Patient " + patient.getName() + " added to queue!");
    }

    public void treatEmergencyPatients() {
        while (!emergencyQueue.isEmpty()) {
            Patient emergencyPatient = emergencyQueue.poll();
            System.out.println("Treating emergency patient: " + emergencyPatient.getName());
        }
        if(emergencyQueue.isEmpty()){
        System.out.println("There are no emergency patients in the queue now!");

    }
    }

    public Patient poll() {
        if (emergencyQueue == null) {
            return null;
        }

        Patient polledPatient = null;
        PriorityQueue<Patient> temp = new PriorityQueue<>(emergencyQueue);
        emergencyQueue = null;
        while (!temp.isEmpty()) {
            Patient patient = temp.poll();

            if (polledPatient == null || patient.getSeverity() > polledPatient.getSeverity()) {
                polledPatient = patient;
            } else {
                emergencyQueue.add(patient);
            }
        }

        return polledPatient;
    }

    

    public void totalPatients() {
        System.out.println("Total Number Of Patients Are: " + getTotalPatients());
    }

    public void writePatientRecord(Patient patient) {
        try {
            FileWriter writer = new FileWriter("patientRecords.txt", true);

            
            writer.write(patient.record() + "\n");
            writer.close();
            System.out.println("Patient record written successfully");
        } catch (IOException e) {
            System.out.println("Error writing patient record: " + e);
        }
    }

    private class PatientComparator implements Comparator <Patient>{

        public int compare(Patient p1 , Patient p2){
            return Integer.compare(p1.getSeverity(),p2.getSeverity());
        }
    }
}



