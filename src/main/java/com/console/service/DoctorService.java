package com.console.service;

import com.console.doctor.Doctor;
import com.console.doctor.IDoctorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DoctorService implements IDoctorService {

    Doctor[] emptyDoctorList = new Doctor[]{};

    @Override
    public void createDoctors(int size) {
        emptyDoctorList = new Doctor[size];
        for (int i = 0; i < emptyDoctorList.length; i++) {
            emptyDoctorList[i] = new Doctor();
            String generatedLastName = RandomStringUtils.randomAlphabetic(3);
            String generatedFirstName = RandomStringUtils.randomAlphabetic(2);
            emptyDoctorList[i].setIdentificationNumber(i);
            emptyDoctorList[i].setLastName(generatedLastName);
            emptyDoctorList[i].setFirstName(generatedFirstName);
            emptyDoctorList[i].setAge(new Random().nextInt(65 - 30 + 1) + 30);
        }

    }

   @Override
    public void displayDoctors() {
       for (Doctor doctor : emptyDoctorList) {
           System.out.println("Doctor: Last Name: " + doctor.getLastName() + " First Name: " + doctor.getFirstName() + " Age: " + doctor.getAge());
       }
    }
}
