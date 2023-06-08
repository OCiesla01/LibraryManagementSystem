package com.oc01.springbootlibrarymanagementsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="award")
public class Award {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Author author;

    @Column(name="date_granted")
    private LocalDate dateGranted;

    public Award() {
    }

    public Award(String name, LocalDate dateGranted) {
        this.name = name;
        this.dateGranted = dateGranted;
    }

    public Award(String name, Author author, LocalDate dateGranted) {
        this.name = name;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        author.getAwards().add(this);
    }

    public LocalDate getDateGranted() {
        return dateGranted;
    }

    public void setDateGranted(LocalDate dateGranted) {
        this.dateGranted = dateGranted;
    }

    @Override
    public String toString() {
        return "Award{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateGranted=" + dateGranted +
                '}';
    }

    public String getAuthorFullName() {
        if (author != null) {
            return author.getFullName();
        }
        return "Author not known";
    }
}
