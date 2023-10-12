package com.snatik.matches.fragments;

import android.widget.TextView;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.snatik.matches.MainActivity;
import com.snatik.matches.R;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
public class GameFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private GameFragment gameFragment;

    @Before
    public void setUp() {
        gameFragment = new GameFragment();

        // Ensure the GameFragment is properly attached to the activity
        activityTestRule.getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, gameFragment)
                .commit();

        // Simulate the required TextView without using Android context
        TextView mTime = new TextView(activityTestRule.getActivity());
        gameFragment.mTime = mTime;
    }

    @Test
    public void testSetTime() {
        // Mocking Log.e method (เรียกใช้ LogMock แทน)
        LogMock.e("Tag", "Message for testing");
        gameFragment.setTime(1234);
        assertEquals(" 12:34", gameFragment.mTime.getText().toString());
    }
}

class LogMock {
    public static void e(String tag, String msg) {
        // อาจมีการเพิ่มการตรวจสอบโค้ดที่คุณต้องการในการทดสอบของคุณ
        // และล็อกผลลัพธ์หรือทำตามความจำเป็นตามรายละเอียดของทดสอบ
    }
}
