package org.jsp.hospitalmanagement.controller;

import java.util.Scanner;

import org.jsp.hospitalmanagement.dao.MedicalRecordDao;
import org.jsp.hospitalmanagement.dto.MedicalRecord;

public class RecordController {
	private static Scanner sc = new Scanner(System.in);
	private static MedicalRecordDao dao = new MedicalRecordDao();

	public static void save() {
		System.out.println("Enter Patient id");
		int p_id = sc.nextInt();
		MedicalRecord record = new MedicalRecord();
		System.out.println("Enter Problem details");
		record.setProblem(sc.next());
		record = dao.save(p_id, record);
		if (record != null)
			System.out.println("Medica record has been saved with id: " + record.getRecordId());
		else
			System.out.println("Invalid patient id");
	}

	public static void update() {
		MedicalRecord record = new MedicalRecord();
		System.out.println("enter medical record id");
		record.setRecordId(sc.nextInt());
		System.out.println("Enter Problem details");
		record.setProblem(sc.next());
		record = dao.update(record);
		if (record != null)
			System.out.println("Medica record has been updated successfully");
		else
			System.err.println("Invalid Medical record id");
	}

	public static void showRecord() {
		System.out.println("Enter Record Id");
		MedicalRecord r = dao.find(sc.nextInt());
		if (r != null) {
			System.out.println("Patient problem: " + r.getProblem() + "\nDate of Examination of patient: "
					+ r.getDate_of_examination());
		} else
			System.err.println("Invalid Medical record id");
	}

	public static void delete() {
		System.out.println("Enter Record Id");
		boolean b = dao.delete(sc.nextInt());
		if (b)
			System.out.println("Record deleted successfully");
		else
			System.err.println("Invalid record id");
	}

}
