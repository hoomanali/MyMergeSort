package com.alihooman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseArgsTest {

    @Test
    void isArgsValid_NoArgsTest() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    ParseArgs.isArgsValid(new String[0]);
                }
        );
    }

    @Test
    void isArgsValid_TooManyArgsTest() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    ParseArgs.isArgsValid(new String[3]);
                }
        );
    }

    @Test
    void isArgsValid_EmptyStringTest() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    ParseArgs.isArgsValid(new String[]{""});
                }
        );
    }

    @Test
    void isArgsValid_ArgsNotDigitsTest() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    ParseArgs.isArgsValid(new String[]{"abcdz"});
                }
        );
    }

    @Test
    void isArgsValid_HasSpecialCharsTest() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    ParseArgs.isArgsValid(new String[]{"!=fj sl ?"});
                }
        );
    }

    @Test
    void isArgsValid_NegativeNumbersTest() {
        assertDoesNotThrow(
                ()-> {
                    ParseArgs.isArgsValid(new String[]{"-1 -15 -4594 +54"});
                }
        );
    }

    @Test
    void isArgsValid_FloatingPointTest() {
        assertDoesNotThrow(
                ()-> {
                    ParseArgs.isArgsValid(new String[]{"4.5 34 9"});
                }
        );
    }

    @Test
    void isArgsValid_CheckValidInputTest() {
        assertDoesNotThrow(
                ()-> {
                    ParseArgs.isArgsValid(new String[]{"45 67 9 0 3"});
                }
        );
    }
}