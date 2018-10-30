package com.shvg.frameworks.springboot.restapiwithjpa.dao.springdatajparepository;

import com.shvg.frameworks.springboot.basedata.entity.JPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPostRepository extends JpaRepository<JPost,Integer> {
}
