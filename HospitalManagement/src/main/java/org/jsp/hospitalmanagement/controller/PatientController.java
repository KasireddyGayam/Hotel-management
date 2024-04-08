package org.jsp.hospitalmanagement.controller;

import java.util.Scanner;

import org.jsp.hospitalmanagement.dao.PatientDao;
import org.jsp.hospitalmanagement.dto.Patient;

public class PatientController {
	private static Scanner sc = new Scanner(System.in);
	private static PatientDao patientDao = new PatientDao();

	public static void savePatient() {
		System.out.println("enter Hospital Id to add patient");
		int hospital_id = sc.nextInt();
		Patient p = new Patient();
		System.out.println("Enter Patient Name");
		p.setPName(sc.next());
		System.out.println("Enter Patient Address");
		p.setPAddress(sc.next());
		System.out.println("Enter Patient Diagnosis");
		p.setPDiagnosis(sc.next());
		p = patientDao.save(hospital_id, p);
		if (p != null)
			System.out.println("Patient record saved with id: " + p.getPid());
		else
			System.out.println("Invalid hospial id");
	}

	public static void updatePatient() {
		Patient p = new Patient();
		System.out.println("enter patient id to update");
		p.setPid(sc.nextInt());
		System.out.println("Enter Patient Name");
		p.setPName(sc.next());
		System.out.println("Enter Patient Address");
		p.setPAddress(sc.next());
		System.out.println("Enter Patient Diagnosis");
		p.setPDiagnosis(sc.next());
		p = patientDao.update(p);
		if (p != null)
			System.out.println("Patient record updated successfully");
		else
			System.err.println("Invalid Patient id");
	}

	public static void getPatient() {
		System.out.println("enter ptient id to show details");
		Patient p = patientDao.find(sc.nextInt());
		if (p != null) {
			System.out.println(
					"Name: " + p.getPName() + "\nAddress: " + p.getPAddress() + "\nDiagnosis: " + p.getPDiagnosis());
		} else
			System.err.println("Invalid Patient Id");
	}

	public static void deletePatient() {
		System.out.println("enter patient id to delete");
		boolean b = patientDao.delete(sc.nextInt());
		if (b)
			System.out.println("Patient record deleted successfully");
		else
			System.err.println("Invalid Patient Id");
	}
}
