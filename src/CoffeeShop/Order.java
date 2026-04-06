package CoffeeShop;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private int id;
    private LocalDateTime orderTime;
    private double totalAmount;
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public Order(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void calculateTotal() {
        totalAmount = 0;

        for (OrderItem item : items) {
            totalAmount += item.getSubtotal();
        }
    }
	
}
