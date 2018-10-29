package com.shvg.spring.springboot.restapiwithjpa.service.impl;

import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JPostRepository;
import com.shvg.spring.springboot.restapiwithjpa.entity.JPost;
import com.shvg.spring.springboot.restapiwithjpa.service.JPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JPostImpl implements JPostService {

    @Autowired
    JPostRepository jPostRepository;

    //findAll
    public List<JPost> get() {

        return jPostRepository.findAll();
    }

    //findOne
    public Optional<JPost> get(int departmentID) {

        return jPostRepository.findById(departmentID);
    }

    //save
    public JPost post(JPost department) {

        return jPostRepository.save(department);
    }

    //deleteOne
    public void delete(int departmentID) throws EmptyResultDataAccessException {

        jPostRepository.deleteById(departmentID);
    }
}
