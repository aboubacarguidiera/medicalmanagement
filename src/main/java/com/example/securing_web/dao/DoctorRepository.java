package com.example.securing_web.dao;

import com.example.securing_web.entity.Doctor;
import com.example.securing_web.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
  public Optional<Doctor> findByName(String name);
  public Optional<Doctor> findByMail(String mail);
}
