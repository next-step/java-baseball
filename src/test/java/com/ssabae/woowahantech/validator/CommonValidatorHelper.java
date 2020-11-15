package com.ssabae.woowahantech.validator;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-16
 */
public class CommonValidatorHelper {

    public static List<Integer> convertStringToNumberList(String str) {
        List<Integer> list = new ArrayList<>();
        if (StringUtils.isBlank(str)) {
            return list;
        }
        String[] array = str.split(",");
        for (String s : array) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
