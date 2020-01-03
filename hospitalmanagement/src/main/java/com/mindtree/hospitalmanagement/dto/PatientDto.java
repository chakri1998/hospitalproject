package com.mindtree.hospitalmanagement.dto;

public class PatientDto {
	
	private int patientId;
	private String patientName;
	private double patientBill;

	private DoctorDto doctorDto;
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
	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", patientName=" + patientName + ", patientBill=" + patientBill
				+ ", doctorDto=" + doctorDto + "]";
	}
	public double getPatientBill() {
		return patientBill;
	}
	public void setPatientBill(double patientBill) {
		this.patientBill = patientBill;
	}
	public DoctorDto getDoctorDto() {
		return doctorDto;
	}
	public void setDoctorDto(DoctorDto doctorDto) {
		this.doctorDto = doctorDto;
	}
	public PatientDto(int patientId, String patientName, double patientBill, DoctorDto doctorDto) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientBill = patientBill;
		this.doctorDto = doctorDto;
	}
	public PatientDto() {
		super();
	}
	

}
