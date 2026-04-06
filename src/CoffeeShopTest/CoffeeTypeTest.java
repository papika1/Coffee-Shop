package CoffeeShopTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import CoffeeShop.CoffeeType;

class CoffeeTypeTest {

	 @Test
	    void latteShouldHaveCorrectLabel() {
	        assertEquals("Latte", CoffeeType.LATTE.getLabel());
	    }

	    @Test
	    void espressoShouldHaveCorrectPrice() {
	        assertEquals(3.50, CoffeeType.ESPRESSO.getPrice(), 0.001);
	    }

	    @Test
	    void toStringShouldReturnLabel() {
	        assertEquals("Cappuccino", CoffeeType.CAPPUCCINO.toString());
	    }

}
