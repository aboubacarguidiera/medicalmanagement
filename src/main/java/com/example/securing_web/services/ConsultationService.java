package com.example.securing_web.services;

import com.example.securing_web.dao.ConsultationRepository;
import com.example.securing_web.entity.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultationService {
  final ConsultationRepository consultationRepository;
  @Autowired
  public ConsultationService(ConsultationRepository consultationRepository) {
    this.consultationRepository = consultationRepository;
  }
  public Iterable<Consultation> findAll() {
    return consultationRepository.findAll();
  }
  public Optional<Consultation> findById(Long id) {
    return consultationRepository.findById(id);
  }
  public Consultation save(Consultation consultation) {
    return consultationRepository.save(consultation);
  }
  public void deleteById(Long id) {
    consultationRepository.deleteById(id);
  }
  public Consultation update(Long id,Consultation consultation) {
    if(consultationRepository.findById(id).isPresent()) {
      consultation.setId(id);
    }
    return consultationRepository.save(consultation);
  }



}
