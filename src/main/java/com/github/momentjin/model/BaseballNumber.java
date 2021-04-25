package com.github.momentjin.model;

public class BaseballNumber {

    private final int value;

    public BaseballNumber(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() { return value; }

    @Override
    public String toString() {
        return "BaseballNumber{" + value + '}';
    }
}
