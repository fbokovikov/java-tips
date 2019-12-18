package java_tips.other;

import java_tips.annotation.Bad;
import java_tips.annotation.Good;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OtherTips {

    private static final String MY_STRING = "MYSTRING";

    @Bad
    static void emptyCollections() {
        Map<String, String> emptyMap = Collections.EMPTY_MAP;
        Set<String> emptySet = Collections.EMPTY_SET;
        List<String> emptyList = Collections.EMPTY_LIST;
    }

    @Bad
    static void emptyCollections2() {
        Map<String, String> emptyMap = Collections.emptyMap();
        Set<String> emptySet = Collections.emptySet();
        List<String> emptyList = Collections.emptyList();
    }

    @Bad
    static void propagateIOException() {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Good
    static void propagateIOException2() {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Bad
    static boolean constantEquals(String s) {
        return s.equals(MY_STRING);
    }

    @Good
    static boolean constantEquals2(String s) {
        return MY_STRING.equals(s);
    }

    public static void main(String[] args) {
        System.out.println(constantEquals2(null));
        System.out.println(constantEquals(null));
    }

}
