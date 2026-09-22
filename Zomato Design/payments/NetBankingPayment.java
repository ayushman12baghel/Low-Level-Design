package payments;
public class NetBankingPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) { System.out.println("Paid " + amount + " via NetBanking."); return true; }
    @Override
    public boolean refund(String paymentId) { return true; }
}
