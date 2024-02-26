package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void tambah() {
        Calculator calculator = new Calculator();

        // Test penambahan bilangan positif
        int hasil1 = calculator.tambah(5, 3);
        assertEquals(8, hasil1); // Memastikan hasil penambahan benar

        // Test penambahan bilangan negatif
        int hasil2 = calculator.tambah(-5, -3);
        assertEquals(-8, hasil2); // Memastikan hasil penambahan benar

        // Test penambahan yang menghasilkan overflow
        int maxInt = Integer.MAX_VALUE;
        int overflowResult = calculator.tambah(maxInt, 1);
        assertEquals(Integer.MIN_VALUE, overflowResult); // Overflow akan menghasilkan nilai negatif terbesar
    }

    @Test
    void kurang() {
        Calculator calculator = new Calculator();

        // Test pengurangan bilangan positif
        int hasil1 = calculator.kurang(10, 4);
        assertEquals(6, hasil1); // Memastikan hasil pengurangan benar

        // Test pengurangan bilangan negatif
        int hasil2 = calculator.kurang(-10, -4);
        assertEquals(-6, hasil2); // Memastikan hasil pengurangan benar

        // Test pengurangan yang menghasilkan underflow
        int minInt = Integer.MIN_VALUE;
        int underflowResult = calculator.kurang(minInt, 1);
        assertEquals(Integer.MAX_VALUE, underflowResult); // Underflow akan menghasilkan nilai positif terbesar
    }
}
