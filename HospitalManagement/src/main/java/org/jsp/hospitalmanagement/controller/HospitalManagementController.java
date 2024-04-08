package org.jsp.hospitalmanagement.controller;

import java.util.Scanner;

public class HospitalManagementController {
	private static Scanner sc = new Scanner(System.in);

	public static void hospitalTab() {
		while (true) {
			System.out.println("=== Hospital Window ===");
			System.out.println("1.Save \n2.Update\n3.Get Hospital Details\n4.Close Hospital\n5.Exit");
			System.out.println("enter ur option");
			switch (sc.nextInt()) {
			case 1:
				HospitalController.saveHospital();
				break;
			case 2:
				HospitalController.updateHospital();
				break;
			case 3:
				HospitalController.getHospitalDetails();
				break;
			case 4:
				HospitalController.deleteHospital();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid Input");

			}
		}
	}

	public static void patientTab() {
		while (true) {
			System.out.println("=== Patient Window ===");
			System.out.println("1.Save \n2.Update\n3.Get Patient Details\n4.delete Patient details\n5.Exit");
			System.out.println("enter ur option");
			switch (sc.nextInt()) {
			case 1:
				PatientController.savePatient();
				break;
			case 2:
				PatientController.updatePatient();
				break;
			case 3:
				PatientController.getPatient();
				break;
			case 4:
				PatientController.deletePatient();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid Input");

			}
		}
	}

	public static void medicalRecordsTab() {
		while (true) {
			System.out.println("=== Medical Record Window ===");
			System.out.println("1.Save \n2.Update\n3.Get show patient record Details\n4.Delete Patient Record\n5.Exit");
			System.out.println("enter ur option");
			switch (sc.nextInt()) {
			case 1:
				RecordController.save();
				break;
			case 2:
				RecordController.update();
				break;
			case 3:
				RecordController.showRecord();
				break;
			case 4:
				RecordController.delete();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid Input");

			}
		}
	}

	public static void doctorTab() {
		while (true) {
			System.out.println("=== Doctor Window ===");
			System.out.println("1.Save \n2.Update\n3.Get Hospital Details\n4.Delete Doctor\n5.Exit");
			System.out.println("enter ur option");
			switch (sc.nextInt()) {
			case 1:
				DoctorController.saveDoctor();
				break;
			case 2:
				DoctorController.updateDoctor();
				break;
			case 3:
				DoctorController.getDoctor();
				;
				break;
			case 4:
				DoctorController.deleteDoctor();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid Input");

			}
		}
	}

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("=== Hospital Management ===");
			System.out.println("1.Hospital\n2.Doctor\n3.Patients\n4.Medical Records\n5.Exit");
			System.out.println("enter ur option");
			switch (sc.nextInt()) {
			case 1:
				hospitalTab();
				break;
			case 2:
				doctorTab();
				break;
			case 3:
				patientTab();
				break;
			case 4:
				medicalRecordsTab();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid Option");
			}

		}

	}

}
