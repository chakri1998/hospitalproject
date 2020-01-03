package com.mindtree.hospitalmanagement.entity;

import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor implements Comparable<Doctor> {

	@Id
	private int doctorId;

	private String doctorName;
	private int yearsOfExperience;
	@Column(columnDefinition = "double default 0")
	private double doctorSalary;
	
	@JsonIgnore
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Patient> patients;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public double getDoctorSalary() {
		return doctorSalary;
	}

	public void setDoctorSalary(double doctorSalary) {
		this.doctorSalary = doctorSalary;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Doctor(int doctorId, String doctorName, int yearsOfExperience, double doctorSalary, List<Patient> patients) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.yearsOfExperience = yearsOfExperience;
		this.doctorSalary = doctorSalary;
		this.patients = patients;
	}

	public Doctor() {
		super();
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", yearsOfExperience="
				+ yearsOfExperience + ", doctorSalary=" + doctorSalary + ", patients=" + patients + "]";
	}

	@Override
	public int compareTo(Doctor arg0) {
		// TODO Auto-generated method stub

		return (int) (arg0.getDoctorSalary() - this.getDoctorSalary());
	}
	public static Comparator<Doctor> expCompare = new Comparator<Doctor>() {
		@Override
		public int compare(Doctor arg0, Doctor arg1) {
			// TODO Auto-generated method stub
			return (arg1.getYearsOfExperience()-arg0.getYearsOfExperience());
		}

    };
	

}
