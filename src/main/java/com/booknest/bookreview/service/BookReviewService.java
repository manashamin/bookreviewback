package com.booknest.bookreview.service;

import com.booknest.bookreview.dto.ReviewRequest;
import com.booknest.bookreview.model.BookReview;

import java.util.List;

public interface BookReviewService {

    BookReview createReview(ReviewRequest request);

    List<BookReview> getAllReviews();

    BookReview updateReview(Long id, ReviewRequest request);

    void deleteReview(Long id);
}
