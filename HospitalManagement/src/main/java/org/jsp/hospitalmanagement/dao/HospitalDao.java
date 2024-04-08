package org.jsp.hospitalmanagement.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hospitalmanagement.dto.Hospital;

public class HospitalDao {
	private EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();

	public Optional<Hospital> saveHospital(Hospital hospital) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(hospital);
		transaction.commit();
		return Optional.of(hospital);
	}

	public Optional<Hospital> updateHospital(Hospital hospital) {
		Hospital h = getHospital(hospital.getId());
		if (h != null) {
			h.setId(hospital.getId());
			h.setAddress(hospital.getAddress());
			h.setCity(hospital.getCity());
			h.setName(hospital.getName());
			manager.merge(h);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return Optional.of(h);
		}
		return null;
	}

	public Hospital getHospital(int id) {
		return (manager.find(Hospital.class, id));

	}

	public boolean delete(int id) {
		Hospital hospital = getHospital(id);
		if (hospital != null) {
			EntityTransaction transaction = manager.getTransaction();
			manager.remove(hospital);
			;
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

}
