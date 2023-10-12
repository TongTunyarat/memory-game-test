package com.snatik.matches;

import com.snatik.matches.model.BoardArrangment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BoardArrangmentTest {

    private BoardArrangment boardArrangment;

    @Before
    public void setUp() {
        boardArrangment = new BoardArrangment();
        Map<Integer, Integer> pairs = new HashMap<>();
        pairs.put(1, 2);
        pairs.put(3, 4);
        pairs.put(5, 6);
        boardArrangment.pairs = pairs;
    }

    @Test
    public void testIsPairWhenIdsArePresentThenReturnTrue() {
        assertTrue(boardArrangment.isPair(1, 2));
    }

    @Test
    public void testIsPairWhenIdsAreNotPresentThenReturnFalse() {
        assertFalse(boardArrangment.isPair(7, 8));
    }

    @Test
    public void testIsPairWhenOneIdIsNotPresentThenReturnFalse() {
        assertFalse(boardArrangment.isPair(1, 8));
    }
}