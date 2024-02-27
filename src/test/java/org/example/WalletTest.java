package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class WalletTest {

    @Test
    public void testOwner() {
        Wallet wallet = new Wallet(
                new Owner("ALipp", 63),
                null,
                0.0
        );
        assertEquals("ALipp", wallet.getOwner().getName());
    }

    // Test Withdraw
    @Test
    public void testWithdrawExceedingBalance() {
        Wallet wallet = new Wallet(new Owner("ALipp", 63), null, 100.0);
        double withdrawnAmount = wallet.withdraw(150.0);
        assertEquals(0.0, withdrawnAmount);
        assertEquals(100.0, wallet.getCash());
    }

    @Test
    public void testWithdrawWithZeroBalance() {
        Wallet wallet = new Wallet(new Owner("ALipp", 63), null, 0.0);
        double withdrawnAmount = wallet.withdraw(50.0);
        assertEquals(0.0, withdrawnAmount);
        assertEquals(0.0, wallet.getCash());
    }

    @Test
    public void testWithdrawWithNegativeAmount() {
        Wallet wallet = new Wallet(new Owner("ALipp", 63), null, 100.0);
        double withdrawnAmount = wallet.withdraw(-50.0);
        assertEquals(0.0, withdrawnAmount);
        assertEquals(100.0, wallet.getCash());
    }

    // Test Deposit

    @Test
    public void testDepositWithNegativeAmount() {
        Wallet wallet = new Wallet(new Owner("ALipp", 63), null, 100.0);
        double depositedAmount = wallet.deposit(-50.0);
        assertEquals(100.0, depositedAmount);
        assertEquals(100.0, wallet.getCash());
    }

    @Test
    public void testDepositWithZeroAmount() {
        Wallet wallet = new Wallet(new Owner("ALipp", 63), null, 100.0);
        double depositedAmount = wallet.deposit(0.0);
        assertEquals(100.0, depositedAmount);
        assertEquals(100.0, wallet.getCash());
    }

    // Test Add Card
    @Test
    public void testAddCardWithDuplicateAccountNumber() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card();
        card1.setAccountNumber(123456789);
        cards.add(card1);

        Wallet wallet = new Wallet(new Owner("ALipp", 63), cards, 0.0);
        wallet.addCards("Bank XYZ", 123456789);
        assertEquals(1, wallet.getCards().size());
    }

    @Test
    public void testAddCardWithUniqueAccountNumber() {
        Wallet wallet = new Wallet(new Owner("ALipp", 63), new ArrayList<>(), 0.0);
        wallet.addCards("Bank ABC", 123456789);
        wallet.addCards("Bank XYZ", 987654321);
        assertEquals(2, wallet.getCards().size());
    }

    // Test Remove Card
    @Test
    public void testRemoveNonExistingCard() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card();
        card1.setAccountNumber(123456789);
        cards.add(card1);

        Wallet wallet = new Wallet(new Owner("ALipp", 63), cards, 0.0);
        wallet.removeCard(987654321); // Trying to remove a non-existing card
        assertEquals(1, wallet.getCards().size());
    }

    @Test
    public void testRemoveExistingCard() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card();
        card1.setAccountNumber(123456789);
        cards.add(card1);

        Wallet wallet = new Wallet(new Owner("ALipp", 63), cards, 0.0);
        wallet.removeCard(123456789);
        assertEquals(0, wallet.getCards().size());
    }

}
