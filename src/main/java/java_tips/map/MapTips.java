package java_tips.map;

import java_tips.annotation.Bad;
import java_tips.annotation.Good;

import java.util.HashMap;
import java.util.Map;

public class MapTips {

    private static final Map<Character, Integer> LETTERS = new HashMap<>();

    @Bad
    static void putValue(Character letter) {
        if (LETTERS.containsKey(letter)) {
            int prevValue = LETTERS.get(letter);
            LETTERS.put(letter, prevValue + 1);
        } else {
            LETTERS.put(letter, 1);
        }
    }

    @Good
    static void putValue2(Character letter) {
        LETTERS.merge(letter, 1, Integer::sum);
    }

    @Bad
    static Integer getValue(Character letter) {
        if (LETTERS.containsKey(letter)) {
            return LETTERS.get(letter);
        } else {
            return 0;
        }
    }

    @Good
    static Integer getValue2(Character letter) {
        return LETTERS.getOrDefault(letter, 0);
    }


}
