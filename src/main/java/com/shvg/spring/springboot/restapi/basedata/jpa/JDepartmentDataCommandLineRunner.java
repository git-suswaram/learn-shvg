package com.shvg.spring.springboot.restapi.basedata.jpa;

import com.shvg.spring.springboot.restapi.entity.JDepartment;
import com.shvg.spring.springboot.restapi.helper.HelperImpl;
import com.shvg.spring.springboot.restapi.service.dao.JDepartmentDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.shvg.spring.springboot.restapi.basedata.jpa.JDepartmentData.getImmutableListOfJDepartments;

@Component
public class JDepartmentDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    JDepartmentDAOImpl jDepartmentDAO;

    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);

    @Override
    public void run(String... args) throws Exception {

        for (JDepartment jDepartmentEntity : getImmutableListOfJDepartments()) {
            JDepartment insertedDepartment = jDepartmentDAO.post(jDepartmentEntity);
            logger.info("Inserted Department: {}",insertedDepartment);
        }

    }
}
