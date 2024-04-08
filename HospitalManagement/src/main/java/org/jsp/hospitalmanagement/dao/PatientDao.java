package org.jsp.hospitalmanagement.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hospitalmanagement.dto.Hospital;
import org.jsp.hospitalmanagement.dto.Patient;

public class PatientDao {
	private EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();

	public Patient save(int hospitl_id, Patient p) {
		Hospital hospital = manager.find(Hospital.class, hospitl_id);
		if (hospital != null) {
			hospital.setPatients(Arrays.asList(p));
			p.setHospital(hospital);
			manager.persist(p);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return p;
		}
		return null;
	}

	public Patient update(Patient patient) {
		Patient p = find(patient.getPid());
		if (p != null) {
			p.setPAddress(patient.getPAddress());
			p.setPDiagnosis(patient.getPDiagnosis());
			p.setPName(patient.getPName());
			manager.merge(p);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return p;
		}
		return null;
	}

	public Patient find(int id) {
		return manager.find(Patient.class, id);
	}

	public boolean delete(int id) {
		Patient p = find(id);
		if (p != null) {
			manager.remove(p);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
}
