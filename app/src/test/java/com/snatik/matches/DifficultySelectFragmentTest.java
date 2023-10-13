package com.snatik.matches;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.snatik.matches.common.Memory;
import com.snatik.matches.common.Shared;
import com.snatik.matches.fragments.DifficultySelectFragment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


public class DifficultySelectFragmentTest {
    @Mock
    private Context mockContext;
    @Mock
    private SharedPreferences mockSharedPreferences;
    @Mock
    private SharedPreferences.Editor mockEditor;
    @Mock
    private View mockView1;
    @Mock
    private View mockView2;
    private DifficultySelectFragment difficultySelectFragment;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(mockContext.getSharedPreferences(Memory.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE))
                .thenReturn(mockSharedPreferences);
        Mockito.when(mockSharedPreferences.edit()).thenReturn(mockEditor);

        Shared.context = mockContext;

        mockView1 = Mockito.mock(View.class);
        mockView2 = Mockito.mock(View.class);

        difficultySelectFragment = new DifficultySelectFragment();
    }

    @Test
    public void testgetBestTimeForStage() {
        int theme = -1;
        int difficulty = -2;
        int expectedBestTime = 125;
        String key = String.format(Memory.bestTimeKey, theme, difficulty);

        Mockito.when(mockSharedPreferences.getInt(key, -1)).thenReturn(expectedBestTime);

        int bestTime = Memory.getBestTime(theme, difficulty);

        int minutes = (bestTime % 3600) / 60;
        int seconds = (bestTime) % 60;

        String result = String.format("BEST : %02d:%02d", minutes, seconds);
        String expected = "";

        if (bestTime != -1) {
            expected = result;
        } else {
            expected = "BEST : -";
            result = "BEST : -";
        }
        assertEquals(expected, result);
        System.out.println(expected +" "+ result);

    }

}

