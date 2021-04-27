package domain;

import java.util.Objects;

public class Count {
    private int count;

    public Count(int count) {
        this.count = count;
    }

    public Count() {
        this.count = 0;
    }

    public void plus(){
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public boolean isNotEmpty() {
        return this.count >0 ;
    }

    public String getCount() {
        return String.valueOf(this.count);
    }

    public void reset() {
        this.count = 0;
    }
}
