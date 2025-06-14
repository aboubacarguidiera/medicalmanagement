package com.example.securing_web.controllers;

import com.example.securing_web.dto.ConsultationRequestDTO;
import com.example.securing_web.entity.Consultation;
import com.example.securing_web.entity.Doctor;
import com.example.securing_web.entity.Patient;
import com.example.securing_web.entity.Status;
import com.example.securing_web.services.ConsultationService;
import com.example.securing_web.services.DoctorService;
import com.example.securing_web.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/patient")
public class PatientController {
  private PatientService patientService;
  private ConsultationService consultationService;
  private DoctorService doctorService;

  @Autowired
  public PatientController(PatientService patientService, ConsultationService consultationService, DoctorService doctorService){
    this.patientService = patientService;
    this.consultationService = consultationService;
    this.doctorService = doctorService;
  }

  @GetMapping("/dashboard")
  public String dashboard(Model model, Authentication authentication) {
    try {
      // Utilisez le nom d'utilisateur de l'authentification
      String username = authentication.getName();

      // Essayez de trouver le patient par nom
      Optional<Patient> patientOpt = patientService.findByName(username);

      if (patientOpt.isPresent()) {
        Patient patient = patientOpt.get();
        model.addAttribute("patient", patient);
        model.addAttribute("consultations", patient.getConsultationsList());
      } else {
        // Si le patient n'est pas trouvé, ajoutez un message
        model.addAttribute("errorMessage", "Patient not found for user: " + username);
      }

      return "patient/dashboard";
    } catch (Exception e) {
      // Log l'erreur
      e.printStackTrace();
      model.addAttribute("errorMessage", "Error loading dashboard: " + e.getMessage());
      return "error";
    }
  }

  @GetMapping("/request-consultation")
  public String showConsultationForm(Model model) {
    model.addAttribute("doctors", doctorService.available());
    model.addAttribute("consultation", new Consultation());
    return "patient/request-consultation";
  }

  @PostMapping("/request-consultation")
  public String requestConsultation(@ModelAttribute ConsultationRequestDTO consultationRequestDTO,
                                   @RequestParam Long doctorId,
                                   Authentication authentication) {
    Patient patient = patientService.findByName(authentication.getName()).orElseThrow();
    Doctor doctor = doctorService.findById(doctorId).orElseThrow();
    Consultation consultation = new Consultation();
    consultation.setPatient(patient);
    consultation.setDoctor(doctor);
    consultation.setDate(LocalDate.now());
    consultation.setTitle(consultationRequestDTO.getDescription());
    consultation.setStatus(Status.PENDING);
    consultationService.save(consultation);
    return "redirect:/patient/dashboard";
  }
}
