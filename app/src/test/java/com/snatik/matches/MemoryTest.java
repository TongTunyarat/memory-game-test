package com.snatik.matches;

import android.content.Context;
import android.content.SharedPreferences;
import com.snatik.matches.common.Memory;
import com.snatik.matches.common.Shared;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MemoryTest {

    @Mock
    private Context mockContext;
    @Mock
    private SharedPreferences mockSharedPreferences;
    @Mock
    private SharedPreferences.Editor mockEditor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockContext.getSharedPreferences(Memory.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE))
                .thenReturn(mockSharedPreferences);
        when(mockSharedPreferences.edit()).thenReturn(mockEditor);
        Shared.context = mockContext;
    }

    @Test
    public void testGetBestTime() {
        int theme = 1;
        int difficulty = 1;
        int expectedBestTime = 25;
        String key = String.format(Memory.bestTimeKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, -1)).thenReturn(expectedBestTime);

        int bestTime = Memory.getBestTime(theme, difficulty);
        int expected = (theme >= 0 && difficulty >= 0) ? expectedBestTime : -1;
        assertEquals(expected, bestTime);
    }

    @Test
    public void testSaveTime() {
        int theme = 1;
        int difficulty = 2;
        int passedSecs = 30;


        when(mockSharedPreferences.getInt(String.format(Memory.bestTimeKey, theme, difficulty), -1))
                .thenReturn(40);

        Memory.saveTime(theme, difficulty, passedSecs);

        Mockito.verify(mockEditor).putInt(String.format(Memory.bestTimeKey, theme, difficulty), passedSecs);
        Mockito.verify(mockEditor).commit();

        when(mockSharedPreferences.getInt(String.format(Memory.bestTimeKey, theme, difficulty), -1))
                .thenReturn(passedSecs);

        int bestTime = Memory.getBestTime(theme, difficulty);
        assertEquals(passedSecs, bestTime);
    }

    @Test
    public void testgetHighStars(){
        // Define the test parameters
        int theme = 1;
        int difficulty = 2;
        int expectedValue = 5;

        String key = String.format(Memory.highStartKey, theme, difficulty);

        when(mockSharedPreferences.getInt(key, 0)).thenReturn(expectedValue);

        int highStars = Memory.getHighStars(theme, difficulty);

        assertEquals(expectedValue, highStars);
    }
}

