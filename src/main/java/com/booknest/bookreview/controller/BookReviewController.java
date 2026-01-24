package com.booknest.bookreview.controller;

import com.booknest.bookreview.dto.ReviewRequest;
import com.booknest.bookreview.model.BookReview;
import com.booknest.bookreview.service.BookReviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class BookReviewController {

    private final BookReviewService service;

    public BookReviewController(BookReviewService service) {
        this.service = service;
    }

    @PostMapping
    public BookReview create(@Valid @RequestBody ReviewRequest request) {
        return service.createReview(request);
    }

    @GetMapping
    public List<BookReview> getAll() {
        return service.getAllReviews();
    }

    @PutMapping("/{id}")
    public BookReview update(@PathVariable Long id, @Valid @RequestBody ReviewRequest request) {
        return service.updateReview(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteReview(id);
    }
}
