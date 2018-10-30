package com.shvg.spring.springboot.test.mockito.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IHelper {

    Object findById(Integer id)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException;

    List<?> findByIds(Integer[] ids);

}
