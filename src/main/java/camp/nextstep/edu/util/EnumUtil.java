package camp.nextstep.edu.util;

import camp.nextstep.edu.code.EnumCode;

public class EnumUtil {

    private EnumUtil() {

    }

    public static boolean isEqual(String code, EnumCode enumCode) {
        return code.equals(enumCode.getCode());
    }
}
