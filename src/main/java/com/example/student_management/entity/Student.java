package com.example.student_management.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "student",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"nom", "prenom"})
        })
@NamedQueries({
        @NamedQuery(name = "Student.findByNom",
                query = "SELECT s FROM Student s WHERE s.nom = :nom"),
        @NamedQuery(name = "Student.findByPrenom",
                query = "SELECT s FROM Student s WHERE s.prenom = :prenom")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 50, nullable = false)
    private String prenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance")
    private Date dateNaissance;

    // Constructeurs
    public Student() {
    }

    public Student(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public Date getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(nom, student.nom) &&
                Objects.equals(prenom, student.prenom) &&
                Objects.equals(dateNaissance, student.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, dateNaissance);
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, nom='%s', prenom='%s', dateNaissance=%s}",
                id, nom, prenom, dateNaissance);
    }
}
