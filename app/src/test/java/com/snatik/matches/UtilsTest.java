package com.snatik.matches;

import androidx.test.core.app.ApplicationProvider;
import com.snatik.matches.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import android.content.Context;
import com.snatik.matches.common.Shared; // ต้องมีการนำเข้าคลาส Shared ในที่นี้
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class UtilsTest {

    @Test
    public void testPxConversion() {
        // Create a test context using Robolectric
        Context context = ApplicationProvider.getApplicationContext();
        Shared.context = context; // กำหนด Shared.context ให้เป็น context ที่คุณสร้างขึ้น

        // Define a test dp value
        int dpValue = 5; // ค่าที่คุณต้องการทดสอบ

        // Calculate the expected result (px) based on the test density and dp value
        float testDensity = context.getResources().getDisplayMetrics().density;
        int expectedPxValue = (int) (testDensity * dpValue);

        // Call the px method to convert dp to px
        int actualPxValue = Utils.px(dpValue);

        // Assert that the actual result matches the expected result
        assertEquals(expectedPxValue, actualPxValue);
    }
}
