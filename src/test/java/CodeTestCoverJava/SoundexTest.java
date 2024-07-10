package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }

    @Test
    public void testNullString() {
        assertEquals("", Soundex.generateSoundex(null));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("A000", Soundex.generateSoundex("A"));
        assertEquals("Z000", Soundex.generateSoundex("Z"));
    }

    @Test
    public void testStandardNames() {
        assertEquals("R163", Soundex.generateSoundex("Robert"));
        assertEquals("R163", Soundex.generateSoundex("Rupert"));
        assertEquals("R150", Soundex.generateSoundex("Rubin"));
        assertEquals("A261", Soundex.generateSoundex("Ashcraft"));
        assertEquals("A261", Soundex.generateSoundex("Ashcroft"));
        assertEquals("T522", Soundex.generateSoundex("Tymczak"));
        assertEquals("P236", Soundex.generateSoundex("Pfister"));
    }

    @Test
    public void testDifferentCasing() {
        assertEquals("R163", Soundex.generateSoundex("robert"));
        assertEquals("R163", Soundex.generateSoundex("RUPERT"));
        assertEquals("A261", Soundex.generateSoundex("AshCrAfT"));
    }

    @Test
    public void testNonAlphabeticCharacters() {
        assertEquals("A000", Soundex.generateSoundex("A123"));
        assertEquals("R163", Soundex.generateSoundex("R*obert"));
        assertEquals("T522", Soundex.generateSoundex("Tymc!zak"));
    }

    @Test
    public void testRepeatedLetters() {
        assertEquals("W252", Soundex.generateSoundex("Woolworth"));
        assertEquals("S560", Soundex.generateSoundex("Ssooonn"));
    }

    @Test
    public void testVowelsBetweenConsonants() {
        assertEquals("P234", Soundex.generateSoundex("Pencil"));
        assertEquals("L530", Soundex.generateSoundex("Lunch"));
    }
}
