package com.example.securing_web.dto;

public class ConsultationRequestDTO {
  private Long doctorId;
  private String description;
  private String name;

  public Long getDoctorId() {
    return doctorId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
