package main.coffeemaker;

public class RecipeBook {

	/** Array of recipes in coffee maker */
	private Recipe[] recipeArray;
	/** Number of recipes in coffee maker */
	private final int NUM_RECIPES = 4;

	/**
	 * Default constructor for a RecipeBook.
	 */
	public RecipeBook() {
		recipeArray = new Recipe[NUM_RECIPES];
	}

	/**
	 * Returns the recipe array.
	 * 
	 * @param r
	 * @return Recipe[]
	 */
	public synchronized Recipe[] getRecipes() {
		// had to check for array length
		if (recipeArray.length > 0) {
			return recipeArray;
		}

		return new Recipe[0];
	}

	public synchronized boolean addRecipe(Recipe r) {
		// Assume recipe doesn't exist in the array until
		// find out otherwise
		boolean exists = false;
		// Check that recipe doesn't already exist in array
		for (int i = 0; i < recipeArray.length; i++) {
			if (r.equals(recipeArray[i])) {
				exists = true;
			}
		}
		// Assume recipe cannot be added until find an empty
		// spot
		boolean added = false;
		// Check for first empty spot in array
		if (!exists) {
			for (int i = 0; i < recipeArray.length && !added; i++) {
				if (recipeArray[i] == null) {
					recipeArray[i] = r;
					added = true;
				}
			}
		}
		return added;
	}

	/**
	 * Returns the name of the recipe deleted at the position specified
	 * and null if the recipe does not exist.
	 * 
	 * @param recipeToDelete
	 * @return String
	 */
	public synchronized String deleteRecipe(int recipeToDelete) {
		// had to add check for out of bounds items
		if (recipeToDelete > recipeArray.length) {
			return null;
		}

		if (recipeArray[recipeToDelete] != null) {
			String recipeName = recipeArray[recipeToDelete].getName();
			recipeArray[recipeToDelete] = new Recipe();
			return recipeName;
		} else {
			return null;
		}
	}

	/**
	 * Returns the name of the recipe edited at the position specified
	 * and null if the recipe does not exist.
	 * 
	 * @param recipeToEdit
	 * @param newRecipe
	 * @return String
	 */
	public synchronized String editRecipe(int recipeToEdit, Recipe newRecipe) {
		// add null check
		if (newRecipe == null) {
			return null;
		}

		if (recipeArray[recipeToEdit] != null) {
			String recipeName = recipeArray[recipeToEdit].getName();
			newRecipe.setName("");
			recipeArray[recipeToEdit] = newRecipe;
			return recipeName;
		} else {
			return null;
		}
	}

}
