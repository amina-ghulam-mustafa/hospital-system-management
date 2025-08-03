import java.util.*;
import java.io.*;
import java.text.*;


class Invoice {

    private int invoiceNumber;
    private int patientId;
    private Date date;
    private List<String> services;
    private double consultationFee;
    private double labTestFee;
    private double surgeryCharges;
    private double additionalServiceCharges;


    public Invoice(int invoiceNumber , int patientId , Date date , Double consultationFee , Double surgeryCharges , Double labTestFee , Double additionalServiceCharges ){

        this.invoiceNumber=invoiceNumber;
        this.patientId=patientId;
        this.date=date;
        this.services = new ArrayList<>();
        this.consultationFee = 0.0;
        this.surgeryCharges =0.0;
        this.labTestFee =0.0;
        this.additionalServiceCharges=0.0;
    }

    public int getInvoiceNumber(){

        return invoiceNumber;
    }

    public int getPatientId(){

        return patientId;
    }

    public Date getDate(){

        return date;
    }

    public double getConsultationFee(){

        return consultationFee;
    }

    public double getLabTestFee(){

        return labTestFee;
    }

    public double getSurgeryCharges(){

        return surgeryCharges;
    }

    public double getAdditionalServiceCharges(){

        return additionalServiceCharges;
    }

    public void addConsultationFee(double fee){

        consultationFee +=fee;
        services.add("Consultation Fee : " +fee);
    }


    public void addLabTestFee(double fee){

        labTestFee+=fee;
        services.add("Lab Test Fee : " +fee);
    }

    public void addSurgeryCharges(double fee){

        surgeryCharges +=fee;
        services.add("Surgery Charges : " +fee);
    }

    public void addAdditionalServiceCharges(double fee){

        additionalServiceCharges +=fee;
        services.add("Additional Service Charges : " +fee);
    }

    public double totalInvoice(){

        return getConsultationFee() + getLabTestFee() + getSurgeryCharges() + getAdditionalServiceCharges();

    }

    public void printInvoice(){

        System.out.println("Invoice Details : ");
        System.out.println("Invoice Number : " +getInvoiceNumber());
        System.out.println("Patient ID : " +getPatientId());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(getDate());

        System.out.println("Date : " + formattedDate);

        for(String service : services){

            System.out.println(service);
        }

        System.out.println("Total Amount : " + totalInvoice());
    }
    
}

