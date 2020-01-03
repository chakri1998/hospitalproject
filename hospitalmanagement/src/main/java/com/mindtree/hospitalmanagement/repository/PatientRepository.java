package com.mindtree.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalmanagement.entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
