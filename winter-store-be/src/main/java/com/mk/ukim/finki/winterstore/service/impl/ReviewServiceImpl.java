package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.Review;
import com.mk.ukim.finki.winterstore.model.User;
import com.mk.ukim.finki.winterstore.repository.ReviewRepository;
import com.mk.ukim.finki.winterstore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public List<Review> findAllReviewsFrom(User user) {
        return reviewRepository.findAllByFrom(user);
    }

    @Override
    public List<Review> findAllReviewsTo(User user) {
        return reviewRepository.findAllByTo(user);
    }
}
