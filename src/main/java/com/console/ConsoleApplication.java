package com.console;

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

		System.out.println("Doctors are being initialized");
		//doctorService.createDoctors(8);
		System.out.println("List of doctors generated: ");
		//doctorService.displayDoctors();
		//System.out.println("Would you like to save the doctors in a file Y/N?");
		//String ch = console.nextLine();
		//doctorService.writeDoctorsToFile();
		//doctorService.readDoctorsFromFile();
		System.out.println("List of patients generated: ");
		patientService.createPatients(100);
		//patientService.displayPatients();
		patientService.writePatientsToFile();
		patientService.readPatinetsFromFile();
	}
}
