package ru.evgkit.Hangman;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        game = new Game("java");
    }

    @Test
    public void acceptingRightGuess() throws Exception {
        assertTrue(game.applyGuess('j'));
    }

    @Test
    public void refusingWrongGuess() throws Exception {
        assertFalse(game.applyGuess('c'));
    }

    @Test
    public void acceptingUpperCaseGuess() throws Exception {
        assertTrue(game.applyGuess('J'));
    }

    @Test
    public void refusingNonLetterGuess() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("A letter is required");

        game.applyGuess('7');
    }

    @Test
    public void refusingAlreadyGuessed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("j has already been guessed");

        game.applyGuess('j');
        game.applyGuess('a');
        game.applyGuess('j');
    }

    @Test
    public void refusingEmptyGuess() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No letter found");

        game.applyGuess("");
    }
}