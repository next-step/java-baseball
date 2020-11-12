package com.game.util;

import com.game.common.EnumCode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EnumUtil {

    public boolean isEqual(String code, EnumCode enumCode) {
        return code.equals(enumCode.getCode());
    }
}
