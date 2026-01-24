package com.booknest.bookreview.model;

import jakarta.persistence.*;

@Entity
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookTitle;
    private String author;
    private String genre;
    private int rating;

    @Column(length = 1000)
    private String reviewText;

    // ✅ Required by JPA
    public BookReview() {}

    // ✅ Constructor used in service
    public BookReview(String bookTitle, String author, String genre, int rating, String reviewText) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    // ✅ Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
