package com.syl.game.baseball.domain.dto;

public class Judgement {

    private String type;
    private int count = 0;

    public Judgement(String type) {
        this.type = type;
    }

    public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void addCount(int cnt) {
            this.count += cnt;
        }

        @Override
        public String toString() {
            return "Judgement{" +
                    "type='" + type + '\'' +
                    ", count=" + count +
                    '}';
        }
}
