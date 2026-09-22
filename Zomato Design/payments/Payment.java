package payments;
import orders.Order;
import java.util.UUID;

public class Payment {
    private int id;
    private Order order;
    private double amount;
    private PaymentStatus status;
    private String transactionId;
    private PaymentStrategy strategy;

    public Payment(int id, Order order, double amount, PaymentStrategy strategy) {
        this.id = id; this.order = order; this.amount = amount; this.strategy = strategy; this.status = PaymentStatus.PENDING;
    }
    
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    
    public boolean makePayment() {
        if (strategy == null) {
            System.out.println("No payment strategy selected.");
            this.status = PaymentStatus.FAILED;
            return false;
        }
        
        boolean success = strategy.pay(amount);
        if (success) {
            this.status = PaymentStatus.SUCCESS;
            this.transactionId = UUID.randomUUID().toString();
        } else {
            this.status = PaymentStatus.FAILED;
        }
        return success;
    }
    public PaymentStatus getStatus() { return status; }
}
