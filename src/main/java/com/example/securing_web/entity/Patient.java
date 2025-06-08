package com.example.securing_web.entity;

import jakarta.persistence.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Entity
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private String mail;
  private String mdp;
 @OneToMany(mappedBy = "patient")
 private List<Consultation> consultationList = new ArrayList<>();

  public int size() {
    return consultationList.size();
  }

  public Consultation get(int index) {
    return consultationList.get(index);
  }

  public void forEach(Consumer<? super Consultation> action) {
    consultationList.forEach(action);
  }

  public boolean containsAll(Collection<?> c) {
    return consultationList.containsAll(c);
  }

  public <T> T[] toArray(IntFunction<T[]> generator) {
    return consultationList.toArray(generator);
  }

  public Stream<Consultation> stream() {
    return consultationList.stream();
  }

  public List<Consultation> subList(int fromIndex, int toIndex) {
    return consultationList.subList(fromIndex, toIndex);
  }

  public Stream<Consultation> parallelStream() {
    return consultationList.parallelStream();
  }

  public boolean remove(Object o) {
    return consultationList.remove(o);
  }

  public ListIterator<Consultation> listIterator(int index) {
    return consultationList.listIterator(index);
  }

  public boolean isEmpty() {
    return consultationList.isEmpty();
  }

  public void add(int index, Consultation element) {
    consultationList.add(index, element);
  }

  public boolean addAll(int index, Collection<? extends Consultation> c) {
    return consultationList.addAll(index, c);
  }

  public Consultation set(int index, Consultation element) {
    return consultationList.set(index, element);
  }

  public boolean addAll(Collection<? extends Consultation> c) {
    return consultationList.addAll(c);
  }

  public Spliterator<Consultation> spliterator() {
    return consultationList.spliterator();
  }

  public Object[] toArray() {
    return consultationList.toArray();
  }

  public void replaceAll(UnaryOperator<Consultation> operator) {
    consultationList.replaceAll(operator);
  }

  public int indexOf(Object o) {
    return consultationList.indexOf(o);
  }

  public Iterator<Consultation> iterator() {
    return consultationList.iterator();
  }

  public boolean removeIf(Predicate<? super Consultation> filter) {
    return consultationList.removeIf(filter);
  }

  public Consultation remove(int index) {
    return consultationList.remove(index);
  }

  public boolean retainAll(Collection<?> c) {
    return consultationList.retainAll(c);
  }

  public boolean contains(Object o) {
    return consultationList.contains(o);
  }

  public boolean removeAll(Collection<?> c) {
    return consultationList.removeAll(c);
  }



  public List<Consultation> getConsultationsList() {
    return consultationList;
  }

  public void setConsultationsList(List<Consultation> consultationList) {
    this.consultationList = consultationList;
  }

  public void clear() {
    consultationList.clear();
  }

  public ListIterator<Consultation> listIterator() {
    return consultationList.listIterator();
  }

  public boolean add(Consultation consultation) {
    return consultationList.add(consultation);
  }

  public void sort(Comparator<? super Consultation> c) {
    consultationList.sort(c);
  }

  public int lastIndexOf(Object o) {
    return consultationList.lastIndexOf(o);
  }

  public <T> T[] toArray(T[] a) {
    return consultationList.toArray(a);
  }

  public Patient() {
  }

  public Patient(String nom, String mail, String mdp) {
    this.nom = nom;
    this.mail = mail;
    this.mdp = mdp;
  }

  public String getMdp() {
    return mdp;
  }

  public void setMdp(String mdp) {
    this.mdp = mdp;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
