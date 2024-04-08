package org.jsp.hospitalmanagement.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column(nullable = false)
	private String pName;
	@Column(nullable = false)
	private String pDiagnosis;
	@Column(nullable = false)
	private String pAddress;
	@ManyToOne
	@JoinColumn(name="hos_id")
	private Hospital hospital;
	@OneToMany(mappedBy = "patient")
	private List<MedicalRecord> medicalRecords;
	
}
