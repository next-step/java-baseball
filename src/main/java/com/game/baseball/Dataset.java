package com.game.baseball;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Dataset {

    private Set<Integer> data = new LinkedHashSet();

    public Set<Integer> getData() {
        return data;
    }

    public int getDataSize() {
        return data.size();
    }

    protected void resetData() {
        data.clear();
    }

    protected void add(Integer item) {
        data.add(item);
    }

}
