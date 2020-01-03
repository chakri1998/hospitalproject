package com.mindtree.hospitalmanagement.serviceinterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.hospitalmanagement.dto.DoctorDto;
import com.mindtree.hospitalmanagement.dto.PatientDto;
import com.mindtree.hospitalmanagement.entity.Doctor;
import com.mindtree.hospitalmanagement.entity.Patient;
import com.mindtree.hospitalmanagement.exception.ControllerException;

@Service
public interface HospitalServiceInterface {

	public Doctor addDoctor(DoctorDto doctorDto);

	public Patient addPatient(PatientDto patientDto);

	public Patient assignToDoctor(PatientDto patientDto);

	public List<DoctorDto> getAllDoctors();

	public List<DoctorDto> displayByCount() throws ControllerException;

}
