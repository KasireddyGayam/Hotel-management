package org.jsp.hospitalmanagement.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	@Column(nullable = false)
	private String problem;
	@CreationTimestamp
	private LocalDateTime date_of_examination;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

}
