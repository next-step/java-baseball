package com.github.sangholeedev.javabaseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Umpire {
    private static List<BallDecision> ballDecisionList;
    private static List<String> opponentList;
    private static List<String> playerList;
    private static List<String> notStrikeList;

    public static List<BallDecision> validBaseball(int opponent, int player) {
        init(opponent, player);
        validStrikes();
        validBalls();
        return ballDecisionList;
    }

    private static void validBalls() {
        for (String playerNumber : notStrikeList) {
            validBall(opponentList, playerNumber)
                    .ifPresent(ballDecisionList::add);
        }
    }

    private static void validStrikes() {
        int opponentListSize = opponentList.size();
        for (int i = 0; i < opponentListSize; i++) {
            String playerNumber = playerList.get(i);
            validStrike(opponentList.get(i), playerNumber)
                    .ifPresent(addStrikeAndRemoveNoStrikeList(ballDecisionList, notStrikeList, playerNumber));
        }
    }

    private static void init(int opponent, int player) {
        ballDecisionList = new ArrayList<>();
        opponentList = numberToStringList(opponent);
        playerList = numberToStringList(player);
        notStrikeList = numberToStringList(player);
    }

    private static Consumer<BallDecision> addStrikeAndRemoveNoStrikeList(List<BallDecision> ballDecisionList, List<String> notStrikeList, String playerNumber) {
        return strike -> {
            ballDecisionList.add(strike);
            notStrikeList.remove(playerNumber);
        };
    }

    private static Optional<BallDecision> validStrike(String opponent, String player) {
        if (opponent.equals(player)) {
            return Optional.of(BallDecision.STRIKE);
        }
        return Optional.empty();
    }

    private static Optional<BallDecision> validBall(List<String> opponents, String player) {
        if (opponents.contains(player)) {
            return Optional.of(BallDecision.BALL);
        }
        return Optional.empty();
    }

    private static List<String> numberToStringList(int number) {
        List<String> numberStringList = new ArrayList<>();
        while (number > 0) {
            numberStringList.add(String.valueOf(number % 10));
            number = number / 10;
        }
        return numberStringList;
    }
}
