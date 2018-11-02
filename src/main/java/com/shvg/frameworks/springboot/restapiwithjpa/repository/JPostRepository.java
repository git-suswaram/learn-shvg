package com.shvg.frameworks.springboot.restapiwithjpa.repository;

import com.shvg.frameworks.springboot.restapiwithjpa.entity.JPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPostRepository extends JpaRepository<JPost, Integer> {
}
