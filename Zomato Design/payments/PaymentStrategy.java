package payments;
public interface PaymentStrategy {
    boolean pay(double amount);
    boolean refund(String paymentId);
}
