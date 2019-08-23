package com.bowling.kata;

public class BowlingGame {

    private int[] rolls;
    private int currentRoll = 0;

    public BowlingGame() {
        this.rolls = new int[21];
    }

    public void roll(int pinsDown) {

        rolls[currentRoll++] = pinsDown;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else if (isStrike(rolls[frameIndex])) {
                score += strikeBonus(frameIndex) + 10;
                frameIndex++;
            } else {
                score += sameOfBoolsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int sameOfBoolsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex] == 10;
    }
}
