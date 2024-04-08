package org.jsp.hospitalmanagement.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Hospital 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String city;
	@OneToMany(mappedBy = "hospital")
	private List<Doctor> doctors;
	@OneToMany(mappedBy = "hospital")
	private List<Patient> patients;
}
