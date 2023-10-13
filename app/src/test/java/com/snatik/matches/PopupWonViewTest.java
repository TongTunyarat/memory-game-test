package com.snatik.matches;

import com.snatik.matches.model.GameState;
import com.snatik.matches.ui.PopupWonView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import android.content.Context;
import android.view.View;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class PopupWonViewTest {

    private PopupWonView popupView;

    @Before
    public void setUp() {

        Context context = Robolectric.buildActivity(MainActivity.class).get();


        popupView = new PopupWonView(context);
    }

    @Test
    public void testSetGameState() {

        GameState gameState = new GameState();
        gameState.remainedSeconds = 120;
        gameState.achievedScore = 100;
        gameState.achievedStars = 2;


        popupView.setGameState(gameState);


        assertEquals("02:00", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());



        popupView.animateStars(gameState.achievedStars);
        assertEquals(View.GONE, popupView.mStar3.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar2.getVisibility());


        GameState gameState2 = new GameState();
        gameState2.remainedSeconds = 75;
        gameState2.achievedScore = 100;
        gameState2.achievedStars = 3;


        popupView.setGameState(gameState2);


        assertEquals("01:15", popupView.mTime.getText().toString());
        assertEquals("0", popupView.mScore.getText().toString());



        popupView.animateStars(gameState2.achievedStars);
        assertEquals(View.VISIBLE, popupView.mStar1.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar2.getVisibility());
        assertEquals(View.VISIBLE, popupView.mStar3.getVisibility());
    }
}