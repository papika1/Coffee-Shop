package CoffeeShopTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CoffeeShop.CoffeeType;
import CoffeeShop.OrderItem;

class OrderItemTest {

	@Test
    void constructorShouldSetCoffeeTypeQuantityAndUnitPrice() {
        OrderItem item = new OrderItem(CoffeeType.LATTE, 2);

        assertEquals(CoffeeType.LATTE, item.getCoffeeType());
        assertEquals(2, item.getQuantity());
        assertEquals(CoffeeType.LATTE.getPrice(), item.getUnitPrice(), 0.001);
    }

    @Test
    void getSubtotalShouldReturnQuantityTimesUnitPrice() {
        OrderItem item = new OrderItem(CoffeeType.ESPRESSO, 3);

        double expectedSubtotal = 3 * CoffeeType.ESPRESSO.getPrice();

        assertEquals(expectedSubtotal, item.getSubtotal(), 0.001);
    }
	
}
