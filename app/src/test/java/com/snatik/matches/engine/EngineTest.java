//package com.snatik.matches.engine;
//
//import com.snatik.matches.model.Game;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class EngineTest {
//
//    private Engine engine;
//
//    @Before
//    public void setUp() {
//        engine = Engine.getInstance();
//    }
//
//    @Test
//    public void testEngineInitialization() {
//        // ตรวจสอบว่า Engine มีอยู่และไม่เป็น null
//        assertNotNull(engine);
//
//        // ตรวจสอบค่าเริ่มต้นของ selectedTheme
//        assertNull(engine.getSelectedTheme());
//
//        // ตรวจสอบค่าเริ่มต้นของ BackgroundImageView
//        assertNull(engine.getBackgroundImageView());
//    }
//
//    @Test
//    public void testSetActiveGame() {
//        // สร้าง Game ใหม่
//        Game newGame = new Game();
//
//        // เรียกใช้เมทอดเพื่อตั้งค่าเกมใหม่ใน Engine
//        engine.setActiveGame(newGame);
//
//        // ตรวจสอบว่า Engine มีเกมที่ถูกตั้งค่าอยู่
//        assertEquals(newGame, engine.getActiveGame());
//    }
//}
