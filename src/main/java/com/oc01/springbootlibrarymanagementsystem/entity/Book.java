package com.oc01.springbootlibrarymanagementsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title", nullable=false)
    private String title;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    @Enumerated(EnumType.STRING)
    @Column(name="genre")
    private Genre genre;
    @Column(name="date_published", nullable=false)
    private LocalDate datePublished;
    @Enumerated(EnumType.STRING)
    @Column(name="rating")
    private Rating rating;
    @Column(name="no_of_pages")
    private int pages;
    @Column(name="is_available", nullable=false)
    private boolean isAvailable;
    @Column(name="row_num")
    private int row;
    @Column(name="shelf_num")
    private int shelf;
    @Column(name="no_of_copies_in_library")
    private int copiesInLibrary;
    @Column(name="no_of_copies_loaned")
    private int copiesLoaned;
    @Column(name="is_deleted")
    private boolean isDeleted;

    public Book() {
    }

    public Book(String title, List<Author> authors, Genre genre, LocalDate datePublished, Rating rating, int pages, boolean isAvailable, boolean isDeleted) {
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.datePublished = datePublished;
        this.rating = rating;
        this.pages = pages;
        this.isAvailable = isAvailable;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getCopiesInLibrary() {
        return copiesInLibrary;
    }

    public void setCopiesInLibrary(int copiesInLibrary) {
        this.copiesInLibrary = copiesInLibrary;
    }

    public int getCopiesLoaned() {
        return copiesLoaned;
    }

    public void setCopiesLoaned(int copiesLoaned) {
        this.copiesLoaned = copiesLoaned;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", genre=" + genre +
                ", datePublished=" + datePublished +
                ", rating=" + rating +
                ", pages=" + pages +
                ", isAvailable=" + isAvailable +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
