package com.example.securing_web.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Consultation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private LocalDate date;
  @ManyToOne(fetch = FetchType.LAZY)
  private Patient patient;
  @ManyToOne(fetch = FetchType.LAZY)
  private Doctor doctor;
  @Enumerated(EnumType.STRING)
   private Status status;
  public Consultation() {
  }

  public Consultation(String title, LocalDate date, Patient patient, Doctor doctor) {
    this.title = title;
    this.date = date;
    this.patient = patient;
    this.doctor = doctor;
    this.status = Status.PENDING;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
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

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
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
