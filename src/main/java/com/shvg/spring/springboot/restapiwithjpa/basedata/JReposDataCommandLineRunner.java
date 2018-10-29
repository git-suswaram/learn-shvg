package com.shvg.spring.springboot.restapiwithjpa.basedata;

import com.shvg.spring.springboot.restapiwithjpa.entity.JContactInfo;
import com.shvg.spring.springboot.restapiwithjpa.entity.JDepartment;
import com.shvg.spring.springboot.restapiwithjpa.entity.JEmployee;
import com.shvg.spring.springboot.restapiwithjpa.helper.HelperImpl;
import com.shvg.spring.springboot.restapiwithjpa.jpa.repository.JContactInfoRepository;
import com.shvg.spring.springboot.restapiwithjpa.jpa.repository.JDepartmentRepository;
import com.shvg.spring.springboot.restapiwithjpa.jpa.repository.JEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.shvg.spring.springboot.restapiwithjpa.basedata.JContactInfoData.getImmutableListOfContactInfos;
import static com.shvg.spring.springboot.restapiwithjpa.basedata.JDepartmentData.getImmutableListOfJDepartments;
import static com.shvg.spring.springboot.restapiwithjpa.basedata.JEmployeeData.getImmutableListOfJExecutives;

@Component
public class JReposDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    JDepartmentRepository jDepartmentRepository;

    @Autowired
    JEmployeeRepository jEmployeeRepository;

    @Autowired
    JContactInfoRepository jContactInfoRepository;

    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);

    @Override
    public void run(String... args) throws Exception {

        for (JDepartment jDepartmentEntity : getImmutableListOfJDepartments()) {
            JDepartment insertedDepartment = jDepartmentRepository.save(jDepartmentEntity);
            logger.info("\nInserted Department Using JPA Repository: {}", insertedDepartment);
        }

        for (JEmployee jEmployeeEntity : getImmutableListOfJExecutives()) {
            JEmployee insertedEmployee = jEmployeeRepository.save(jEmployeeEntity);
            logger.info("\nInserted Employee Using JPA Repository: {}", insertedEmployee);
        }

        for (JContactInfo jContactInfoEntity : getImmutableListOfContactInfos()) {
            JContactInfo insertedDepartment = jContactInfoRepository.save(jContactInfoEntity);
            logger.info("\nInserted Department Using JPA Repository: {}", insertedDepartment);
        }

    }
}
