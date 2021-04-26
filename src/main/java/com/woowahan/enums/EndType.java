package com.woowahan.enums;

import lombok.Getter;

@Getter
public enum EndType {
    RETRY(1),
    END(2);

    private final int code;

    EndType(int code) {
        this.code = code;
    }
    public boolean isEqualTo(int code){
        return this.code == code;
    }
}
