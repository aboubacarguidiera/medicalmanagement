package com.example.securing_web.controllers;

import com.example.securing_web.entity.Doctor;
import com.example.securing_web.entity.Patient;
import com.example.securing_web.services.DoctorService;
import com.example.securing_web.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public AdminController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/doctors")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.findAll());
        model.addAttribute("newDoctor", new Doctor());
        return "admin/doctors";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/admin/doctors";
    }

    @PostMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
        return "redirect:/admin/doctors";
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("newPatient", new Patient());
        return "admin/patients";
    }

    @PostMapping("/patients/add")
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.save(patient);
        return "redirect:/admin/patients";
    }

    @PostMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return "redirect:/admin/patients";
    }
}
