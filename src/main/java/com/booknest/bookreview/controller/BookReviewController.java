package com.booknest.bookreview.controller;

import com.booknest.bookreview.dto.ReviewRequest;
import com.booknest.bookreview.model.BookReview;
import com.booknest.bookreview.service.BookReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class BookReviewController {

    private final BookReviewService service;

    public BookReviewController(BookReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BookReview> createReview(
            @Valid @RequestBody ReviewRequest request) {
        return new ResponseEntity<>(
                service.createReview(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<BookReview>> getAllReviews() {
        return ResponseEntity.ok(service.getAllReviews());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookReview> updateReview(
            @PathVariable Long id,
            @Valid @RequestBody ReviewRequest request) {
        return ResponseEntity.ok(service.updateReview(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        service.deleteReview(id);
    }
}