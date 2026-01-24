package com.booknest.bookreview.service;

import com.booknest.bookreview.dto.ReviewRequest;
import com.booknest.bookreview.exception.ResourceNotFoundException;
import com.booknest.bookreview.model.BookReview;
import com.booknest.bookreview.repository.BookReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements BookReviewService {

    private final BookReviewRepository repository;

    public ReviewServiceImpl(BookReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookReview createReview(ReviewRequest request) {
        BookReview review = new BookReview(
                request.getTitle(),
                request.getAuthor(),
                request.getGenre(),
                request.getRating(),
                request.getReviewText()
        );
        return repository.save(review);
    }

    @Override
    public List<BookReview> getAllReviews() {
        return repository.findAll();
    }

    @Override
    public BookReview updateReview(Long id, ReviewRequest request) {
        BookReview review = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));

        review.setTitle(request.getTitle());
        review.setAuthor(request.getAuthor());
        review.setGenre(request.getGenre());
        review.setRating(request.getRating());
        review.setReviewText(request.getReviewText());

        return repository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        BookReview review = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));
        repository.delete(review);
    }
}
