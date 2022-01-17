package test;

import main.coffeemaker.*;
import main.coffeemaker.exceptions.*;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class InventoryTest {

	private Recipe r1, r2, r3, r4, r5, r6, r7;

	@Before
	public void setUp() throws RecipeException {
		// Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		// Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");

		// Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");

		// Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");

		// Set up for r5
		r5 = new Recipe();
		r5.setName("Test");
		r5.setAmtChocolate("1");
		r5.setAmtCoffee("1");
		r5.setAmtMilk("1");
		r5.setAmtSugar("1");
		r5.setPrice("1");

		// Set up for r6
		r6 = new Recipe();
		r6.setName("Test coffe");
		r6.setAmtChocolate("0");
		r6.setAmtCoffee("1");
		r6.setAmtMilk("0");
		r6.setAmtSugar("0");
		r6.setPrice("1");

		// Set up for r7
		r7 = new Recipe();
		r7.setName("Test coffee 0");
		r7.setAmtChocolate("0");
		r7.setAmtCoffee("0");
		r7.setAmtMilk("0");
		r7.setAmtSugar("0");
		r7.setPrice("1");

	}

	@Test
	public void testDefaults() {
		Inventory inventory = new Inventory();
		int chocUnits = inventory.getChocolate();
		int milkUnits = inventory.getMilk();
		int sugarUnits = inventory.getSugar();
		int coffeeUnits = inventory.getCoffee();

		// after running the test we had to add "synchronized" to every get

		assertEquals(15, chocUnits);
		assertEquals(15, milkUnits);
		assertEquals(15, sugarUnits);
		assertEquals(15, coffeeUnits);
	}

	@Test
	public void testAddition() {
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

	@Test
	public void testExpectedError() {
		Inventory inventory = new Inventory();

		inventory.setChocolate(0);
		inventory.setMilk(0);
		inventory.setSugar(0);
		inventory.setCoffee(0);

		// testing choco
		assertThrows(
				InventoryException.class, () -> inventory.addChocolate("") // Should throw an InventoryException
		);

		assertThrows(
				InventoryException.class, () -> inventory.addChocolate("choco") // Should throw an InventoryException
		);

		// testing coffee
		assertThrows(
				InventoryException.class, () -> inventory.addCoffee("") // Should throw an InventoryException
		);

		assertThrows(
				InventoryException.class, () -> inventory.addCoffee("coffee") // Should throw an InventoryException
		);

		// testing milk
		assertThrows(
				InventoryException.class, () -> inventory.addMilk("") // Should throw an InventoryException
		);

		assertThrows(
				InventoryException.class, () -> inventory.addMilk("milk") // Should throw an InventoryException
		);

		// testing sugar
		assertThrows(
				InventoryException.class, () -> inventory.addSugar("") // Should throw an InventoryException
		);

		assertThrows(
				InventoryException.class, () -> inventory.addSugar("sugar") // Should throw an InventoryException
		);

		assertThrows(InventoryException.class, () -> inventory.addChocolate(-1 + ""));
		assertThrows(InventoryException.class, () -> inventory.addCoffee(-1 + ""));
		assertThrows(InventoryException.class, () -> inventory.addMilk(-1 + ""));
		assertThrows(InventoryException.class, () -> inventory.addSugar(-1 + "")); // amtSugar <= 0 - had do reverse
																					// logic

		int chocUnits = inventory.getChocolate();
		int milkUnits = inventory.getMilk();
		int sugarUnits = inventory.getSugar();
		int coffeeUnits = inventory.getCoffee();

		assertEquals(0, chocUnits);
		assertEquals(0, milkUnits);
		assertEquals(0, coffeeUnits);
		assertEquals(0, sugarUnits);
	}

	@Test
	public void testEnoughIngredients() {
		Inventory inventory = new Inventory();

		boolean ingredientsResult = inventory.enoughIngredients(r5);

		assertEquals(true, ingredientsResult);

		inventory.setChocolate(0);
		inventory.setMilk(0);
		inventory.setSugar(0);
		inventory.setCoffee(0);

		boolean ingredients2Result = inventory.enoughIngredients(r5);

		assertEquals(false, ingredients2Result);

		// if we need 0 and we have zero we expect true
		boolean ingredients3Result = inventory.enoughIngredients(r7);

		assertEquals(true, ingredients3Result);

	}

	@Test
	public void testUseIngredients() {
		Inventory inventory = new Inventory();

		inventory.setChocolate(1);
		inventory.setMilk(1);
		inventory.setSugar(1);
		inventory.setCoffee(1);

		boolean ingredientsResult = inventory.useIngredients(r5);

		assertEquals(true, ingredientsResult);

		boolean ingredients2Result = inventory.useIngredients(r5);

		assertEquals(false, ingredients2Result);

		boolean ingredients3Result = inventory.useIngredients(r6);

		// found that coffee wasn't removed Inventory.coffee += r.getAmtCoffee();
		assertEquals(false, ingredients3Result);
	}

	@Test
	public void testToString() {
		Inventory inventory = new Inventory();
		assertEquals("Coffee: 15\n" +
				"Milk: 15\n" +
				"Sugar: 15\n" +
				"Chocolate: 15\n", inventory.toString());
	}

}