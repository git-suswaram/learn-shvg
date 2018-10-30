package com.shvg.spring.springboot.restapiwithjpa;

import com.shvg.spring.basedata.entity.JContactInfo;
import com.shvg.spring.basedata.entity.JDepartment;
import com.shvg.spring.basedata.entity.JEmployee;
import com.shvg.spring.basedata.util.HelperImpl;
import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JContactInfoRepository;
import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JDepartmentRepository;
import com.shvg.spring.springboot.restapiwithjpa.dao.springdatajparepository.JEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.shvg.spring.basedata.data.JContactInfoData.getImmutableListOfContactInfos;
import static com.shvg.spring.basedata.data.JDepartmentData.getImmutableListOfJDepartments;
import static com.shvg.spring.basedata.data.JEmployeeData.getImmutableListOfJExecutives;

@Component
public class JReposDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    JEmployeeRepository jEmployeeRepository;

    @Autowired
    JDepartmentRepository jDepartmentRepository;

    @Autowired
    JContactInfoRepository jContactInfoRepository;

    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);

    @Override
    public void run(String... args) throws Exception {


        for (JEmployee jEmployeeEntity : getImmutableListOfJExecutives()) {
            JEmployee insertedEmployee = jEmployeeRepository.save(jEmployeeEntity);
            logger.info("\nInserted Employee Using JPA Repository: {}", insertedEmployee);
        }
        for (JDepartment jDepartmentEntity : getImmutableListOfJDepartments()) {
            JDepartment insertedDepartment = jDepartmentRepository.save(jDepartmentEntity);
            logger.info("\nInserted Department Using JPA Repository: {}", insertedDepartment);
        }

        for (JContactInfo jContactInfoEntity : getImmutableListOfContactInfos()) {
            JContactInfo insertedDepartment = jContactInfoRepository.save(jContactInfoEntity);
            logger.info("\nInserted Department Using JPA Repository: {}", insertedDepartment);
        }

    }
}
