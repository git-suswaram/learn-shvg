package com.shvg.frameworks.springboot.restapiwithjpa.dao.jpa;

import com.shvg.frameworks.springboot.basedata.entity.JDepartment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class JDepartmentDAOImpl implements JDepartmentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<JDepartment> get() {
        return Collections.emptyList();
    }

    @Override
    public JDepartment get(int departmentID) {
        return null;
    }

    @Override
    public JDepartment post(JDepartment department) {

        entityManager.persist(department);
        return department;
    }

    @Override
    public JDepartment delete(int departmentID) {
        return null;
    }


}
