package com.example.securing_web.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String mail;
  private String mdp;
  private boolean available = false;
  @OneToMany(mappedBy = "doctor")
  private List<Consultation> consultations = new ArrayList<>(); ;
  public Doctor() {
  }

  public Doctor(String name, String mail, String mdp) {
    this.name = name;
    this.mail = mail;
    this.mdp = mdp;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public String getMdp() {
    return mdp;
  }

  public void setMdp(String mdp) {
    this.mdp = mdp;
  }

  public Long getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public List<Consultation> getConsultations() {
    return consultations;
  }

  public void setConsultations(List<Consultation> consultations) {
    this.consultations = consultations;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
