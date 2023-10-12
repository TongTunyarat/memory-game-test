package com.snatik.matches;

import android.support.v4.app.FragmentActivity;
import com.snatik.matches.common.Shared;
import com.snatik.matches.engine.ScreenController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class ScreenControllerTest {

    private ScreenController screenController;

    @Before
    public void setUp() {
        // Mock Shared.activity สำหรับทดสอบ
        Shared.activity = Robolectric.setupActivity(FragmentActivity.class);
        screenController = ScreenController.getInstance();
    }

    @Test
    public void testOpenScreen() {
        // Start by checking the initial state, that there are no screens open.
        assertEquals(true, ScreenController.openedScreens.isEmpty());

        // Open the MENU screen.
        screenController.openScreen(ScreenController.Screen.MENU);

        assertEquals(true, ScreenController.openedScreens.contains(ScreenController.Screen.MENU));
        assertEquals(ScreenController.Screen.MENU, ScreenController.openedScreens.get(ScreenController.openedScreens.size() - 1));

        assertEquals(false, ScreenController.openedScreens.contains(ScreenController.Screen.DIFFICULTY));

    }

}
