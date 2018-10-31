package com.shvg.frameworks.springboot.restapiwithjpa_emp.util.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IHelper {

    Object findById(Integer id)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException;

    List<?> findByIds(Integer[] ids);

}
