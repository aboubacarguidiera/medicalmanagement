package com.example.securing_web.services;

import com.example.securing_web.dao.PatientRepository;
import com.example.securing_web.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
  final PatientRepository patientRepository;
  @Autowired
  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }
public Iterable<Patient> findAll() {
    return patientRepository.findAll();
}
  public Optional<Patient> findById(Long id) {
    return patientRepository.findById(id);
  }
  public Patient save(Patient patient) {
    return patientRepository.save(patient);
  }
  public void deleteById(Long id) {
    patientRepository.deleteById(id);
  }
  public Patient update(Long id,Patient patient) {
    if(patientRepository.findById(id).isPresent()) {
      patient.setId(id);
    }
    return patientRepository.save(patient);
  }
  public Optional<Patient> findByName(String name){
    return patientRepository.findByNom(name);
  }
}
