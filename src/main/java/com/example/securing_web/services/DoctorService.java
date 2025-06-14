package com.example.securing_web.services;

import com.example.securing_web.dao.DoctorRepository;
import com.example.securing_web.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
  final DoctorRepository doctorRepository;
  @Autowired
  public DoctorService(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }
  public Iterable<Doctor> findAll() {
    return doctorRepository.findAll();
  }
  public Optional<Doctor> findById(Long id) {
    return doctorRepository.findById(id);
  }
  public Doctor save(Doctor doctor) {
    return doctorRepository.save(doctor);
  }
  public void deleteById(Long id) {
    doctorRepository.deleteById(id);
  }
  public Doctor update(Long id,Doctor doctor) {
    if(doctorRepository.findById(id).isPresent()) {
      doctor.setId(id);
    }
    return doctorRepository.save(doctor);
  }
  public Optional<Doctor> findByName(String name){
    return this.doctorRepository.findByName(name);

  }
public List<Doctor> available(){
    return this.doctorRepository.findByAvailableTrue();
}
  public Optional<Doctor> findByEmail(String email){
    return this.doctorRepository.findByMail(email);
  }
}
