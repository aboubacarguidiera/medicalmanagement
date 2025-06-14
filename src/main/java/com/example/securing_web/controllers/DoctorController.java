package com.example.securing_web.controllers;

import com.example.securing_web.entity.Doctor;
import com.example.securing_web.services.ConsultationService;
import com.example.securing_web.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
  private DoctorService doctorService;
  private ConsultationService consultationService;

  @Autowired
  public DoctorController(DoctorService doctorService, ConsultationService consultationService) {
    this.doctorService = doctorService;
    this.consultationService = consultationService;
  }

  @GetMapping("/dashboard")
  public String dashboard(Model model, Authentication authentication) {
    try {
      String username = authentication.getName();
      Optional<Doctor> doctorOpt = doctorService.findByName(username);

      if (doctorOpt.isPresent()) {
        Doctor doctor = doctorOpt.get();
        model.addAttribute("doctor", doctor);
        model.addAttribute("consultations", doctor.getConsultations());
      } else {
        model.addAttribute("errorMessage", "Doctor not found for user: " + username);
      }

      return "doctor/dashboard";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("errorMessage", "Error loading dashboard: " + e.getMessage());
      return "error";
    }
  }
  @GetMapping("/available")
  public String listAvailableDoctors(Model model) {
    model.addAttribute("availables", doctorService.available());
    return "doctors/available";
  }
}
