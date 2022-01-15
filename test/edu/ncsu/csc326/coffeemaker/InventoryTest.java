package test.edu.ncsu.csc326.coffeemaker;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.ncsu.csc326.coffeemaker.Inventory;

public class InventoryTest {

	@Test
	public void testDefaults() {
		Inventory inventory = new Inventory();
		int chocUnits = inventory.getChocolate();
		int milkUnits = inventory.getMilk();
		int sugarUnits = inventory.getSugar();
		int coffeeUnits = inventory.getCoffee();

		assertEquals(15, chocUnits);
		assertEquals(15, milkUnits);
		assertEquals(15, sugarUnits);
		assertEquals(15, coffeeUnits);
	}

	@Test
	public void testUnitAddition() {
		Inventory inventory = new Inventory();
		inventory.setChocolate(1);
		inventory.setMilk(1);
		inventory.setSugar(1);
		inventory.setCoffee(1);

		int chocUnits = inventory.getChocolate();
		int milkUnits = inventory.getMilk();
		int sugarUnits = inventory.getSugar();
		int coffeeUnits = inventory.getCoffee();

		assertEquals(1, chocUnits);
		assertEquals(1, milkUnits);
		assertEquals(1, sugarUnits);
		assertEquals(1, coffeeUnits);
	}
}