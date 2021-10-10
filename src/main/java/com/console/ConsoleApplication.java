package com.console;

import com.console.service.ClinicService;
import com.console.service.DoctorService;
import com.console.service.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;


@SpringBootApplication
public class ConsoleApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DoctorService doctorService = new DoctorService();
		PatientService patientService = new PatientService();
		Scanner console = new Scanner(System.in);
		ClinicService clinicService = new ClinicService();

		System.out.println("Doctors are being initialized");
		doctorService.createDoctors(8);
		System.out.println("List of doctors generated: ");
		doctorService.displayDoctors();
	//	System.out.println("Doctors are being written to a file");
	//	doctorService.writeDoctorsToFile();
	//	System.out.println("Read doctors from file");
	//	doctorService.readDoctorsFromFile();
		System.out.println("List of patients generated: ");
		patientService.createPatients(100);
	//	patientService.displayPatients();
		//System.out.println("Patients are being written to a file");
	//	patientService.writePatientsToFile();
		//System.out.println("Read patients from file");
	//	patientService.readPatinetsFromFile();
		System.out.println("Test if clinic service works");
		clinicService.createClinic(doctorService, patientService);
	}
}
