package org.jsp.hospitalmanagement.controller;

import java.util.Optional;
import java.util.Scanner;

import org.jsp.hospitalmanagement.dao.HospitalDao;
import org.jsp.hospitalmanagement.dto.Hospital;

public class HospitalController {
	private static HospitalDao hospitalDao = new HospitalDao();
	private static Scanner sc = new Scanner(System.in);

	public static void saveHospital() {
		Hospital hospital = new Hospital();
		System.out.println("enter hospital name");
		hospital.setName(sc.next());
		System.out.println("enter hospital Address");
		hospital.setAddress(sc.next());
		System.out.println("enter hospital city");
		hospital.setCity(sc.next());
		hospital = hospitalDao.saveHospital(hospital).get();
		System.out.println("Hospital is saved with id: " + hospital.getId());
	}

	public static void updateHospital() {
		Hospital hospital = new Hospital();
		System.out.println("enter hospital id");
		hospital.setId(sc.nextInt());
		System.out.println("enter hospital name");
		hospital.setName(sc.next());
		System.out.println("enter hospital Address");
		hospital.setAddress(sc.next());
		System.out.println("enter hospital city");
		hospital.setCity(sc.next());
		Optional<Hospital> hos = hospitalDao.updateHospital(hospital);
		if (hos.isPresent())
			System.out.println("Hospital is updated successfully ");
		else
			System.out.println("Invalid Hospital id");
	}

	public static void getHospitalDetails() {
		System.out.println("enter hospital id");
		Hospital hospital = hospitalDao.getHospital(sc.nextInt());
		if (hospital != null) {

			System.out.println("Name: " + hospital.getName() + "\nAddress: " + hospital.getAddress() + "\nCity:"
					+ hospital.getCity());
		} else
			System.out.println("Invalid Hospital id");
	}

	public static void deleteHospital() {
		System.out.println("Enter hospital id to delete");
		boolean b = hospitalDao.delete(sc.nextInt());
		if (b)
			System.out.println("Hospital record deleted successfully");
		else
			System.out.println("Invalid Hospital Id");
	}

}
