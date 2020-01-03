package com.mindtree.hospitalmanagement.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mindtree.hospitalmanagement.dto.DoctorDto;
import com.mindtree.hospitalmanagement.entity.Doctor;
import com.mindtree.hospitalmanagement.serviceimplimentation.HospitalServiceImplimentation;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class HospitalControllerTest {

	@Mock
	HospitalServiceImplimentation serviceImpl;
	
	
	@InjectMocks
    private HospitalController controller;
	
	@Autowired
	private MockMvc mockmvc;
	
	DoctorDto doctorDto=new DoctorDto(1, "sdvb", 1, 234,null);
	
	Doctor doctor=new Doctor(1, "sdvb", 1, 234,null);
	
	@Test
	public void testAddDoctor() {
		when(serviceImpl.addDoctor(doctorDto)).thenReturn(doctor);
		assertEquals(controller.addDoctor(doctorDto).getStatusCodeValue(),200);
	}

	@Test
	public void testGetDoctors() {
		List<DoctorDto>result=new ArrayList<DoctorDto>();
		result.add(doctorDto);
		when(serviceImpl.getAllDoctors()).thenReturn(result);
		assertEquals(result.size(), 1);
	}


}
