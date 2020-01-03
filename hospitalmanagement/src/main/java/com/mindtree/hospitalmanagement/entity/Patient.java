package com.mindtree.hospitalmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Patient {

	@Id
	private int patientId;

	private String patientName;
	private double patientBill;

	@ManyToOne
	private Doctor doctor;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public double getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(double patientBill) {
		this.patientBill = patientBill;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient(int patientId, String patientName, double patientBill, Doctor doctor) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientBill = patientBill;
		this.doctor = doctor;
	}

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientBill=" + patientBill
				+ ", doctor=" + doctor + "]";
	}

}
