package com.bowling.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    void setup() {
        game = new BowlingGame();
    }

    @Test
    void testGutterGame() {

        rollMany(20,0);
        assertEquals(0, game.score());
    }
    @Test
    void tetAllOnes(){
        rollMany(20,1);
        assertEquals(20,game.score());

    }
    @Test
    void testOneSpare(){
        rollSpare();
        game.roll(3);
        rollMany(17,0);
        assertEquals(16,game.score());

    }

    @Test
    void testOneStrike(){
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16,0);
        assertEquals(24,game.score());

    }

    @Test
    void testMaxScore(){
        rollMany(12,10);
        assertEquals(300,game.score());

    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);//spare
    }

    private void rollMany(int n,int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}
