package com.console.service;

import com.console.doctor.Doctor;
import com.console.doctor.IDoctorService;
import com.console.patient.Patient;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.io.*;
import java.util.Random;

@Service
public class DoctorService implements IDoctorService {

    static Doctor[] emptyDoctorList = new Doctor[]{};
    private static final String filepath = "D:/Projects/Spring Work/console/files/doctor.txt";


    @Override
    public void createDoctors(int size) {
        emptyDoctorList = new Doctor[size];
        Random rnd = new Random();
        for (int i = 0; i < emptyDoctorList.length; i++) {
            emptyDoctorList[i] = new Doctor();
            String generatedLastName = RandomStringUtils.randomAlphabetic(3);
            String generatedFirstName = RandomStringUtils.randomAlphabetic(2);
            emptyDoctorList[i].setIdentificationNumber(new Random().nextInt(9999 - 1000 + 1) + 1000);
            emptyDoctorList[i].setLastName(generatedLastName);
            emptyDoctorList[i].setFirstName(generatedFirstName);
            emptyDoctorList[i].setAge(new Random().nextInt(65 - 30 + 1) + 30);
        }

    }

    @Override
    public void displayDoctors() {
        for (Doctor doctor : emptyDoctorList) {
            System.out.println("Doctor: Last Name: " + doctor.getLastName() + " First Name: " + doctor.getFirstName() + " Age: " + doctor.getAge()+" Identification Number: " + doctor.getIdentificationNumber());
        }
    }


    public void writeDoctorsToFile() throws IOException{
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(emptyDoctorList);
            System.out.println("The Objects  were succesfully written to a file");
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readDoctorsFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        try {
            while (true) {

                Doctor[] doc = (Doctor[]) in.readObject();
                if (doc == null) {
                    break;
                } else {
                    for (Doctor mockDoctor: doc) {
                        System.out.println("Doctor: Last Name: " + mockDoctor.getLastName() + " First Name: " + mockDoctor.getFirstName() + " Age: " + mockDoctor.getAge() + " Identification Number: " + mockDoctor.getIdentificationNumber() );
                    }
                }


            }
            fileIn.close();
        }catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }
    public Doctor[] getDoctors(){
        return emptyDoctorList;
    }
}
