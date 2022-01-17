package test;

import org.junit.Test;
import org.junit.Before;

import main.coffeemaker.*;
import main.coffeemaker.exceptions.*;

import static org.junit.Assert.*;

public class RecipeTest {
    private Recipe r1, r2, r3, r4, r5, r6, r7;
    private Recipe recipe1, recipe2;

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

        recipe1 = new Recipe();
        recipe1.setName("Test");
        recipe1.setAmtChocolate("1");
        recipe1.setAmtCoffee("1");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setPrice("1");

        recipe2 = new Recipe();
        recipe2.setName("Test");
        recipe2.setAmtChocolate("1");
        recipe2.setAmtCoffee("1");
        recipe2.setAmtMilk("1");
        recipe2.setAmtSugar("1");
        recipe2.setPrice("1");
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

    @Test
    public void testGetAmtChocolatePositiveInt() {
        assertEquals(0, r1.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate() {
        try {
            r1.setAmtChocolate("12");
            assertEquals(12, r1.getAmtChocolate());
        } catch (RecipeException e) {
            fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    public void testSetAmtChocolateNegativeNumber() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate(-1 + ""));
    }

    @Test
    public void testSetAmtChocolateInvalid() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate("Blah"));
    }

    @Test
    public void testSetAmtChocolateNoInput() {
        assertThrows(RecipeException.class, () -> r1.setAmtChocolate(""));
    }

    @Test
    public void testGetAmtCoffee() {
        assertEquals(3, r1.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee() {
        try {
            r1.setAmtCoffee("17");
            assertEquals(17, r1.getAmtCoffee());
        } catch (RecipeException e) {
            fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    public void testSetAmtCoffeeNegativeNumber() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee(-1 + ""));
    }

    @Test
    public void testSetAmtCoffeeInvalid() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee("Blah"));
    }

    @Test
    public void testSetAmtCoffeeEmptyInput() {
        assertThrows(RecipeException.class, () -> r1.setAmtCoffee(""));
    }

    @Test
    public void testGetAmtMilk() {
        assertEquals(1, r1.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk() {
        try {
            r1.setAmtMilk("9");
            assertEquals(9, r1.getAmtMilk());
        } catch (RecipeException e) {
            fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    public void testSetAmtMilkNegativeNumber() {
        assertThrows(RecipeException.class, () -> r1.setAmtMilk(-1 + ""));
    }

    /**
     * @Test Case ID: 14
     */
    @Test
    public void testSetAmtMilkInvalid() {
        assertThrows(RecipeException.class, () -> r1.setAmtMilk("Blah"));
    }

    @Test
    public void testSetAmtMilkEmptyInput() {
        assertThrows(RecipeException.class, () -> r1.setAmtMilk(""));
    }

    @Test
    public void testGetAmtSugar() {
        assertEquals(1, r1.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar() {
        try {
            r1.setAmtSugar("11");
            assertEquals(11, r1.getAmtSugar());
        } catch (RecipeException e) {
            fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    public void testSetAmtSugarNegativeNumber() {
        assertThrows(RecipeException.class, () -> r1.setAmtSugar(-1 + ""));
    }

    @Test
    public void testSetAmtSugarInvalid() {
        assertThrows(RecipeException.class, () -> r1.setAmtSugar("Blah"));
    }

    @Test
    public void testSetAmtSugarEmptyInput() {
        assertThrows(RecipeException.class, () -> r1.setAmtSugar(""));
    }

    @Test
    public void testGetName() {
        assertEquals("Coffee", r1.getName());
    }

    @Test
    public void testSetName() {
        r1.setName("New");
        assertEquals("New", r1.getName());
    }

    @Test
    public void testSetNameNull() {
        r1.setName(null);
        assertNotNull(r1.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50, r1.getPrice());
    }

    @Test
    public void testSetPrice() {
        try {
            r1.setPrice("55");
            assertEquals(55, r1.getPrice());
        } catch (RecipeException e) {
            fail("RecipeException was thrown, due to an invalid input!");
        }
    }

    @Test
    public void testSetPriceNegativeNumber() {
        assertThrows(RecipeException.class, () -> r1.setPrice(-1 + ""));
    }

    @Test
    public void testSetPriceInvalid() {
        assertThrows(RecipeException.class, () -> r1.setPrice("Blah"));
    }

    @Test
    public void testSetPriceEmptyInput() {
        assertThrows(RecipeException.class, () -> r1.setPrice(""));
    }

    @Test
    public void testToString() {
        assertEquals(r1.getName(), r1.toString());
    }

    @Test
    public void testHashCode() {
        assertTrue(recipe1.hashCode() == recipe2.hashCode());
        assertTrue(recipe1.equals(recipe2) && recipe2.equals(recipe1));
    }

    @Test
    public void testEqualsValid() throws RecipeException {

        Recipe recipe3 = new Recipe();
        recipe3.setAmtChocolate("5");
        recipe3.setAmtCoffee("10");
        recipe3.setAmtMilk("8");
        recipe3.setAmtSugar("7");
        recipe3.setName("Coffee");
        recipe3.setPrice("50");
        assertEquals(r1, recipe3);

        r2 = r1;
        assertEquals(r1, r2);
    }

    @Test
    public void testEqualsNull() {
        r2 = null;
        assertFalse(r1.equals(r2));
    }

    @Test
    public void testEqualsReturnFalse() {
        r2.setName("new name");
        assertFalse(r1.equals(r2));
    }

    @Test
    public void testEqualsGetClass() {

        Inventory inv = new Inventory();
        assertFalse(r1.equals(inv));
    }
}
