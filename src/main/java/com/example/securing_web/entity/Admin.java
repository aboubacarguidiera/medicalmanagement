package com.example.securing_web.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private String mdp;
  @OneToMany
  private List<Patient> patientList = new ArrayList<Patient>();
  @OneToMany
  private List<Doctor> doctorList = new ArrayList<Doctor>();
  public Admin() {}

  public Admin(String nom, String mdp) {
    this.nom = nom;
    this.mdp = mdp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getMdp() {
    return mdp;
  }

  public void setMdp(String mdp) {
    this.mdp = mdp;
  }

  public List<Patient> getPatientList() {
    return patientList;
  }

  public void setPatientList(List<Patient> patientList) {
    this.patientList = patientList;
  }

  public List<Doctor> getDoctorList() {
    return doctorList;
  }

  public void setDoctorList(List<Doctor> doctorList) {
    this.doctorList = doctorList;
  }
}
