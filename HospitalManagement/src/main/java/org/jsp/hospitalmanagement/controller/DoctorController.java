package org.jsp.hospitalmanagement.controller;

import java.util.Optional;
import java.util.Scanner;

import org.jsp.hospitalmanagement.dao.DoctorDao;
import org.jsp.hospitalmanagement.dto.Doctor;

public class DoctorController {
	private static Scanner sc = new Scanner(System.in);
	private static DoctorDao doctorDao = new DoctorDao();

	public static void saveDoctor() {
		System.out.println("Enter Hospital id to add doctor");
		int hospital_id = sc.nextInt();
		Doctor d = new Doctor();
		System.out.println("Enter Doctor name");
		d.setName(sc.next());
		System.out.println("Enter Doctor Qualification");
		d.setQualifications(sc.next());
		System.out.println("enter doctor salary");
		d.setSalary(sc.nextDouble());
		Optional<Doctor> doc = doctorDao.saveDoctor(hospital_id, d);
		if (doc.isPresent()) {
			System.out.println("Doctor record is saved with id: " + d.getId());
		} else
			System.out.println("Invalid Hopsital id");
	}

	public static void updateDoctor() {
		Doctor d = new Doctor();
		System.out.println("Enter Doctor id ");
		d.setId(sc.nextInt());
		System.out.println("Enter Doctor name");
		d.setName(sc.next());
		System.out.println("Enter Doctor Qualification");
		d.setQualifications(sc.next());
		System.out.println("enter doctor salary");
		d.setSalary(sc.nextDouble());
		Optional<Doctor> doc = doctorDao.updatedoctor(d);
		if (doc.isPresent()) {
			System.out.println("Doctor record is updated successfully");
		} else
			System.out.println("Invalid Doctor id");
	}

	public static void getDoctor() {
		System.out.println("enter Doctor id to get details");
		Optional<Doctor> d = doctorDao.find(sc.nextInt());
		if (d.isPresent()) {
			Doctor doc = d.get();
			System.out.println("Name: " + doc.getName() + "\nQualification: " + doc.getQualifications() + "\nSalary: "
					+ doc.getSalary());
		} else
			System.out.println("Invalid Doctor Id");
	}

	public static void deleteDoctor() {
		System.out.println("Enter doctor id to delete");
		boolean b = doctorDao.delete(sc.nextInt());
		if (b)
			System.out.println("Doctor delete successfully");
		else
			System.out.println("Invlid doctor id");
	}

}
