package com.shvg.spring.springboot.test.mockito.basedata;

import com.shvg.spring.springboot.test.mockito.dao.springdatajparepository.JContactInfoRepository;
import com.shvg.spring.springboot.test.mockito.dao.springdatajparepository.JEmployeeRepository;
import com.shvg.spring.springboot.test.mockito.entity.JContactInfo;
import com.shvg.spring.springboot.test.mockito.entity.JEmployee;
import com.shvg.spring.springboot.test.mockito.helper.HelperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.shvg.spring.springboot.test.mockito.basedata.JContactInfoData.getImmutableListOfContactInfos;
import static com.shvg.spring.springboot.test.mockito.basedata.JEmployeeData.getImmutableListOfJExecutives;

@Component
public class JReposDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    JEmployeeRepository jEmployeeRepository;

    @Autowired
    JContactInfoRepository jContactInfoRepository;

    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);

    @Override
    public void run(String... args) throws Exception {

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
