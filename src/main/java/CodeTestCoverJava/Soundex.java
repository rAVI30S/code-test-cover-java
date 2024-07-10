package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {
    private static final Map<Character, Character> soundexMap = new HashMap<>();

    static {
        soundexMap.put('B', '1');
        soundexMap.put('F', '1');
        soundexMap.put('P', '1');
        soundexMap.put('V', '1');
        soundexMap.put('C', '2');
        soundexMap.put('G', '2');
        soundexMap.put('J', '2');
        soundexMap.put('K', '2');
        soundexMap.put('Q', '2');
        soundexMap.put('S', '2');
        soundexMap.put('X', '2');
        soundexMap.put('Z', '2');
        soundexMap.put('D', '3');
        soundexMap.put('T', '3');
        soundexMap.put('L', '4');
        soundexMap.put('M', '5');
        soundexMap.put('N', '5');
        soundexMap.put('R', '6');
    }

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));

        String encodedString = encodeString(name.substring(1), soundex.charAt(0));
        return padWithZeros(soundex.append(encodedString)).toString();
    }

    private static String encodeString(String name, char firstChar) {
        StringBuilder encoded = new StringBuilder();
        char prevCode = getSoundexCode(firstChar);

        for (char c : name.toCharArray()) {
            char code = getSoundexCode(c);
            if (isValidCode(code, prevCode)) {
                encoded.append(code);
                prevCode = code;
                if (encoded.length() >= 3) break;
            }
        }
        return encoded.toString();
    }

    private static boolean isValidCode(char code, char prevCode) {
        return code != '0' && code != prevCode;
    }

    private static StringBuilder padWithZeros(StringBuilder soundex) {
        while (soundex.length() < 4) {
            soundex.append('0');
        }
        return soundex;
    }
    

    private static char getSoundexCode(char c) {
        return soundexMap.getOrDefault(Character.toUpperCase(c), '0');
    }
}
