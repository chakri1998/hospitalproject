package com.mindtree.hospitalmanagement.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DoctorDto {

	private int doctorId;

	private String doctorName;
	private int yearsOfExperience;
	private double doctorSalary;
	@JsonIgnoreProperties("doctorDto")
	private List<PatientDto> patientsDto;

	public DoctorDto() {
		super();
	}

	public DoctorDto(int doctorId, String doctorName, int yearsOfExperience, double doctorSalary,
			List<PatientDto> patientsDto) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.yearsOfExperience = yearsOfExperience;
		this.doctorSalary = doctorSalary;
		this.patientsDto = patientsDto;
	}

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

	public List<PatientDto> getPatientsDto() {
		return patientsDto;
	}

	public void setPatientsDto(List<PatientDto> patientsDto) {
		this.patientsDto = patientsDto;
	}

	@Override
	public String toString() {
		return "DoctorDto [doctorId=" + doctorId + ", doctorName=" + doctorName + ", yearsOfExperience="
				+ yearsOfExperience + ", doctorSalary=" + doctorSalary + ", patientsDto=" + patientsDto + "]";
	}

}
