package baseball.service;

import baseball.domain.GameNumberPackage;

@FunctionalInterface
public interface GameNumberPackageGenerator {
    GameNumberPackage generate();
}

