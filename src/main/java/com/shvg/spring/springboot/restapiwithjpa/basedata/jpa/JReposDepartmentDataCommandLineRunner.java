package com.shvg.spring.springboot.restapiwithjpa.basedata.jpa;

import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;
import com.shvg.spring.springboot.restapiwithjpa.helper.HelperImpl;
import com.shvg.spring.springboot.restapiwithjpa.jpa.repository.JDepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.shvg.spring.springboot.restapiwithjpa.basedata.jpa.JDepartmentData.getImmutableListOfJDepartments;

@Component
public class JReposDepartmentDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    JDepartmentRepository jDepartmentRepository;

    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);

    @Override
    public void run(String... args) throws Exception {

        for (JDepartment jDepartmentEntity : getImmutableListOfJDepartments()) {
            JDepartment insertedDepartment = jDepartmentRepository.save(jDepartmentEntity);
            logger.info("\nInserted Department Using JPA Repository: {}",insertedDepartment);
        }

    }
}
