package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.Review;
import com.mk.ukim.finki.winterstore.model.User;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviewsFrom(User user);
    List<Review> findAllReviewsTo(User user);
}
