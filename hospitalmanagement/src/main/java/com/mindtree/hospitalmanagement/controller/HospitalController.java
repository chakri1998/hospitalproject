package com.mindtree.hospitalmanagement.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hospitalmanagement.dto.DoctorDto;
import com.mindtree.hospitalmanagement.dto.PatientDto;
import com.mindtree.hospitalmanagement.entity.Doctor;
import com.mindtree.hospitalmanagement.entity.Patient;
import com.mindtree.hospitalmanagement.exception.ControllerException;
import com.mindtree.hospitalmanagement.serviceinterface.HospitalServiceInterface;

@RestController
@RequestMapping("/hospitalmanagementsystem")
public class HospitalController {

	@Autowired
	HospitalServiceInterface hospitalServiceInterface;

	@PostMapping("/adddoctor")
	public ResponseEntity<Map<String, Object>> addDoctor(@RequestBody DoctorDto doctorDto) {

		Doctor result = hospitalServiceInterface.addDoctor(doctorDto);
		Map<String, Object> success = new HashMap<String, Object>();

		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", result);

		return new ResponseEntity<Map<String,Object>>(success,HttpStatus.OK);

	}

	@PostMapping("/addpatient")
	public ResponseEntity<Map<String, Object>> addPatient(@RequestBody PatientDto patientDto) {
		Patient result = hospitalServiceInterface.addPatient(patientDto);
		Map<String, Object> success = new HashMap<String, Object>();

		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", result);
		return new ResponseEntity<Map<String,Object>>(success,HttpStatus.OK);
	}

	@PostMapping("/assigntodoctor")
	public ResponseEntity<Map<String, Object>> assignToDoctor(@RequestBody PatientDto patientDto) {
		Patient result = hospitalServiceInterface.assignToDoctor(patientDto);
		Map<String, Object> success = new HashMap<String, Object>();

		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", result);
		return new ResponseEntity<Map<String,Object>>(success,HttpStatus.OK);
	}

	@GetMapping("/getdoctors")
	public ResponseEntity<Map<String, Object>> getDoctors() throws ControllerException {
		List<DoctorDto> result = new ArrayList<DoctorDto>();
		result = hospitalServiceInterface.getAllDoctors();
		File file=new File("D://Shyam//hospitaldatabase.txt");
		try {
			FileWriter fileWriter=new FileWriter(file);
			for (DoctorDto doctorDto : result){
				fileWriter.write(""+doctorDto);

				fileWriter.write("\n");
			}
			
			fileWriter.close();
		}
		catch (IOException e) {
			// TODO: handle exception
			throw new ControllerException("file not found");
		}
		
		Map<String, Object> success = new HashMap<String, Object>();

		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", result);
		return new ResponseEntity<Map<String,Object>>(success,HttpStatus.OK);
	}

	@GetMapping("/displaybycount")
	public ResponseEntity<Map<String, Object>> displayByCount() throws ControllerException {
		List<DoctorDto> result = new ArrayList<DoctorDto>();
		result = hospitalServiceInterface.displayByCount();
		Map<String, Object> success = new HashMap<String, Object>();

		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", result);
		return new ResponseEntity<Map<String,Object>>(success,HttpStatus.OK);
	}

}
