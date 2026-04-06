package CoffeeShop;

public class OrderItem {


    private int id;
    private int orderId;
    private CoffeeType coffeeType;
    private int quantity;
    private double unitPrice;

    public OrderItem() {
    }

    public OrderItem(CoffeeType coffeeType, int quantity) {
        this.coffeeType = coffeeType;
        this.quantity = quantity;
        this.unitPrice = coffeeType.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return quantity * unitPrice;
    }
	
}
