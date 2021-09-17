package com.hauschildt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SalesTransactionTest {

    SalesTransaction salesTransaction;

    @BeforeEach
    void setUp() {
        salesTransaction = new SalesTransaction();
    }

    @Test
    void getTransactionId() {
        int expected = SalesTransaction.DEFAULT_TRANSACTION_ID;
        int actual = salesTransaction.getTransactionId();
        assertEquals(expected, actual);
    }

    @Test
    void setTransactionIdZeroGood() {
        salesTransaction.setTransactionId(0);
        int expected = 0;
        int actual = salesTransaction.getTransactionId();
        assertEquals(expected, actual);
    }

    @Test
    void setTransactionIdPotiveGood() {
        salesTransaction.setTransactionId(1);
        int expected = 1;
        int actual = salesTransaction.getTransactionId();
        assertEquals(expected, actual);
    }

    @Test
    void setTransactionIdNegativeBad() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                salesTransaction.setTransactionId(SalesTransaction.MIN_TRANSACTION_ID - 1);
            }
        });
    }

    @Test
    void getSalesPersonId() {
        fail();
    }

    @Test
    void setSalesPersonId() {
        fail();
    }

    @Test
    void getTransactionDateTime() {
        fail();
    }

    @Test
    void setTransactionDateTime() {
        fail();
    }

    @Test
    void getItemId() {
        fail();
    }

    @Test
    void setItemId() {
        fail();
    }

    @Test
    void getUnitPrice() {
        fail();
    }

    @Test
    void setUnitPrice() {
        fail();
    }

    @Test
    void getQuantitySold() {
        fail();
    }

    @Test
    void setQuantitySold() {
        fail();
    }

    @Test
    void testToString() {
        fail();
    }

    @Test
    void compareToDate1BeforeDate2() {
        fail();
    }
    @Test
    void compareToDate2BeforeDate1() {
        fail();
    }
    @Test
    void compareToDate1EqualDate2() {
        SalesTransaction st2 = new SalesTransaction();
        assertEquals(salesTransaction.getTransactionDateTime(), st2.getTransactionDateTime());
    }
}