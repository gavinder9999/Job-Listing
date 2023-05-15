package com.gavinder.joblisting.repository;

import com.gavinder.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);

}
