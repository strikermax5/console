package com.console.service;

import com.console.doctor.Doctor;
import com.console.patient.IPatientService;
import com.console.patient.Patient;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.util.Random;

public class PatientService implements IPatientService {
    Patient[] emptyPatientList = new Patient[]{};
    private static final String filepath = "D:/Projects/Spring Work/console/files/patient.txt";

    @Override
    public void createPatients(int size) {
        emptyPatientList = new Patient[size];

        for (int i = 0; i < emptyPatientList.length; i++) {
            emptyPatientList[i] = new Patient();
            String generatedLastName = RandomStringUtils.randomAlphabetic(4);
            String generatedFirstName = RandomStringUtils.randomAlphabetic(5);
            emptyPatientList[i].setLastName(generatedLastName);
            emptyPatientList[i].setFirstName(generatedFirstName);
            emptyPatientList[i].setAge(new Random().nextInt(85 + 1));
            emptyPatientList[i].setReason(String.valueOf(Reason.getRandom()));
        }

    }

    @Override
    public void displayPatients() {
        for (Patient patient : emptyPatientList) {
            System.out.println("Doctor: Last Name: " + patient.getLastName()
                    + " First Name: " + patient.getFirstName()
                    + " Age: " + patient.getAge()
                    + " Reason: " + patient.getReason());
        }
        patientsSummary();
    }


    public void patientsSummary() {
        int[] count = new int[4];
        for (Patient patient : emptyPatientList) {

            if (patient.getAge() <= 1)
                count[0]++;
            if (patient.getAge() >= 1 && patient.getAge() <= 7)
                count[1]++;
            if (patient.getAge() >= 7 && patient.getAge() <= 18)
                count[2]++;
            if (patient.getAge() > 18)
                count[3]++;
        }
        System.out.println("Summary: ");
        System.out.println("Children: " + count[0]);
        System.out.println("Pupil: " + count[1]);
        System.out.println("Student: " + count[2]);
        System.out.println("Adult: " + count[3]);
    }

    private enum Reason {
        CONSULTATION, PRESCRIPTION, TREATMENT;

        public static Reason getRandom() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

    }
    public void writePatientsToFile() throws IOException {
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(emptyPatientList);
            System.out.println("The Objects  were succesfully written to a file");
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readPatinetsFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            while (true) {

                Patient[] pat = (Patient[]) in.readObject();
                if (pat == null) {
                    break;
                } else {
                    for (Patient mockPatient: pat) {
                        System.out.println("Doctor: Last Name: " + mockPatient.getLastName() + " First Name: " + mockPatient.getFirstName() + " Age: " + mockPatient.getAge() + " Reason: " + mockPatient.getReason() );
                    }


                }


            }
            fileIn.close();
        }catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }
    public Patient[] getPatients(){
        return emptyPatientList;
    }
    public void returnRemainingPatients(Patient[] patients, int position) {
        int nrOfPatients = patients.length - position;
        System.out.println("Remaining patients untreated are: " + nrOfPatients);
        for (int i = position; i < patients.length; i++) {
            System.out.println("Patient: Last Name: " + patients[i].getLastName()
                    + " First Name: " + patients[i].getFirstName()
                    + " Age: " + patients[i].getAge()
                    + " Reason: " + patients[i].getReason());
        }

    }
}
