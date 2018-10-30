package com.shvg.frameworks.springboot.basedata.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelperImpl implements IHelper {

    private static Logger logger = LoggerFactory.getLogger(HelperImpl.class);
    private List<?> objectList;

    public HelperImpl(List<?> objectList) {
        this.objectList = objectList;
    }

    /**
     * Class.forName(object.getClass().getName()).getMethod()
     * ClassLoader.getSystemClassLoader().loadClass(object.getClass().getName()).getMethod()
     */
    @Override
    public Object findById(Integer id)
            throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        for (Object object : objectList) {
            Object getId =
                    object.getClass()
                            .getMethod("getId")
                            .invoke(object, (Object[]) null);

            if (Integer.valueOf(getId.toString()).equals(id)) {
                return object;
            }
        }
        return null;
    }


    @Override
    public List<?> findByIds(Integer[] ids) {

        return Arrays.stream(ids)
                .map((Integer e) -> {
                    try {
                        return findById(e);
                    } catch (NoSuchMethodException
                            | IllegalAccessException
                            | InvocationTargetException e1) {
                        logger.error("Exception Occurred: {}", (Object) e1.getStackTrace());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
