package com.console.clinic;

import com.console.doctor.Doctor;
import com.console.patient.Patient;
import com.console.service.DoctorService;
import com.console.service.PatientService;

public interface IClinicService {
    void createClinic(DoctorService doctorService, PatientService patientService);
    void shift(Doctor doctor, Patient[] patients);
}

