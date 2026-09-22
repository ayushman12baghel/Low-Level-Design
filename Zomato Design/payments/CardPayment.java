package payments;
public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) { System.out.println("Paid " + amount + " via Card."); return true; }
    @Override
    public boolean refund(String paymentId) { return true; }
}
