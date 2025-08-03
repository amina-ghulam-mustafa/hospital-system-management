 import java.util.*;
import java.io.*;
import java.text.*;

 class Prescription {
    private Patient patient;
    private String disease;
    private String dosage;
    private String medicines;
    private int daysOfMedicines;
    private boolean isLabTest;
    private List<LabTest> labTests;
    private boolean admit;

    public Prescription(String disease, String dosage, String medicines, int daysOfMedicines, boolean admit,boolean isLabTest)
{
        this.disease = disease;
        this.dosage = dosage;
        this.medicines = medicines;
        this.isLabTest = isLabTest;
        this.labTests = labTests;

        this.daysOfMedicines = daysOfMedicines;
        
        this.admit = admit;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public int getDaysOfMedicines() {
        return daysOfMedicines;
    }

    public void setDaysOfMedicines(int daysOfMedicines) {
        this.daysOfMedicines = daysOfMedicines;
    }


    public boolean getAdmit() {
        return admit;
    }

    public void setAdmit(boolean admit) {
        this.admit = admit;
    }

     public boolean isLabTest() {
        return isLabTest;
    }

    public void setLabTest(boolean labTest) {
        isLabTest = labTest;
    }

    public List<LabTest> getLabTests() {
        return labTests;
    }

    public void setLabTests(List<LabTest> labTests) {
        this.labTests = labTests;
    }


    public void printPrescription() {
       
       patient.viewDetails();
    
        System.out.println("Disease: " + getDisease());
        System.out.println("Dosage: " + dosage);
        System.out.println("Medicines: " + medicines);
        System.out.println("Days of Medicines: " + daysOfMedicines);

        System.out.println("Is Lab Test Required: " + isLabTest);
        if (isLabTest) {
            System.out.println("Lab Tests:");
            for (LabTest labTest : labTests) {
                System.out.println("- " + labTest.getName());
            }
        }
       
        System.out.println("Admit: " + admit);
    }
}

