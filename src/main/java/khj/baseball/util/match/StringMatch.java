package khj.baseball.util.match;

import khj.baseball.model.Record;

public interface StringMatch {
    Record matchingString(String expected, String actual);
}
