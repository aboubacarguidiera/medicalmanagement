package com.example.securing_web.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Consultation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private Date date;
  @ManyToOne(fetch = FetchType.LAZY)
  private Patient patient;
  @ManyToOne(fetch = FetchType.LAZY)
  private Doctor doctor;

  public Consultation() {
  }

  public Consultation(String title, Date date, Patient patient, Doctor doctor) {
    this.title = title;
    this.date = date;
    this.patient = patient;
    this.doctor = doctor;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

//  public void setId(Long id) {
//    this.id = id;
//  }

  public Long getId() {
    return id;
  }

//  public void setId(Long id) {
//    this.id = id;
//  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
