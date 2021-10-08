package com.console;

import com.console.service.DoctorService;
import com.console.service.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ConsoleApplication {

	public static void main(String[] args) {
//		DoctorService doctorService = new DoctorService();
		PatientService patientService = new PatientService();
//		System.out.println("Doctors are being initialized");
//		doctorService.createDoctors(8);
//		System.out.println("List of doctors generated: ");
//		doctorService.displayDoctors();
//		System.out.println("List of patients generated: ");
		patientService.createPatients(100);
		patientService.displayPatients();
	}
}
