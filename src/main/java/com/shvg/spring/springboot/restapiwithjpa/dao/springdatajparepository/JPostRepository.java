package com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.spring.springboot.restapiwithjpa.entity.JPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPostRepository extends JpaRepository<JPost,Integer> {
}
