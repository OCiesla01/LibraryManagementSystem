package com.oc01.springbootlibrarymanagementsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="library_system_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name", nullable=false)
    private String firstName;
    @Column(name="last_name", nullable=false)
    private String lastName;
    @Column(name="email", nullable=false)
    private String email;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    @Column(name="registered_since", nullable=false)
    private LocalDate registeredSince;
    @Column(name="total_books_loaned")
    private int totalBooksLoaned;
    @Column(name="books_on_loan")
    private int currentBooksLoaned;
    @Column(name="is_deleted", nullable=false)
    private boolean isDeleted;

    public User() {
    }

    public User(String firstName, String lastName, String email, Role role, LocalDate registeredSince, boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.registeredSince = registeredSince;
        this.isDeleted = isDeleted;
    }

    public User(Role role) {
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getRegisteredSince() {
        return registeredSince;
    }

    public void setRegisteredSince(LocalDate registeredSince) {
        this.registeredSince = registeredSince;
    }

    public int getTotalBooksLoaned() {
        return totalBooksLoaned;
    }

    public void setTotalBooksLoaned(int totalBooksLoaned) {
        this.totalBooksLoaned = totalBooksLoaned;
    }

    public int getCurrentBooksLoaned() {
        return currentBooksLoaned;
    }

    public void setCurrentBooksLoaned(int currentBooksLoaned) {
        this.currentBooksLoaned = currentBooksLoaned;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", registeredSince=" + registeredSince +
                ", totalBooksLoaned=" + totalBooksLoaned +
                ", currentBooksLoaned=" + currentBooksLoaned +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
