package test;

import org.junit.Test;
import org.junit.Before;

import main.coffeemaker.*;
import main.coffeemaker.exceptions.*;

import static org.junit.Assert.*;

public class RecipeTest {
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
        Recipe recipe = new Recipe();

        String name = recipe.getName();
        int chocoAmt = recipe.getAmtChocolate();
        int milkAmt = recipe.getAmtMilk();
        int sugarAmt = recipe.getAmtSugar();
        int coffeeAmt = recipe.getAmtCoffee();
        int price = recipe.getPrice();

        assertEquals("", name);
        assertEquals(0, chocoAmt);
        assertEquals(0, milkAmt);
        assertEquals(0, sugarAmt);
        assertEquals(0, coffeeAmt);
        assertEquals(0, price);
    }

    @Test
    public void testAddition() {
        String name = r5.getName();
        int chocoAmt = r5.getAmtChocolate();
        int milkAmt = r5.getAmtMilk();
        int sugarAmt = r5.getAmtSugar();
        int coffeeAmt = r5.getAmtCoffee();
        int price = r5.getPrice();

        assertEquals("Test", name);
        assertEquals(1, chocoAmt);
        assertEquals(1, milkAmt);
        assertEquals(1, sugarAmt);
        assertEquals(1, coffeeAmt);
        assertEquals(1, price);
    }
}
