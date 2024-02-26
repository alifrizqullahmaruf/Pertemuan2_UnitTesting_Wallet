package org.example;

public class Calculator {
    private int hasil;

    public Calculator() {
        this.hasil = 0;
    }

    public int getHasil() {
        return hasil;
    }

    public void setHasil(int hasil) {
        this.hasil = hasil;
    }

    public int tambah(int a, int b) {
        hasil = a + b;
        return hasil;
    }

    public int kurang(int a, int b) {
        hasil = a - b;
        return hasil;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Contoh penggunaan penambahan
        int hasilPenambahan = calculator.tambah(5, 3);
        System.out.println("Hasil Penambahan: " + hasilPenambahan); // Output: 8
        System.out.println("Hasil saat ini: " + calculator.getHasil()); // Output: 8

        // Contoh penggunaan pengurangan
        int hasilPengurangan = calculator.kurang(10, 4);
        System.out.println("Hasil Pengurangan: " + hasilPengurangan); // Output: 6
        System.out.println("Hasil saat ini: " + calculator.getHasil()); // Output: 6
    }
}
