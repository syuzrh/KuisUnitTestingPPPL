import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.example.Wallet;

public class WalletTest {

    private Wallet wallet;

    @BeforeEach
    public void setupBeforeEach() {
        wallet = new Wallet(100.0, "USD");
    }

    @AfterEach
    public void tearDownAfterEach() {
        wallet = null;
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(100.0, wallet.getBalance(), 0.0);
    }

    @Test
    public void testGetCurrency() {
        Assertions.assertEquals("USD", wallet.getCurrency());
    }

    @Test
    public void testDepositAmount() {
        wallet.depositAmount(50.0);
        Assertions.assertEquals(150.0, wallet.getBalance(), 0.0);
    }

    @Test
    public void testDepositNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.depositAmount(-50.0);
        });
    }

    @Test
    public void testWithdrawAmount() {
        Assertions.assertTrue(wallet.withdrawAmount(50.0));
        Assertions.assertEquals(50.0, wallet.getBalance(), 0.0);
    }

    @Test
    public void testWithdrawExcessiveAmount() {
        Assertions.assertFalse(wallet.withdrawAmount(150.0));
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.withdrawAmount(-50.0);
        });
    }

    @Test
    public void testTransferFunds() {
        Wallet wallet2 = new Wallet(50.0, "USD");
        wallet.transferFunds(wallet2, 50.0);
        Assertions.assertEquals(50.0, wallet.getBalance(), 0.0);
        Assertions.assertEquals(100.0, wallet2.getBalance(), 0.0);
    }

    @Test
    public void testTransferFundsInsufficient() {
        Wallet wallet2 = new Wallet(50.0, "USD");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.transferFunds(wallet2, 150.0);
        });
    }

    @Test
    public void testTransferFundsDifferentCurrency() {
        Wallet wallet2 = new Wallet(50.0, "EUR");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.transferFunds(wallet2, 50.0);
        });
    }
}