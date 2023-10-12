package com.snatik.matches;

import com.snatik.matches.themes.Theme;
import com.snatik.matches.themes.Themes;
import org.junit.Test;
import static org.junit.Assert.*;

public class ThemesTest {

    @Test
    public void testCreateAnimalsTheme() {
        Theme animalsTheme = Themes.createAnimalsTheme();

        assertNotNull(animalsTheme);

        assertEquals("Animals", animalsTheme.name);
    }

    @Test
    public void testCreateMonsterTheme() {
        Theme monstersTheme = Themes.createMosterTheme();

        assertNotNull(monstersTheme);

        assertEquals("Monsters", monstersTheme.name);
    }

    @Test
    public void testCreateEmojiTheme() {
        Theme emojiTheme = Themes.createEmojiTheme();

        assertNotNull(emojiTheme);

        assertEquals("Emoji", emojiTheme.name);
    }
}
