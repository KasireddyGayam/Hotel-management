package org.jsp.hospitalmanagement.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hospitalmanagement.dto.MedicalRecord;
import org.jsp.hospitalmanagement.dto.Patient;

public class MedicalRecordDao {
	private EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();

	public MedicalRecord save(int p_id, MedicalRecord record) {
		Patient p = manager.find(Patient.class, p_id);
		if (p != null) {
			record.setPatient(p);
			p.setMedicalRecords(Arrays.asList(record));
			manager.persist(record);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return record;
		}
		return null;
	}

	public MedicalRecord update(MedicalRecord record) {
		MedicalRecord r = find(record.getRecordId());
		if (r != null) {
			r.setProblem(record.getProblem());
			manager.merge(r);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return r;
		}
		return null;
	}

	public MedicalRecord find(int id) {
		return manager.find(MedicalRecord.class, id);
	}

	public boolean delete(int id) {
		MedicalRecord r = find(id);
		if (r != null) {
			manager.remove(r);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

}
