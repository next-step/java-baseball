package com.game.util;

import com.game.common.EnumCode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EnumUtil {

    /**
     * enum 동일성 검사
     * @param code enum 코드 문자열
     * @param enumCode EnumCode 구현체
     * @return 동일성 여부
     */
    public boolean isEqual(String code, EnumCode enumCode) {
        return code.equals(enumCode.getCode());
    }
}
