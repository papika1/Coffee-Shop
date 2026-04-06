package CoffeeShopTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import CoffeeShop.CoffeeType;
import CoffeeShop.Order;
import CoffeeShop.OrderItem;

class OrderTest {


    @Test
    void addItemShouldAddItemToList() {
        Order order = new Order(LocalDateTime.now());
        OrderItem item = new OrderItem(CoffeeType.CAPPUCCINO, 2);

        order.addItem(item);

        assertEquals(1, order.getItems().size());
        assertEquals(item, order.getItems().get(0));
    }

    @Test
    void calculateTotalShouldSumAllItemSubtotals() {
        Order order = new Order(LocalDateTime.now());

        OrderItem item1 = new OrderItem(CoffeeType.LATTE, 2);
        OrderItem item2 = new OrderItem(CoffeeType.ESPRESSO, 1);

        order.addItem(item1);
        order.addItem(item2);

        order.calculateTotal();

        double expectedTotal = item1.getSubtotal() + item2.getSubtotal();

        assertEquals(expectedTotal, order.getTotalAmount(), 0.001);
    }

}
