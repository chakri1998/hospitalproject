package com.mindtree.hospitalmanagement.serviceimplimentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalmanagement.dto.DoctorDto;
import com.mindtree.hospitalmanagement.dto.PatientDto;
import com.mindtree.hospitalmanagement.entity.Doctor;
import com.mindtree.hospitalmanagement.entity.Patient;
import com.mindtree.hospitalmanagement.exception.ControllerException;
import com.mindtree.hospitalmanagement.repository.DoctorRepository;
import com.mindtree.hospitalmanagement.repository.PatientRepository;
import com.mindtree.hospitalmanagement.serviceinterface.HospitalServiceInterface;

@Service
public class HospitalServiceImplimentation implements HospitalServiceInterface {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Doctor addDoctor(DoctorDto doctorDto) {

		Doctor result = new Doctor();
		ModelMapper modelMappper = new ModelMapper();
		Doctor doctor = modelMappper.map(doctorDto, Doctor.class);
		result = doctorRepository.save(doctor);
		return result;
	}

	@Override
	public Patient addPatient(PatientDto patientDto) {

		Patient result = new Patient();
		ModelMapper modelMappper = new ModelMapper();
		Patient patient = modelMappper.map(patientDto, Patient.class);
		result = patientRepository.save(patient);
		return result;
	}

	@Override
	public Patient assignToDoctor(PatientDto patientDto) {

		System.out.println(patientDto.toString());
		Patient result = new Patient();
		List<Patient> patients = new ArrayList<Patient>();
		List<Doctor> doctors = new ArrayList<Doctor>();
		ModelMapper modelMappper = new ModelMapper();
		Patient patient = modelMappper.map(patientDto, Patient.class);
		System.out.println(patient.toString());
		patients = patientRepository.findAll();
		doctors = doctorRepository.findAll();
		for (Patient patient1 : patients) {
			for (Doctor doctor : doctors) {
				if (patient1.getPatientName().equals(patient.getPatientName())) {
					if (doctor.getDoctorName().equals(patient.getDoctor().getDoctorName())) {
						patient1.setDoctor(doctor);
						double salary = doctor.getDoctorSalary() + patient1.getPatientBill();
						doctor.setDoctorSalary(salary);
						result = patientRepository.saveAndFlush(patient1);
						doctorRepository.saveAndFlush(doctor);
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<DoctorDto> getAllDoctors() {

		List<Doctor> result = doctorRepository.findAll();
		List<DoctorDto> doctorDtos = new ArrayList<DoctorDto>();
		Collections.sort(result);
		for (Doctor doctor1 : result) {
			List<PatientDto> patients = new ArrayList<PatientDto>();
			for (Patient patient : doctor1.getPatients()) {
				PatientDto patientDto = new PatientDto();
				BeanUtils.copyProperties(patient, patientDto);
				patients.add(patientDto);
			}
			DoctorDto doctorDto = new DoctorDto();
			doctorDto.setPatientsDto(patients);
			BeanUtils.copyProperties(doctor1, doctorDto);
			doctorDtos.add(doctorDto);
		}

		return doctorDtos;
	}

	@Override
	public List<DoctorDto> displayByCount() throws ControllerException {

		List<Doctor> result = new ArrayList<Doctor>();
		List<Doctor> doctors = doctorRepository.findAll();
		List<DoctorDto> doctorDtos = new ArrayList<DoctorDto>();
		for (Doctor doctor : doctors) {
			if (doctor.getPatients().size() >= 1) {
				result.add(doctor);
			}
		}
		Collections.sort(result, Doctor.expCompare);

		for (Doctor doctor1 : result) {
			List<PatientDto> patients = new ArrayList<PatientDto>();
			for (Patient patient : doctor1.getPatients()) {
				PatientDto patientDto = new PatientDto();
				BeanUtils.copyProperties(patient, patientDto);
				patients.add(patientDto);
			}
			DoctorDto doctorDto = new DoctorDto();
			doctorDto.setPatientsDto(patients);
			BeanUtils.copyProperties(doctor1, doctorDto);
			doctorDtos.add(doctorDto);
		}
		if (doctorDtos.isEmpty()) {
			throw new ControllerException("no doctors found");
		}
		return doctorDtos;
	}

}
