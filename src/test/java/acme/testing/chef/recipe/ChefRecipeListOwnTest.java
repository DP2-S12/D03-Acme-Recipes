
package acme.testing.chef.recipe;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class ChefRecipeListOwnTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/chef/recipe/recipe.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void checkChef1RecipeListing(final int recordIndex, final String code, final String heading, final String description, final String preparationNotes, final String link,
		final String name, final String code2, final String description2, final String retailPrice, final String link2, final String type) {

		super.signIn("chef1", "chef1");

		super.clickOnMenu("Chef", "List Own Recipes");

		super.checkListingExists();

		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, heading);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, preparationNotes);
		super.checkColumnHasValue(recordIndex, 4, link);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("heading", heading);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("preparationNotes", preparationNotes);
		super.checkInputBoxHasValue("link", link);
		
		super.clickOnButton("Cooking Items");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code2);
		super.checkColumnHasValue(recordIndex, 2, description2);
		super.checkColumnHasValue(recordIndex, 3, retailPrice);
		super.checkColumnHasValue(recordIndex, 4, link2);
		super.checkColumnHasValue(recordIndex, 5, type);

		super.signOut();
	}

}
