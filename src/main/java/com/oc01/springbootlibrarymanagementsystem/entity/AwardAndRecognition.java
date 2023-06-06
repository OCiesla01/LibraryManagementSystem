package com.oc01.springbootlibrarymanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="awards_and_recognitions")
public class AwardAndRecognition {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="date_granted")
    private Date dateGranted;

    public AwardAndRecognition() {
    }

    public AwardAndRecognition(String name, Date dateGranted) {
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

    public Date getDateGranted() {
        return dateGranted;
    }

    public void setDateGranted(Date dateGranted) {
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
