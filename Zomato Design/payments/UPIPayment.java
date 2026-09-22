package payments;
public class UPIPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) { System.out.println("Paid " + amount + " via UPI."); return true; }
    @Override
    public boolean refund(String paymentId) { return true; }
}
