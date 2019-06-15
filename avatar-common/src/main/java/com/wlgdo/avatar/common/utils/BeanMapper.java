package com.wlgdo.avatar.common.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: Ligang.Wang[wlgchun@l63.com]
 * Date: 2019/6/15 23:57
 */
public class BeanMapper<T> {

    public static Object map(Object source, Object target) {
        try {
            BeanUtils.copyProperties(source, target);
            target=target;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return target;
    }

    public static Object mapList(Collection source, Class<?> target) {

        List<Object> targetList = new ArrayList(source.size());

        source.stream().forEach(e -> {
            try {
                targetList.add(map(e, target.newInstance()));
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        });

        return targetList;
    }

}
