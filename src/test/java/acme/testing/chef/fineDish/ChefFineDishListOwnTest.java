package acme.testing.chef.fineDish;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class ChefFineDishListOwnTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/chef/fine-dish/list-own.csv", encoding = "utf-8" ,numLinesToSkip = 1)
	@Order(10)
	public void positiveCase(final int recordIndex, final String status, final String code, final String request, 
		final String budget, final String startsAt, final String finishesAt, final String link) {
		
		super.signIn("chef1", "chef1");
		
		super.clickOnMenu("Chef", "List Own Fine Dishes");
		
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, budget);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("request", request);
		super.checkInputBoxHasValue("budget", budget);
//		super.checkInputBoxHasValue("publishedStatus", publishedStatus);
		super.checkInputBoxHasValue("startsAt", startsAt);
		super.checkInputBoxHasValue("finishesAt", finishesAt);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
	}
}
