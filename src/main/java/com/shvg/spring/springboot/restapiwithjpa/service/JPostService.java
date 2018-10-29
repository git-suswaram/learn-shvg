package com.shvg.spring.springboot.restapiwithjpa.service;

import com.shvg.spring.springboot.restapiwithjpa.entity.JPost;

import java.util.List;
import java.util.Optional;

public interface JPostService {

    List<JPost> get();

    Optional<JPost> get(int postID);

    JPost post(JPost jPost);

    void delete(int postID);

}
