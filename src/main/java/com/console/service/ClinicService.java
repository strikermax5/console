package com.console.service;


import com.console.clinic.IClinicService;
import com.console.doctor.Doctor;
import com.console.patient.Patient;

import java.util.Arrays;
import java.util.HashMap;

public class ClinicService implements IClinicService {
    HashMap<Long, Boolean> doctorHasWorked = new HashMap<Long, Boolean>();
    long workday = 720; //workday in hours
    long shift = workday / 2;
    int position = 0;

    @Override
    public void createClinic(DoctorService doctorService, PatientService patientService) {

        Doctor[] doctors = doctorService.getDoctors();
        Patient[] patients = patientService.getPatients();
        Arrays.sort(patients);
        //patientService.displayPatients();

        for (Doctor doc : doctors) {
            doctorHasWorked.put(doc.getIdentificationNumber(), false);
        }
        for (Doctor doc : doctors) {
            shift(doc, patients);
        }

        patientService.returnRemainingPatients(patients, position);


    }

    @Override
    public void shift(Doctor doctor, Patient[] patients) {
        int startHour = 0;
        long price = 0;
        int count = 0;
        if (position > 0) {
            for (int i = position; i < patients.length; i++) {
                if (startHour > shift) {
                    break;
                } else {
                    if (patients[i].getReason() == "PRESCRIPTION") {
                        price = price + 20;
                        startHour = startHour + 20;
                        position = position + 1;
                        count = count + 1;
                    } else if (patients[i].getReason() == "CONSULTATION") {
                        price = price + 50;
                        startHour = startHour + 30;
                        position = position + 1;
                        count = count + 1;
                    } else if (patients[i].getReason() == "TREATMENT") {
                        price = price + 35;
                        startHour = startHour + 40;
                        position = position + 1;
                        count = count + 1;
                    }
                }
            }
        } else {
            for (int i = 0; i < patients.length; i++) {
                if (startHour > shift) {
                    break;
                } else {
                    if (patients[i].getReason() == "PRESCRIPTION") {
                        price = price + 20;
                        startHour = startHour + 20;
                        position = position + 1;
                        count = count + 1;
                    } else if (patients[i].getReason() == "CONSULTATION") {
                        price = price + 50;
                        startHour = startHour + 30;
                        position = position + 1;
                        count = count + 1;
                    } else if (patients[i].getReason() == "TREATMENT") {
                        price = price + 35;
                        startHour = startHour + 40;
                        position = position + 1;
                        count = count + 1;
                    }
                }
            }
        }

        doctorHasWorked.put(doctor.getIdentificationNumber(), true);
        System.out.println("Doctor: First Name " + doctor.getFirstName() + " Last Name: " + doctor.getLastName() + " - " + doctor.getIdentificationNumber() + ": Nr of patients: " + count + " Time on Shift: " + startHour + "; Cashed: " + price);

    }


}
