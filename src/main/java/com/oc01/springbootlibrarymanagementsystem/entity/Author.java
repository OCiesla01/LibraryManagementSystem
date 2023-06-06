package com.oc01.springbootlibrarymanagementsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name="origin")
    private String origin;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name="date_of_death")
    private LocalDate dateOfDeath;

    @OneToMany(mappedBy="author", cascade=CascadeType.REMOVE)
    private List<AwardAndRecognition> awardAndRecognition;

    @Column(name="biography")
    private String biography;

    @Column(name="total_books")
    private int totalBooks;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    @Column(name="is_deleted")
    private boolean isDeleted;

    public Author() {
    }

    public Author(String firstName, String lastName, String origin, LocalDate dateOfBirth, LocalDate dateOfDeath, int totalBooks, boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.origin = origin;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.totalBooks = totalBooks;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<AwardAndRecognition> getAwardsAndRecognitions() {
        return awardAndRecognition;
    }

    public void setAwardsAndRecognitions(List<AwardAndRecognition> awardsAndRecognitions) {
        this.awardAndRecognition = awardAndRecognition;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", origin='" + origin + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", awardsAndRecognitions=" + awardAndRecognition +
                ", totalBooks=" + totalBooks +
                ", books=" + books +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
