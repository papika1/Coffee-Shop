package CoffeeShop;

public enum CoffeeType {
	
    ESPRESSO("Espresso", 3.50),
    LATTE("Latte", 4.50),
    CAPPUCCINO("Cappuccino", 4.20),
    AMERICANO("Americano", 3.80);

    private final String label;
    private final double price;

    CoffeeType(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return label;
    }
	
}
