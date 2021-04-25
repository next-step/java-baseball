package domain;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    List<Number> generate();
}
