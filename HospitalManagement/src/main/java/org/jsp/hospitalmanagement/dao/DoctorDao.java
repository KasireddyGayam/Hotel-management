package org.jsp.hospitalmanagement.dao;

import java.util.Arrays;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hospitalmanagement.dto.Doctor;
import org.jsp.hospitalmanagement.dto.Hospital;

public class DoctorDao {
	private EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();

	public Optional<Doctor> saveDoctor(int id, Doctor doctor) {
		Hospital hospital = manager.find(Hospital.class, id);
		if (hospital != null) {
			EntityTransaction transaction = manager.getTransaction();
			doctor.setHospital(hospital);
			hospital.setDoctors(Arrays.asList(doctor));
			manager.persist(doctor);
			transaction.begin();
			transaction.commit();
			return Optional.of(doctor);
		}
		return null;
	}

	public Optional<Doctor> updatedoctor(Doctor doctor) {
		Optional<Doctor> d1 = find(doctor.getId());
		if (d1.isPresent()) {
			Doctor d = d1.get();
			d.setName(doctor.getName());
			d.setQualifications(doctor.getQualifications());
			d.setSalary(doctor.getSalary());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(d);
			return Optional.of(d);
		}
		return null;

	}

	public Optional<Doctor> find(int id) {
		return Optional.of(manager.find(Doctor.class, id));
	}

	public boolean delete(int id) {
		Optional<Doctor> d = find(id);
		if (d.isPresent()) {
			manager.remove(d.get());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
}
