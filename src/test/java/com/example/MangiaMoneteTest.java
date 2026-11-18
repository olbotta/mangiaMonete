package com.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MangiaMoneteTest {

    @Test
    void promemoriaAssertBase() {
        // assertEquals: verifica uguaglianza
        assertEquals(4, 2 + 2);

        // assertNotEquals: verifica disuguaglianza
        assertNotEquals(5, 2 + 2);

        // assertThrows: verifica che venga lanciata un'eccezione
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("abc"));

        // assertDoesNotThrow: verifica che non venga lanciata alcuna eccezione
        assertDoesNotThrow(() -> Integer.parseInt("123"));
    }
}
