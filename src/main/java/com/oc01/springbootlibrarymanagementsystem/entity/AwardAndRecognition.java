package com.oc01.springbootlibrarymanagementsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="award_and_recognition")
public class AwardAndRecognition {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @Column(name="date_granted")
    private LocalDate dateGranted;

    public AwardAndRecognition() {
    }

    public AwardAndRecognition(String name, LocalDate dateGranted) {
        this.name = name;
        this.dateGranted = dateGranted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateGranted() {
        return dateGranted;
    }

    public void setDateGranted(LocalDate dateGranted) {
        this.dateGranted = dateGranted;
    }

    @Override
    public String toString() {
        return "AwardAndRecognition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateGranted=" + dateGranted +
                '}';
    }
}
