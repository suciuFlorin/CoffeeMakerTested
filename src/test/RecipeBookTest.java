package test;

import main.coffeemaker.*;
import main.coffeemaker.exceptions.*;
import org.junit.Test;

import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe recipeTest1;
    private Recipe recipeTest2;

    @Before
    public void setUp() throws RecipeException {
        recipeBook = new RecipeBook();
        recipeTest1 = new Recipe();
        recipeTest1.setName("Coffee");
        recipeTest1.setAmtChocolate("0");
        recipeTest1.setAmtCoffee("3");
        recipeTest1.setAmtMilk("1");
        recipeTest1.setAmtSugar("1");
        recipeTest1.setPrice("50");

        recipeTest2 = new Recipe();
        recipeTest2.setName("Tea");
        recipeTest2.setAmtChocolate("0");
        recipeTest2.setAmtCoffee("3");
        recipeTest2.setAmtMilk("1");
        recipeTest2.setAmtSugar("1");
        recipeTest2.setPrice("50");
    }

    @Test
    public void testAddRecipe() {
        Recipe[] recipes = recipeBook.getRecipes();
        assertTrue(recipeBook.addRecipe(recipeTest1));
        Recipe recipeTest = recipes[0];
        assertEquals(recipeTest1, recipeTest);
        assertFalse(recipeBook.addRecipe(recipeTest1));
    }

    @Test
    public void testAddRecipeAddingTheSameRecipe() {
        recipeBook.addRecipe(recipeTest1);
        assertFalse(recipeBook.addRecipe(recipeTest1));
    }

    @Test
    public void testGetRecipeBooks() {
        Recipe[] recipes = new Recipe[4];
        recipes[0] = recipeTest1;
        recipeBook.addRecipe(recipeTest1);
        assertArrayEquals(recipes, recipeBook.getRecipes());
    }

    @Test
    public void testDeleteRecipe() {
        RecipeBook reBook = new RecipeBook();
        Recipe[] emptyRecipe = new Recipe[0];
        reBook.addRecipe(recipeTest1);
        reBook.deleteRecipe(0);
        assertNotSame(recipeTest1, reBook.getRecipes()[0]);
        assertEquals(emptyRecipe[0], reBook.getRecipes()[0]);
    }

    @Test
    public void testDeleteRecipeThatIsEmpty() {
        assertNull(recipeBook.deleteRecipe(3));
    }

    @Test
    public void deleteInvalidRecipe() {
        assertNull(recipeBook.deleteRecipe(recipeBook.getRecipes().length + 10));
    }

    @Test
    public void testEditRecipe() throws RecipeException {
        recipeBook.addRecipe(recipeTest1);
        Recipe testRecipe = new Recipe();
        testRecipe.setName("Tea");
        testRecipe.setAmtChocolate("0");
        testRecipe.setAmtCoffee("3");
        testRecipe.setAmtMilk("1");
        testRecipe.setAmtSugar("1");
        testRecipe.setPrice("50");
        recipeBook.editRecipe(0, recipeTest2);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = testRecipe;
        assertArrayEquals(recipes, recipeBook.getRecipes());
        assertSame(testRecipe, recipeBook.getRecipes()[0]);
    }

    @Test
    public void testEditRecipeAtNullPosition() {

        assertNull(recipeBook.editRecipe(0, recipeTest2));
    }

    @Test
    public void testEditRecipeWithNullRecipe() {
        // had to add a check for when Recipe is null
        recipeBook.addRecipe(recipeTest1);
        assertNull(recipeBook.editRecipe(0, null));
    }
}
