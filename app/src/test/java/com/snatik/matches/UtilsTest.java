package com.snatik.matches;

import androidx.test.core.app.ApplicationProvider;
import com.snatik.matches.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import android.content.Context;
import com.snatik.matches.common.Shared;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class UtilsTest {

    @Test
    public void testPxConversion() {
        // Mock Shared.context สำหรับทดสอบ
        Context context = ApplicationProvider.getApplicationContext();
        Shared.context = context;

        int dpValue = 5;

        //การแปลงค่า PX
        float testDensity = context.getResources().getDisplayMetrics().density;
        int expectedPxValue = (int) (testDensity * dpValue);

        int actualPxValue = Utils.px(dpValue);

        assertEquals(5, actualPxValue);
    }
}
